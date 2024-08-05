public class OStack<T> implements DataStructure<T>{

    private T[] arr;

    private int initializationSize;
    private int sizeIncreaseScale;
    private int size = 0;
    private int tail = -1;

    public OStack() {
        this(10,2);
        arr = (T[]) new Object[initializationSize];
    }

    public OStack(int initializationSize, int sizeIncreaseScale) {
        if(initializationSize>0)
            this.initializationSize = initializationSize;
        if(sizeIncreaseScale>1)
            this.sizeIncreaseScale = sizeIncreaseScale;
    }

    @Override
    public void push(T obj) {
        resizeIfNecessary();
        arr[tail+1] = obj;
        tail++;
        size++;
    }

    @Override
    public T poll() {
        if(isEmpty()){
            tail = -1;
            return null;
        }
        T obj = arr[tail];
        tail--;
        size--;
        return obj;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private void resizeIfNecessary(){
        if(size == arr.length){
            int arraySize = this.arr.length * sizeIncreaseScale;
            T[] newArr = (T[]) new Object[arraySize];
            for (int i = 0; i < this.arr.length; i++) {
                newArr[i] = this.arr[i];
            }
            this.arr = newArr;
        }
    }
    @Override
    public void printArray(){
        for (int i = 0; i < this.arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
