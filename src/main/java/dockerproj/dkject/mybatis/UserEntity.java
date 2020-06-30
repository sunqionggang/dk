package dockerproj.dkject.mybatis;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@TableName("user")
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
@ApiModel
public class UserEntity {
    /** 自增ID */
    @ApiModelProperty("自增id")
    private Long id;
    /** 账号 */
    @ApiModelProperty("用户名")
    private String username;
    /** 密码 */
    @ApiModelProperty("密码")
    private String password;
    /** 角色名：Shiro 支持多个角色，而且接收参数也是 Set<String> 集合，但这里为了简单起见定义成 String 类型了 */
    @ApiModelProperty("角色名称")
    private String roleName;
    /** 是否禁用 */
    @ApiModelProperty("是否禁用")
    private boolean locked;
    // 省略 GET SET 构造函数...
}
