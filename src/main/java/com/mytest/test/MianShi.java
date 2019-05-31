package com.mytest.test;

import com.mytest.vo.ReplyDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by shixi  on 2019/4/25
 */
@Data
@Slf4j
public class MianShi {

    public static void main(String[] args) {
//        int i1 =128;
//        Integer I1 = 128;
//        Integer I2 = 128;
//        Integer I3 = new Integer(127);
//        Integer I4 = new Integer(127);
//        Double D1 = 100.0;
//        Double D2= 100.0;
//
//        System.out.println(i1==I1);
//        System.out.println(I2==I1);
//        System.out.println(I3==I4);
//        System.out.println(D1==D2);
//
//        List<ReplyDTO> replyDTOS = new ArrayList<>();
//
//        ReplyDTO replyDTO1 = new ReplyDTO();
//        replyDTO1.setId(1);
//        replyDTOS.add(replyDTO1);
//
//        ReplyDTO replyDTO2 = new ReplyDTO();
//        replyDTO2.setId(2);
//        replyDTOS.add(replyDTO2);
//
//        List<Integer> collect = replyDTOS.stream().filter(replyDTO -> replyDTO.getSalesId() != null).map(replyDTO -> replyDTO.getSalesId()).collect(Collectors.toList());
//
//
//        log.info("collect = {} ", collect);
//
//        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.putIfAbsent("key","value");


        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num%5==0 && num%7==0){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
