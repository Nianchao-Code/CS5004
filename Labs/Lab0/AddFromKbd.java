import java.util.Scanner;

public class AddFromKbd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first integer : ");
        int num1 = in.nextInt();

        System.out.print("Enter the second integer : ");
        int num2 = in.nextInt();

        int sum = num1 + num2;

        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum);
    }
}