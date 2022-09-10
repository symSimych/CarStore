package api;

public interface Store<T> {

    void add(T good);
    T getById(String id);
    void delete(String id);
}

