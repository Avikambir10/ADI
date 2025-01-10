package Employ;
// 3. Find the occurrence of a substring in a parent string

// Input:

// aAbcDefabcAdf

// Substring: abc
public class SubstringOccurrence {
    public static void main(String[] args) {
        String parentString = "aAbcDefabcAdf";
        String substring = "abc";

        // Find occurrences (case-sensitive)
        int occurrences = findOccurrences(parentString, substring);

        System.out.println("Parent String: " + parentString);
        System.out.println("Substring: " + substring);
        System.out.println("Occurrences: " + occurrences);
    }

    static int findOccurrences(String parentString, String substring) {
        int cnt = 0;
        int idx = parentString.indexOf(substring);

        if (idx != -1) {
            cnt++;
            idx = parentString.indexOf(substring, idx + 1);
        }
        return cnt;
    }
}
