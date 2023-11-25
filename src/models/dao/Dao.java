package models.dao;

import java.util.Optional;
import java.util.List;
import java.util.Map;

public interface Dao<T> {
    Optional<T> get(Object id);

    List<T> getAll();

    void save(T t);
    
    void update(T t, Map<String, String> map);

    void delete(T t);

}
