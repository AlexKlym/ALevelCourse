package practice3;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add(0, "Jo");
        list.add(1, "si");
        list.add(2, "ka");;
        list.add(3, "lo");
        list.add("Kell");
        System.out.println(list.size());
        list.delete(4);
        System.out.println(list.size());
        System.out.println(list.get(1));
        list.set(2, "leo");
        System.out.println(list.get(2));
        System.out.println(list.contains("si"));
        System.out.println(list.contains("MEggi"));


    }


}
