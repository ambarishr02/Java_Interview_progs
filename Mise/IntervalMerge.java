package Mise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Interval {
	int startTime;
	int endTime;
	
	public Interval(int st, int et) {
		this.startTime=st;
		this.endTime=et;
	}
	
}

public class IntervalMerge {
	
	
	public static List<Interval>  mergeInterval(List<Interval> intervals) {
		List<Interval> merged=new ArrayList<Interval>();
		
		Collections.sort(intervals, (a, b)-> Integer.compare(a.startTime, b.startTime));
		
		Iterator<Interval> itr=intervals.iterator();
		Interval i1=itr.next();
		int start=i1.startTime;
		int end=i1.endTime;
		
		while(itr.hasNext()) {
			Interval next=itr.next();
			if(next.startTime<=end) {
				end=Math.max(end, next.endTime);
			}else {
				merged.add(new Interval(start, end));
				start=next.startTime;
				end=next.endTime;
			}
		}
		merged.add(new Interval(start, end));
		return merged;
		
	}

	public static void main(String[] args) {
		 List<Interval> input = new ArrayList<Interval>();
		    input.add(new Interval(1, 4));
		    input.add(new Interval(2, 5));
		    input.add(new Interval(7, 9));
		    System.out.print("Merged intervals: ");
		    for (Interval interval : mergeInterval(input))
		      System.out.print("[" + interval.startTime + "," + interval.endTime + "] ");
		    System.out.println();

	}
}
