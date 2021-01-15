import java.util.*;

public abstract class MyAbstractList<E> implements MyList<E>    {

    public abstract boolean add(E e);

    public abstract void add(int index, E element);

    public abstract void clear();

    public boolean contains(Object obj) {
        return indexOf(obj)!= -1;
    }

    public abstract boolean equals(Object obj);

    public abstract E get(int index);

    public abstract E set(int index, E element);

    public abstract int indexOf(Object obj);

    public boolean isEmpty() {
        return size()==0;
    }

    public abstract Iterator<E> iterator();

    public abstract int lastIndexOf(Object obj);

    public abstract E remove(int index);

    public boolean remove(Object obj) {
        int index = indexOf(obj);

        if(index == -1)
            return false;

        remove(index);
        return true;
    }

    public abstract int size();

}
