import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class Permutation
{

    public static void main(String[] args)
    {
        Integer k = Integer.valueOf(args[0]);
        RandomizedQueue rq = new RandomizedQueue();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            rq.enqueue(s);
        }
        while(k>0) {
            System.out.println(rq.dequeue());
            k--;
        }
    }
}
