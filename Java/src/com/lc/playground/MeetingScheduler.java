package com.lc.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[][] p1Meetings = {
		        {1230, 1300},
		        { 845,  900},
		        {1300, 1500}
		    };
		    int[][] p2Meetings = {
		        { 0, 844},
		        { 930, 1200},
		        {1515, 1546},
		        {1600, 2400}
		    };
		    int[][] p3Meetings = {
		        { 845,  915},
		        {1515, 1545},
		        {1235, 1245}
		    };
		    int[][] p4Meetings = {
		        {   1,  5},
		        { 844, 900},
		        {1515, 1600}
		    };
		    
		    
		    List<int[][]> schedule1 = Arrays.asList(p1Meetings,p2Meetings,p3Meetings);
		    List<int[][]> schedule2 =Arrays.asList(p1Meetings,p3Meetings);
		    List<int[][]> schedule3 =Arrays.asList(p2Meetings,p4Meetings);
		    
		    
		    List<List<Integer>> result= findAvailability(schedule1);
		    System.out.println("Availibility Slot is ");
		    result.forEach(obj->System.out.println(obj));
	}

	private static List<List<Integer>>findAvailability(List<int[][]> schedule1) {
		
		List<List<Integer>> result = new ArrayList<>();
		List<List<Integer>> combinedSchedule =new ArrayList<List<Integer>>();
		List <Integer> rec ;
		List <Integer> AvailabilityList ;
		
		for(int[][] schedule :schedule1)
		{ 
			
			for(int[] eschedule: schedule)
			{ rec = new ArrayList();
				rec.add(eschedule[0]);
			 rec.add(eschedule[1]);
				combinedSchedule.add(rec);
			}
		}
		
		Collections.sort(combinedSchedule,(a,b)-> Integer.compare(a.get(0), b.get(0)));
		System.out.println("Combined schedule is ");
		combinedSchedule.forEach(e->System.out.println(e));
		
		int end = combinedSchedule.get(0).get(1);
		for(int i=0; i<combinedSchedule.size(); i ++)
		{
			if(combinedSchedule.get(i).get(0) > end)
			{
				AvailabilityList =new ArrayList<Integer>();
				AvailabilityList.add(end);
				AvailabilityList.add(combinedSchedule.get(i).get(0));
				result.add(AvailabilityList);
				end=combinedSchedule.get(i).get(1);
			}else if(combinedSchedule.get(i).get(1) >end) {
				end= combinedSchedule.get(i).get(1);
			}
		}
		
		return result ;
		
		
	}

}
