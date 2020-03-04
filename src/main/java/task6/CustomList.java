package task6;

import java.util.Arrays;

public class CustomList<T>{
	private int size=0;
	private static final int INITIAL_CAPACITY=10;
	private Object elements[];
	
	public CustomList() {
		elements = new Object[INITIAL_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public T get(int i) {
		if(i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index : "+i+", Size : "+size);
		}
		return (T)elements[i];
	}
	
	public void add(T t) {
		if(size==elements.length) {
			increaseCapacity();
		}
		elements[size++]=t;
	}
	
	@SuppressWarnings("unchecked")
	public T remove(int i) {
		
		if(i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index : "+i+", Size : "+size);
		}
		
		Object item=elements[i];
		int numElements=elements.length-(i+1);
		System.arraycopy(elements, i+1, elements, i, numElements);
		size--;
		return (T) item;
	}
	
	public String toString() {
		
		StringBuilder sb=new StringBuilder();
		sb.append('[');
		for(int i=0;i<size;i++) {
			sb.append(elements[i].toString());
			if(i<size-1)	sb.append(',');
		}
		sb.append(']');
		
		return sb.toString();
	}
	
	
	public int size() {
		return size;
	}
	
	private void increaseCapacity(){
		int newSize=elements.length*2;
		elements=Arrays.copyOf(elements, newSize);
	}
}