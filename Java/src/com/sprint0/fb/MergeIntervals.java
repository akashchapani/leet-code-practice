package com.sprint0.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	
	//Make sure interval ref is used than local variable for current pointer. for example use currentInterval[1] instead of currentInterva end
	 public int[][] merge(int[][] intervals) {
         //[[1,3],[2,6],[8,10],[15,18]]
  
  List<int[]>  resultlist = new ArrayList<>();
  
  //Sort array by interval Start time.
  Arrays.sort(intervals,(array1,array2)->Integer.compare(array1[0],array2[0]));
  System.out.println("Result Array is : "  +Arrays.deepToString(intervals));
  
  int[] currentInterval = intervals[0];
 
  resultlist.add(currentInterval);   //[1,3]
  
  for(int[] interval : intervals)
  {
     
      int nextStart = interval[0];
      int nextEnd = interval[1];
      
      if(currentInterval[1]  >= interval[0] )
      {
          currentInterval[1] = Math.max( currentInterval[1] ,nextEnd);
          
      }else 
      {
          resultlist.add(interval);
          currentInterval = interval;
      }
      
  }
 int[][]resultarray = new int[resultlist.size()][];
 resultlist.toArray(resultarray);

return  resultarray;
  
}
}
