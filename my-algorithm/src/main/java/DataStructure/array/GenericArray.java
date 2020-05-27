package DataStructure.array;

import java.util.Date;
import java.util.Objects;

/**
 * @Auther: tinntetuki
 * @Date: 2020/5/24 16:38
 * @Description:
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }

    public int capacity() {
        return data.length;
    }

    public int count() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set (int index, T e){
        checkIndex(index);
        data[index] = e;
    }

    public T get(int index){
        checkIndex(index);
        return data[index];
    }

    public boolean contains(T e) {
        for (T t : data) {
            if (t.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find (T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void add (int index, T value) {
        checkIndexForAdd(index);
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size -1; i >= index; i--) {
            data[i] = data[i-1];
        }

        data[index] = value;
        size ++;
    }

    public void addFirst(T value){
        add(0, value);
    }

    public void addLast(T value){
        add(size, value);
    }

    public T remove(int index){
        checkIndex(index);

        T ret = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size --;
        data[size] = null;

        if (size == data.length / 4 && data.length /2 != 0) {
            resize(data.length /2);
        }

        return ret;
    }

    public T removeFirst(){
        return remove(0);
    }

    public T removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    private void resize(int length) {
        T[] newData = (T[])new Objects[length];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed, required index > 0 and index < size");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index <= size.");
        }
    }

}
