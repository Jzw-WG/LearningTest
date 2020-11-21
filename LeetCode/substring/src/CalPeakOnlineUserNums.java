import java.util.ArrayList;
import java.util.List;

/**字节面视题
 * 找到最高峰时用户在线时间区间和人数
 * 
 * 
 * 答案：int[86400]
 * delta[]
 * onilne[]
 */
public class CalPeakOnlineUserNums {
    public static class User {
        public int userID;
        public int loginTime;
        public int logoutTime;

        public User(int id, int loginTime, int logoutTime) {
            this.userID = id;
            this.loginTime = loginTime;
            this.logoutTime = logoutTime;
        }
    }

    /***
     * calPeakUserNums
     * @param userList 
     * @return 峰值人数
     */
    public int calPeakUserNums(List<User> userList) {
        int max = 0;
        int left = 0;
        int right = 24;

        for (User user : userList) {
            if (user.loginTime > left && user.loginTime <= right) {
                left = user.loginTime;
            }
            if (user.logoutTime < right && user.logoutTime >= left) {
                right = user.logoutTime;
            }
            if (user.loginTime <= left && user.logoutTime >= right) {
                max++;
            }
        }
        System.out.println(left + "-" + right);
        return max;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        CalPeakOnlineUserNums l = new CalPeakOnlineUserNums();
        users.add(new User(1, 3, 4));
        users.add(new User(1, 4, 12));
        users.add(new User(1, 5, 12));
        users.add(new User(1, 11, 12));
        users.add(new User(1, 3, 14));
        // users.add(new User(2, 2, 21));
        // users.add(new User(3, 5, 18));
        // users.add(new User(4, 16, 18));
        // users.add(new User(5, 11, 20));
        // users.add(new User(6, 3, 20));
        // users.add(new User(7, 4, 14));
        // users.add(new User(8, 2, 12));
        // users.add(new User(9, 1, 23));
        // users.add(new User(10, 15, 16));
        // users.add(new User(11, 7, 14));
        // users.add(new User(12, 4, 6));
        int max = l.calPeakUserNums(users);
        System.out.println(max);
    }
    // 以上是错误的
}