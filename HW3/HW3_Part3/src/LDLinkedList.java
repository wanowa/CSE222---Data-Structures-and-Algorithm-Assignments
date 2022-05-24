import java.util.*;

public class LDLinkedList<T> extends AbstractList<T> implements List<T>{
    private Node<T> root;
    private Node<T> tail;
    private static LDLinkedList trash = new LDLinkedList();
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(){
            data = null;
            next = null;
        }

        public Node(T var) {
            data = var;
            next = null;
        }

        public Node(T var, Node<T> nextNode) {
            data = var;
            next = nextNode;
        }

        private T getData() {
            return this.data;
        }
    }

    @Override
    public T get(int index) {
        return getNode(index).getData();
    }

    public boolean addTrash(T t){
        Node<T> temp;
        if(size == 0){
            addTrashFirst(t);
        }
        else{
            addTrashLast(t);
        }
        return true;
    }

    public void addTrashFirst(T t){
        root = new Node<>(t);
        tail = root;
        size++;
    }

    public void addTrashLast(T t){
        tail.next = new Node<>(t);
        tail = tail.next;
        size++;
    }

    public boolean add(T t){
        boolean founded = false;
        Node<T> temp;
        int i = 0;
        if(trash.size != 0){
            for (; i < size ; i++){
                if(t.equals(trash.getTrashNode(i).getData())){
                    founded = true;
                    break;
                }
            }
        }

        if(size == 0){
            if(founded){
                addFirst((T) trash.getTrashNode(i).getData());
                trash.removeFromTrash(i);
            }
            else{
                addFirst(t);
            }
            return true;
        }
        if(founded){
            addLast((T) trash.getTrashNode(i).getData());
            trash.removeFromTrash(i);
        }
        else{
            addLast(t);
        }
        return true;
    }


    private void addFirst(T t){
        root = new Node<>(t);
        tail = root;
        size++;
    }

    private void addLast(T t){
        tail.next = new Node<>(t);
        tail = tail.next;
        size++;
    }

    public T getData(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = root;
        for(int i = 0 ; i < index ; i++){
            temp = temp.next;
        }
        return temp.getData();
    }

    /**
     * Given an index, return the node at that index
     *
     * @param index The index of the node to return.
     * @return The node at the given index.
     */

    public Node<T> getTrashNode(int index){
        Node<T> temp = root;
        for(int i  = 0 ; i < index && temp != null; i++){
            temp = temp.next;
        }
        return temp;
    }

    public Node<T> getNode(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = root;
        for(int i  = 0 ; i < index ; i++){
            temp = temp.next;
        }
        return temp;
    }

    public int indexOf(Object o){
        Node<T> temp = root;
        for(int i = 0 ; i < size ; i++){
            if(temp.data.equals((T) o)){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public T removeFromTrash(int index){
        Node<T> temp,removed;
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(getTrashNode(0).getData().equals(get(index))){
            return removeFirst();
        }
        return removeAfter(getTrashNode(index-1));
    }

    public T removeFromTrashFirst(){
        Node<T> temp = root;
        if(root != null){
            if(root.next == null){
                root = null;
            }
            else{
                root = root.next;
                temp.next = null;
            }
            size--;
            return temp.data;
        }
        return null;
    }

    public T removeFromTrashAfter(Node<T> temp){
        Node<T> removedNode = temp.next;
        if(temp != null){
            if(removedNode.next == null){
                temp.next = null;
            }
            else{
                temp.next = removedNode.next;
                removedNode.next = null;
            }
            size--;
            return removedNode.data;
        }
        return null;
    }

    @Override
    public T remove(int index){
        Node<T> temp,removed;
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(getNode(0).getData().equals(get(index))){
            return removeFirst();
        }
        return removeAfter(getNode(index-1));
    }

    public T removeFirst(){
        Node<T> temp = root;
        if(root != null){
            if(root.next == null){
                root = null;
            }
            else{
                root = root.next;
                temp.next = null;
            }
            trash.addTrash(temp);
            size--;
            trash.size++;
            return temp.data;
        }
        return null;
    }

    public T removeAfter(Node<T> temp){
        Node<T> removedNode = temp.next;
        if(temp != null){
            if(removedNode.next == null){
                temp.next = null;
            }
            else{
                temp.next = removedNode.next;
                removedNode.next = null;
            }
            trash.addTrash(removedNode);
            trash.size++;
            size--;
            return removedNode.data;
        }
        return null;
    }

    public int getSize() {
        return size;
    }

}