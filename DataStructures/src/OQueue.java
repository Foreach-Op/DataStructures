public class OQueue<T> implements DataStructure<T>{

    /*
    A Queue implementation with the circular array methodology.
    It is a storage friend approach.
     */
    private T[] arr;

    private int initializationSize;
    private int sizeIncreaseScale;
    private int size = 0;
    private int head = -1;
    private int tail = 0;

    public OQueue() {
        this(10,2);
        arr = (T[]) new Object[initializationSize];
    }

    public OQueue(int initializationSize, int sizeIncreaseScale) {
        if(initializationSize>0)
            this.initializationSize = initializationSize;
        if(sizeIncreaseScale>1)
            this.sizeIncreaseScale = sizeIncreaseScale;
    }

    @Override
    public void push(T obj) {
        resizeIfNecessary();
        if(head == arr.length-1){
            head = 0;
            arr[head] = obj;
        }else {
            arr[head+1] = obj;
            head++;
        }
        size++;
    }

    @Override
    public T poll() {
        if(isEmpty()){
            head = -1;
            tail = 0;
            return null;
        }
        T obj = arr[tail];
        arr[tail] = null;
        if(tail == arr.length-1){
            tail = 0;
        }else {
            tail++;
        }
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

            int tempHead = head;
            if(tail>head)
                tempHead += this.arr.length;
            System.out.println("head: "+head);
            System.out.println("tail: "+tail);
            System.out.println("tempHead: "+tempHead);
            for (int i = tail, j = 0; i <= tempHead; i++) {
                int index = i % this.arr.length;
                newArr[j++] = this.arr[index];
            }
            head = size-1;
            tail = 0;
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
