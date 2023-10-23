package com.fb.practiceplan;

import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class PairSums {

  // Add any helper functions you may need here
  

  int numberOfWays(int[] arr, int k) {
    // Write your code here
   
    /* --Brute Force O(n2)
    int result =0;
    
    if(arr==null || arr.length <=0)
    {
      return result;
    }
    for(int i=0; i<arr.length -1; i++)
    {
     for(int j=i+1; j<arr.length ; j++)
      if(arr[i] + arr[j] ==k )
      {  
       // System.out.println(" Result value , i value and J value "+result +" : "+ i+" : "+j);
        result++;
       
      }
    }
    return result;
    */
    
    Map<Integer,Integer> complementMap= new HashMap();
    int result=0;
     for(int i=0; i<arr.length ; i++)
     {
       if(!complementMap.containsKey(arr[i]) )
         complementMap.put(arr[i] , 0);
       
       complementMap.put(arr[i], complementMap.get(arr[i])+1);
     }
    
     for(int i=0; i<arr.length ; i++)
     {
       if( complementMap.get(k-arr[i]) !=null)
       {

         result   += complementMap.get(k-arr[i]);
         if(k-arr[i] == arr[i])
           result--;
       }
     }
    return result/2;
  }











  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  
  public void run() {
    int k_1 = 6;
    int[] arr_1 = {1, 2, 3, 4, 3};
    int expected_1 = 2;
    int output_1 = numberOfWays(arr_1, k_1);
    check(expected_1, output_1);

    int k_2 = 6;
    int[] arr_2 = {1, 5, 3, 3, 3};
    int expected_2 = 4;
    int output_2 = numberOfWays(arr_2, k_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) {
    new PairSums().run();
  }
}