package com.zhouyf.learn.service;

import com.zhouyf.learn.pojo.Resource;
import com.zhouyf.learn.pojo.RoleAndResource;
import com.zhouyf.learn.pojo.User;
import com.zhouyf.learn.repository.ResourceRepository;
import com.zhouyf.learn.repository.RoleAndResourceRepository;
import com.zhouyf.learn.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.*;

/**
 * @author Zhouyf
 * @Data 2020-08-14  10:11
 */
@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private RoleAndResourceRepository roleAndResourceRepository;

    /**
     * 获取用户相对应的所有访问权限(没有被禁用的)
     */
    public List<String> findPathByUserId(String userId){
        return resourceRepository.findPathByUserId(userId);
    }

    /**
     * 添加资源信息
     */
    public Result addResource(Resource resource){
        return new Result(resourceRepository.save(resource));
    }

    /**
     * 删除资源信息
     * @param resourceIds
     */
    public Result delResource(String[] resourceIds){
        resourceRepository.deleteAllByResourceId(resourceIds);
        return new Result("DELETE : "+resourceIds.toString());
    }

    /**
     * 修改资源信息
     */
    public Result updateResource(Integer resourceId , Resource resource){
        Optional<Resource> oRes = resourceRepository.findById(resourceId);
        if(oRes.isPresent()) return new Result("resourceId 错误，找不到对应资源信息！",null);

        Resource res = oRes.get();
        if(null!=resource.getIsUse()) res.setIsUse(resource.getIsUse());
        if(null!=resource.getPath()) res.setPath(resource.getPath());
        if(null!=resource.getDescription()) res.setDescription(resource.getDescription());

        return new Result(resourceRepository.saveAndFlush(res));
    }

    /**
     * 查询资源信息
     */
    public Result findResource(String path,Boolean isUse,String roleIds){
        List<Resource> resultList = new LinkedList<>();
        Specification querySpecifi = (Specification<Resource>) (root, criteriaQuery, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            if(null != path){
                predicates.add(criteriaBuilder.like(root.get("path"),"%"+path+"%"));
            }
            if(null != isUse){
                predicates.add(criteriaBuilder.equal(root.get("isUse"),isUse));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        List<Resource> resourceList = resourceRepository.findAll(querySpecifi);

        if(null==roleIds || roleIds.split(",").length==0){
            resultList.addAll(resourceList);
        }else {
            for(Resource resource : resourceList){
                List<String> roleIdList = roleAndResourceRepository.findRoleIdsByResourceId(resource.getResourceId());
                //如果包含就返回
                if(roleIdList.containsAll(Arrays.asList(roleIds.split(",")))){
                    resultList.add(resource);
                }
            }
        }
        return new Result(resultList);
    }
}
