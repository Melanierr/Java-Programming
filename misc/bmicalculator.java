package randomitem;
import java.util.Scanner;

public class bmicalculator {
    public static void main(String[] args){
        double weight = 0;
        double height = 0;
        double bmi = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("BMI Calculator");

        System.out.print("Enter your weight: ");
        weight = scanner.nextDouble();

        System.out.print("Enter your height: ");
        height = scanner.nextDouble();
        bmi = weight / (height * height);

        System.out.println("Your BMI is : " + bmi);
        if(bmi < 18.5){
            System.out.println("You are underweight");
        }
        else if(bmi >= 18.5 && bmi <= 24.9){ // are we deadass and does not exist but use concatenate +
            System.out.println("You are fine");
        }
        else if(bmi >= 25 && bmi < 30){ // how do i have two logic operators?? uh ask chatgpt ig
            System.out.println("You are overweight");
        }
        else if(bmi >= 30){
            System.out.println("You are obese");
        }

        scanner.close(); // uh it's >= and <= Lol, also and means && in here bruh
    }
}
