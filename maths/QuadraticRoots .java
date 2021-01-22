//Program to format the output. (Asked in amazon test)
public class QuadraticRoots {

	public static void main(String[] args) {
    
    double a = 10;
    double b = -9;
    double c = -6;

    double root = Math.sqrt((b*b) - (4*a*c));

    double xp = (-b + root)/(2*a);
    double xm = (-b - root)/(2*a);

//     String s1 = String.format("%.3f",xp);
//     String s2 = String.format("%.3f",xm);

    System.out.printf("roots are - %.3f and %.3f",xp,xm);

    }
}
/*Note - in order to format the output, we use printf.
* String also has String.format function.*/
