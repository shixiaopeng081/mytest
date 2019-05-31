package com.mytest.utils;

/**
 * Created by shixi  on 2019/4/2
 */
public class Test2 {



    public static void main(String[] args) {
        int a =1;
        int b = 1;
        int c =1;
        int d = 1;
        int e =1;


        for(int i=0;i<5;i++){


            switch (i){
                case 1:a++;
                case 2:b++;
                case 3:c++;
                case 4:d++;
                case 5:e++;
            }
        }


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        System.out.println(new String() instanceof Object);
       // System.out.println('A' instanceof Character);
        System.out.println((String )null instanceof String);
        System.out.println(new Object() instanceof String);

        for(byte byte1 = Byte.MIN_VALUE; byte1< Byte.MAX_VALUE;b++){
            if(byte1==0x90){
                System.out.println("Joy!");
            }
        }



//try{
//    System.out.println("创建对象开始");
//    Test2 t = new Test2("22222222222222222222");
//    System.out.println("创建对象结束");
//}catch (Exception exception){
//    System.out.println("ssssss");
//}


    }

//    private Test2 instance = new Test2("111111111111");
//
//    public Test2(String a) {
//        System.out.println(a +"构造");
//
//    }
}
