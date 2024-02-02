package CodSoft;
import java.util.Scanner;
public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n*****STUDENT GRADE CALCULATOR*****");

        System.out.println("\nEnter your name: ");

        String studentname = sc.nextLine();

        int num= 0;

        System.out.println("\nEnter number of Subjects:");

        num = sc.nextInt();

        int[] mark = new int[num];

        for(int i = 0; i< mark.length; i++)

        {

            System.out.println("\nEnter Mark for Subject " + (i+ 1) + ":");

            mark[i] = sc.nextInt();


            while(mark[i] < 0 || mark[i] > 100)

            {

                System.out.println("\nEnter Marks for Subject " + (i + 1) + ":");

                mark[i] = sc.nextInt();

            }

        }


        int totalmark = 0;

        double avgmark = 0.0;

        String grade = "";


        for(int i= 0; i < mark.length; i++)

        {

            totalmark += mark[i];

        }


        avgmark= totalmark/num;


        if(avgmark >= 80)

        {

            grade = "A";

        }else if(avgmark>= 70 && avgmark < 80)

        {

            grade = "B";

        }else if(avgmark >= 60 && avgmark < 70)

        {

            grade = "C";

        }else if(avgmark >= 50 && avgmark < 60)

        {

            grade = "D";

        }else if(avgmark >= 40 && avgmark < 50)

        {

            grade = "E";

        }else if(avgmark >= 30 && avgmark < 40)

        {

            grade = "F";

        }else

        {

            grade = "FF";

        }



        System.out.printf("\n\nStudent Name: %s\n\nTotal Subjects: %d\nTotal Mark: %d\nAverage Mark: %.2f\nGrade: %s",

                studentname,num,totalmark,avgmark,grade);


    }


}