package dockerproj.dkject;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import dockerproj.dkject.mybatis.UserEntity;
import dockerproj.dkject.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DkjectApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        List<UserEntity> li= userMapper.getAll();
        for (UserEntity u:li
             ) {
            System.out.println(u.getUsername());

        }
        List<UserEntity> li2=userMapper.selectList(new QueryWrapper<>());
        for (UserEntity u:li2
        ) {
            System.err.println(u.getUsername());

        }
    }

}
