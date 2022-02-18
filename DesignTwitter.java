import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {
    Map<Integer, Set<Integer>> followMap;// userId, list of followees
    Map<Integer, List<Post>> postMap;// userId, list of posts
    int time;

    public DesignTwitter() {
        followMap = new HashMap<>();
        postMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        postMap.putIfAbsent(userId, new ArrayList<>());
        postMap.get(userId).add(new Post(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> curSet = followMap.getOrDefault(userId, new HashSet<>());
        curSet.add(userId);
        PriorityQueue<Post> pq = new PriorityQueue<>((a, b) -> a.timestamp - b.timestamp);// small time first
        for (int id : curSet) {
            List<Post> cur = postMap.getOrDefault(id, new ArrayList<>());
            for (Post post : cur) {
                pq.offer(post);
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (pq.size() > 0) {
            res.add(pq.poll().tweetId);
        }
        Collections.reverse(res);
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followerId);
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

class Post {
    int tweetId;
    int timestamp;
    public Post(int id, int time) {
        tweetId = id;
        timestamp = time;
    }
}