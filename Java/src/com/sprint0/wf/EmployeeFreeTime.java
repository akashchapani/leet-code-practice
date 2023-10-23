package com.sprint0.wf;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List e1 =new ArrayList<>();
		e1.add(new Interval(1,2));
		e1.add(new Interval(5,6));
		List e2 =new ArrayList<>();
		e2.add(new Interval(1,3));
		List e3 =new ArrayList<>();
		e3.add(new Interval(4,10));
		List <List<Interval>>schedule =new ArrayList<List<Interval>>();
		schedule.add(e1);
		schedule.add(e2);
		schedule.add(e3);
		List <Interval>result = employeeFreeTime(schedule);
	//	List <List<Interval>>schedule = [[{1,2},{5,6}],[{1,3}],[{4,10}]];
       System.out.println(" Size is "+ result.size());
	   result.forEach((Interval e)-> System.out.println(e.start +":" + e.end));
	}
	
	//Priority queue is used to sort all intervals based on start value irrespective of emloyees
	//Then Compare the start of next interval to start of  current interval to see if there is any overlap
public static  List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
	
	List<Interval> result = new ArrayList<Interval>();
	
	PriorityQueue<Interval>pq= new PriorityQueue<>((a,b) -> a.start-b.start );
	schedule.forEach(e-> pq.addAll(e));
	
	Interval temp= pq.poll();
	while(!pq.isEmpty())
	{
		if(temp.end < pq.peek().start)
		{
			result.add(new Interval(temp.end,pq.peek().start));
			temp=pq.poll();
		}
		else
		{
			temp =temp.end< pq.peek().end ? pq.peek(): temp;
			pq.poll();
		}
	}
	
	return result;
	
        
    }

}
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
