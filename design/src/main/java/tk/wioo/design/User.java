package tk.wioo.design;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import tk.wioo.pojo.UserPojo;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/user")
public interface User {
    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value="/getAll",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<UserPojo> getAllUsers();
    @RequestMapping(method = RequestMethod.POST)
    public UserPojo createUser(@Valid @RequestBody UserPojo user);
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    @ApiOperation(value="查找用户", notes="根据url的id来查找用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    public ResponseEntity<UserPojo> findOne(
            @ApiParam(required=true, name="name", value="人员Id")
            @RequestParam(name = "name", required=true)
            @PathVariable("id") Long id);
    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    @ApiOperation(value="更新信息", notes="根据url的id来指定更新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "UserPojo")
    })
    public ResponseEntity<UserPojo> updateUser(@Valid @RequestBody UserPojo user, @PathVariable("id") Long id);
    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) ;
}
