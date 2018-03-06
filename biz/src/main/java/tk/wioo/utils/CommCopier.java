package tk.wioo.utils;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017-10-09.
 */
@Component
public interface CommCopier<V,E> {
    public V newViewObject();
    public E newEntity();
    public void copyForInsert(V vo, E entity);
    public void copyForUpdate(V vo, E entity);;
    public void copyToViewObject(E entity, V vo);
    public V copyToViewObject(E entity,Class<V> clazz);
}