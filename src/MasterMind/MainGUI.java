/*
 * Made with ❤️ By:
 * Leader: Mohamed Hossam  - 2302142
 *         Mostafa Hamdy   - 2301354
 *         Omar    Hisham  - 2301297
 *         Ephraim Yousef  - 2301294
 *         Mostafa Mohamed - 2301291
 *         Haneen  Muhamed - 2300449
 *         Mina    Maken   - 2200390
 */



package MasterMind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainGUI {
    public static void main(String[] args) {
        JFrame Frame = new JFrame("MasterMind");
        ImageIcon image = new ImageIcon("logo.png");
        Frame.setIconImage(image.getImage());
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(950, 650);
        Frame.setLayout(null);
        Frame.setResizable(false);
        Frame.getContentPane().setBackground(new Color(0x182a47));


        JLabel inputLabel = new JLabel("Code maker, Enter Your Secret Color : ");
        JTextField inputField = new JTextField(12);
        JButton sButton = new JButton("Submit");
        
        JPanel inputPanel = new JPanel();
        inputPanel.setBounds(2,24, 930, 40);
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        inputPanel.add(sButton);
        inputPanel.setBackground(new Color(0x093c94));
        inputLabel.setForeground(Color.white);
        inputLabel.setFont(new Font("Arial", Font.BOLD, 17));
        Frame.add(inputPanel);
        
        JPanel feedBackPanel = new JPanel();
        feedBackPanel.setBackground(new Color(0xd8dce3));
        feedBackPanel.setBounds(0,90,935,500);
        JLabel welcome = new JLabel("Welcome to MasterMind!!    Available colors: Red, Green, Blue, Yellow, Orange, Purple");
        JLabel win = new JLabel("Congratulations, you win! 😊");
        welcome.setFont(new Font("Arial", Font.BOLD, 18));
        win.setFont(new Font("Noto Color Emoji", Font.BOLD, 20));
        feedBackPanel.add(welcome);
        Frame.add(feedBackPanel);
        
        
        Timer timer = new Timer(3000, w -> {
            feedBackPanel.removeAll();
            feedBackPanel.add(welcome);
            feedBackPanel.revalidate();
            feedBackPanel.repaint();
            inputLabel.setText("Code maker, Enter Your Secret Color : ");
        });



        sButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

            if(Att.getSecretCode() == null){
                timer.stop();
                Att.setSecretCode(inputField.getText().toLowerCase());
                if(!Check.IsValidCode(Att.getSecretCode())){
                    JLabel invalidSecret = new JLabel("Invalid Secret Color!! Please Type 4 Colors Separated by Spaces, and From 'Red, Green, Blue, Yellow, Orange, Purple'.");
                    invalidSecret.setFont(new Font("Arial", Font.BOLD, 16));
                    invalidSecret.setForeground(Color.red);
                    feedBackPanel.add(invalidSecret);
                    Att.setSecretCode(null);
                    inputField.setText("");
                    feedBackPanel.revalidate(); // بتعمل ريفريش للبانيل
                    feedBackPanel.repaint();
                } else {
                    feedBackPanel.removeAll();
                    JLabel player_2 = new JLabel("The Code Maker has Set the Colors, Code Breaker, Start Guessing!");
                    player_2.setFont(new Font("Arial", Font.BOLD, 18));
                    feedBackPanel.add(player_2);
                    inputField.setText("");
                    inputLabel.setText("Enter Your Guess : ");
                    feedBackPanel.revalidate(); // بتعمل ريفريش للبانيل
                    feedBackPanel.repaint();
                }
            } else{

                Att.setGuess(inputField.getText().toUpperCase());
                if (!Check.IsValidCode(Att.getGuess())) {
                    JLabel invalidGuess = new JLabel("Invalid Guess!! Please Type 4 Colors Separated by Spaces, and From 'Red, Green, Blue, Yellow, Orange, Purple'.");
                    invalidGuess.setFont(new Font("Arial", Font.BOLD, 16));
                    invalidGuess.setForeground(Color.red);
                    feedBackPanel.add(invalidGuess);
                    inputField.setText("");
                    feedBackPanel.revalidate(); // بتعمل ريفريش للبانيل
                    feedBackPanel.repaint();
                } else{
                    int x = Att.getAttempts();
                    x++;
                    Att.setAttempts(x);
                    int[] feedback = TheFeedback.Feedback(Att.getSecretCode(), Att.getGuess().toLowerCase());
                    int blackPegs = feedback[0];
                    int whitePegs = feedback[1];
                    JLabel feedbackLabel = new JLabel("Attempt " + Att.getAttempts() + " of " + Att.getMAX_ATTEMPTS() + "   -   " + Att.getGuess() + "        Feedback: " + blackPegs + " Black Pegs, " + whitePegs + " White Pegs\n");
                    feedbackLabel.setFont(new Font("Noto Color Emoji", Font.BOLD, 18));
                    feedBackPanel.add(feedbackLabel);

                    if(blackPegs == Att.getCODE_LENGTH()){
                        feedBackPanel.removeAll();
                        feedBackPanel.add(win);
                        feedBackPanel.revalidate(); // بتعمل ريفريش للبانيل
                        feedBackPanel.repaint();
                        Timer timer = new Timer(3000, w -> {
                            System.exit(0); // Exit the application
                        });
                        timer.start();

                    } else if(Att.getAttempts() >= Att.getMAX_ATTEMPTS()){
                        feedBackPanel.removeAll();
                        JLabel lose = new JLabel("Unfortunately, you ran out of attempts. The secret code was: " + Att.getSecretCode() + " 😢");
                        lose.setFont(new Font("Noto Color Emoji", Font.BOLD, 20));
                        feedBackPanel.add(lose);
                        Att.setAttempts(0);
                        Att.setSecretCode(null);
                        feedBackPanel.revalidate(); // بتعمل ريفريش للبانيل
                        feedBackPanel.repaint();
                        
                        timer.start();
                    }
                }
            }
            inputField.setText("");
            feedBackPanel.revalidate();
            feedBackPanel.repaint();
            }
        });

        Frame.setVisible(true);

    }
}
