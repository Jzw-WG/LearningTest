import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
    public static void main(String[] args) {
        
        RegularExpression r = new RegularExpression();
    }
}

