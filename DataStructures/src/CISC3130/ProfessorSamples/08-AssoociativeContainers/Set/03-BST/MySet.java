import java.util.*;

public class MySet<E> implements Iterable<E> {

    private class SetIterator implements Iterator<E> {
        private ArrayList<E> elements;
        private int index;

        public SetIterator() {
            elements = new ArrayList<>();
            inorderTraversal(root, elements);
            index = 0;
        }

        public E next() {
            index++;
            return elements.get(index-1);
        }
        public boolean hasNext() {
            return index < elements.size();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }


    }


    private static class TreeNode<E>{
        public E data;
        public TreeNode<E> left;
        public TreeNode<E> right;
        public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode<E> root;
    private Comparator<E> comp;
    private int numElements;

    public MySet(Comparator<E> comp) {
        this.comp = comp;
        this.root = null;
        this.numElements = 0;
    }

    public MySet() {
        this(null);
    }

    private int myCompFn(E e1, E e2) {
        if(e1 instanceof Comparable)
            return ((Comparable<E>)e1).compareTo(e2);
        else
            return comp.compare(e1, e2);

    }


    public boolean add(E e) {
        if(contains(e))
            return false;

        this.root = add(root, e);
        this.numElements++;
        return true;
    }

    private TreeNode<E> add(TreeNode<E> root, E data) {
        if(root==null) {
            root = new TreeNode<E>(data, null, null);
            return root;

        }else if(myCompFn(data, root.data) < 0)
            root.left = add(root.left, data);
        else
            root.right = add(root.right, data);

        return root;
    }

    public boolean contains(Object obj) {
        return contains(root, (E)obj);
    }

    private boolean contains(TreeNode<E> root, E data) {
        if(root==null)
            return false;

        int result = myCompFn(data, root.data);

        if(result==0)
            return true;
        else if (result < 0)
            return contains(root.left, data);
        else
            return contains(root.right, data);

    }

    public int size() {
        return numElements;
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public void clear() {
        root=null;
        numElements=0;
    }

    public Iterator<E> iterator() {
        return new SetIterator();
    }

    private void inorderTraversal(TreeNode<E> root, ArrayList<E> elems) {
        if(root==null)
            return;

        inorderTraversal(root.left, elems);
        elems.add(root.data);
        inorderTraversal(root.right, elems);
    }

    public static void main(String[] args) {
        MySet<Integer> set = new MySet<>();

        for(int i=0; i<10; i++)
            set.add(i);

        for(int x: set) {
            System.out.println(x);
        }
    }

}
