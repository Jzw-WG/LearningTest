public class DotaSenate {
    public String predictPartyVictory(String senate) {
        StringBuilder sb = new StringBuilder(senate);
        if (senate.length() == 1) {
            return senate.charAt(0) == 'D' ? "Dire" : "Radiant";
        }
        
        int RCount = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'R') {
                RCount++;
            }
        }
        if (RCount == sb.length()) {
            return "Radiant";
        } else if (RCount == 0) {
            return "Dire";
        }
        if (RCount > sb.length()*2/3) {
            return "Radiant";
        } else if (RCount < sb.length()/3) {
            return "Dire";
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'R') {
                for (int j = i + 1; j != i; j++) {
                    if (j == sb.length()) {
                        j = 0;
                    }
                    if (sb.charAt(j) == 'D') {
                        sb.deleteCharAt(j);
                        if (j <= i) {
                            i--;
                        }
                        break;
                    }
                    if (j == i) {
                        break;
                    }
                }
            } else {
                for (int j = i + 1; j != i; j++) {
                    if (j == sb.length()) {
                        j = 0;
                    }
                    if (sb.charAt(j) == 'R') {
                        sb.deleteCharAt(j);
                        if (j <= i) {
                            i--;
                        }
                        RCount--;
                        break;
                    }
                    if (j == i) {
                        break;
                    }
                }
            }
        }
        if (RCount == sb.length()) {
            return "Radiant";
        } else if (RCount == 0) {
            return "Dire";
        }
        return predictPartyVictory(sb.toString());
    }

    public static void main(String[] args) {
        DotaSenate ds = new DotaSenate();
        // String senate = "DRRDRDRDRDDRDRDR";
        String senate = "RRR";
        String res = ds.predictPartyVictory(senate);
        System.out.println(res);
    }
}