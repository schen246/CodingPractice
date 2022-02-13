public class FirstBadVersion extends VersionControl{
    public int firstBadVersion(int n) {
        int left = 1, right = n, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}

class VersionControl {
    private int bad;
    public void setBad(int b) {bad = b; }
    public boolean isBadVersion(int version) {
        return version >= bad;
    }
}
