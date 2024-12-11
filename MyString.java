/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        //System.out.println(countChar(hello, 'h')); // 1
        //System.out.println(countChar(hello, 'l')); // 2
        //System.out.println(countChar(hello, 'z')); // 0
        //System.out.println(countChar(hello, 'H')); // 0
        //System.out.println(subsetOf("he", hello)); // true
        //System.out.println(subsetOf("He", hello)); // false
        //System.out.println(subsetOf("Ht", hello)); // false
        //System.out.println(subsetOf("eh", hello)); // true
        //System.out.println(spacedString(hello));
        //System.out.println(spacedString("Dror"));
        //System.out.println("\nTesting remove:");
        //System.out.println("committee - meet -> " + MyString.remove("committee", "meet") + " (expected: comit)");
        //System.out.println("abc - abc -> " + MyString.remove("abc", "abc") + " (expected: )");
        //System.out.println("abc - b -> " + MyString.remove("abc", "b") + " (expected: ac)");
        //System.out.println("hello - empty string -> " + MyString.remove("hello", "") + " (expected: hello)");
        //System.out.println("String num 1 : " + randomStringOfLetters(1)); 
        //System.out.println("String num 5 : " + randomStringOfLetters(5)); 
        //System.out.println("String num 10 : " + randomStringOfLetters(10)); 
        //System.out.println("String num 0 : " + randomStringOfLetters(0)); 
        //System.out.println("String num -5 : " + randomStringOfLetters(-5)); 
        System.out.println("\nTesting spacedString:");
        System.out.println("silent -> \"" + MyString.spacedString("silent") + "\" (expected: s i l e n t)");
        System.out.println("a -> \"" + MyString.spacedString("a") + "\" (expected: a)");
        System.out.println("empty string -> \"" + MyString.spacedString("") + "\" (expected: )");
        System.out.println("hi -> \"" + MyString.spacedString("hi") + "\" (expected: h i)");//// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int countChar = 0;
        for (int i = 0; i < str.length(); i ++) {
            if (ch == str.charAt(i)) {
                countChar ++; 
            }
        }
        return countChar;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
         if (str1.length() > str2.length()) {
            return false;
         }
         char[] str1Arry = new char[str1.length()];
         char[] str2Arry = new char[str2.length()];
         for (int i = 0; i < str1Arry.length; i++){
            str1Arry[i] = str1.charAt(i);
         }
         for (int i = 0; i < str2Arry.length; i++){
            str2Arry[i] = str2.charAt(i);
         }

         for (int i = 0; i < str1Arry.length; i ++) {
            for (int j = 0; j < str2Arry.length; j ++){
                if ((str2Arry[j] == str1Arry[i])) {
                    str1Arry[i] = ' ';
                    str2Arry[j] = ' ';
                }
            }
        }
        str1 = new String(str1Arry);
        str2 = new String(str2Arry);
        //System.out.println(str2);
        //System.out.println(str1);
        return str1.isBlank();
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        if (str.length() <= 1) {
            return str;
        }
        char[] strChar = new char[(str.length() * 2) - 1];
        String result = "";

        for (int i = 0; i < strChar.length; i++) {
            if (i % 2 == 0) {
                strChar[i] = str.charAt((i / 2));
            } else{
                strChar[i] = ' ';
            }
        }
        for (int i = 0; i < strChar.length; i++){
            result += strChar[i];
        }
        return result;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String resulString = "";
        for (int i = 0; i < n; i ++){
            int numOfASCII = (int)(Math.random() * 26);
            char theChar = (char)(numOfASCII + 97);
            resulString += theChar;
        }
        return resulString;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        char[] str1Arry = new char[str1.length()];
        char[] str2Arry = new char[str2.length()];
        String resulString = "";
        if (str2.length() == 0) {
            return str1;
        }
        for (int i = 0; i < str1Arry.length; i++){
           str1Arry[i] = str1.charAt(i);
        }
        for (int i = 0; i < str2Arry.length; i++){
           str2Arry[i] = str2.charAt(i);
        }
        for (int i = 0; i < str1Arry.length; i ++){
            for (int j = 0; j < str2Arry.length; j ++){
                if (str2Arry[j] == str1Arry[i]) {
                    str2Arry[j] = ' ';
                    str1Arry[i] = ' ';
                }
            }
        }
        
        for (int i = 0; i < str1Arry.length; i ++) {
            if (str1Arry[i] != ' ') {
                resulString += str1Arry[i]; 
            }
        }
        return resulString;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
