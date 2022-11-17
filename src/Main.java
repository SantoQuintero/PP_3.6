import java.util.*;
public class Main {
    /*
3.6)  Write an app HiLoGame that plays the Hi-Lo guessing game.
Listing 3.3 in the book (and given below) gives some of the logic for it, but
you will improve the player experience. The program will pick a random number
between 1 and 100 and then keep asking the user to guess the number. On each guess,
report to the user if the guess is correct, too high or too low.  Keep accepting
guesses until the user guesses correctly or quits.  (QUITTING MUST BE AN OPTION) At
the end of the game, ask if the user wants to play again.  Include in your app the method
validateGuess().  Play the game showing all functionality (guessing too high, too low and
correctly as well as playing again and then quitting).  To make your job a little easier, you
may output the correct answer so that you can "cheat" and keep your output to a manageable size.

Listing 3.3
//********************************************************************
//  Guessing.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of a block statement in an if-else.
//********************************************************************
import java.util.Scanner;
import java.util.Random;
public class Guessing
{
   //-----------------------------------------------------------------
   //  Plays a simple guessing game with the user.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      final int MAX = 10;
      int answer, guess;
      Scanner scan = new Scanner (System.in);
      Random generator = new Random();
      answer = generator.nextInt(MAX) + 1;
      System.out.print ("I'm thinking of a number between 1 and "
                        + MAX + ". Guess what it is: ");
      guess = scan.nextInt();
      if (guess == answer)
         System.out.println ("You got it! Good guessing!");
      else
      {
         System.out.println ("That is not correct, sorry.");
         System.out.println ("The number was " + answer);
      }
   }
}
*/

    public static void main(String[] args) {
        boolean again = playGame();
        while(again)
        {
            again = playGame();
        }

        System.out.print("GoodBye/\n\nSanto Quintero");
    }

    public static boolean playGame() {

        boolean cheated = false;
        //Declaring a var to keep track of if they have cheated/gave up

        Random rand = new Random();
        int answer = rand.nextInt(101);
        //Generates the answer

        System.out.println("CHEATING: " + answer);
        //Shows right answer

        System.out.println("To Give up enter 0.");
        //How to give up

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your guess (1-100 inclusive)");
        int guess = scan.nextInt();
        guess = validateGuess(guess);
        //Gets the first guess and validates it

        while (guess != answer)
        {
            if (guess > answer)
            {
                System.out.println("Too High!!");
                System.out.println("Enter your guess (1-100 inclusive)");
                guess = scan.nextInt();

                guess = validateGuess(guess);

            } else if (guess == 0)
            {
                cheated = true;
                guess = answer;
            } else
            {

                System.out.println("Too Low..");
                System.out.println("Enter your guess (1-100 inclusive)");
                guess = scan.nextInt();

                guess = validateGuess(guess);

            }
        }

        if(!cheated) {
            System.out.println("Correct!!!!!!!!!!!!!!!!");
        }

        System.out.println("Would you like to play again? Type \"y\" for yes and \"n\" for no.");
        String playAgain = scan.next();

        if(playAgain.equals("y"))
        {
            return true;
        }
        return false;
    }

    public static int validateGuess(int aGuess)
    {
        Scanner scan = new Scanner(System.in);

        while(aGuess>100||aGuess<0)
        {
            System.out.println("Invalid Guess! Try Again...");
            System.out.println("Enter your guess (1-100 inclusive)");
            aGuess = scan.nextInt();

        }

        return aGuess;
    }
}