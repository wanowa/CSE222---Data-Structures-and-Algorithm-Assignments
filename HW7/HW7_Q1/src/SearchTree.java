public interface SearchTree<E extends Comparable<E>> {

    boolean add(E data);
    boolean contains(E data);
    E find(E data);
    E delete(E data);
    boolean remove(E data);


}
