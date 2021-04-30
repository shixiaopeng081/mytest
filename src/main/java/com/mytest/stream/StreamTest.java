package com.mytest.stream;

import lombok.Data;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shixi  on 2018/11/8
 */
public class StreamTest {

    public static void main(String[] args) {
        //流的初始化

        Stream stream = Stream.of("aaaa", "bbb", "ccc");

        Integer[] arrayInteger = {1, 2, 3, 4, 5, 6};
        Stream streamInt = Stream.of(arrayInteger);


        List<Integer> integerList = Arrays.asList(arrayInteger);
        Stream st = integerList.stream();

        //流的操作

        List<Student> stuList = new ArrayList<>();
        stuList.add(new Student("test1", 1, 80));
        stuList.add(new Student("test2", 2, 84));
        stuList.add(new Student("test3", 1, 78));
        //根据list中的某个属性分组，生成map
        Map<Integer, List<Student>> listMap = stuList.stream().collect(Collectors.groupingBy(o -> o.getSex()));
        //自定义map类型
        LinkedHashMap<Integer, List<Student>> linkedMap = stuList.stream().collect(
                Collectors.groupingBy(o -> o.getSex(),
                LinkedHashMap::new,
                Collectors.toList()));

        System.out.println(listMap);

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        //过滤功能

        System.out.println(strings.stream().filter(s -> !s.isEmpty()).count());

        List<String> stringList = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println(stringList);

        String mergedString = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        //循环功能
        stringList.forEach(System.out::println);
        stringList.forEach(s -> System.out.println(s.length()));


        List<Student> staff = Arrays.asList(
                new Student("mkyong", 30, 67),
                new Student("jack", 27, 77),
                new Student("lawrence", 33, 69)
        );

        staff.forEach(student -> student.setName("1111"));
        staff.stream().forEach(student -> student.setName("22222"));
        //map操作
        List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println("*************"+collect); //[mkyong, jack, lawrence]


        List<Student> collect1 = staff.stream().map(student -> {
            Integer score = student.getScore();
            student.setScore(score + 10);
            return student;
        }).collect(Collectors.toList());

        System.out.println(collect1);

        Map<Integer, Student> studentMap = staff.stream().collect(Collectors.toMap(o -> o.getSex(), o -> o));

        System.out.println(studentMap);

        //Stream 和 parallelStream比较
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            testList.add(i);
        }

        Long start = System.currentTimeMillis();
        testList.stream()
                .forEach(integer -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        Long end = System.currentTimeMillis();
        System.out.println((end - start) + "first for");
        start = System.currentTimeMillis();
        testList.parallelStream()
                .forEach(integer -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        end = System.currentTimeMillis();
        System.out.println((end - start) + "second for");
    }

    @Data
    static class Student {
        private String name;
        private Integer sex;
        private Integer score;

        public Student(String name, Integer sex, Integer score) {
            this.name = name;
            this.sex = sex;
            this.score = score;
        }
    }

}
