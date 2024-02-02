package CodSoft;
import java.util.Random;
import java.util.Scanner;
public class NumberGame
{

    private static int win;
    public static void main(String[] args)
    {
        System.out.println("*******Number Game*******\n");
        System.out.println("Enter Your Name: \n");

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();

        System.out.println("Hello " + name);

        String op;
        boolean flag = true;
        win = 0;

        do
        {
            System.out.println("\n Select your option: \n\n1. Start\n2. Exit\n");

            op = sc.next();

            switch(op)
            {
                case "1":

                    Nogame(sc, flag);

                    System.out.println("\n\nDo you want to play again?: \n\n1. Yes\n2. No\n");
                    String choice = sc.next();

                    while(choice.equals("1"))
                    {
                        Nogame(sc, flag);
                        System.out.println("\n\nDo you want to play again?: \n\n1. Yes\n2. No\n");

                        choice = sc.next();
                    }

                    System.out.println("****Bravo!! - You have Won " + win + " Round(s)*****");

                    flag = false;

                    break;

                case "2":

                    System.out.println("****Didn't make it, Try again*****");
                    flag = false;
                    break;

                default:

                    System.err.println("Invalid Input, Please Enter Again!");
                    break;
            }

        }while(flag);

    }

    public static void Nogame(Scanner sc, boolean flag)
    {
        Random r = new Random();
        int rndval = r.nextInt(101);
        System.out.println("Let's get started!");

        int c = 10;
        int guess;

        while(c > 0)
        {
            System.out.println("\nChances Left: " + c);
            System.out.println("Please enter Your Guess: ");

            guess = sc.nextInt();

            if(guess > rndval)
            {
                System.out.println("Enter a Lower Value!!!\n");

            }else if(guess < rndval)
            {
                System.out.println("Enter a Higher Value!!!\n");

            }else
            {
                System.out.println("****Congratulations You Won*****");
                win++;
                flag = false;
                break;
            }

            c -= 1;
        }

        if(flag)
        {
            System.out.println("\nRandom Value = " + rndval);
            System.out.println("\n****Game Over, You didn't win this time*****");
            flag = false;
        }

    }

}



