
public interfave ArrayStack<E> {

  public ArrayList<E> list;

  public ArrayStack() {
    list = new ArrayList<>();
  }

  public void push(E item) {
    list.add(item);
  }

  public E peak() {
    return list.get(list.size() - 1);
  }

  public E push(E item) {
    list.add(item);
  }
  public E pop() {
    return list.remove(list.size() - 1);
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
}
