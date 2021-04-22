public class ArrayMergeSort {
    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r); 
        }     
    }

    private static void merge(int[] nums, int l, int m, int r) {
        int k = 0;
        int i = l;
        int j = m + 1;
        int[] temp = new int[r - l + 1];
        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= m) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }
        for (int n = 0; n < temp.length; n++) {
            nums[l + n] = temp[n];
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1,4,6,7,5,3,6,8};
        ArrayMergeSort.mergeSort(nums);
        System.out.println(nums);
    }
}