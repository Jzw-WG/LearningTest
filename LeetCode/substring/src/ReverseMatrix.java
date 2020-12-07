/**LeetCode 861 */
public class ReverseMatrix {
    public int matrixScore(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                reverse(A, 1, i);
            }
        }
        res += A.length * (1 << (A[0].length - 1));
        
        for (int i = 1; i < A[0].length; i++) {
            int oneCount = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 1) {
                    oneCount++;
                }
            }
            if (oneCount < A.length - oneCount) {
                // reverse(A, 0, i);
                res += (A.length - oneCount) * (1 << (A[0].length - 1 - i));
            } else {
                res += oneCount * (1 << (A[0].length - 1 - i));
            }
        }
        return res;
    }
    //flag = 0 col, flag = 1 row
    public void reverse(int[][] A, int flag, int index) {
        if (flag == 0) {
            for (int i = 0; i < A.length; i++) {
                A[i][index] = ~A[i][index] & 1;
            }
        } else {
            for (int i = 0; i < A[index].length; i++) {
                A[index][i] = ~A[index][i] & 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] A = new int[2][2];
        A[0][0] = 0;
        A[0][1] = 1;
        A[1][0] = 0;
        A[1][1] = 0;
        ReverseMatrix r = new ReverseMatrix();
        int a = r.matrixScore(A);
        System.out.println(a);
    }
}