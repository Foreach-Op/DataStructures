public class OArrayList<T> implements OCollection<T>{
    private T[] arr;

    private int initializationSize = 10;
    private int sizeIncreaseScale = 2;
    private int size = 0;

    public OArrayList(){
        this(10, 2);
        arr = (T[]) new Object[initializationSize];
    }

    public OArrayList(int initializationSize, int sizeIncreaseScale) {
        if(initializationSize>0)
            this.initializationSize = initializationSize;
        if(sizeIncreaseScale>1)
            this.sizeIncreaseScale = sizeIncreaseScale;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void add(T data) {
        resizeIfNecessary();
        arr[size++] = data;
    }

    @Override
    public void add(int index, T data) {
        resizeIfNecessary();
        for (int i = size-1, j = size; i >= index; i--, j--) {
            arr[j] = arr[i];
        }
        arr[index] = data;
        size++;
    }

    @Override
    public void addFirst(T data) {
        add(0, data);
    }

    @Override
    public T get(int index) {
        if(index>=size)
            throw new RuntimeException();
        return arr[index];
    }

    @Override
    public int find(T data) {
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(data))
                return i;
        }
        return -1;
    }

    @Override
    public T remove(T data) {
        T returnedData = null;
        for (int i = 0; i < size; i++) {
            assert arr[i] != null;
            if(!arr[i].equals(data) && returnedData==null)
                continue;
            if(arr[i].equals(data))
                returnedData = arr[i];
            if(i+1<size)
                arr[i] = arr[i+1];
            else
                arr[i] = null;
        }
        if(returnedData!=null)
            size--;
        return returnedData;
    }

    @Override
    public T removeAt(int index) {
        if(index>=size)
            throw new RuntimeException();
        T returnedData = arr[index];
        for (int i = index; i < size; i++) {
            if(i+1<size)
                arr[i] = arr[i+1];
            else
                arr[i] = null;
        }
        if(returnedData!=null)
            size--;
        return returnedData;
    }

    @Override
    public void removeAll() {
        arr = (T[]) new Object[initializationSize];
        size = 0;
    }

    @Override
    public T[] toArray() {
        T[] newArr = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    @Override
    public void printAll() {
        for (int i = 0; i < size; i++) {
            if(i!=size-1)
                System.out.print(arr[i]+",");
            else
                System.out.println(arr[i]);
        }
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
}
