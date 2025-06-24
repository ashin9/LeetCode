package LCGo;

public class vowelStrings2586 {
    /**
     *
     */
    /**
     * switch 语句（推荐，清晰高效）
     * @param c
     * @return
     */
    public boolean isVowel(char c) {
        switch (Character.toLowerCase(c)) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                return true;
            default:
                return false;
        }
    }
    /**
     * 使用字符串包含判断
     */
    /*public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }*/

    /**
     * Set<Character>（适合频繁判断）
     */
    /*Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public boolean isVowel(char c) {
        return vowels.contains(c);
    }*/

}
