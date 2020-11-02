import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        String[] s = new String[]{"a","b","c","d","e"};
        for (int i = 0; i < s.length; i++) {
            System.out.println(i);
            System.out.println(s[++i]);
            System.out.println(i);
        }
    }
}
