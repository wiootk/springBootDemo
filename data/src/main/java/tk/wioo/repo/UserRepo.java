package tk.wioo.repo;

import org.springframework.stereotype.Repository;
import tk.wioo.entity.UserEntity;

@Repository
public interface UserRepo extends CommRepo<UserEntity, Long> {
}