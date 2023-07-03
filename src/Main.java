import LinkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
//        list.addFirst(6);
//        list.removeFirst();
        list.reverse();
        list.print();
    }
}