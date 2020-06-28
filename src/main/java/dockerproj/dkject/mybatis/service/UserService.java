package dockerproj.dkject.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import dockerproj.dkject.mybatis.UserEntity;

import java.util.List;

public interface UserService extends IService {
    UserEntity getUserInfoById(Long id);

    List<UserEntity> getAllUser();
}
