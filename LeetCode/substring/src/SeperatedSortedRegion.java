//纯傻逼方法
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SeperatedSortedRegion {
    int seperatedSortedRegion(int[] nums, int m) {
        int count = 0;
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }
        for (int l = 1; l < m+1; l++) {
            
            for (int r = l; r < m+1; r++) {
                    LinkedList<Integer> removedtemp = new LinkedList<>(q);
                    removeElement(removedtemp, l, r);
                    LinkedList<Integer> tempq = new LinkedList<>();
                    for (int i = 0; i < removedtemp.size(); i++) {
                        tempq.add(new Integer(removedtemp.get(i).intValue()));
                    }
                    Collections.sort(tempq);
                    if (sameList(removedtemp, tempq)) {
                        count++;
                    }
            }
        }
        return count;
    }

    boolean sameList(List<Integer> l1, List<Integer> l2) {
        for (int i = 0; i < l1.size(); i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return false;
            }
        }
        return true;
    }

    void removeElement(List<Integer> list, int l, int r) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) >= l && list.get(i) <= r) {
                list.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,1,4,1,2};
        SeperatedSortedRegion l = new SeperatedSortedRegion();
        int a = l.seperatedSortedRegion(nums, 5);
        System.out.println(a);
    }
}