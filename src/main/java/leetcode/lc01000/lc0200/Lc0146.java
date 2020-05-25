package leetcode.lc01000.lc0200;

import java.util.*;

public class Lc0146 {

    Map<Integer,Integer> map = new HashMap();
    List<Integer> list = new ArrayList<>() ;
    int capacity ;
    public Lc0146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null){
            return -1;
        }else{
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == key){
                    list.remove(i);
                    break;
                }
            }
            //把当前元素添加到头部
            list.add(0,key);
            return value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == key){
                    list.remove(i);
                    break;
                }
            }
            list.add(0,key);
            map.put(key,value);
        }else {
            if (map.size() == capacity) {
                //删除最后一个元素
                Integer remove = list.remove(list.size() - 1);
                map.remove(remove);
                //把当前元素添加到尾部
                list.add(0,key);
                map.put(key,value);
            } else {
                map.put(key, value);
                list.add(0,key);
            }
        }
    }

}
