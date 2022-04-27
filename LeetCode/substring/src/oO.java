import java.util.ArrayList;

public class oO {
    int eyeNumber = 2;
    String mouth = "_";
    // String[] eyes = {"o","O","⭕","⚪","〇","●","·"};
    String[] eyes = {"o","O","^","Q","〇","●","·"};
    public oO(String mouth, String[] eyes) {
        this.mouth = mouth;
        this.eyes = eyes;
    }

    public oO() {}

    public void publishAlloOExpression() {
        ArrayList<String> combinations = new ArrayList<>();
        StringBuilder combination = new StringBuilder();
        backtrack(combinations, combination);
        for (String string : combinations) {
            System.out.println(string);
        }
    }

    private void backtrack(ArrayList<String> combinations, StringBuilder combination) {
        if (combination.length() == eyeNumber) {
            combinations.add(insertMouthToEyes(combination));
            return;
        }
        for (int i = 0; i < eyes.length; i++) {
            combination.append(eyes[i]);
            backtrack(combinations, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public String insertMouthToEyes(StringBuilder combination) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < combination.length(); i++) {
            sb.append(combination.charAt(i));
            if (i < combination.length() - 1) {
                sb.append(mouth);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        oO o = new oO();
        o.publishAlloOExpression();
    }
}