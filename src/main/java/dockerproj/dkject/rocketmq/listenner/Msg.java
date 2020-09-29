package dockerproj.dkject.rocketmq.listenner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Msg implements Serializable {

    /** 消息对象id **/
    private Long id;
    /** 消息类型 **/
    private String type;
    /** 数据类型 */
    private String objectType;
    /** 应用唯一标识 */
    //private AppKeyEnum appKey;
    /** 消息发送人 */
    private Long creator;
    /** 租户Id */
    private Long tenantId;
    /** 名字 **/
    private String name;
    /** 摘要 **/
    private String summary;
    /** 参数 **/
    private Map<String, Object> args;

    private static final long serialVersionUID = 2492174436894976003L;

    public Msg(Long id, Object type, String name, String summary, Map<String, Object> args) {
        this.id = id;
        this.type = type.toString();
        this.name = name;
        this.summary = summary;
        this.args = args;

    }

    public Msg(Long id, Object type, String name, String summary) {
        this.id = id;
        this.type = type.toString();
        this.name = name;
        this.summary = summary;
        this.args = Collections.emptyMap();
    }

    public Msg(Object type, String name, String summary) {
        this.type = type.toString();
        this.name = name;
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }

}
