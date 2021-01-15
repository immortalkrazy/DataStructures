import java.util.*;
import java.io.*;

public class MyHeapQueue<E> implements MyPriorityQueue<E>{

    private ArrayList<E> theHeap;
    private Comparator<E> comp;

    public MyHeapQueue() {
        this(null);

    }

    public MyHeapQueue(Comparator<E> comp) {
        this.theHeap = new ArrayList<>();
        this.comp = comp;
    }

    public boolean isEmpty() {
        return theHeap.isEmpty();
    }

    public boolean add(E e) {
        theHeap.add(e);

        bubbleUp(size()-1);

        return true;
    }

    public E peek() {
        return theHeap.get(0);
    }

    public E poll(){
        swap(theHeap, 0, size()-1);
        E answer = theHeap.get(size()-1);
        theHeap.remove(size()-1);
        minHeapify(0);

        return answer;
    }

    public void clear() {
        theHeap.clear();
    }

    public int size() {
        return theHeap.size();
    }

    public Iterator<E> iterator() {
        return theHeap.iterator();
    }

    public boolean contains(Object obj) {
        return theHeap.contains(obj);
    }

    public boolean remove(Object obj) {
        theHeap.remove(obj);

	buildHeap();

	return true;
    }

    private void bubbleUp(int index){
        int parent = parentIndex(index);

        //as long as index is in bounds
        //and the index and parent are in the wrong order, swap them.
        while(index > 0 &&
              myCompareFn(theHeap.get(index), theHeap.get(parent)) < 0) {

            swap(theHeap, index, parent);

            index = parent;
            parent = parentIndex(index);
        }


    }

    private void minHeapify(int root) {

        //find the smaller of the two children.
        int left = leftChildIndex(root);
        int right = rightChildIndex(root);

        int indexOfSmallest;

        if(left < theHeap.size() &&
           myCompareFn(theHeap.get(left), theHeap.get(root)) < 0)

            indexOfSmallest = left;

        else
            indexOfSmallest = root;

        if(right < theHeap.size() &&
            myCompareFn(theHeap.get(right), theHeap.get(indexOfSmallest)) < 0)

                indexOfSmallest = right;


        //if the root is smallest, do nothing.
        //Otherwise, swap the root with the smaller child and repeat.
        if(indexOfSmallest != root) {
            swap(theHeap, indexOfSmallest, root);
            minHeapify(indexOfSmallest);
        }

    }

    private void buildHeap() {

	for(int i=(theHeap.size()-1)/2; i>=0; i--)
		minHeapify(i);
   }

    private int myCompareFn(E e1, E e2) {
        if(comp==null)
            return ((Comparable<E>)e1).compareTo(e2);
        else
            return comp.compare(e1, e2);
    }

    private static int parentIndex(int index) {
        return (index-1)/2;
    }

    private static int leftChildIndex(int index) {
        return 2*index + 1;
    }

    private static int rightChildIndex(int index) {
        return 2*index + 2;
    }

    private static <E>  void swap(ArrayList<E> arr, int index1, int index2) {
        E e = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, e);
    }

    public static void main(String[] args) throws Exception {

        MyHeapQueue<Integer> intPQueue = new MyHeapQueue<>();

        for(String arg: args)
            intPQueue.add(Integer.parseInt(arg));

        while(!intPQueue.isEmpty())
            System.out.println(intPQueue.poll());

        MyHeapQueue<String> strQueue = new MyHeapQueue<>(new Comparator<String>() {
                                                            public int compare(String str1, String str2) {
                                                                return -str1.compareTo(str2);
                                                            }
                                                         });
        Scanner scanner = new Scanner(new File("MyHeapQueue.java"));

        while(scanner.hasNext())
            strQueue.add(scanner.next());

        while(!strQueue.isEmpty())
            System.out.println(strQueue.poll());


    }


}
