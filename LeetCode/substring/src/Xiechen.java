import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
//完全做错了
public class Xiechen {
    public static int[] max(int n, int K, int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] - o1[0] > o2[1] - o2[0]) {
                    return -1;
                } else if (o1[1] - o1[0] == o2[1] - o2[0]) {
                    if (o1[0] < o2[0]) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });
        int[] res = {0, n - 1};
        if (K >= n) {
            return res;
        }
        int l = 0;
        int r = l + K - 1;
        double average = 0;
        for (int i = 0; i < K; i++) {
            average += arr[i];
        }
        average = average / (1.0 * K);
        double max = average;
        pq.offer(new int[]{l, r});
        while (r < n - 1) {

            r++;
            average = (average * (r - l) + arr[r]) / (1.0 * (r - l + 1));
            
            if (average > max) {
                max = average;
                pq.clear();
                pq.offer(new int[]{l, r});
            } else if (average == max) {
                pq.offer(new int[]{l, r});
            }
            while (r - l >= K) {
                average = (average * (r - l + 1) - arr[l]) / (1.0 * (r - l));
                l++;
                if (average > max) {
                    max = average;
                    pq.clear();
                    pq.offer(new int[]{l, r});
                } else if (average == max) {
                    pq.offer(new int[]{l, r});
                }
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) throws IOException{
        // int[] a = {2,2,2,2,2,2,2,2,2};
        int[] a = {1,2,3,1,2,2,2,2,2};
        int n = 9;
        int K = 3;

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String[] t = br.readLine().trim().split(" ");
        // int n = Integer.parseInt(t[0]);
        // int K = Integer.parseInt(t[1]);
        // int[] input = new int[n];
        // String[] arr = br.readLine().trim().split(" ");
        // for (int i = 0; i < n; i++) {
        //     input[i] = Integer.parseInt(arr[i]);
        // }
        System.out.println(max(n, K, a)[0] + " " + max(n, K, a)[1]);
    }
    
}