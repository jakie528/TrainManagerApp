import java.util.ArrayList;
import java.util.List;

public class SortedCollection<T extends Comparable<T>> implements SortedCollectionInterface<T> {
	private List<T> list;
	
	public SortedCollection() {
		this.list = new ArrayList<>();
	}
    @Override
    public boolean insert(T data) throws NullPointerException, IllegalArgumentException {
        return this.list.add(data);
    }

    @Override
    public boolean remove(T data) throws NullPointerException, IllegalArgumentException {
        return this.list.remove(data);
    }

    @Override
    public boolean contains(T data) {
        return this.list.contains(data);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
	
	
	
	

}
