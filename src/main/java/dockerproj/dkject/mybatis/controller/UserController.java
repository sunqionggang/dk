package dockerproj.dkject.mybatis.controller;

import dockerproj.dkject.mybatis.UserEntity;
import dockerproj.dkject.mybatis.service.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/getUserInfoById")
    public UserEntity getUserInfoById(@RequestParam("id") Long id){
        return service.getUserInfoById(id);
    }

    @GetMapping("/getAllUser")
    public List<UserEntity> getAllUser(){
        return service.getAllUser();
    }

    @GetMapping
    public String get() {
        return "get.....";
    }

    /**
     * RequiresRoles 是所需角色 包含 AND 和 OR 两种
     * RequiresPermissions 是所需权限 包含 AND 和 OR 两种
     *
     * @return msg
     */
    @RequiresRoles(value = {"admin", "test"}, logical = Logical.OR)
    //@RequiresPermissions(value = {"user:list", "user:query"}, logical = Logical.OR)
    @GetMapping("/query")
    public String query() {
        return "query.....";
    }

    @GetMapping("/find")
    @RequiresRoles(value = {"test"})
    @RequiresPermissions(value = {"user:list"})
    public String find() {
        return "find.....";
    }
}
