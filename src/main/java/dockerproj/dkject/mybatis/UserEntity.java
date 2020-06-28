package dockerproj.dkject.mybatis;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserEntity {
    private String name;
    private Integer id;
    private String code;
}
