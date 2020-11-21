/**LeetCode 514 */
class RingRotateSteps {

    public int findRotateSteps(String ring, String key) {    
        int steps = 0;    
        int keyIndex = 0;
        int start = 0; 
        steps = findCharFromRing(ring, key, keyIndex, start, steps);
        return steps + key.length();
    }

    public int findCharFromRing(String ring, String key, int keyIndex, int start, int steps) {
        if (keyIndex == key.length()) {
            return steps;
        }
        char c = key.charAt(keyIndex);
        int left = start;
        int right = start;
        while (ring.charAt(left) != c && ring.charAt(right) != c) {
            left--;
            right++;
            if (left == -1) {
                left = ring.length() - 1;
            } else if (left == ring.length()) {
                left = 0;
            }
            if (right == -1) {
                right = ring.length() - 1;
            } else if (right == ring.length()) {
                right = 0;
            }
            steps++;
        }
        if (left != right) {
            int count1 = findCharFromRing(ring, key, keyIndex + 1, left, steps);
            int count2 = findCharFromRing(ring, key, keyIndex + 1, right, steps);
            start = count1 < count2 ? left : right;
        }
        // } else if (ring.charAt(left) == c) {
        //     start = left;
        // } else if (ring.charAt(right) == c) {
        //     start = right;
        // }
        return findCharFromRing(ring, key, keyIndex + 1, start, steps);
    }

    public static void main(String[] args) {
        String ring = "caotmcaataijjxi";
        String key = "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx";
        RingRotateSteps a = new RingRotateSteps();
        int steps = a.findRotateSteps(ring, key);
        System.out.println(steps);
    }
}