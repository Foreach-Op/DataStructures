import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        OQueueTest();

    }

    private static void OStackTest(){
        DataStructure<Integer> dt= new OStack<>();
        for (int i = 0; i < 50; i++) {
            dt.push(i);
        }

        for (int i = 0; i < 60; i++) {
            System.out.println(dt.poll());
        }

        for (int i = 0; i < 100; i++) {
            dt.push(i);
        }

        for (int i = 0; i < 60; i++) {
            System.out.println(dt.poll());
        }
        System.out.println(dt.isEmpty());
    }

    private static void OQueueTest(){
        DataStructure<Integer> dt= new OQueue<>();
        for (int i = 0; i < 10; i++) {
            dt.push(i);
        }


        for (int i = 0; i < 1; i++) {
            dt.poll();
        }

        dt.push(30);
        dt.printArray();

        dt.push(31);
        dt.printArray();

        System.out.println(dt.poll());
        System.out.println(dt.poll());
        dt.printArray();

        for (int i = 0; i < 10; i++) {
            dt.push(i);
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(dt.poll());
        }
        System.out.println(dt.size());



    }
}