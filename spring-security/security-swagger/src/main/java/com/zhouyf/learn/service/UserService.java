package com.zhouyf.learn.service;

import com.zhouyf.learn.pojo.Role;
import com.zhouyf.learn.pojo.User;
import com.zhouyf.learn.pojo.UserAndRole;
import com.zhouyf.learn.repository.UserAndRoleRepository;
import com.zhouyf.learn.repository.UserRepository;
import com.zhouyf.learn.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.text.MessageFormat;
import java.util.*;

/**
 * @author Zhouyf
 * @Data 2020-08-13  9:35
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserAndRoleRepository userAndRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username))
            throw new UsernameNotFoundException(MessageFormat.format("Username :{0} not found!",username));
        User user = userRepository.findByUsername(username);
        if(null==user)
            throw new UsernameNotFoundException(MessageFormat.format("User :{0} is Empty!",username));

        List<String> resourceList = resourceService.findPathByUserId(user.getUserId());
        if(resourceList.isEmpty())
            throw new RuntimeException(MessageFormat.format("User :{0} is not path!",username));

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for(String path : resourceList){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(path);
            authorities.add(authority);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getIsUse(),true,true,true,
                authorities
        );

    }

    @Transactional(rollbackFor = Exception.class)
    public Result addUser(User user, String[] roleIds){
        User saveUser = userRepository.save(user);
        List<Role> roles = new LinkedList<>();
        for(String roleId : roleIds){
            Optional<Role> optionalRole = roleService.findById(roleId);
            if(optionalRole.isPresent()) return new Result("角色信息错误",null);
            UserAndRole ur = new UserAndRole(saveUser.getUserId(),optionalRole.get().getRoleId());
            userAndRoleRepository.save(ur);
            roles.add(optionalRole.get());
        }

        return new Result(new HashMap<String,Object>(){{
            this.put("user",saveUser);
            this.put("roles",roles);
        }});
    }

    public Result delUser(String userId){
        userAndRoleRepository.deleteAllByUserId(userId);
        userRepository.deleteById(userId);
        return new Result("操作成功");
    }

    @Transactional(rollbackFor = Exception.class)
    public Result updateUser(String userId,String[] roleIds){
        //先删除以前的
        userAndRoleRepository.deleteAllByUserId(userId);

        List<Role> roles = new LinkedList<>();
        for(String roleId : roleIds){
            Optional<Role> optionalRole = roleService.findById(roleId);
            if(optionalRole.isPresent()) return new Result("角色信息错误",null);
            UserAndRole ur = new UserAndRole(userId,optionalRole.get().getRoleId());
            userAndRoleRepository.save(ur);
            roles.add(optionalRole.get());
        }

        return new Result(new HashMap<String,Object>(){{
            this.put("user",userRepository.findById(userId).get());
            this.put("role",roles);
        }});
    }

    @Transactional(rollbackFor = Exception.class)
    public Result findUser(String name,Boolean isUse,String roleIds){
        List<Map<String,Object>> resultList = new LinkedList<>();
        Map<String,Object> userMap;
        List<Role> roleList;

        Specification querySpecifi = (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            if(null != name){
                predicates.add(criteriaBuilder.like(root.get("name"),"%"+name+"%"));
            }
            if(null != isUse){
                predicates.add(criteriaBuilder.equal(root.get("isUse"),isUse));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<User> userList = userRepository.findAll(querySpecifi);
        if(roleIds.split(",").length != 0) {
            for(User user : userList){
                userMap = new LinkedHashMap<>();
                roleList = new LinkedList<>();
                List<String> roleIdList = userAndRoleRepository.findRoleIdByUserId(user.getUserId());
                //判断 如果该用户拥有这个权限才返回
                if(roleIdList.containsAll(Arrays.asList(roleIds.split(",")))){
                    userMap.put("user",user);
                    for(String roleId : roleIdList){
                        Optional<Role> roleOptional = roleService.findById(roleId);
                        if(roleOptional.isPresent())
                            roleList.add(roleOptional.get());
                        else
                            userAndRoleRepository.deleteAllByUserIdAndRoleId(user.getUserId(),roleId);
                    }
                    userMap.put("roles",roleList);
                }
                resultList.add(userMap);
            }
        }

        return new Result(resultList);
    }
}
