package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval
{
	int start;
	int end;

	Interval()
	{
		start = 0;
		end = 0;
	}

	Interval(int s, int e)
	{
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return this.start + " : " + this.end;
	}
}

public class MergeIntervals
{
	public static List<Interval> merge(List<Interval> intervals)
	{
		List<Interval> ans = new ArrayList<Interval>();

		if (intervals == null || intervals.size() == 0)
			return ans;

		Collections.sort(intervals, new Comparator<Interval>()
		{
			@Override
			public int compare(Interval i1, Interval i2)
			{
				return i1.start - i2.start;
			}
		});

		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++)
		{
			Interval curr = intervals.get(i);
			if (curr.start > prev.end)
			{
				ans.add(prev);
				prev = curr;
			}
			else
			{
				prev.end = Math.max(prev.end, curr.end);
			}
		}
		ans.add(prev);
		return ans;
	}

	public static void main(String args[]) {
		Interval arr[]=new Interval[4];
		arr[0]=new Interval(6,8);
		arr[1]=new Interval(1,9);
		arr[2]=new Interval(2,4);
		arr[3]=new Interval(4,7);
		System.out.println(merge(Arrays.asList(arr)));
	}
}
