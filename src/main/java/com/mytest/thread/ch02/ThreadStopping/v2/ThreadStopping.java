package com.mytest.thread.ch02.ThreadStopping.v2;

public class ThreadStopping
{
   public static void main(String[] args)
   {
      class StoppableThread extends Thread
      {
         private boolean stopped; // defaults to false

         @Override
         public void run()
         {
            synchronized(this)
            {
               while(!stopped)
                 System.out.println(Thread.currentThread().getName()+"running");
            }
         }

         synchronized void stopThread()
         {
            stopped = true;
         }
      }
      StoppableThread thd = new StoppableThread();
      thd.start();
      StoppableThread thd2 = new StoppableThread();
      thd2.start();
      try
      {
         Thread.sleep(1000); // sleep for 1 second
      }
      catch (InterruptedException ie)
      {
      }
      thd.stopThread();
      thd2.stopThread();
   }
}