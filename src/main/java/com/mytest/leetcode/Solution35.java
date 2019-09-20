package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution35 {

    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        int[] nums = {0,1,3,4,6,7,8,9};
        log.info("{}", solution.searchInsert(nums, 8));
        log.info("{}", nums);
        int[] A = {4,2,5,7};

        log.info("{}", solution.sortArrayByParityII(A));

        List<String> timePoints = new ArrayList<>();

        timePoints.add("00:00");
        timePoints.add("23:59");
        timePoints.add("00:00");
        log.info("{}", solution.findMinDifference1(timePoints));
    }

    public int searchInsert(int[] nums, int target) {
        if(nums == null){
            return 0;
        }
        int min = nums[0];
        int max = nums[nums.length - 1];

        if(target < min){
            return 0;
        }
        if(target > max){
            return nums.length;
        }

        for(int i = 0;i < nums.length -1; i++){
            if (nums[i] == target) {
                return i;
            }else if(nums[i] < target && nums[i+1] >= target){
                return i+1;
            }
        }
        return 0;
    }

    public int[] sortArrayByParityII(int[] A) {

        int [] o = new int[A.length/2];
        int [] q = new int[A.length/2];

        int a = 0;
        int b = 0;
        for(int i = 0;i < A.length; i++){
            if(A[i]%2 == 0){
                o[a++] = A[i];
            }else{
                q[b++] = A[i];
            }
        }

        for(int i = 0;i < A.length; i++){
            if(i%2 == 0){
                A[i] = o[--a];
            }else{
                A[i] = q[--b];
            }
        }

        return A;
    }

    public int findMinDifference(List<String> timePoints) {
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String firstTime = timePoints.get(0);
        String secondTime = timePoints.get(1);
        long compareTime = 0;
        try {
            Date first = sdf.parse(firstTime);
            Calendar firstCal= Calendar.getInstance();
            firstCal.setTime(first);
            int firstHour = firstCal.get(Calendar.HOUR_OF_DAY);

            Date second = sdf.parse(secondTime);
            Calendar secondCal= Calendar.getInstance();
            secondCal.setTime(second);
            int secondHour = secondCal.get(Calendar.HOUR_OF_DAY);

            if(firstHour > secondHour && firstHour - secondHour > 12){
                secondCal.add(Calendar.DAY_OF_MONTH, 1);
            }else if(firstHour < secondHour && secondHour - firstHour > 12){
                firstCal.add(Calendar.DAY_OF_MONTH, 1);
            }
//            log.info("first {}", sf.format(firstCal.getTime()));
//            log.info("second {}", sf.format(secondCal.getTime()));

            if(firstCal.compareTo(secondCal) > 0){
                compareTime = firstCal.getTime().getTime() - secondCal.getTime().getTime();
            }else{
                compareTime = secondCal.getTime().getTime() - firstCal.getTime().getTime();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int) (compareTime/1000/60);
    }

    public int findMinDifference1(List<String> timePoints) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long compareTime = 12*60*60*1000;
        try {
            for(int i = 0;i <timePoints.size(); i++){
                for(int j=i+1;j<timePoints.size(); j++){
                    Date timeI = sdf.parse(timePoints.get(i));
                    Date timeJ = sdf.parse(timePoints.get(j));

                    if(timeI.getTime() - timeJ.getTime() > 12*60*60*1000){
                        timeJ.setTime(timeJ.getTime() + 24*60*60*1000);
                    }
                    if(timeJ.getTime() - timeI.getTime() > 12*60*60*1000){
                        timeI.setTime(timeI.getTime() + 24*60*60*1000);
                    }

                    long compare = 0;
                    if(timeI.getTime() > timeJ.getTime()){
                        compare = timeI.getTime()- timeJ.getTime();
                    }else{
                        compare = timeJ.getTime()- timeI.getTime();
                    }
                    if(compare< compareTime){
                        compareTime = compare;
                    }
                }
            }
        } catch (ParseException e) {
        e.printStackTrace();
        }

        return (int) (compareTime/1000/60);
    }

    public int findMinDifference2(List<String> timePoints) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long compareTime = 12*60*60*1000;
        try {
            for(int i = 0;i <timePoints.size(); i++){
                for(int j=i+1;j<timePoints.size(); j++){
                    Date timeI = sdf.parse(timePoints.get(i));
                    Date timeJ = sdf.parse(timePoints.get(j));

                    if(timeI.getTime() - timeJ.getTime() > 12*60*60*1000){
                        timeJ.setTime(timeJ.getTime() + 24*60*60*1000);
                    }
                    if(timeJ.getTime() - timeI.getTime() > 12*60*60*1000){
                        timeI.setTime(timeI.getTime() + 24*60*60*1000);
                    }

                    long compare = 0;
                    if(timeI.getTime() > timeJ.getTime()){
                        compare = timeI.getTime()- timeJ.getTime();
                    }else{
                        compare = timeJ.getTime()- timeI.getTime();
                    }
                    if(compare< compareTime){
                        compareTime = compare;
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return (int) (compareTime/1000/60);
    }
}

