package randomitem;

import java.util.Scanner;
import java.util.Arrays;

public class studentmanager {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] classStudents = new String[]{"Alice", "Bob", "Charlie", "David", "Emma"};
        int[] classScores = new int[]{90, 81, 74, 95, 88};
        boolean isExit = false;
        String menuMode;

        do {
            System.out.println("MENU");
            System.out.println("1.View students\n2.Search student\n3.Highest graded\n4.Average grade\n5.Change score\n6.Exit");
            menuMode = scanner.nextLine();
            switch(menuMode){
                case "1" ->{
                    for( int i = 0; i<classStudents.length; i++){
                        System.out.println(classStudents[i] + ": " + classScores[i]);
                    }
                }
                case "2" -> {
                    System.out.print("Student name: "); String searchStudent = scanner.nextLine();
                    for(int i = 0; i < classStudents.length; i++) {
                        boolean isFound = false;
                        if (searchStudent.equals(classStudents[i])) {
                            isFound = true;
                            System.out.println(classStudents[i] + ": " + classScores[i]);
                        }
                        else if(!isFound){
                            System.out.println("Student not found");
                        }
                    }
                }
                case "3" -> {
                    int maxScore = classScores[0];
                    for (int highScore : classScores) {
                        if (highScore > maxScore) {
                            maxScore = highScore;
                        }
                    }
                    System.out.println("Highest score of student is " + maxScore);
                }
                case "4" -> {
                    int avgScores = averageScore(classScores);
                    System.out.println(avgScores);
                }
                case "5" -> {
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    for(int i = 0; i < classStudents.length; i++) {
                        if (name.equals(classStudents[i])) {
                            System.out.println("Student found");
                            System.out.println(classStudents[i] + ": " + classScores[i]);
                            System.out.print("Enter new score: ");
                            classScores[i] = scanner.nextInt();
                            System.out.println("Student info updated");
                            System.out.println(classStudents[i] + ": " + classScores[i]);
                            scanner.nextLine();
                        }
                    }
                }
                case "6" -> isExit = true;
                default -> {
                    System.out.println("This mode does not exist");
                    continue;
                }
            }

        }while(!isExit);
        scanner.close();
    }
    static int averageScore(int ... scores){ // how do i know how many variable was passed guh
        int sum = 0;
        for(int score :scores){ sum += score; }
        return sum / scores.length;
    }
}
