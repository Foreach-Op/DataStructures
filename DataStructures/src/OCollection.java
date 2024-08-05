public interface OCollection<T> {

    int size();
    boolean isEmpty();
    void add(T data);
    void add(int index, T data);
    void addFirst(T data);
    T get(int index);
    int find(T data);
    T remove(T data);
    T removeAt(int index);
    void removeAll();
    T[] toArray();
    void printAll();
}
