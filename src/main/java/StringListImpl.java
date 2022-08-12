package main.java;

import java.util.ArrayList;
import java.util.List;

public class StringListImpl implements StringList {
    private ArrayList<Strings> strings;

    public StringListImpl() {
        this.strings = new ArrayList<>(List.of(
                new Strings("Каждый охотник"),
                new Strings("желает знать"),
                new Strings("где сидит"),
                new Strings("фазан")
        ));
    }

    @Override
    public String add(String item) {
        Strings newString = new Strings(item);
        strings.add(newString);
        return newString.toString();
    }

    @Override
    public String add(int index, String item) {
        int factSize = strings.size();
        Strings newString = new Strings(item);
        strings.add(index, newString);
        if (strings.size() > factSize) {
            throw new Ar;
        }
        return newString.toString() + "добавлен";
    }

    @Override
    public String set(int index, String item) {
        Strings newString = new Strings(item);
        strings.set(index, newString);
        if (index > strings.size()) {
            throw new RuntimeException("Индекс вызодит за пределы массива");
        }
        return newString.toString() + "заменен";
    }

    @Override
    public String remove(String item) {
        Strings newString = new Strings(item);
        if (strings.contains(newString)) {
            strings.remove(newString);
        } else {
            throw new RuntimeException("Данной строки нет в листе");
        }
        return newString.toString() + "строка удалена";
    }

    @Override
    public String remove(int index) {
        if (strings.get(index) != null) {
            strings.remove(index);
        } else {
            throw new RuntimeException("Данного индеса нет в листе");
        }
        return strings.get(index) + "строка удалена";
    }

    @Override
    public boolean contains(String item) {
        Strings newString = new Strings(item);
        boolean result = strings.contains(newString);
        return result;
    }

    @Override
    public int indexOf(String item) {
        Strings newString = new Strings(item);
        int indexOf = strings.indexOf(newString);
        if (strings.contains(indexOf)) {
            return indexOf;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        Strings newString = new Strings(item);
        int indexOf = strings.lastIndexOf(newString);
        if (strings.contains(indexOf)) {
            return indexOf;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (strings.get(index) != null) {
            strings.get(index);
        } else {
            throw new RuntimeException("Данного индеса нет в листе");
        }
        return strings.get(index) + "строка удалена";
    }

    @Override
    public boolean equals(StringList otherList) {
        List<Strings> newList = new ArrayList<>();
        newList.add(new Strings("Каждый охотник"));
        boolean result=strings.equals(newList);
        if(newList==null){
            throw new RuntimeException("Пустой лист");
        }
        return result;
}

    @Override
    public int size() {
        return strings.size();
    }

    @Override
    public boolean isEmpty() {
        if(strings.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        strings.removeAll(strings);
    }

    @Override
    public String[] toArray() {
        String[] newString=new String[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            newString[i]=strings.get(i).toString();
        }
        return newString;
    }
}
