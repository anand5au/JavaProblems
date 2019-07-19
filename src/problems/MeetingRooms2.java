package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals, Comparator.comparing((int[] arr) -> arr[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }

    public static void main(String args[]) {
        int[][] schedule = new int[][]{{0, 30},{5, 10},{15, 20}};
        System.out.println(minMeetingRooms(schedule));
    }
}
