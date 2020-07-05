package design.iterator;

public class MyArrayList<E> implements MyCollection<E> {
    E [] objects = (E [])new Object[10];
    private int index = 0;
    public void add(E o){
        if(index == objects.length) {
            E [] newObjects = (E[]) new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index ++;
    }

    public int size(){

        return  index;
    }

    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator<E> implements Iterator<E>{
        private int currentIndex = 0;
        public boolean hansNext() {
           if(currentIndex>=index){
               return false;
           }
           return true;
        }

        public E next() {
            E o = (E) objects[currentIndex];
            return  o;
        }
    }
}
