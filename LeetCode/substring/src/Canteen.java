import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;
public class Canteen {
    public static void predict(int[] tableArr, String people) {
        int n = tableArr.length;
        int m = people.length();
        for (int i = 0; i < m; i++) {
            int left0 = -1;
            int left1 = -1;
            for (int j = 0; j < n; j++) {
                if (tableArr[j] == 0) {
                    left0 = j;
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if (tableArr[j] == 1) {
                    left1 = j;
                    break;
                }
            }
            int sit = -1;
            if (people.charAt(i) == 'M') {
                sit = left1 != -1 ? left1 : left0;
            } else {
                sit = left0 != -1 ? left0 : left1;
            }
            tableArr[sit]++;
            System.out.println(sit + 1);
        }
        return;
    }
     
    public static void main(String[] args) throws IOException {
        String content = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        content = br.readLine();
        int groups = Integer.parseInt(content.trim());
        int row = 0;
        while (row < groups && (content = br.readLine()) != null) {
            int n = Integer.parseInt(content.trim());
            content = br.readLine();
            String tables = content.trim();
            int[] tableArr = new int[n];
            for (int i = 0; i < n; i++) {
                tableArr[i] = tables.charAt(i) - '0';
            }
            content = br.readLine();
            int m = Integer.parseInt(content.trim());
            content = br.readLine();
            String people = content.trim();
            Canteen.predict(tableArr, people);
            row++;
        }
    }   
}
