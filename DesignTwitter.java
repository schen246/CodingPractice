import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class DesignTwitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Post>> tweetMap;
    int time;

    /** Initialize your data structure here. */
    public DesignTwitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Post(tweetId, time++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> set = followMap.getOrDefault(userId, new HashSet<>());
        set.add(userId);
        Queue<Post> pq = new PriorityQueue<>((a, b) -> a.time - b.time);// small first
        for (int user : set) {
            for (Post post : tweetMap.getOrDefault(user, new ArrayList<>())) {
                pq.offer(post);
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (pq.size() > 0) {
            res.add(pq.poll().id);
        }
        Collections.reverse(res);
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followerId);
        followMap.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.get(followerId) != null) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

class Post {
    int id, time;
    public Post(int id, int time) {
        this.id = id;
        this.time = time;
    }
}