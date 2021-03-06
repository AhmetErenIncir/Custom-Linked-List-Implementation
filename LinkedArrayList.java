import java.util.*;

public class LinkedArrayList<E> extends AbstractList<E> implements List<E>  {

    private Node<E> head ;
    private Node<E> tail;
    private Node<E> iter;
    private int CurrentSizeList;

    /**
     * Constructor
     */
    public LinkedArrayList(){
        head = new Node<>();
        iter = head;
        tail = head;
        CurrentSizeList = 1;
    }

    /**
     * My inner class. This node holds the information about list using array.
     * @param <T>
     */
    class Node<T>{

        private  T[] arr ;
        private Node<T> next;
        private Node<T> prev;
        private int  CurrentSizeArr;
        static final int MAX_SIZE_OF_ARRAY = 5;

        /**
         * No argument constructor
         */
        public Node(){
            arr = (T[]) new Object[MAX_SIZE_OF_ARRAY];
            next = null;
            prev = null;
            CurrentSizeArr = 0;
        }

        /**
         * This constructor takes new data , prev and next for new node
         * @param data
         * @param prev
         * @param next
         */
        public Node(T data , Node<T> prev, Node<T> next) {
           CurrentSizeArr = 0;
           arr = (T[]) new Object[MAX_SIZE_OF_ARRAY];
           arr[CurrentSizeArr] = data;
           this.next = next;
           this.prev = prev;
           CurrentSizeArr++;
        }

        /**
         * returns value of index
         * @param index index
         * @return
         */
        public T getData(int index){
            return arr[index];
        }

        /**
         * This method takes index and replace the index value with new data
         * @param index index
         * @param newData new data
         */
        public void setData(int index ,T newData){
            arr[index] = newData;
        }

        /**
         * This method returns next node
         * @return next node
         */
        public Node<T> getNext(){
            return next;
        }

        /**
         * This method returns previous node
         * @return previous node
         */
        public Node<T> getPrev(){
            return prev;
        }

        /**
         * Change the next node with new node.
         * @param
         */
        public void SetNext(Node<T> newNext){
            this.next = newNext;
        }
        /**
         * Change the previous node with new node.
         * @param
         */
        public void SetPrev(Node<T> newPrev){
            this.prev = newPrev;
        }

        /**
         * It returns size of node
         * @return size of node
         */
        public int getCurrentSizeArr() {
            return CurrentSizeArr;
        }

        /**
         * This method returns true if node has space
         * @return boolean
         */
        public boolean hasSpace(){
            return CurrentSizeArr < MAX_SIZE_OF_ARRAY;
        }

        /**
         * This method insert element to node
         * @param data
         */
        public void insert(T data){
            if(CurrentSizeArr < MAX_SIZE_OF_ARRAY){
                arr[CurrentSizeArr] = data;
                CurrentSizeArr++;
            }
        }

        /**
         * This method pirnts elements of node
         */
        public void print(){

            for(int i=0 ; i<CurrentSizeArr ; i++){
                System.out.print(arr[i] + " ");
            }
        }

        /**
         * This method returns value according to index
         * @param index index of array
         * @return index value
         */
        public T getElement(int index){return arr[index];}



    }

    /**
     * My custom iterator class , implements from ListIterator Interface
     */
    class LinkedArrayListIterator implements ListIterator<E>{

        private Node<E> current;

        /**
         * Constructor
         */
        public LinkedArrayListIterator(){
            current = head;
        }

        /**
         * This methods returns true if list has next node.
         * @return boolean
         */
        @Override
        public boolean hasNext() {

            return current.next != null;

        }

        /**
         * This method provides to pass next node
         * @return current index value
         */
        @Override
        public E next() {

            if(current == null){
                throw new NoSuchElementException();
            }
            E temp = current.getData(0);
            current.print();
            current = current.getNext();
            return temp;
        }

        /**
         * This methods returns true if list has previous node.
         * @return boolean
         */
        @Override
        public boolean hasPrevious() {
            return current.prev != null;
        }

        /**
         * This method provides to pass previous node
         * @return current index value
         */
        @Override
        public E previous() {
            if(current == null){
                throw new NoSuchElementException();
            }
            E temp = current.getData(0);
            current.print();
            current = current.getPrev();
            return temp;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {
            
        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {
            current.insert(e);
        }


    }


    /**
     * This method returns head of list
     * @return head
     */
    public Node<E> getHead(){
        return head;
    }

    /**
     * This method returns tail of list
     * @return tail
     */
    public Node<E> getTail() {
        return tail;
    }

    /**
     * This method returns current size of list
     * @return size of list
     */
    public int getCurrentSizeList() {
        return CurrentSizeList;
    }
    /**
     * This method returns current size of list
     * @return size of list
     */
    @Override
    public int size() {
        return CurrentSizeList;
    }

    /**
     * It returns true if list is empty
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    /**
     * This method returns my custom inner iterator class.
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * This method insert new element to end.
     * @param e new element
     * @return boolean
     */
    @Override
    public boolean add(E e) {

        Iterator<E> iterator = this.iterator();

        if(iter.hasSpace())
            iter.insert(e);
        else{
            iter.next = new Node<E>();
            iter.next.prev = iter;
            iter = iter.next;
            iter.insert(e);
            CurrentSizeList++;
            iter.next = new Node<E>();
        }

        return true;
    }

    /**
     * This method remove the element.
     * @param o element
     * @return boolean
     */
    @Override
    public boolean remove(Object o) {

        //ListIterator<E> iter = this.iterator();

        iter = head;

        int index = 0;

        while (iter.next != null){

            for(int i=0; i<iter.getCurrentSizeArr() ; i++){
                if(iter.getData(i) == o){
                    index = i;
                    break;
                }
            }

            iter = iter.next;

        }



        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    /**
     * This method clear all list.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        CurrentSizeList = 0;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    /**
     * It returns the element in the ArrayList.
     * @param index index of element
     * @return return the index value
     */
    @Override
    public E get(int index) {
        iter = head;

        while (iter.next != null){
            if(iter.getCurrentSizeArr() < index){
                index = index - iter.getCurrentSizeArr();
            }
            else break;
            iter = iter.next;
        }

        return iter.getData(index-1);
    }

    /**
     * This method Change value of index.
     * @param index index of changing data
     * @param element new element
     * @return current index value
     */
    @Override
    public E set(int index, E element) {
        iter = head;

        while (iter.next != null){
            if(iter.getCurrentSizeArr() < index){
                index = index - iter.getCurrentSizeArr();
            }
            else break;
            iter = iter.next;
        }

        iter.setData(index-1,element);

        return iter.getData(index-1);
    }

    /**
     * This method insert new element according to index.
     * @param index index of changing element
     * @param element new element
     */
    @Override
    public void add(int index, Object element) {
        iter = head;

        while (iter.next != null){
            if(iter.getCurrentSizeArr() < index){
                index = index - iter.getCurrentSizeArr();
            }
            else break;
            iter = iter.next;
        }

        iter.setData(index-1,(E) element);

    }

    /**
     * This method removes element according to index
     * @param index index of removed element
     * @return removed element
     */
    @Override
    public E remove(int index) {

        Iterator<E> iterator = this.iterator();

        if(index < 0 )
            throw new IndexOutOfBoundsException();
        iter = head;
        while (iter.next != null){
            if(iter.getCurrentSizeArr() < index){
                index = index - iter.getCurrentSizeArr();
            }
            else {
                if(iter.getCurrentSizeArr() == 0){
                    iter.prev = iter.next;
                    iter.next = iter.prev;
                }

                for(int i = index-1 ; i<iter.getCurrentSizeArr()-1 ; i++){
                    iter.setData(i,iter.getData(i+1));
                }
                iter.CurrentSizeArr--;
                break;
            }
            iter = iter.next;
        }

        return iter.getData(index-1);
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    /**
     * My custom listIterator method.
     * @return LinkedArrayListIterator
     */
    @Override
    public ListIterator<E> listIterator() {
        return new LinkedArrayListIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        return new LinkedArrayListIterator();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {



        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    /**
     * It prints current status of Nodes and List.
     */
    public void printList(){

        Node<E> iter = head;

        while (iter != null){
            iter.print();
            iter = iter.next;
        }

    }


}
