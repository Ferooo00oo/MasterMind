/*
/*
Made With ❤ BY:
Big Eng:Mohamed Hossam
&
Big Eng:Ephraim Yousef
*/
/*
package com.mycompany.project;
import java.util.Scanner;

public class Project {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("                        Welcome to Mastermind!");
        System.out.println("Available colors: R(Red), G(Green), B(Blue), Y(Yellow), O(Orange), P(Purple)");
        System.out.println("      Code Maker, enter your secret code (4 colors) 'Without Spaces'");
        System.out.println("_________________________________________________________________________________");
        
        System.out.print("\nPlease enter the Secret colors : ");
        
        //player_1
        //Secret Color
        //عشان نستدعيهم بسهوله
        String SC = in.nextLine().toUpperCase();
        
        if (!Check.IsValidCode(SC)) {
            System.out.println("Please type only 4 characters  and within the colors 'R, G, B, Y, P, O'");
            return ;
        }
        
        //Player_2
        System.out.println("_________________________________________________________________________________");
        System.out.println("\nCode Breaker, Guess The Secret Code! 'Hint: You have only 10 Attempts'.");
        int attempts = 0 ;
        while(attempts < Att.getMAX_ATTEMPTS()){
            System.out.print(attempts + 1 + "/10 - Enter your guess (4 colors): ");
            String trys = in.nextLine().toUpperCase();
            
            if (!Check.IsValidCode(trys)) {
                System.out.println("Please type only 4 characters 'Without Spaces' and within the colors 'R, G, B, Y, P, O'");
                return ;
            }
            int getFeedback[] = TheFeedback.Feedback(SC, trys);
            
            int blackPegs = getFeedback[0];
            int whitePegs = getFeedback[1];
            System.out.println("Feedback:" + blackPegs + " Black Peg, " + whitePegs + " White peg" );
            if (blackPegs == att.getCODE_LENGTH()) {
                System.out.println("cogratulations you win 😊");
                break ;
            }
            attempts++;
            
            if (attempts == att.getMAX_ATTEMPTS()) {
                System.out.println("Unfortunately, YOU RAN OUT OF ATTEMPTS 😢");
            }
        }
    }
}
*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */