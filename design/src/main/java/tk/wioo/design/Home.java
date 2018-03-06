package tk.wioo.design;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public interface Home {
    @RequestMapping("/")
    public String index(Model model) ;
}