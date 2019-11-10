package com.geekerstar.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author geekerstar
 * date: 2019-08-23 14:12
 * description:
 */
public class LocalDateTest {
    @Test
    public void LambdaTest1(){
        List<String> names = Arrays.asList("hello","world","yes","no");

//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });


//        Collections.sort(names,(String a,String b) -> {
//            return b.compareTo(a);
//        });


//        Collections.sort(names,(String a,String b) -> b.compareTo(a));


//        names.sort((a,b) -> b.compareTo(a);

        names.sort(Comparator.reverseOrder());
        System.out.println(names);

    }

}
