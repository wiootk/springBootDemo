package tk.wioo.design;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import tk.wioo.biz.demoBiz;
//@RestController
//public class demoImpl implements demo {
//    @Autowired
//    private demoBiz biz;
//    @Override
//    public String get(@PathVariable("id") Integer id) {
//        return biz.get(id);
//    }
//}


@RestController
public class demoImpl implements demo {
    @Override
    public String get(@PathVariable("id") Integer id) {
        return "123   "+ id;
    }
}