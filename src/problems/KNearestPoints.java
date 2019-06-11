package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* class Point implements Comparable<Point>
{
	double x, y;

	public Point()
	{
		x = 0;
		y = 0;
	}

	public Point(double a, double b)
	{
		x = a;
		y = b;
	}

	public double distFromOrigin()
	{
		return Math.hypot(x, y);
	}

	@Override
	public int compareTo(Point o)
	{
		if (this.distFromOrigin() < o.distFromOrigin())
			return 1;
		else if (this.distFromOrigin() > o.distFromOrigin())
			return -1;
		return 0;
	}
} */

class Point
{
	double x, y;

	public Point()
	{
		x = 0;
		y = 0;
	}

	public Point(double a, double b)
	{
		x = a;
		y = b;
	}

	public double distFromOrigin()
	{
		return Math.hypot(x, y);
	}
}

public class KNearestPoints
{
	static void findKNearestPoints(List<Point> points, int k)
	{
		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, new Comparator<Point>()
		{
			@Override
			public int compare(Point o1, Point o2)
			{
				if (o1.distFromOrigin() > o2.distFromOrigin())
					return -1;
				if (o1.distFromOrigin() < o2.distFromOrigin())
					return 1;
				return 0;
			}
		});
		for (Point p : points)
		{
			if (maxHeap.size() < k)
			{
				maxHeap.offer(p);
			}
			else
			{
				if (maxHeap.peek().distFromOrigin() > p.distFromOrigin())
				{
					maxHeap.poll();
					maxHeap.offer(p);
				}
			}
		}
		while (maxHeap.size() > 0)
		{
			Point p = maxHeap.poll();
			System.out.println(p.x + "," + p.y);
		}
	}

	public static void main(String[] args)
	{
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 1));
		points.add(new Point(1, 2.5));
		points.add(new Point(-1, 1.4));
		points.add(new Point(-1, 2));
		points.add(new Point(1.5, -1.5));
		points.add(new Point(1.6, -1));
		points.add(new Point(-1, -1.5));
		points.add(new Point(-1, 3));
		points.add(new Point(2, 2));
		findKNearestPoints(points, 5);
	}
}
