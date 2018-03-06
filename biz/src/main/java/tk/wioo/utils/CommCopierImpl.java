package tk.wioo.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public abstract class CommCopierImpl<V, E> implements CommCopier<V, E> {
    @Override
    public V newViewObject() {
        return (V) new Object();
    }
    @Override
    public E newEntity() {
        return (E) new Object();
    }
    @Override
    public void copyForInsert(V vo, E entity) {
//      BeanUtils.copyProperties(vo, entity, "id");
        BeanUtils.copyProperties(vo, entity);
    }
    @Override
    public void copyForUpdate(V vo, E entity) {
        BeanUtils.copyProperties(vo, entity);
    }
    @Override
    public void copyToViewObject(E entity, V vo) {
        BeanUtils.copyProperties(entity, vo);
    }
    @Override
    public V copyToViewObject(E entity, Class<V> clazz) {
        V vo = null;
        try {
            vo = clazz.newInstance();
            BeanUtils.copyProperties(entity, vo);
        } catch (Exception e) {
//            logger.error("初始化{}对象失败。", clazz, e);
        }
        return vo;
    }
}