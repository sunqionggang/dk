package dockerproj.dkject.mybatis;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@TableName("user")
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class UserEntity {
    /** 自增ID */
    private Long id;
    /** 账号 */
    private String username;
    /** 密码 */
    private String password;
    /** 角色名：Shiro 支持多个角色，而且接收参数也是 Set<String> 集合，但这里为了简单起见定义成 String 类型了 */
    private String roleName;
    /** 是否禁用 */
    private boolean locked;
    // 省略 GET SET 构造函数...
}
