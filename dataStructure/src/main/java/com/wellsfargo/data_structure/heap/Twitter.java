//package com.wellsfargo.data_structure.heap;
//
//import java.util.*;
//
//public class Twitter {
//
//    private Map<Integer , PriorityQueue<TweetData>> userToTwittMap;
//
//
//    /** Initialize your data structure here. */
//    public Twitter() {
//        this. userToTwittMap =new HashMap<>();
//    }
//
//    /** Compose a new tweet. */
//    public void postTweet(int userId, int tweetId) {
//        if(!userToTwittMap.containsKey(userId)){
//            userToTwittMap.put(userId , new PriorityQueue<>(new Comparator<TweetData>() {
//                @Override
//                public int compare(TweetData o1, TweetData o2) {
//                    return (int)o2.timeStamp -(int)o1.timeStamp;
//                }
//            }));
//
//        }
//        userToTwittMap.get(userId).add(new TweetData(tweetId, System.currentTimeMillis()));
//    }
//
//    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
//    public List<Integer> getNewsFeed(int userId) {
//
//    }
//
//    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
//    public void follow(int followerId, int followeeId) {
//
//    }
//
//    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
//    public void unfollow(int followerId, int followeeId) {
//
//    }
//
//    class TweetData{
//        int tweetId;
//        long timeStamp;
//
//        public TweetData(int tweetId, long timeStamp) {
//            this.tweetId = tweetId;
//            this.timeStamp = timeStamp;
//        }
//    }
//}
//
///**
// * Your Twitter object will be instantiated and called as such:
// * Twitter obj = new Twitter();
// * obj.postTweet(userId,tweetId);
// * List<Integer> param_2 = obj.getNewsFeed(userId);
// * obj.follow(followerId,followeeId);
// * obj.unfollow(followerId,followeeId);
// */