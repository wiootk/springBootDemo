package tk.wioo.biz;

import org.springframework.stereotype.Service;

import javax.inject.Named;

/**
 * Created by Administrator on 2017-10-09.
 */
@Service
public class demoBiz {
    public String get(Integer id){
        return  "demoBiz  : "+ id;
    }
}
