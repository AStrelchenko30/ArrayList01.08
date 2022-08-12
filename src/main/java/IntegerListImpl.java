package main.java;

import exceptions.ArrayIsFull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray.partition;

public class IntegerListImpl implements IntegerList {
    private Integer[] integer;
    private int size;

    public IntegerListImpl(Integer[] integer) {
        integer = new Integer[10];
    }

    public IntegerListImpl(int initSize) {
        integer = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        growIfNeeded();
        validateItem(item);
        integer[size++]=item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
       validateItem(item);
       growIfNeeded();
       validateIndex(index);
       if(index==size){
           add(item);
           return item;
       }
        System.arraycopy(integer,index,integer,index+1,size-index);
       integer[index]=item;
       return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        integer[index]=item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
      validateItem(item);
      int index=indexOf(item);
      if(index==-1){
          throw new RuntimeException();
      }
      System.arraycopy(integer,index+1,integer,index,size-index);
      size--;
      return item;
    }

    @Override
    public Integer remove(int index) {
        Integer item=integer[index];
        validateIndex(index);
        if(index==-size) {
            System.arraycopy(integer, index + 1, integer, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] copy = toArray();
        sort(copy);
        return binary(copy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i <size ; i++) {
            Integer s=integer[i];
            if(s.equals(item)){
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Integer item) {

        for (int i = size-1; i >= 0 ; i--) {
            Integer s = integer[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
       validateIndex(index);
       return integer[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integer, size);
    }

    private void sort(Integer[] arr) {
        quickSort(arr,0,arr.length-1);
        }
    }

    private boolean binary(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void grow() {
        integer = Arrays.copyOf(integer, size + size / 2);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new RuntimeException();
        }
    }

    private void growIfNeeded() {
        if (size == integer.length) {
            grow();
        }
    }

    private void validateIndex(Integer index) {
        if (index < 0 || index > size) {
            throw new RuntimeException();
        }
    }
    private void quickSort(Integer[]arr,int begin,int end){
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }

    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}