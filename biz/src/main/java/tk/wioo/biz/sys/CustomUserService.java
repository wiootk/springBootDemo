package tk.wioo.biz.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import tk.wioo.entity.sys.SysUser;
import tk.wioo.repo.SysUserRepository;

public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserRepository userRepository;
    //重写UserDetailsService接口，实现loadUserByUsername方法, 查询到对应的用户
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("s:"+s);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }
}

