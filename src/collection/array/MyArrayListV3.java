package collection.array;

import java.util.Arrays;

public class MyArrayListV3 {

    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elementsData;
    private int size = 0;
    public MyArrayListV3() {
        elementsData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV3(int initialCapacity) {
        elementsData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(Object e) {
        if(size == elementsData.length) {
            grow();
        }
        elementsData[size] = e;
        size++;
    }

    public void add(int index, Object e) {
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

    public Object get(int index) {
        return elementsData[index];
    }

    public Object set(int index, Object element) {
        Object oldValue = get(index);
        elementsData[index] = element;
        return oldValue;
    }

    //코드 추가
    public Object remove(int index) {
        Object oldValue = get(index);
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

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if(o.equals(elementsData[i])) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementsData, size)) +
                "size=" + size + ", capacity=" + elementsData.length;
    }
}
