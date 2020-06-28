package dockerproj.dkject.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dockerproj.dkject.mybatis.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {
    @Select("select * from user")
    List<UserEntity> getAll();
}
