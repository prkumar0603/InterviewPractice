package String;

public class stringFunctions {
    public static void main(String[] args) {
        String regex = ".@.";
        stringFunctions.compare("Hacker@Earth.com", regex); // false
        stringFunctions.compare("a@N", regex);              // true
        System.out.println("--------------------------------");
        String regex1 = ".*@.*";
        stringFunctions.compare("Hacker@Earth.com", regex1);  // true
        stringFunctions.compare("a@N", regex1);               // true
    }

    private static void compare(String str, String regex) {
        if (str.matches(regex))
            System.out.println(str+" matches");
        else
            System.out.println(str+ " does not match");
    }
}
/*
  Output -  Hacker@Earth.com does not match
            a@N matches
            --------------------------------
            Hacker@Earth.com matches
            a@N matches
*/
