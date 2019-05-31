package com.mytest.demo.ch02.ID.v3;

public class ID
{
   private static int counter; // initialized to 0 by default

   public static int getID()
   {
      return counter++;
   }

   public static void main(String[] args)
   {
      System.out.println(ID.getID());
   }
}