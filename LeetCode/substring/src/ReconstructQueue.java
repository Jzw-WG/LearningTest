import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/** LeetCode 406 */
class ReconstructQueue {
    public static int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return -1;
                } else if (o1[0] < o2[0]) {
                    return 1;
                } else {
                    return o1[1] > o2[1] ? 1 : -1;
                }               
            }
        });
        
        // for (int i = 0; i < people.length; i++) {
        //     int[] cur = people[i];
        //     int count = cur[1];
        //     for (int j = 0; j < i; j++) {
        //         if (cur[0] <= people[j][0]) {                    
        //             count--;                 
        //         } else {
        //             continue;
        //         }
        //         if (count < 0) {
        //             people[i] = people[j];
        //             people[j] = cur;
        //             break;
        //         }
        //     }
        // }
        // return people;

        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] ans = ReconstructQueue.reconstructQueue(people);
        System.out.println(ans);
    }
}