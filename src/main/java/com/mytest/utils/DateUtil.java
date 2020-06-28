package com.mytest.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by shixi  on 2020/6/1
 */
@Slf4j
public class DateUtil {

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月

        int i = calendar.get(Calendar.MONTH);
        log.info("{}",i);
        Date date = calendar.getTime();
        String accDate = format.format(date);
        log.info("{}",accDate);


        log.info("{}", Integer.toBinaryString(13));
        log.info("{}", Integer.toBinaryString(17));
        log.info("{}", 13 & 17);


        List<Long> a = new ArrayList<>();
        a.add(3456567L);
        a.add(3456568L);
        a.add(3456569L);
        a.add(3456560L);

        List<Long> b = new ArrayList<>();
        b.add(3456567L);
        b.add(3456560L);

        a.removeAll(b);

        log.info("a {}",a);

        log.info("{}", CollectionUtils.isEmpty(a));

    }
}
