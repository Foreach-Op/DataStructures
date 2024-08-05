public interface OSQ<T>{
    void push(T obj);
    T poll();

    int size();

    boolean isEmpty();

    void printArray();


}
