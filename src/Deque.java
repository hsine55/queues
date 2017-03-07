import java.util.Iterator;
import java.util.LinkedList;


public class Deque<Item> implements Iterable<Item> {

	private LinkedList<Item> linkedList ;
	
	public Deque() {
		linkedList = new LinkedList();
	}

	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	
	public int size() {
		return linkedList.size();
	}
	
	public void addFirst(Item item) {
		checkItem(item);
		linkedList.addFirst(item);
	}
	
	public void addLast(Item item) {
		checkItem(item);
		linkedList.addLast(item);
	}
	
	public Item removeFirst() {
		if (isEmpty()) throw new java.util.NoSuchElementException();
		return linkedList.removeFirst();
	}
	
	public Item removeLast() {
		if (isEmpty()) throw new java.util.NoSuchElementException();
		return linkedList.removeLast();
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new listIterator();
	}
	
	private class listIterator implements Iterator<Item> {

		Iterator<Item> iterator = linkedList.iterator();
		
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public Item next() {
			return iterator.next();
		}
		
	}
	
	private void checkItem(Item item) {
		if (item == null) {
			throw new java.lang.NullPointerException(); 
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
