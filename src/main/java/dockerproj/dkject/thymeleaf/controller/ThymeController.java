package dockerproj.dkject.thymeleaf.controller;

import dockerproj.dkject.mybatis.UserEntity;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class ThymeController {
    @GetMapping("/thymIndex")
    public ModelAndView tt(){
        ModelAndView modelAndView=new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        modelAndView.setViewName("/index");
        modelAndView.addObject("name","sqg");
        modelAndView.addObject("age",18);
        UserEntity u=new UserEntity();
        u.setRoleName("admin");
        modelAndView.addObject("entity",u);
        return modelAndView;
    }

    @GetMapping("thymIndex2")
    public String tt2(HttpServletRequest request){
        request.setAttribute("name","sqg");
        request.setAttribute("age",19);
        UserEntity u=new UserEntity();
        u.setRoleName("admin");
        request.setAttribute("entity",u);
        //返回的 index 默认映射到 src/main/resources/templates/xxxx.html
        return "index";

    }
}
