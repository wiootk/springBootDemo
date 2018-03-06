package tk.wioo.repo;


import org.springframework.stereotype.Repository;
import tk.wioo.entity.sys.SysUser;

@Repository
public interface SysUserRepository extends CommRepo<SysUser, Long> {
    SysUser findByUsername(String username);
}