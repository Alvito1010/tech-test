package ConsoleQuestions;
import java.util.Scanner;


// check prime
public class Console1 {
    public static void main(String[] args) {
        
        System.out.print("Input: ");

        Scanner scan = new Scanner(System.in);

        int input = scan.nextInt();

        scan.close();

        System.out.print("Output: ");

        for (int i = 2; i <= input; i++){
            if (checkPrime(i)){
                if (i > 2){
                    System.out.print(", ");
                }
                System.out.print(i);

            }
        }
        System.out.println();

    }

    public static boolean checkPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
