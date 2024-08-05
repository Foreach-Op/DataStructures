import java.util.*;

public class Main {
    public static void main(String[] args) {
        OArrayListTest();
    }

    private static void OStackTest(){
        OSQ<Integer> dt= new OStack<>();
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
        OSQ<Integer> dt= new OQueue<>();
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

    private static void OArrayListTest(){
        OCollection<Integer> dt= new OArrayList<>();
        dt.printAll();
        for (int i = 0; i < 10; i++) {
            dt.add(i);
        }
        System.out.println(dt.size());
        dt.printAll();
        System.out.println(dt.remove(9));
        System.out.println(dt.remove(8));
        System.out.println(dt.remove(1));
        System.out.println(dt.remove(0));
        System.out.println(dt.remove(3));
        dt.printAll();

        dt.add(0);
        dt.add(0,0);
        dt.add(0,-1);
        dt.add(1,-2);
        dt.add(1,-2);
        dt.add(1,-2);
        dt.add(10,-20);
        dt.addFirst(667);
        dt.addFirst(666);
        System.out.println(dt.size());
        dt.printAll();
        System.out.println(dt.get(0));
        System.out.println(dt.get(12));
        System.out.println(dt.get(6));
        System.out.println(dt.get(13));
        dt.printAll();
        System.out.println(dt.find(-2));
        System.out.println(dt.find(0));
        System.out.println(dt.find(9));
        System.out.println(dt.find(666));
        dt.printAll();
        System.out.println(dt.removeAt(1));
        System.out.println(dt.removeAt(0));
        System.out.println(dt.removeAt(dt.size()-1));
        dt.printAll();
        System.out.println("Remove All");
        dt.removeAll();
        System.out.println(dt.isEmpty());
    }

    private static void OLinkedListTest(){
        OCollection<Integer> dt= new OLinkedList<>();
        dt.printAll();

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            dt.add(i);
        }
        dt.printAll();
        System.out.println(dt.size());
        System.out.println(dt.remove(9));
        System.out.println(dt.remove(8));
        System.out.println(dt.remove(1));
        System.out.println(dt.remove(0));
        System.out.println(dt.remove(3));
        dt.add(0);
        dt.add(0,0);
        dt.add(0,-1);
        dt.add(1,-2);
        dt.add(1,-2);
        dt.add(1,-2);
        dt.add(10,-20);
        dt.addFirst(667);
        dt.addFirst(666);
        System.out.println(dt.size());
        dt.printAll();
        System.out.println(dt.get(0));
        System.out.println(dt.get(12));
        System.out.println(dt.get(6));
        System.out.println(dt.get(13));
        dt.printAll();
        System.out.println(dt.find(-2));
        System.out.println(dt.find(0));
        System.out.println(dt.find(9));
        System.out.println(dt.find(666));
        dt.printAll();
        System.out.println(dt.removeAt(1));
        System.out.println(dt.removeAt(0));
        System.out.println(dt.removeAt(dt.size()-1));
        dt.printAll();
        System.out.println("Remove All");
        dt.removeAll();
        System.out.println(dt.isEmpty());
    }
}