package problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStream
{
	public static void main(String args[])
	{
		List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> list = myList.parallelStream().map(a -> a + 1).collect(Collectors.toList());
		System.out.println(Arrays.toString(list.toArray()));
	}
}
