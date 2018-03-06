package tk.wioo.copier;

import org.springframework.stereotype.Component;
import tk.wioo.entity.UserEntity;
import tk.wioo.pojo.UserPojo;
import tk.wioo.utils.CommCopierImpl;

/**
 * Created by Administrator on 2017-10-09.
 */
@Component
public class UserCopierImpl extends CommCopierImpl<UserPojo,UserEntity> {

}
