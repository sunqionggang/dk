package dockerproj.dkject.mybatis.controller;

import dockerproj.dkject.mybatis.UserEntity;
import dockerproj.dkject.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
}
