import java.util.*;
public class SentinelLink<E> {

    private class Node{
        private E data;
        private Node next, prev;

        public Node() {}
            public Node(E data) {
                this.data = data;
            }
            public boolean hasNext() {
                return next != null;
            }

        }

        private Node s;
        public int len;

        public SentinelLink(){
            s = new Node();
            s.next= null;
            s.prev= null;
        }

        public void addFirst(E data) {
            Node nmd = new Node(data);

            if(s.next == null) {
                s.next = nmd;
                nmd.prev = s;
                nmd.next = s;
                s.prev = nmd;
            }else {
                nmd.next = s.next;
                nmd.prev = s;
                s.next.prev = nmd;
                s.next = nmd;
            }

            len++;
        }

        public boolean isEmpty() {
            return len == 0;
        }
        public int size() {
            return len;

        }

        public void add(int ind, E data ) {
            Node nmd= new Node(data);
            Node create= s.next;
            while(create.hasNext()) {
                create = Next();
            }
        }

        private SentinelLink<E>.Node Next() {
            // TODO Auto-generated method stub
            return null;
        }

        public boolean add(E data) {
            addLast(data);
            return true;
        }

        public void clear() {
            s.prev = null;
            s.next = null;
            len = 0;
        }
        public void print() {
            Node temp = s;
            while(temp.next != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
        public boolean removeFirstOccurrence(Object o) {
            int count = 0;
            Node nmd = s;
            for(int i=0; i<size(); i++) {
                nmd= nmd.next;
                if(nmd.equals(o))
                count ++;
                if(count == 1)
                return true;
            }
            return false;
        }
        public boolean removeLastOccurrence(Object o) {
            int count = 0;
            Node nmd = s;
            for(int i=0; i<size(); i++) {
                nmd = nmd.prev;
                if(nmd.equals(o))
                count ++;
                if(count == 1)
                return true;
            }
            return false;
        }
        public E removeLast() {
            s.prev = s.prev.prev;
            s.prev.next = s;

            return s.prev.data;
        }
        public E remove() {
            if(this.isEmpty())
            throw new NoSuchElementException();
            Node nmd = s.next.next;
            nmd = s.next.prev;
            s.next = nmd;
            return s.next.data;

        }
        public E getLast() {
            return s.prev.data;
        }

        public E getFirst(){
            return s.next.data;
        }

        public E element() {
            return s.next.data;
        }

        public E peek() {
            return element();
        }
        public E peekFirst() {

            if(s.next == null)
            return null;
            return element();
        }

        public E peekLast() {
            if(s.prev == null)
            return null;
            return s.prev.data;
        }

        public E removeFirst() {
            s.next = s.next.next;
            s.next.prev = s;

            return s.next.data;
        }
        public E set(int index, E element) {
            return null;
        }

        public void addLast(E e) {
            Node nmd = new Node(e);
            if(s.next == null) {
                s.next = nmd;
                s.prev = nmd;
                nmd.prev = s;
                nmd.next = s;
            }else {
                nmd.next = s;
                s.prev.next =  nmd;
                nmd.prev = s.prev;
                s.prev = nmd;
            }

            len++;
        }
    }
