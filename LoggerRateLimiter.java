import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    Map<String, Integer> map;//<message, print time>

    public LoggerRateLimiter() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message) && timestamp < map.get(message) + 10) {
            return false;
        }
        map.put(message, timestamp);
        return true;
    }
}
