package dockerproj.dkject.module.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

@Repository
@ConfigurationProperties(prefix = "my")
/**
 * 使用@Value("${my.name}")可以单独绑定到变量
 *
 * 使用 @ConfigurationProperties 把配置文件自动绑定到Person
 */
@Data
public class Person {
    private String name;
    private int age;
    private String sex;
    private String active;

    public String toString(){
        return "name:"+name+"->age:"+age+"->sex:"+sex+"->active:"+active;
    }
}
