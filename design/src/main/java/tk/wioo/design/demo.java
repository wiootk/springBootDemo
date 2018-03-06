package tk.wioo.design;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import tk.wioo.biz.demoBiz;



@RequestMapping("/demo")
public interface demo {
    // http://localhost:8005/demo/get/1
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") Integer id);
}
