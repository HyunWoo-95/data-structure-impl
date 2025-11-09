package list;

public interface IList<T> {

	void add(T t);
	void insert(int idx, T t);
	void clear();
	boolean delete(T t);
	boolean deleteByIndex(int idx);
	T get(int idx);
	int indexOf(T t);
	boolean isEmpty();
	boolean contains(T t);
	int size();

}
