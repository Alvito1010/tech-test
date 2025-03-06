package ConsoleQuestions;
import java.util.Scanner;


// switch 2 variable values without temp
public class Console3 {
    public static void main(String[] args) {

        System.out.print("Input X = ");

        Scanner scan = new Scanner(System.in);

        int inputX = scan.nextInt();

        scan.nextLine();

        System.out.print("Input Y = ");

        int inputY = scan.nextInt();

        scan.close();

        inputX += inputY;
        
        inputY = inputX-inputY;

        inputX = inputX - inputY;
        
        System.out.println();

        System.out.print("Output X = ");
        System.out.println(inputX);

        System.out.print("Output Y = ");
        System.out.println(inputY);
    }
}
