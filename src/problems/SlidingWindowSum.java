package problems;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowSum
{
    static List<Integer> slidingWindowSum(List<Integer> a, int k)
    {
        if (a == null || a.size() == 0)
            return null;

        int sum = 0, i = 0;
        List<Integer> res = new ArrayList<Integer>();
        for (i = 0; i < a.size(); i++)
        {
            sum += a.get(i);
            if (i < k-1)
                continue;
            res.add(sum);
            sum -= a.get(i-k+1);
        }
        if (i < k)
            res.add(sum);
        return res;
    }

    public static void main(String[] args)
    {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1); l.add(3); l.add(-1); l.add(1); l.add(3); l.add(-1);
        System.out.println(slidingWindowSum(l, 3));
    }
}
