package com.mytest;

import com.mytest.vo.Person;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
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
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by shixi  on 2018/11/29
 */
@Data
@Slf4j
public class Utils {
    public static void main(String[] args) {
        //时间戳毫秒转LocalDateTime
        LocalDateTime localDateTime = new Date(1535444725000L).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();

        System.out.println(localDateTime);

        System.out.println(getRemainSecondsOneDay(new Date()));
//        listTest();

        List<String> ss = new ArrayList<>();
        ss.add("1");
        ss.add("2");
        ss.add("3");

        String [] aa = new String[ss.size()];
        ss.toArray(aa);
ss.add(0,"4");
        log.info("ss : {}",ss);
        log.info("aa : {}",aa);

//        String dateStr = "2019-02-28";
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate = LocalDate.parse(dateStr, dateTimeFormatter);

//        int day = localDate.getDayOfMonth();
//        if(day == 10 ){
//            System.out.println("上旬日");
//        }else if(day ==20){
//            System.out.println("中旬日");
//        }else if(day==localDate.lengthOfMonth()){
//            System.out.println("下旬日");
//        }
//        System.out.println(localDate.getDayOfMonth());
//        System.out.println(localDate.lengthOfMonth());

        String phoneNum = "13718348719";
        phoneNum = phoneNum.substring(0,3) + "****"+phoneNum.substring(7);
        System.out.println(phoneNum);

//
//        String ss = "0101";
//
//        System.out.println(Integer.parseInt(ss.toUpperCase()));

        String str = "sf,ds";
        System.out.println(str.split(",").length);

        TreeMap treeMap = new TreeMap();
        treeMap.put(4,"da");
        treeMap.put(6,"da");
        treeMap.put(3,"da");
        treeMap.put(1,"da");

        log.info("{}",treeMap);

        BigDecimal num1 = new BigDecimal(0.005);
        log.info("{}",num1);
        BigDecimal num2 = new BigDecimal(1000000);

        num1 = num1.subtract(num2);

        log.info("{}",num1);

        java.util.Date utilDate=new Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());

        log.info("{}",date.getMonth());

        log.info("{}",date.toLocalDate().getMonth().getValue());
        log.info("{}",date.toLocalDate().getMonthValue());
        log.info("{}",date.toLocalDate().lengthOfMonth());

//        String dateStr = "2019-09-19";5ba121000000000000000000--db.getCollection('idea_content_sem').find({"_id":{$lt: ObjectId("5d41bb000000000000000000")}}).count()
        String dateStr = "2019-09-19";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateStr, dateTimeFormatter);

        long timestamp = localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = sdf.parse(dateStr);
            System.out.println(parse.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(timestamp);


        String objectId = Long.toHexString(timestamp/1000)+"0000000000000000";
        System.out.println(objectId);

        BigDecimal big  = BigDecimal.ZERO;
        big = big.add(new BigDecimal("1"));
        log.info("{}",big);


        List<Long> lists = new ArrayList<>();

        lists.add(1651324292856855L);
        lists.add(1654514023985160L);

        log.info("{}",lists.contains(1651324292856855L));
        log.info("{}",lists.contains(1654514023985160L));
        log.info("{}",lists.contains(1L));

        listObjectTest();

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

    public static void listObjectTest(){

        List<Person> personList = new ArrayList<>();
        Person person1 = Person.builder()
                .name("aaa")
                .sex(1)
                .build();
        Person person2 = Person.builder()
                .name("bbbb")
                .sex(2)
                .build();

        personList.add(person1);
        personList.add(person2);
        personList.stream().map(person -> {
            person.setName("shixiaopeng");
            return person;
        }).collect(Collectors.toList());

        log.info("{}",personList);
    }



}
