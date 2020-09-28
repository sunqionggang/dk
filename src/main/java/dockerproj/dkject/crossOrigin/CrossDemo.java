package dockerproj.dkject.crossOrigin;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 跨域
 * @author: module
 * @create: 2020-09-28 08:42
 */
@CrossOrigin(origins = "http://127.0.0.1:8089",maxAge = 3600)
@RestController
public class CrossDemo {
    @GetMapping("/")
    public String index() {
        return "hello,CORS";
    }
}