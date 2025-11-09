package list;

import java.util.Arrays;

public class MyArrayList<T> implements IList<T> {
	private static final int DEFAULT_SIZE = 50;

	private int size;
	private T[] elements;

	public MyArrayList() {
		this.size = 0;
		this.elements = (T[])new Object[DEFAULT_SIZE];
	}

	@Override
	public void add(T t) {
		if (this.size == this.elements.length) {
			this.elements = Arrays.copyOf(this.elements, this.size * 2);
		} // 배열의 길이가 모두 찼을때 길일를 늘려주는 코드
		this.elements[this.size] = t;
		this.size += 1;

	}

	@Override
	public void insert(int idx, T t) {
		if (this.size == this.elements.length) {
			this.elements = Arrays.copyOf(this.elements, this.size * 2);
		} // 배열의 길이가 모두 찼을때 길일를 늘려주는 코드
		for (int i = idx; i < this.size; i++) {
			this.elements[i + 1] = this.elements[i];
		}
		this.elements[idx] = t;
		this.size++;
	}

	@Override
	public void clear() {
		this.size = 0;
		this.elements = (T[])new Object[DEFAULT_SIZE];

	}

	@Override
	public boolean delete(T t) {
		for (int i = 0; i < this.size; i++) {
			if (this.elements[i].equals(t)) {
				for (int j = i; j < this.size - 1; j++) {
					this.elements[j] = this.elements[j + 1];
				}
				this.size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteByIndex(int idx) {
		if (idx < 0 || idx > this.size - 1) {
			return false;
		}
		for (int i = idx; i < this.size - 1; i++) {
			this.elements[i] = this.elements[i + 1];
		}
		this.size--;
		return true;
	}

	@Override
	public T get(int idx) {
		if (idx < 0 || idx > this.size - 1) {
			throw new IndexOutOfBoundsException();
		}
		return this.elements[idx];
	}

	@Override
	public int indexOf(T t) {
		for (int i = 0; i < this.size; i++) {
			if (this.elements[i].equals(t)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public boolean contains(T t) {
		for (int i = 0; i < this.size; i++) {
			if (this.elements[i].equals(t)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}
}
