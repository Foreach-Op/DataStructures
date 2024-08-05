public class OLinkedList<T> implements OCollection<T>{
    private ONode<T> root;
    private int size=0;

    public OLinkedList(){
        this.root = null;
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
    public void add(T data){
        ONode<T> newNode = new ONode<>(data);
        ONode<T> curr = root;
        if(isEmpty()){
            this.root = newNode;
        }else {
            while (curr.hasNext()){
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.previous = curr;
        }
        size++;
    }

    @Override
    public void add(int index, T data){
        ONode<T> newNode = new ONode<>(data);
        ONode<T> curr = root;
        if(index>size)
            add(data);
        else if(isEmpty()){
            this.root = newNode;
        }else {
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            newNode.next = curr;
            newNode.previous = curr.previous;
            if(curr.hasPrevious())
                curr.previous.next = newNode;
            else
                this.root = newNode;
            curr.previous = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T data) {
        add(0, data);
    }

    @Override
    public T get(int index) {
        if(index>=size)
            return null;
        ONode<T> curr = root;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public int find(T data) {
        if(isEmpty())
            return -1;
        ONode<T> curr = root;
        int ind = 0;
        while (curr != null){
            if(curr.data.equals(data))
                return ind;
            ind++;
            curr = curr.next;
        }
        return -1;
    }

    @Override
    public T remove(T data) {
        if(isEmpty())
            return null;
        ONode<T> curr = root;
        while (curr!=null){
            if(curr.data.equals(data)){
                ONode<T> prev = curr.previous;
                ONode<T> next = curr.next;
                if(prev == null && next == null){
                    // Only root exists
                    System.out.println("Trace1");
                    root = null;
                }
                else if(prev == null){
                    // It is head
                    System.out.println("Trace2");
                    root = next;
                    root.previous = null;
                } else if (next == null) {
                    // It is tail
                    System.out.println("Trace3");
                    prev.next = null;
                }else {
                    // It is in middle
                    System.out.println("prev:"+prev.data);
                    prev.next = next;
                    next.previous = prev;
                }
                curr.next = null;
                curr.previous = null;
                size--;
                return curr.data;
            }
            curr = curr.next;
        }
        return null;
    }

    @Override
    public T removeAt(int index) {
        if(index>=size)
            return null;
        ONode<T> curr = root;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        if(!curr.hasPrevious() && !curr.hasNext()){
            // Only root exists
            root = null;
        }else if (!curr.hasPrevious()){
            // It is head
            root = curr.next;
            root.previous = null;
        }else if (!curr.hasNext()){
            // It is tail
            curr.previous.next = null;
        }else {
            // It is in middle
            curr.previous.next = curr.next;
            curr.next.previous = curr.previous;
        }
        size--;
        return curr.data;
    }

    @Override
    public void removeAll() {
        root = null;
        size = 0;
    }

    @Override
    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        int ind = 0;
        ONode<T> curr = root;
        while (curr.hasNext()){
            arr[ind] = curr.data;
            curr = curr.next;
            ind++;
        }
        return arr;
    }

    @Override
    public void printAll() {
        if(isEmpty())
            return;
        ONode<T> curr = root;
        while (curr.hasNext()){
            System.out.print(curr.data+",");
            curr = curr.next;
        }
        System.out.println(curr.data);
    }
}

class ONode<T>{
    ONode<T> next;
    ONode<T> previous;
    T data;

    public ONode(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public boolean hasNext(){
        return next!=null;
    }

    public boolean hasPrevious(){
        return previous!=null;
    }
}
