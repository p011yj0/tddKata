import java.util.HashMap;
import java.util.Map;

public class Interleave {

    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(final String s1, final String s2, final String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;

        final Map<Character, Integer> string3 = new HashMap<>();
        final Map<Character, Integer> string1And2 = new HashMap<>();
        populate(s3, string3);
        populate(s1, string1And2);
        populate(s2, string1And2);
        return validate(s3, string3, string1And2);
    }

    private boolean validate(final String s3, final Map<Character, Integer> string3, final Map<Character, Integer> string1And2) {
        for (char ch: s3.toCharArray()) {
            if (!string3.get(ch).equals(string1And2.get(ch)))
                return false;
        }
        return true;
    }

    private void populate(final String s, final Map<Character, Integer> map) {
        for (char ch: s.toCharArray()) {
            if (null != map.get(ch)) {
                final Integer integer = map.get(ch);
                map.put(ch, integer + 1);
            } else
                map.put(ch, 1);
        }
    }


    public boolean isInterleave2(final String s1, final String s2, final String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        final StringBuilder st3 = new StringBuilder();
        final StringBuilder combo = new StringBuilder(s1 + s2);
        st3.append(s3);
        for (int i = 0; i < s3.length(); i++) {
            for (int j = 0; j < combo.length(); j++) {
                if (st3.charAt(i) == combo.charAt(j)) {
                    combo.deleteCharAt(j);
                    break;
                }
            }
        }
        return combo.length() == 0;
    }
}
