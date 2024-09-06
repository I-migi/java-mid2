package collection.list;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elementsData;
    private int size = 0;
    public MyArrayList() {
        elementsData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        elementsData = new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        if(size == elementsData.length) {
            grow();
        }
        elementsData[size] = e;
        size++;
    }

    @Override
    public void add(int index, E e) {
        if(size == elementsData.length) {
            grow();
        }
        //데이터 이동
        shiftRightFrom(index);
        elementsData[index] = e;
        size++;
    }

    //코드 추가, 요소의 마지막부터 index까지 오른쪽으로 밀기
    private void shiftRightFrom(int index) {
        for (int i= size; i> index; i--) {
            elementsData[i] = elementsData[i - 1];
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementsData[index];
    }

    @Override
    public E set(int index, E element) {
        E oldValue = get(index);
        elementsData[index] = element;
        return oldValue;
    }

    private void grow() {
        int oldCapacity = elementsData.length;
        int newCapacity = oldCapacity * 2;


        //배열을 새로 만들고, 기존 배열을 새로운 배열에 복사
//        Object[] newArr = new Object[newCapacity];
//
//        for (int i = 0; i < elementsData.length; i++) {
//            newArr[i] = elementsData[i];
//        }

        elementsData = Arrays.copyOf(elementsData, newCapacity);

    }

    //코드 추가
    @Override
    public E remove(int index) {
        E oldValue = get(index);
        shiftLeftFrom(index);

        size--;
        elementsData[size] = null;
        return oldValue;

    }

    private void shiftLeftFrom(int index) {
        for (int i = index; i< size-1; i++) {
            elementsData[i] = elementsData[i+1];
        }
    }
    @Override
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if(o.equals(elementsData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementsData, size)) +
                "size=" + size + ", capacity=" + elementsData.length;
    }
}
