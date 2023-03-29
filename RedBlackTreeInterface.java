public interface RedBlackTreeInterface<T extends Comparable<T>>{
public String toString();
public String toString(T start, T end);
public void insert(Train train);
public Train delete(Train train);
}
