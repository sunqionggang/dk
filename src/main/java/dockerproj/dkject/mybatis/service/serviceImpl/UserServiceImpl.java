package dockerproj.dkject.mybatis.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dockerproj.dkject.mybatis.UserEntity;
import dockerproj.dkject.mybatis.mapper.UserMapper;
import dockerproj.dkject.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public UserEntity getUserInfoById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return mapper.selectList(new QueryWrapper<>());
    }
}
