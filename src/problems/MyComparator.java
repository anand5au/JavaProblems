package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class Order
{
	String productId;
	double cost;
	int quantity;

	public Order(String id, double cost, int q)
	{
		this.productId = id;
		this.cost = cost;
		this.quantity = q;
	}

	@Override
	public String toString()
	{
		return "Q: " + this.quantity + " C: " + this.cost;
	}
}

public class MyComparator
{
	public static void main(String[] args)
	{
		List<Order> list = new ArrayList<Order>();
		Random r = new Random();
		for (int i = 0; i < 100; i++)
		{
			Order o = new Order("Product" + i, r.nextDouble() * 100, r.nextInt(100));
			list.add(o);
		}

		for (int i = 0; i < 100; i++)
			System.out.print(list.get(i).toString() + " ");
		System.out.println();

		Collections.sort(list, new Comparator<Order>()
		{
			@Override
			public int compare(Order o1, Order o2)
			{
				if (o1.quantity != o2.quantity)
					return o1.quantity - o2.quantity;
				else
					return (int) (o1.cost - o2.cost);
			}
		});

		for (int i = 0; i < 100; i++)
			System.out.print(list.get(i).toString() + " ");
	}

}
