package com.expedia.validator.samples.mergeintervals;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindOverlappingIntervals {

	public static void main(String[] args) {

		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(){{
			setStart(1);
			setEnd(6);
		}});
		intervals.add(new Interval(){{
			setStart(4);
			setEnd(10);
		}});
		intervals.add(new Interval(){{
			setStart(12);
			setEnd(19);
		}});
		intervals.add(new Interval(){{
			setStart(20);
			setEnd(25);
		}});

		mergeIntervals(intervals);

		for (Interval interval:
			 intervals) {
			System.out.println(interval.getStart() + "  " + interval.getEnd());
		}
	}

	private static void mergeIntervals(List<Interval> intervals) {

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				if(a == b) return b.getEnd() - a.getEnd();
				return a.getStart() - b.getStart();
			}
		});
		int i = 0;
		while (i < intervals.size() - 1) {
			if(intervals.get(i).getEnd() > intervals.get(i + 1).getStart()) {
				intervals.get(i).setEnd(Math.max(intervals.get(i).getEnd(), intervals.get(i+1).getEnd()));
				intervals.remove(i+1);
			}
			else i++;
		}
	}


}
