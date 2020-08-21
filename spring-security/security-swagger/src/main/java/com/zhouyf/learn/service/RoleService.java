package com.zhouyf.learn.service;

import com.zhouyf.learn.pojo.Resource;
import com.zhouyf.learn.pojo.Role;
import com.zhouyf.learn.pojo.RoleAndResource;
import com.zhouyf.learn.pojo.UserAndRole;
import com.zhouyf.learn.repository.ResourceRepository;
import com.zhouyf.learn.repository.RoleAndResourceRepository;
import com.zhouyf.learn.repository.RoleRepository;
import com.zhouyf.learn.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.*;

/**
 * @author Zhouyf
 * @Data 2020-08-07  11:49
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private RoleAndResourceRepository roleAndResourceRepository;

    public List<Role> findRolesByUserId(String userId){
        if(StringUtils.isEmpty(userId!=null)) return null;
        return roleRepository.findRolesByUserId(userId);
    }

    public Optional<Role> findById(String roleId){
        return roleRepository.findById(roleId);
    }

    /**
     * 添加角色
     */
    public Result addRole(Role role, String[] resourceIds){
        Role saveRole = roleRepository.save(role);
        List<Resource> resourceList = new LinkedList<>();

        for(String resourceId : resourceIds){
            Optional<Resource> optionalResource = resourceRepository.findById(Integer.parseInt(resourceId));
            if(optionalResource.isPresent()) return new Result("资源信息错误",null);
            RoleAndResource rr = new RoleAndResource(saveRole.getRoleId(),optionalResource.get().getResourceId());
            roleAndResourceRepository.save(rr);
            resourceList.add(optionalResource.get());
        }

        return new Result(new HashMap<String,Object>(){{
            this.put("role",saveRole);
            this.put("resource",resourceList);
        }});
    }

    /**
     * 修改角色
     */
    public Result updateRole(Role role,String[] resourceIds){
        roleAndResourceRepository.deleteAllByRoleId(role.getRoleId());

        Role saveRole = roleRepository.save(role);
        List<Resource> resourceList = new LinkedList<>();
        for(String resourceId : resourceIds){
            Optional<Resource> optionalResource = resourceRepository.findById(Integer.parseInt(resourceId));
            if(optionalResource.isPresent()) return new Result("角色信息错误",null);
            RoleAndResource rr = new RoleAndResource(saveRole.getRoleId(),optionalResource.get().getResourceId());
            roleAndResourceRepository.save(rr);
            resourceList.add(optionalResource.get());
        }

        return new Result(new HashMap<String,Object>(){{
            this.put("role",saveRole);
            this.put("resource",resourceList);
        }});

    }


    /**
     * 删除角色
     * 直接删除角色和对应的资源 不对用户进行判断
     */
    public Result delUser(String roleId){
        roleAndResourceRepository.deleteAllByRoleId(roleId);
        roleRepository.deleteById(roleId);
        return new Result("操作成功");
    }

    /**
     * 查询角色
     */
    public Result findRole(String roleName,Boolean isUse){
        Specification querySpecifi = (Specification<Resource>) (root, criteriaQuery, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            if(null != roleName){
                predicates.add(criteriaBuilder.like(root.get("roleName"),"%"+roleName+"%"));
            }
            if(null != isUse){
                predicates.add(criteriaBuilder.equal(root.get("isUse"),isUse));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        List<Role> roleList = roleRepository.findAll(querySpecifi);
        return new Result(roleList);
    }
}
