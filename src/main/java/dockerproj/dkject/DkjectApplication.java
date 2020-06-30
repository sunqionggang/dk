package dockerproj.dkject;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@PropertySource(value = "classpath:application2.properties")
@ServletComponentScan
@MapperScan("dockerproj.dkject.mybatis.mapper")
@EnableSwagger2Doc
public class DkjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DkjectApplication.class, args);
    }


}
