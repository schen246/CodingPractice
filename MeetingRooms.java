import java.util.Arrays;

public class MeetingRooms {
    // sweep line - time: O(nlogn) sort + O(n) space: O(n) sort space
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0]) {
                return false;
            }
            end = intervals[i][1];
        }
        return true;
    }
}
