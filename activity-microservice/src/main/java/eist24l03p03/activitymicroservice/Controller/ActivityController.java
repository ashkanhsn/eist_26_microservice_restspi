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

    public List<Tweet> getActivity(@PathVariable("id") int userID) {
        return new ArrayList<>();
    }

    public void addActivity(@RequestBody Tweet tweet) {
    }

    public void addFollower(@RequestBody FollowRequest followRequest) {
    }

    public void deleteActivity(@RequestBody Tweet tweet) {
    }

    public void deleteFollower(@RequestBody FollowRequest followRequest) {
    }

    public List<User> getFollowedList(@PathVariable("id") int userID) {
        // TODO: this method is also not complete, so you have to implement it accordingly :)
        return new ArrayList<>();
    }
}