package tk.wioo.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import tk.wioo.pojo.PageableList;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-10-09.
 */
@Component
public class DataMaker<V, E> {
    @Autowired
    private CommCopierImpl<V, E> commCopier;
        public List<V> toView(List<E> eList,Class<V> vClass) {
        List<V> vList = new ArrayList<V>();
        for (E e : eList) {
            V v =  commCopier.copyToViewObject(e,vClass );
            vList.add(v);
        }
        return vList;
    }
    public PageableList<V> toView(Page<E> page) {
        PageableList<V> pl = new PageableList<V>();
        pl.setPageNo(page.getNumber() + 1);
        pl.setPageSize(page.getSize());
        pl.setTotalPages(page.getTotalPages());
        pl.setTotalRecords(page.getTotalElements());
        List<V> list = new ArrayList<V>();
        List<E> pList = page.getContent();
        for (E entity : pList) {
            V vo = commCopier.newViewObject();
            commCopier.copyToViewObject(entity, vo);
            list.add(vo);
        }
        pl.setRecords(list);
        return pl;
    }
}