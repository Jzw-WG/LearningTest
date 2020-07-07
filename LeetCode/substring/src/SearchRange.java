//LeetCode 34
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        return getk(nums, 0, nums.length - 1, target);
    }

    public int[] getk(int[] nums, int start, int end, int target) {
        int[] startEnd = {start,end};
        int[] noResult = {-1,-1};
        if (nums.length == 0) {
            return noResult;
        }
        if (nums[start] == nums[end] && nums[start] == target) {
            return startEnd;
        } else if (nums[start] == nums[end] && nums[start] != target) {
            return noResult;
        }
        int k = (start + end)/2;
        
        if (nums[k] < target) {
            return getk(nums, k + 1, end, target);
        } else if (nums[k] > target) {
            return getk(nums, start, k - 1, target);
        } else {
            int newStart = nums[start] < target?start + 1:start;
            int newEnd = nums[end] > target?end - 1:end;
            return getk(nums, newStart, newEnd, target);
        }
    }
    public static void main(String[] args) {
        int[] nums = {5,5,7,7,8,8,10};
        SearchRange l = new SearchRange();
        int[] a = l.searchRange(nums, 6);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}