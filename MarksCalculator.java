import java.util.Scanner;

public class MarksCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];

        System.out.println("\nEnter the marks obtained in each subject (out of 100):");
        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else {
            grade = "F";
        }

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}


// //output
// Enter the number of subjects: 6

// Enter the marks obtained in each subject (out of 100):
// Subject 1: 90
// Subject 2: 85
// Subject 3: 80
// Subject 4: 95
// Subject 5: 96
// Subject 6: 83

// Total Marks: 529
// Average Percentage: 88.16666666666667%
// Grade: A