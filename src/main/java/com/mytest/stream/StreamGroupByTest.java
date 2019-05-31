package com.mytest.stream;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by shixi  on 2019/1/18
 */
public class StreamGroupByTest {


    private static LinkedHashMap<String, List<ReplyDO>> getMap(List<ReplyDO> replyList) {
        //todo stream ??
        Map<String, List<ReplyDO>> map = replyList.stream().collect(Collectors.groupingBy(replyDO -> replyDO.getCategory() ));
        System.out.println("map ======== {}"+ map);
        LinkedHashMap<String, List<ReplyDO>> collect = replyList.stream().collect(Collectors.groupingBy(replyDO -> replyDO.getCategory(), LinkedHashMap::new, Collectors.toList()));
        System.out.println("collect ==== {}"+ collect);
        LinkedHashMap<String, List<ReplyDO>> defaultMap = new LinkedHashMap<>();
        for (ReplyDO reply : replyList) {
            List<ReplyDO> replyDOList = defaultMap.get(reply.getCategory());
            if (replyDOList == null || replyDOList.size() == 0) {
                replyDOList = new ArrayList<>();
            }
            replyDOList.add(reply);
            defaultMap.put(reply.getCategory(), replyDOList);
        }
        System.out.println("defaultMap = {}"+ defaultMap);
        return defaultMap;
    }

    public static void main(String[] args) {
        List<ReplyDO> replyList = new ArrayList<>();

        ReplyDO replyDO2 = new ReplyDO();
        replyDO2.setCategory("你猜");
        replyList.add(replyDO2);

        ReplyDO replyDO4 = new ReplyDO();
        replyDO4.setCategory("你猜");
        replyDO4.setText("wwwwwwwwwwwwww");
        replyList.add(replyDO4);

        ReplyDO replyDO3 = new ReplyDO();
        replyDO3.setCategory("你猜");
        replyDO3.setText("qqqqqqqqqqqqqqqq");
        replyList.add(replyDO3);

        ReplyDO replyDO1 = new ReplyDO();
        replyDO1.setCategory("11");
        replyList.add(replyDO1);

        getMap(replyList);
    }

    @Data
    private static class ReplyDO {

        private Integer id;

        private Integer salesId;

        private String category;

        private String text;

        LocalDateTime updateDateTime;

        private String shortcutKey;
    }
}
