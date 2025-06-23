package com.example.newdemo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class NewDemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("this is a test demo");
        System.out.println("hello world\n");
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = numbers.stream();
        Stream<Integer> integerStream = stream.map(x -> x * 2);
        List<Integer> collect = integerStream.collect(Collectors.toList());
// 使用Lambda表达式映射每个元素的平方
        List<Integer> squares = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(squares);
// 输出: [1, 4, 9, 16, 25]



        Person tom = new Person(12, "tom");
        Person toki = new Person(23, "toki");
        Person abbly = new Person(12, "abbly");
        ArrayList<Person> people = CollUtil.toList(tom, toki, abbly);
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge(); //升序
//                return o2.getAge() - o1.getAge(); //降序
//                return o1.getName().compareTo(o2.getName());//姓名字母排序
                return StrUtil.compare(o1.getName(), o2.getName(), true);

            }
        });


        for (Person p : people) {
            System.out.println(p.getName() + ",age:" + p.getAge());
        }

    }
}
