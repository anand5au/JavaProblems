package problems;

import java.util.Iterator;

public class MyIterable implements Iterable<Integer>
{
	int[] array;

	@Override
	public Iterator<Integer> iterator()
	{
		return null;
	}

	class MyIterator implements Iterator<Integer>
	{
		@Override
		public boolean hasNext()
		{
			System.out.println(MyIterable.this.array);
			return false;
		}

		@Override
		public Integer next()
		{
			return null;
		}
	}
}
