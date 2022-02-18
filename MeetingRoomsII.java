import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new int[]{interval[0], -1});
            list.add(new int[]{interval[1], 1});
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];// end first
            }
            return a[0] - b[0];// small first
        });
        int cnt = 0, res = 0;
        for (int[] arr : list) {
            if (arr[1] == -1) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                cnt--;
            }
        }
        return res;
    }
}
