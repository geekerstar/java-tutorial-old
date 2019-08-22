package com.geekerstar.collection1;

import org.junit.Test;

import java.util.*;

/**
 * @author geekerstar
 * date: 2019-07-22 09:37
 * description:
 */
public class Test01 {
    /**
     * 使用iterator接口迭代访问集合
     */
    @Test
    public void test1(){
        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }
    }



    /**
     * 使用Lambda表达式来遍历iterator
     */
    @Test
    public void test2(){
        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        Iterator<String> iterator = list.iterator();
        iterator.forEachRemaining((String name)->System.out.println(name));
    }

    /**
     * 使用foreach循环遍历list
     */
    @Test
    public void test3(){
        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        for (String name : list){
            System.out.println(name);

        }
    }

    /**
     * 随机访问，通过索引值遍历list
     */
    @Test
    public void test4(){
        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        int size = list.size();
        for (int i = 0; i < size; i++){
            System.out.println(list.get(i));

        }
    }

    /**
     * 遍历set，通过Iterator(推荐）
     */
    @Test
    public void test5(){
        Set<String> set = new HashSet<>();
        set.add("c");
        set.add("b");
        set.add("a");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }
    }
}
