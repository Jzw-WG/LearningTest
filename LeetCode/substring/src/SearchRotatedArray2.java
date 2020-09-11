//LeetCode 33
public class SearchRotatedArray2 {
    public boolean search(int[] nums, int target) {
        return getk(nums, 0, nums.length - 1, target);
    }

    public boolean getk(int[] nums, int start, int end, int target) {
        if (nums.length == 0) {
            return false;
        }
        int k = (start + end)/2;
        if (nums[k] == target) {
            return true;
        }
        if (k == start) {
            return (nums[start] == target || nums[end] == target)?true:false;
        }
        if (start > end) {
            return false;
        }
        if (start == end) {
            return (nums[start] == target)?true:false;
        }
        if (nums[start] < nums[end]) {
            if (nums[k] < target) {
                return getk(nums, k + 1, end, target);
            } else {
                return getk(nums, start, k - 1, target);
            }
        } else if ((nums[k] <= target && target >= nums[start] && nums[k] < nums[start]) || (nums[k] >= target && target >= nums[start]) || (nums[k] >= target && target <= nums[start]) && nums[k] < nums[start]) {
            return getk(nums, start, k, target);
        } else if ((nums[k] <= target && target >= nums[start] && nums[k] > nums[start]) || (nums[k] <= target && target <= nums[start]) || (nums[k] >= target && target <= nums[start]) && nums[k] > nums[start]) {
            return getk(nums, k, end, target);
        } else if (nums[k] == nums[start]) {
            return getk(nums, start + 1, end, target);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,0,0,1};
        SearchRotatedArray2 l = new SearchRotatedArray2();
        boolean a = l.search(nums, 0);
        System.out.println(a);
    }
}