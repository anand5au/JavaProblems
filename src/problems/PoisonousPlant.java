package problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PoisonousPlant
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("poison.txt"));
		List<Integer> nums = new ArrayList<Integer>();
		int listSize = sc.nextInt();
		for (int i = 0; i < listSize; i++)
		{
			nums.add(sc.nextInt());
		}
		int ans = 0;
		while (true)
		{
			int deadCnt = 0;
			int left = -1;
			for (int i = 1; i < nums.size();)
			{
				if (nums.get(i) > ((left == -1) ? nums.get(i - 1) : left))
				{
					left = nums.remove(i);
					deadCnt++;
				}
				else
				{
					left = -1;
					i++;
				}
			}

			if (deadCnt == 0)
				break;
			ans++;
		}
		System.out.print(ans);
		sc.close();
	}
}
