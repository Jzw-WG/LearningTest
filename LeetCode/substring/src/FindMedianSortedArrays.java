public class FindMedianSortedArrays {
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int left11 = (nums1.length+1)/2-1;
    //     int left12 = nums1.length/2;
    //     int left21 = (nums2.length+1)/2-1;
    //     int left22 = nums2.length/2;
    //     if (nums1.length == 0) {
    //         return ((double)nums2[left21] + nums2[left22])/2;
    //     } else if (nums2.length == 0) {
    //         return ((double)nums1[left11] + nums1[left12])/2;                
    //     } else if (nums1.length <= 2 && nums2.length <= 2) {
    //         if (nums1.length == 1 && nums2.length == 1) {
    //             return ((double)nums1[0] + nums2[0])/2;
    //         } else if (nums1.length == 1 && nums2.length == 2) {
    //            return ((nums1[0] >= nums2[0] ? nums1[0] : nums2[0]) >= nums2[1]) ? nums2[1] :(nums1[0] >= nums2[0] ? nums1[0] : nums2[0]);
    //         } else if (nums2.length == 1 && nums1.length == 2) {
    //             return ((nums2[0] >= nums1[0] ? nums2[0] : nums1[0]) >= nums1[1]) ? nums1[1] :(nums2[0] >= nums1[0] ? nums2[0] : nums1[0]);
    //         } else if (nums1.length == 2 && nums2.length == 2) {
    //             int[] num = {nums1[0],nums1[1],nums2[0],nums2[1]};
    //             Arrays.sort(num);
    //             return ((double)num[1] + num[2])/2;
    //         }
    //     }

    //     if (nums1[left11] <= nums2[left21]) {
    //         nums1 = Arrays.copyOfRange(nums1, left11, nums1.length);
    //     } else if (nums1[left11] >= nums2[left21]) {
    //         nums2 = Arrays.copyOfRange(nums2, left21, nums2.length);
    //     }
    //     if (nums1[left12] >= nums2[left22]) {
    //         nums1 = Arrays.copyOfRange(nums1, 0, left12 + 1);
    //     } else if (nums1[left12] <= nums2[left22]) {
    //         nums2 = Arrays.copyOfRange(nums2, 0, left22 + 1);
    //     }
    //     return findMedianSortedArrays(nums1, nums2);
    // }
        public double findMedianSortedArrays(int[] A, int[] B) {
            int m = A.length, n = B.length;
            int l = (m + n + 1) / 2;
            int r = (m + n + 2) / 2;
            return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
        }
    
        public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
            if (aStart > A.length - 1) return B[bStart + k - 1];            
            if (bStart > B.length - 1) return A[aStart + k - 1];                
            if (k == 1) return Math.min(A[aStart], B[bStart]);
    
            int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
            if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
            if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        
    
            if (aMid < bMid) 
                return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft 
            else 
                return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
        }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {1,2,3};
        FindMedianSortedArrays l = new FindMedianSortedArrays();
        double a = l.findMedianSortedArrays(nums1, nums2);
        System.out.println(a);
    }
}