package dockerproj.dkject.mybatis.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import dockerproj.dkject.mybatis.UserEntity;
import dockerproj.dkject.mybatis.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(tags = "1.1", description = "用户管理", value = "用户管理")
@Slf4j
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

    @GetMapping("testaaa")
    @ApiOperation(value = "条件查询（DONE）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY),
            @ApiImplicitParam(name = "password", value = "密码", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY,required = true),
    })
    public UserEntity query(String username, String password) {
        log.info("多个参数用  @ApiImplicitParams");
        return new UserEntity();
    }

    @PostMapping("/postu")
    @ApiOperation(value = "添加用户（DONE）")
    public UserEntity post(@RequestBody UserEntity user) {
        log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
        return user;
    }


}
