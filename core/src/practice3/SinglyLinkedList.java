package practice3;

import javax.swing.plaf.ColorUIResource;

public class SinglyLinkedList<E> {

    protected Node<E> head;
    protected int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(int index, E element) {
        Node<E> temp = new Node<E>(element);
        Node<E> current = head;
        if(index > size | index < 0){
            throw new IllegalArgumentException("Illegal index");
        }
        if(index == 0){
            temp.setLink(head);
            this.head = temp;
        }else{
            for(int i = 1; i < index; i++){
                current = current.getLink();
            }
            temp.setLink(current.getLink());
            current.setLink(temp);
        }
        this.size++;
    }

    public void add(E element){
        add(size, element);
        }

    public void delete(int index){
        Node<E> current  = head;
        if(index > size | index < 0){
            throw new IllegalArgumentException("Illegal index");
        }
        if(index == 0){
            head = head.getLink();
        }else{
            for(int i = 1; i < index; i++){
                current = current.getLink();
            }
            current.setLink(current.getLink().getLink());
        }
        this.size--;
    }

    public E get(int index){
    Node<E> current = head;
    if( index > size | index < 0){
        throw new IllegalArgumentException("Illegal index");
    }
    for(int i = 0; i < index; i++){
        current = current.getLink();
    }
    return  current.getData();
}

public int size(){
        return this.size;
}

public void clear(){
        this.head = null;
}

public void set(int index, E element){
        Node<E> current = head;
    if(index > size | index < 0){
        throw new IllegalArgumentException("Illegal index");
    }
    for(int i = 0; i < index; i++){
        current = current.getLink();
    }
    current.setData(element);
}

public boolean contains(E element){
        for(Node<E> current = head; current.getLink() != null; current = current.getLink()){
            if(element.equals(current.getData()))
                return true;
        }
        return false;
}

    private class Node<E> {
        E data;
        Node<E> link;

        public Node(E element) {
            link = null;
            this.data = element;
        }

        public Node(E d, Node<E> n) {
            data = d;
            link = n;
        }

        public E getData() {
            return this.data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getLink() {
            return this.link;
        }

        public void setLink(Node<E> n) {
            this.link = n;
        }


    }
}
