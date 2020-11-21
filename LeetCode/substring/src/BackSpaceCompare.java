/**LeetCode 844*/
public class BackSpaceCompare {

    static class StateMachine {
        public static final int DELETE_STRING = 0;
        public static final int GET_STRING = 1;
        public int state;
        public StateMachine() {
            state = GET_STRING;
        }
        public void changeState(char c) {
            if (c == '#') {
                state = DELETE_STRING;
            } else {
                state = GET_STRING;
            }
        }
    }
    public boolean backspaceCompare(String S, String T) {
        getString(S);
        getString(T);
        if (S.equals(T)) {
            return true;
        } else {
            return false;
        }
    }

    public void getString(String s) {
        StringBuffer sb = new StringBuffer(s);
        StateMachine sm = new StateMachine();
        int count = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            sm.changeState(sb.charAt(i));           
            if (sm.state == StateMachine.DELETE_STRING) {
                count++;
                continue;
            } else {
                if (count == 0) {
                    continue;
                } else {
                    if (count < sb.length()) {
                        sb.delete(i - count + 1, i + count + 1);
                        i = sb.length();
                        count = 0;
                    } else {
                        s = "";
                        count = 0;
                        break;
                    }   
                }               
            }
        }
        s = sb.toString();
    }
}

