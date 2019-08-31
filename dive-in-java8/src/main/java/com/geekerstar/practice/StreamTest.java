package com.geekerstar.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author geekerstar
 * date: 2019-08-31 20:36
 * description:
 */
public class StreamTest {
    public static void main(String[] args) {
        learnStream();
    }

    private static void learnStream() {
        // 创建一个1-6乱序的list
        List<Integer> lists = new ArrayList<>();
        lists.add(4);
        lists.add(3);
        lists.add(6);
        lists.add(1);
        lists.add(5);
        lists.add(2);

        // list里面的数据
        System.out.println("lists原来的数据:");

        for (Integer elem : lists){
            System.out.print(elem + " ");
        }
        System.out.println();

        // 最小值
        System.out.print("lists的最小值");
        Stream<Integer> stream = lists.stream();
        Optional<Integer> min = stream.min(Integer::compareTo);
        if (min.isPresent()){
            System.out.println(min.get());
        }

        // 最大值
        System.out.print("lists的最大值");
        lists.stream().max(Integer::compareTo).ifPresent(System.out::println);

        // 排序
        System.out.print("将list流进行排序");
        Stream<Integer> sorted = lists.stream().sorted();
        sorted.forEach(elem -> System.out.print(elem+""));
        System.out.println();

        // 过滤
        System.out.print("过滤list流，只剩下大于3的元素");
        lists.stream()
                .filter(elem -> elem > 3)
                .forEach(elem -> System.out.print(elem + ""));
        System.out.println();

        // 过滤
        System.out.print("过滤list流，只剩下大于0且小于4的元素");
        lists.stream()
                .filter(elem -> elem > 0)
                .filter(elem -> elem < 4)
                .sorted(Integer::compareTo)
                .forEach(System.out::print);


        // 看看原来的list有没有变化
        System.out.print("原来list里的数据");
        for (Integer elem : lists){
            System.out.print(elem + "");

        }




    }
}
