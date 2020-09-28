//
public class SearchMount{
    public int search(int[] nums) {
        return getk(nums, 0, nums.length - 1);
    }

    public int getk(int[] nums, int start, int end) {
        int k = (start + end)/2;      
        if (start == end) {
            return k;
        }
        if (nums[k] < nums[k + 1]) {
            return getk(nums, k + 1, end);
        } else {
            return getk(nums, start, k);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,2};
        SearchMount l = new SearchMount();
        int a = l.search(nums);
        System.out.println(a);
    }
}