package chen.zhujie;

import java.util.*;

/**
 * 陈宇超
 * 20:50
 */
public class MyList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();


        TreeMap<String, Jiansheng> treeMap = new TreeMap(new Comparator<Jiansheng>() {
            @Override
            public int compare(Jiansheng o1, Jiansheng o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });



    }
}

class Jiansheng implements Comparable<Jiansheng> {
    private int id;
    private String name;

    public Jiansheng() {
    }

    public Jiansheng(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Jiansheng o) {
        return 0;
    }
}




