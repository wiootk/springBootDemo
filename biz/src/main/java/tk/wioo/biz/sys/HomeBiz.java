package tk.wioo.biz.sys;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import tk.wioo.design.Home;
import tk.wioo.pojo.Msg;

@Controller
public class HomeBiz implements Home {
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }
}