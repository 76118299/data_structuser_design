package design.iterator;

public interface MyCollection<E> {
    public void  add(E o);
    public int size();

    Iterator iterator();
}
