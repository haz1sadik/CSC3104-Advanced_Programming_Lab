package PracticeQuestions;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int matricNum;
        double firstTest, secondTest, A1, A2, A3, finalMark;

        double firstTestPercent, secondTestPercent,totalAssignment, totalAssignmentPercent, finalMarkPercent, totalPercent;

        System.out.print("Matric: ");
        matricNum = input.nextInt();
        System.out.print("1st Test: ");
        firstTest = input.nextDouble();
        System.out.print("2nd Test: ");
        secondTest = input.nextDouble();
        System.out.print("Assignment 1: ");
        A1 = input.nextDouble();
        System.out.print("Assignment 2: ");
        A2 = input.nextDouble();
        System.out.print("Assignment 3: ");
        A3 = input.nextDouble();
        System.out.print("Final Exam: ");
        finalMark = input.nextDouble();

        firstTestPercent = (firstTest / 40) * 20;
        secondTestPercent = (secondTest / 40) * 20;
        totalAssignment = A1 + A2 + A3;
        totalAssignmentPercent = (totalAssignment / 150) * 30;
        finalMarkPercent = (finalMark / 80) * 30;

        totalPercent = firstTestPercent + secondTestPercent + totalAssignmentPercent + finalMarkPercent;

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\tCALCULATED MARKS\n");
        System.out.printf("| %-6s | %-14s | %-14s |  %-5s  %-5s  %-5s  %-14s | %-14s | %-6s |\n", "MATRIC", "FIRST TEST", "SECOND TEST", "A1", "A2", "A3", "ASSIGNMENT", "FINAL", "TOTAL");
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.printf("| %-6d | %-2.2f (%-2.2f%%) | %-2.2f (%-2.2f%%) | %-2.2f  %-2.2f  %-2.2f  %-2.2f (%-2.2f%%) | %-2.2f (%-2.2f%%) | %-2.2f%% |\n", matricNum, firstTest, firstTestPercent, secondTest, secondTestPercent, A1, A2, A3, totalAssignment, totalAssignmentPercent, finalMark, finalMarkPercent, totalPercent);

    }
}

