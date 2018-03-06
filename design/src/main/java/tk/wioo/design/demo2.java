package tk.wioo.design;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/demo2")
//public class demo2 {
//    @Autowired
//    private demoBiz biz;
//    // http://localhost:8005/demo/get/1
//    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
//    public String get(@PathVariable("id") Integer id) {
//        return biz.get(id);
//    } ;
//}

@RestController
@RequestMapping("/demo2")
public class demo2 {
    // http://localhost:8005/demo/get/1
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") Integer id) {
        return ""+ id;
    } ;
}