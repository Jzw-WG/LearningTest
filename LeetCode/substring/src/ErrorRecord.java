import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ErrorRecord {
    public static void getErrorMsg(List<String> filePath, List<Integer> lineNo, Map<String, Integer> errorMsg, Map<String, Integer> errorOrder) {
        if (filePath.size() != lineNo.size()) {
            return;
        }
        for (int i = 0; i < filePath.size(); i++) {
            String fileName = null;
            String s = filePath.get(i);
            int no = lineNo.get(i);
            String NoStr = String.valueOf(no);
            int n = s.split("\\\\").length;
            fileName = s.split("\\\\")[n - 1];
            String key = fileName + "," + NoStr;
            errorMsg.put(key, errorMsg.getOrDefault(key, 0) + 1);
            if (!errorOrder.containsKey(key)) {
                errorOrder.put(key, i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String content = null;
        List<String> filePath = new ArrayList<>();
        List<Integer> lineNo = new ArrayList<>();
        while (!(content = br.readLine()).equals("")) {
            filePath.add(content.trim().split(" ")[0]);
            lineNo.add(Integer.parseInt(content.trim().split(" ")[1]));
        }
        Map<String, Integer> errorMsg = new HashMap<>();
        Map<String, Integer> errorOrder = new HashMap<>();
        ErrorRecord.getErrorMsg(filePath, lineNo, errorMsg, errorOrder);
        PriorityQueue<String> pq = new PriorityQueue<>(
            new Comparator<String>(){
                @Override
                public int compare(String o1, String o2) {
                    int l1 = o1.split("-")[1].split(" ").length;
                    int l2 = o2.split("-")[1].split(" ").length;
                    int n1 = Integer.parseInt(o1.split("-")[1].split(" ")[l1 - 1]);
                    int n2 = Integer.parseInt(o2.split("-")[1].split(" ")[l2 - 1]);
                    if (n1 == n2) {
                        return errorOrder.get(o1.split("-")[0]) - errorOrder.get(o2.split("-")[0]);
                    } else {
                        return n2 - n1;
                    }
                }
            }
        );
        for (Map.Entry<String, Integer> entry : errorMsg.entrySet()) {
            String fileName = entry.getKey().split(",")[0];
            String line = entry.getKey().split(",")[1];
            String shortName = fileName;
            if (fileName.length() > 16) {
                shortName = fileName.substring(fileName.length() - 16, fileName.length());
            }
            pq.offer(entry.getKey() + "-" + shortName + " " + line + " " + entry.getValue());
        }
        int i = 0;
        while (!pq.isEmpty() && i < 8) {
            System.out.println(pq.poll().split("-")[1]);
            i++;
        }
    }
}