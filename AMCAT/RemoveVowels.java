package AMCAT;

// Program to remove all vowels fromm a given string using pointers : 
// Input : ACADEMY OF TECHNOLOGY    
// output: CDMY F TCHNLGY
public class RemoveVowels {
    public static void main(String[] args) {
        String str = "ACADEMY OF TECHNOLOGY";
        System.out.println("Input : " + str);
        System.out.println("Output : " + removeVowels(str));
    }

    static String removeVowels(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!isVowel(c)) {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
