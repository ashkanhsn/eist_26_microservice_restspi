package eist24l03p03.activitymicroservice.Controller;

import eist24l03p03.activitymicroservice.FollowRequest;
import eist24l03p03.activitymicroservice.Tweet;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import eist24l03p03.activitymicroservice.User;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    // TODO: implement the methods of this class. Make a use of the provided data structures
    private Map<Integer, List<Tweet>> userActivityMap = new HashMap<>();
    private Map<Integer, List<User>> userFollowedMap = new HashMap<>();

    @GetMapping("/getActivity/{id}")
    public List<Tweet> getActivity(@PathVariable("id") int userID) {
        return userActivityMap.getOrDefault(userID, new ArrayList<>());
    }

    @PostMapping("/addActivity")
    public void addActivity(@RequestBody Tweet tweet) {
        if (tweet == null) return;
        int userId = tweet.getUser().getUserID();
        userActivityMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(tweet);
    }

    @PostMapping("/addFollower")
    public void addFollower(@RequestBody FollowRequest followRequest) {
        User follower = followRequest.getFollower();
        User followed = followRequest.getFollowed();
        userFollowedMap.computeIfAbsent(follower.getUserID(), f -> new ArrayList<>()).add(followed);
    }

    @DeleteMapping("deleteActivity")
    public void deleteActivity(@RequestBody Tweet tweet) {
        if (tweet == null) return;
        int userId = tweet.getUser().getUserID();
//        if (userActivityMap.containsKey(userId)){
//            userActivityMap.get(userId).remove(tweet);
//        }
        userActivityMap.computeIfPresent(userId, (id, list) -> {
            list.remove(tweet);
            return list.isEmpty() ? null : list;
        });
    }

    @DeleteMapping("/deleteFollower")
    public void deleteFollower(@RequestBody FollowRequest followRequest) {
        User followed = followRequest.getFollowed();
        User follower = followRequest.getFollower();
        userFollowedMap.computeIfPresent(follower.getUserID(), (id, list) -> {
            list.remove(followed);
            return list.isEmpty() ? null : list;
        });

    }

    @GetMapping("/getFollowedList/{id}")
    public List<User> getFollowedList(@PathVariable("id") int userID) {
        // TODO: this method is also not complete, so you have to implement it accordingly :)
        return userFollowedMap.getOrDefault(userID, new ArrayList<>());
    }
}