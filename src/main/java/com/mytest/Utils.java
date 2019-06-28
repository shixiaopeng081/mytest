package com.mytest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shixi  on 2018/11/29
 */
@Data
@Slf4j
public class Utils {
    public static void main(String[] args) {
        //时间戳毫秒转LocalDateTime
//        LocalDateTime localDateTime = new Date(1535444725000L).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
//
//        System.out.println(localDateTime);
//
//        System.out.println(getRemainSecondsOneDay(new Date()));
//        listTest();

//        List<String> ss = new ArrayList<>();
//        ss.add("1");
//        ss.add("2");
//        ss.add("3");
//
//        String [] aa = new String[ss.size()];
//        ss.toArray(aa);
//
//        log.info("ss : {}",ss);
//        log.info("aa : {}",aa);

        String dateStr = "2019-02-28";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateStr, dateTimeFormatter);

        int day = localDate.getDayOfMonth();
        if(day == 10 ){
            System.out.println("上旬日");
        }else if(day ==20){
            System.out.println("中旬日");
        }else if(day==localDate.lengthOfMonth()){
            System.out.println("下旬日");
        }
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.lengthOfMonth());


    }

    public static Integer getRemainSecondsOneDay(Date currentDate) {
        //获取当前时间，到今晚12点的剩余秒
        LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());
        long seconds = ChronoUnit.SECONDS.between(currentDateTime, midnight);
        return (int) seconds;
    }

    public static void listTest(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);




        for(int i = 1;i < 3 ;i ++){
            List<Integer> listNew = new ArrayList<>();
            listNew.addAll(list1);
            listNew.removeAll(list2);
            listNew.removeAll(null);
            System.out.println(list1);

        }
    }

}
