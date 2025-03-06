package ConsoleQuestions;

// make triangle

import java.util.Scanner;

public class Console2 {
    public static void main(String[] args) {

        System.out.print("Tinggi Segitiga Bintang = ");

        Scanner scan = new Scanner(System.in);

        int input = scan.nextInt();

        scan.close();

        System.out.println();

        for (int i = 0; i < input; i++){
            for(int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for(int k = 0; k < input-i; k++){
                System.out.print(i+1);
            }
            System.out.println();
        }
    }
}
