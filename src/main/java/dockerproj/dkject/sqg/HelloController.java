package dockerproj.dkject.sqg;

import dockerproj.dkject.exception.CommonException;
import dockerproj.dkject.exception.valid.DemoReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class HelloController {
    Logger logger= LoggerFactory.getLogger(HelloController.class);
    @Value("${my.active}")
    private String active;

    @Autowired
    private Person person;

    @PostMapping("/getCurrentProfile")
    public  String say(){
        logger.info("printProfile");
        return  "currentProfile->"+active;
    }

    @PostMapping("/getPerson")
    public  String printPerson(){
        logger.info("personInfo",person.toString());
        return  "person->"+person.toString();
    }


    @PostMapping("/pathVar/{name}")
    public String pathVariable(@PathVariable("name")String name){
        logger.info("controller 方法执行pathVariable");
        return name;
    }

    @PostMapping("/test/reqParam")
    public String reqParam(@RequestParam("name")String name){
        logger.info("controller reqParam");
        return name;
    }

    @GetMapping("/demo")
    public String demo() {
        throw new CommonException("01001", "发送异常22");
    }

    @GetMapping("/demo/valid")
    public String demoValid(@Valid DemoReq req) {
        return req.getCode() + "," + req.getName();
    }


}
