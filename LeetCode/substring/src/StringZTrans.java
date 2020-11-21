public class StringZTrans {
    public String convert(String s, int numRows) {
        if (s.length() < 3 || numRows == 1) {
            return s;
        }
        int p = 0;
        int numCols = 0;
        char[] res = new char[s.length()];
        while (p < s.length()) {
            if (p % (2*numRows - 2) == 0 || (p % (2*numRows - 2) >= numRows && p % (2*numRows - 2) < 2*numRows - 2)) {
                numCols++;
            }
            p++;
        }
        char[][] mat = new char[numCols][numRows];
        int col = 0;
        int row = 0;
        p = 0;
        boolean reverse = true;
        while (p < s.length()) {
            mat[col][row] = s.charAt(p);
            if (p % (2*numRows - 2) >= numRows - 1 && p % (2*numRows - 2) < 2*numRows - 2) {
                col++;
            }

            if (p % (2*numRows - 2) == 0 || p % (2*numRows - 2) == numRows - 1) {
                reverse = !reverse;
            }

            if (reverse) {
                row--;
            } else {
                row++;
            }
           
            p++;
        }

        while (p < s.length()) {
            mat[col][row] = s.charAt(p);
            if (p % (2*numRows - 2) >= numRows - 1 && p % (2*numRows - 2) < 2*numRows - 2) {
                col++;
            }

            if (p % (2*numRows - 2) == 0 || p % (2*numRows - 2) == numRows - 1) {
                reverse = !reverse;
            }

            if (reverse) {
                row--;
            } else {
                row++;
            }
           
            p++;
        }
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (mat[j][i] != 0) {
                    res[index] = mat[j][i];
                    index++;
                }
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String testStr = "L";
        StringZTrans l = new StringZTrans();
        String a = l.convert(testStr, 1);
        System.out.println(a);
    }
}
