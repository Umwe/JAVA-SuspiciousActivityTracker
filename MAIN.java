import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SuspiciousActivityTracker {

    // Inner class to represent an activity
    public static class Activity {
        private String userId;
        private String activityType;
        private LocalDateTime timestamp;
        private String description;

        public Activity(String userId, String activityType, LocalDateTime timestamp, String description) {
            this.userId = userId;
            this.activityType = activityType;
            this.timestamp = timestamp;
            this.description = description;
        }

        public String getUserId() {
            return userId;
        }

        public String getActivityType() {
            return activityType;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "Activity [userId=" + userId + ", activityType=" + activityType + ", timestamp=" + timestamp 
                    + ", description=" + description + "]";
        }
    }

    // List to store suspicious activities
    private List<Activity> suspiciousActivities;

    public SuspiciousActivityTracker() {
        suspiciousActivities = new ArrayList<>();
    }

    // Method to add suspicious activity
    public void logSuspiciousActivity(String userId, String activityType, String description) {
        Activity activity = new Activity(userId, activityType, LocalDateTime.now(), description);
        suspiciousActivities.add(activity);
    }

    // Method to retrieve all suspicious activities
    public List<Activity> getSuspiciousActivities() {
        return suspiciousActivities;
    }

    // Method to filter suspicious activities by user
    public List<Activity> getSuspiciousActivitiesByUser(String userId) {
        List<Activity> userActivities = new ArrayList<>();
        for (Activity activity : suspiciousActivities) {
            if (activity.getUserId().equals(userId)) {
                userActivities.add(activity);
            }
        }
        return userActivities;
    }

    // Method to print all suspicious activities
    public void printAllSuspiciousActivities() {
        for (Activity activity : suspiciousActivities) {
            System.out.println(activity.toString());
        }
    }

    public static void main(String[] args) {
        // Example usage
        SuspiciousActivityTracker tracker = new SuspiciousActivityTracker();
        
        tracker.logSuspiciousActivity("user123", "Failed Login", "User failed to login multiple times.");
        tracker.logSuspiciousActivity("user456", "Access Restricted Area", "User tried to access restricted section.");

        tracker.printAllSuspiciousActivities();

        System.out.println("\nActivities by user123:");
        List<Activity> user123Activities = tracker.getSuspiciousActivitiesByUser("user123");
        for (Activity activity : user123Activities) {
            System.out.println(activity.toString());
        }
    }
}
