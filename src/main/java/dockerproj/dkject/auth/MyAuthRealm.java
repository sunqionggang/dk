package dockerproj.dkject.auth;

import dockerproj.dkject.mybatis.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Configuration
public class MyAuthRealm extends AuthorizingRealm {

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    /**
     * 验证权限时调用
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //Session session = SecurityUtils.getSubject().getSession();
        //Session session=null;
        UserEntity userEntity=null;
        if(redisCacheTemplate.opsForValue().get("USER_SESSION")!=null){
            userEntity=(UserEntity)redisCacheTemplate.opsForValue().get("USER_SESSION");
        }
        //获取登陆成功后设置的session值
        //UserEntity userEntity=(UserEntity)session.getAttribute("USER_SESSION");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles=new HashSet<>();
        roles.add(userEntity.getRoleName());
        info.setRoles(roles);

        final Map<String, Collection<String>> permissionsCache = DbCache.PERMISSIONS_CACHE;
        final Collection<String> permissions = permissionsCache.get(userEntity.getRoleName());
        info.addStringPermissions(permissions);
        return info;
    }

    /**
     * 登陆时调用
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /*if(redisCacheTemplate.opsForValue().get("token")!=null){
            token=(AuthenticationToken)redisCacheTemplate.opsForValue().get("token");
        }*/
        String principal=(String)token.getPrincipal();

        //构造一个假的用户
       /* UserEntity user=new UserEntity();
        user.setPassword("123456");
        user.setUsername("module");
        user.setRoleName("admin");
        user.setLocked(true);
        //比对查找数据库中用户是否存在
        if(!user.getUsername().equals(principal)){
            throw new UnknownAccountException();
        }*/
       if(DbCache.USER_CACHE.get(principal)==null){
           throw new UnknownAccountException();
       }
       UserEntity user=DbCache.USER_CACHE.get(principal);
        //用户是否被锁定
        if (!user.isLocked()) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, user.getPassword(), getName());
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("USER_SESSION", user);
        redisCacheTemplate.opsForValue().set("USER_SESSION",user);
        return authenticationInfo;
    }
}
