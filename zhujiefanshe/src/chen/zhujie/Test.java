package chen.zhujie;

import java.util.HashMap;

/**
 * 陈宇超
 * 15:25
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name",new Person());
        hashMap.put("sex","male");

        System.out.println(hashMap.get("name"));
        System.out.println("do you like what you see?");
    }
}

class Person{

}
