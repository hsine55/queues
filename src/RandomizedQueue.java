import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] array;
    private int N; //elements count
    
    public RandomizedQueue() {
        array = (Item[]) new Object[N+1];
    }
    
    public void enqueue(Item item) {
        checkItem(item);
        array[N++] = item;
        if (N == array.length) resize(2*N);
        
    }
    
    public Item dequeue() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        int itemIndex = StdRandom.uniform(0, N);
        Item result = (Item) array[itemIndex];
        array[itemIndex] = null;
        swap(itemIndex,N-1);
        N--;
        if (N <= array.length/4.0) resize(array.length/2);
        return result;
    }
    
    private void swap(int i, int j) {
        Item firstValue = array[i];
        array[i] = array[j];
        array[j] = firstValue;
    }
    
    public Item sample() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        int itemIndex = StdRandom.uniform(0, N);
        return (Item) array[itemIndex];
    }
    
    private void resize(int newSize) {
        Item[] copyArray = (Item[]) new Object[newSize];
        int iterationSize = newSize > N ? N : newSize;
        for(int i = 0; i < iterationSize; i++) {
            copyArray[i] = array[i];
        }
        array = copyArray;  
    }
    
    public boolean isEmpty() {
        return N == 0;
    }
    
    public int size() {
        return N;
    }
    
    private void checkItem(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException(); 
        }
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new arrayIterator();
    }
    
    private class arrayIterator implements Iterator<Item> {
        
        RandomizedQueue<Item> itRandomizedQueue = new RandomizedQueue<>();
        
        public arrayIterator() {
            for (Item item : array) {
                if (item == null) {
                    break;
                }
                itRandomizedQueue.enqueue(item);
            }
        }
        
        @Override
        public boolean hasNext() {
            return !itRandomizedQueue.isEmpty();
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new java.util.NoSuchElementException();
            return itRandomizedQueue.dequeue();
        }
        
    }
    
    public static void main(String[] args) {
         RandomizedQueue<Integer> rq = new RandomizedQueue();
         rq.enqueue(18);
         rq.enqueue(41);
         rq.enqueue(11);
         System.out.println(rq.dequeue());
         System.out.println(rq.dequeue());
         rq.enqueue(46);

    }

}
