package dockerproj.dkject.auth;

import dockerproj.dkject.mybatis.UserEntity;

import java.util.*;

public class DbCache {
    public static final Map<String,UserEntity> USER_CACHE=new HashMap<>();
    public static final Map<String, Collection<String>> PERMISSIONS_CACHE = new HashMap<>();

    static {
        USER_CACHE.put("u1",new UserEntity(1L,"u1","p1","admin",true));
        USER_CACHE.put("u2",new UserEntity(2L,"u2","p2","commons",true));
        USER_CACHE.put("u3",new UserEntity(3L,"u3","p3","test",true));
        PERMISSIONS_CACHE.put("admin", Arrays.asList("user:list", "user:add", "user:edit"));
        PERMISSIONS_CACHE.put("test", Collections.singletonList("user:list"));

    }
}
