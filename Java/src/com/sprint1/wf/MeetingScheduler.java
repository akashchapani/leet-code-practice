package com.sprint1.wf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * p1_meetings = [ (1230, 1300), ( 845, 900), (1300, 1500), ]
		 * 
		 * p2_meetings = [ ( 0, 844), ( 930, 1200), (1515, 1546), (1600, 2400), ]
		 * 
		 * p3_meetings = [ ( 845, 915), (1515, 1545), (1235, 1245), ]
		 * 
		 * p4_meetings = [ ( 1, 5), (844, 900), (1515, 1600) ]
		 * 
		 * schedules1 = [p1_meetings, p2_meetings, p3_meetings] schedules2 =
		 * [p1_meetings, p3_meetings] schedules3 = [p2_meetings, p4_meetings]
		 * 
		 * Expected output:
		 * 
		 * findAvailableTimes(schedules1) => [ 844, 845 ], [ 915, 930 ], [ 1200, 1230 ],
		 * [ 1500, 1515 ], [ 1546, 1600 ]
		 * 
		 * findAvailableTimes(schedules2) => [ 0, 845 ], [ 915, 1230 ], [ 1500, 1515 ],
		 * [ 1545, 2400 ]
		 * 
		 * findAvailableTimes(schedules3) [ 900, 930 ], [ 1200, 1515 ]
		 * 
		 * n = number of meetings s = number of schedules
		 */

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
		    
		    List <List<Integer>> result = findSchedule(schedule1);
		    System.out.println("Availablility =>");
		    for(int i=0; i<result.size(); i++)
		    {
		    	List<Integer> rec = result.get(i);
		    	System.out.println( "["+ rec.get(0) +" , "+rec.get(1)+ "]");
		    }
	}

	private static List<List<Integer>> findSchedule(List<int[][]> schedule1) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = new ArrayList<List<Integer>>();
	
		List<List<Integer>> combinedSchedule= new ArrayList<List<Integer>>();
		for(int[][] schedule:schedule1)
		{
			for(int[] eschedule:schedule)
			{
				List<Integer> current = new ArrayList<Integer>();
				current.add(eschedule[0]); //845
				current.add(eschedule[1]);  //900
				combinedSchedule.add(current);
			}
				
		}
		
		Collections.sort(combinedSchedule,(a,b)->Integer.compare(a.get(0), b.get(0)));
		
	/*	if(combinedSchedule.get(0).get(0) !=0)
		{
			List<Integer> start= new ArrayList<Integer>();
			start.add(0);
			start.add(combinedSchedule.get(0).get(1));
			result.add(start);
		}
		if(combinedSchedule.get(combinedSchedule.size()-1).get(1) !=2400)
		{
			List<Integer> end= new ArrayList<Integer>();
			end.add(combinedSchedule.get(combinedSchedule.size()-1).get(1));
			end.add(2400);
			result.add(end);
		}
		*/
		
		//Loop through all the schedules and find any gaps
		int end= combinedSchedule.get(0).get(1);
		for(int i=0; i<combinedSchedule.size(); i++)
		{
			if(combinedSchedule.get(i).get(0)>end)
			{
				List <Integer> availibility= new ArrayList<Integer>();
				availibility.add(end);
				availibility.add(combinedSchedule.get(i).get(0));
				end= combinedSchedule.get(i).get(1);
				result.add(availibility);
			}else if(combinedSchedule.get(i).get(1) >end)
			{
				end=combinedSchedule.get(i).get(1);
			}
		}
		
		return result;
	}

}
