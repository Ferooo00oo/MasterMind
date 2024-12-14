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

package MasterMind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project{
    private static String secretCode;
    private static int attempts = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mastermind");
            ImageIcon logo = new ImageIcon("hamada.jpg");
            frame.setIconImage(logo.getImage());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 300);
            frame.setLayout(new BorderLayout());
            frame.setResizable(true);

            // Panel for input
            JPanel inputPanel = new JPanel();
            JLabel label = new JLabel();
            JTextField inputField = new JTextField(12);
            JButton submitButton = new JButton("Submit");
            label.setText("Code Maker, Enter your secret code (4 colors): ");

            inputPanel.add(label);
            inputPanel.add(inputField);
            inputPanel.add(submitButton);
            frame.add(inputPanel, BorderLayout.SOUTH);

            // Panel for feedback
            JTextArea feedbackArea = new JTextArea();
            feedbackArea.setEditable(false);
            feedbackArea.setFont(new Font("Noto Color Emoji" , Font.BOLD , 15));
            frame.add(new JScrollPane(feedbackArea));

            // Action listener for the submit button
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (secretCode == null) {
                        // First input (secret code)
                        secretCode = inputField.getText().toUpperCase();
                        if (!Check.IsValidCode(secretCode)) {
                            feedbackArea.append("Invalid secret code! Please use 4 characters from 'R, G, B, Y, P, O'.\n");
                            secretCode = null; // Reset secret code
                        } else {
                            feedbackArea.append("Secret code set! Now, guess the code.\n");
                            inputField.setText("");
                            label.setText("Code breaker, Try to guess the secret colors -Remember you have only 10 Guesses !!!-");
                        }
                    } else {
                        // Guess input
                        String guess = inputField.getText().toUpperCase();
                        if (!Check.IsValidCode(guess)) {
                            feedbackArea.append("Invalid guess! Please use 4 characters from 'R, G, B, Y, P, O'.\n");
                        } else {
                            attempts++;
                            int[] feedback = TheFeedback.Feedback(secretCode, guess);
                            int blackPegs = feedback[0];
                            int whitePegs = feedback[1];
                            feedbackArea.append("Attempt " + attempts + " of " + Att.getMAX_ATTEMPTS() + "   -   " + guess + "\nFeedback: " + blackPegs + " Black Pegs, " + whitePegs + " White Pegs\n");

                            if (blackPegs == Att.getCODE_LENGTH()) {
                                feedbackArea.append("Congratulations, you win! 😊\n");
                                Timer timer = new Timer(3000, w -> {
                                    System.exit(0); // Exit the application
                                });
                                timer.start();
                            } else if (attempts >= Att.getMAX_ATTEMPTS()) {
                                feedbackArea.append("Unfortunately, you ran out of attempts. The secret code was: " + secretCode + " 😢\n");
                                secretCode = null; // Reset for a new game
                                attempts = 0; // Reset attempts
                            }
                        }
                    }
                    inputField.setText("");
                }
            });

            frame.setVisible(true);
        });
    }
}
