package Recursion;

// given a charachtet to skip;;; like = a
public class SkipACharachter {
    public static void main(String[] args) {
//        skip("", "avikam");
        System.out.println(skip("aviakm"));

    }

//    public static void skip(String p, String str) {
//        if (str.isEmpty()) {
//            System.out.println(p);
//            return;
//        }
//        char ch = str.charAt(0);
//        if (ch == 'a') {
//            skip(p, str.substring(1));
//        } else {
//            skip(p + ch, str.substring(1));
//        }
//    }
    public static String skip( String str) {
        if (str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if (ch == 'a') {
            return skip(str.substring(1));
        } else {
            return ch + skip( str.substring(1));
        }
    }
}
