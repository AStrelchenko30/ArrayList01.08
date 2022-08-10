package main.java;

import exceptions.ArrayIsFull;

import java.util.ArrayList;
import java.util.List;

public class IntegerListImpl implements IntegerList {
    private ArrayList<Integer> integer;

    public IntegerListImpl() {
        this.integer = new ArrayList<>(List.of(
                new Integer("Каждый охотник"),
                new Integer("желает знать"),
                new Integer("где сидит"),
                new Integer("фазан")
        ));
    }

    @Override
    public Integer add(Integer item) {
        Integer newInteger = new Integer(item);
        integer.add(newInteger);
        return newInteger;
    }

    @Override
    public Integer add(int index, Integer item) {
        int factSize = integer.size();
        Integer newInteger = new Integer(item);
        integer.add(index, newInteger);
        if (integer.size() > factSize) {
            throw new ArrayIsFull();
        }
        return newInteger;
    }

    @Override
    public Integer set(int index, Integer item) {
        Integer newInteger = new Integer(item);
        integer.set(index, newInteger);
        if (index > integer.size()) {
            throw new RuntimeException("Индекс вызодит за пределы массива");
        }
        return newInteger;
    }

    @Override
    public Integer remove(Integer item) {
        Integer newInteger = new Integer(item);
        if (integer.contains(newInteger)) {
            integer.remove(newInteger);
        } else {
            throw new RuntimeException("Данной строки нет в листе");
        }
        return newInteger;
    }

    @Override
    public Integer remove(int index) {
        if (integer.get(index) != null) {
            integer.remove(index);
        } else {
            throw new RuntimeException("Данного индеса нет в листе");
        }
        return integer.get(index);
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] copy=toArray();
        sort(copy);
        return binary(copy,item);
    }

    @Override
    public int indexOf(Integer item) {
        Integer newInteger = toArray(item);
        int indexOf = integer.indexOf(newInteger);
        if (integer.contains(indexOf)) {
            return indexOf;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        Integer newInteger = new Integer(item);
        int indexOf = integer.lastIndexOf(newInteger);
        if (integer.contains(indexOf)) {
            return indexOf;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (integer.get(index) != null) {
            integer.get(index);
        } else {
            throw new RuntimeException("Данного индеса нет в листе");
        }
        return integer.get(index);
    }

    @Override
    public boolean equals(IntegerList otherList) {
        List<Integer> newList = new ArrayList<>();
        newList.add(new Integer("Каждый охотник"));
        boolean result=integer.equals(newList);
        if(newList==null){
            throw new RuntimeException("Пустой лист");
        }
        return result;
}

    @Override
    public int size() {
        return integer.size();
    }

    @Override
    public boolean isEmpty() {
        if(integer.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        integer.removeAll(integer);
    }

    @Override
    public Integer[] toArray() {
        Integer[] newInteger=new Integer[integer.size()];
        for (int i = 0; i < integer.size(); i++) {
            newInteger[i]=integer.get(i);
        }
        return newInteger;
    }
    private void sort(Integer[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
    private boolean binary(Integer [] arr,Integer item){
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
}
