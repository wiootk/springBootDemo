package tk.wioo.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.wioo.copier.UserCopierImpl;
import tk.wioo.design.User;
import tk.wioo.entity.UserEntity;
import tk.wioo.pojo.UserPojo;
import tk.wioo.repo.UserRepo;
import tk.wioo.utils.DataMaker;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserImpl implements User {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserCopierImpl userCopier;
    @Autowired
    private DataMaker<UserPojo, UserEntity> userDataMaker;

    public List<UserPojo> getAllUsers() {
        List<UserEntity> list = userRepo.findAll();
        List<UserPojo> pojoList = userDataMaker.toView(list,UserPojo.class);
        return pojoList;
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserPojo createUser(@Valid @RequestBody UserPojo pojo) {
        UserEntity entity = new UserEntity();
        userCopier.copyForInsert(pojo, entity);
        entity = userRepo.save(entity);
        userCopier.copyToViewObject(entity, pojo);
        return pojo;
    }

    public ResponseEntity<UserPojo> findOne(@PathVariable("id") Long id) {
        UserEntity user = userRepo.findOne(id);
        if (user == null) {
            return new ResponseEntity<UserPojo>(HttpStatus.NOT_FOUND);
        }
        UserPojo pojo = new UserPojo();
        userCopier.copyToViewObject(user, pojo);
        return new ResponseEntity<UserPojo>(pojo, HttpStatus.OK);
    }

    public ResponseEntity<UserPojo> updateUser(@Valid @RequestBody UserPojo pojo, @PathVariable("id") Long id) {
        UserEntity userDb = userRepo.findOne(id);
        if (userDb == null) {
            return new ResponseEntity<UserPojo>(HttpStatus.NOT_FOUND);
        } else {
            userDb.setName(pojo.getName());
            userDb = userRepo.save(userDb);
            userCopier.copyToViewObject(userDb, pojo);
            return new ResponseEntity<UserPojo>(pojo, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) {
        userRepo.delete(id);
    }
}
