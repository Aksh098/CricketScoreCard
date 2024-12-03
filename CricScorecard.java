package cicProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CricScorecard {
    public static void main(String[] args) {
        // Create the main frame of the application
        JFrame frame = new JFrame("Cricket Scorecard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the window on the screen
        
        // Set the layout of the frame
        frame.setLayout(new BorderLayout());

        // Panel for user input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2, 10, 10));

        // Create labels and text fields for inputs
        JLabel oversLabel = new JLabel("Total Overs: ");
        JTextField oversField = new JTextField();

        JLabel tossWinnerLabel = new JLabel("Toss Winner (Team): ");
        JTextField tossWinnerField = new JTextField();

        JLabel tossDecisionLabel = new JLabel("Toss Decision (bat/ball): ");
        JTextField tossDecisionField = new JTextField();

        JLabel team1Label = new JLabel("Team 1 Name: ");
        JTextField team1Field = new JTextField();

        JLabel team2Label = new JLabel("Team 2 Name: ");
        JTextField team2Field = new JTextField();

        // Adding the input fields to the input panel
        inputPanel.add(oversLabel);
        inputPanel.add(oversField);
        inputPanel.add(tossWinnerLabel);
        inputPanel.add(tossWinnerField);
        inputPanel.add(tossDecisionLabel);
        inputPanel.add(tossDecisionField);
        inputPanel.add(team1Label);
        inputPanel.add(team1Field);
        inputPanel.add(team2Label);
        inputPanel.add(team2Field);

        // Button panel for Submit and Cancel buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Center the buttons with spacing

        JButton submitBtn = new JButton("Submit");
        JButton cancelBtn = new JButton("Cancel");

        buttonPanel.add(submitBtn);
        buttonPanel.add(cancelBtn);

        // Text area to display the results
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Panel for displaying results
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.add(new JLabel("Match Results: "), BorderLayout.NORTH);
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to the frame
        frame.add(inputPanel, BorderLayout.NORTH); // Input panel at the top
        frame.add(buttonPanel, BorderLayout.CENTER); // Button panel in the center
        frame.add(resultPanel, BorderLayout.SOUTH); // Result panel at the bottom

        // Action listener for the Submit button
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get user input for match details
                String totalOvers = oversField.getText();
                String tossWinner = tossWinnerField.getText();
                String tossDecision = tossDecisionField.getText();
                String team1 = team1Field.getText();
                String team2 = team2Field.getText();

                // Number of players in each team
                int numBatsmen = Integer.parseInt(JOptionPane.showInputDialog("Enter number of batsmen for Team 1:"));
                int numBowlers = Integer.parseInt(JOptionPane.showInputDialog("Enter number of bowlers for Team 1:"));

                // Create arrays to hold player data
                Player[] team1Batsmen = new Player[numBatsmen];
                Player[] team1Bowlers = new Player[numBowlers];

                // Taking batting and bowling input for Team 1
                for (int i = 0; i < numBatsmen; i++) {
                    String name = JOptionPane.showInputDialog("Enter name of batsman " + (i + 1) + " for Team 1:");
                    float runs = Float.parseFloat(JOptionPane.showInputDialog("Enter runs for " + name + ":"));
                    float balls = Float.parseFloat(JOptionPane.showInputDialog("Enter balls faced for " + name + ":"));
                    team1Batsmen[i] = new Player(name, runs, balls);
                }

                for (int i = 0; i < numBowlers; i++) {
                    String name = JOptionPane.showInputDialog("Enter name of bowler " + (i + 1) + " for Team 1:");
                    float overs = Float.parseFloat(JOptionPane.showInputDialog("Enter overs bowled by " + name + ":"));
                    float runs = Float.parseFloat(JOptionPane.showInputDialog("Enter runs conceded by " + name + ":"));
                    int wickets = Integer.parseInt(JOptionPane.showInputDialog("Enter wickets taken by " + name + ":"));
                    team1Bowlers[i] = new Player(name, overs, runs, wickets);
                }

                // Similarly, input for Team 2
                int numBatsmen2 = Integer.parseInt(JOptionPane.showInputDialog("Enter number of batsmen for Team 2:"));
                int numBowlers2 = Integer.parseInt(JOptionPane.showInputDialog("Enter number of bowlers for Team 2:"));

                Player[] team2Batsmen = new Player[numBatsmen2];
                Player[] team2Bowlers = new Player[numBowlers2];

                // Taking batting and bowling input for Team 2
                for (int i = 0; i < numBatsmen2; i++) {
                    String name = JOptionPane.showInputDialog("Enter name of batsman " + (i + 1) + " for Team 2:");
                    float runs = Float.parseFloat(JOptionPane.showInputDialog("Enter runs for " + name + ":"));
                    float balls = Float.parseFloat(JOptionPane.showInputDialog("Enter balls faced for " + name + ":"));
                    team2Batsmen[i] = new Player(name, runs, balls);
                }

                for (int i = 0; i < numBowlers2; i++) {
                    String name = JOptionPane.showInputDialog("Enter name of bowler " + (i + 1) + " for Team 2:");
                    float overs = Float.parseFloat(JOptionPane.showInputDialog("Enter overs bowled by " + name + ":"));
                    float runs = Float.parseFloat(JOptionPane.showInputDialog("Enter runs conceded by " + name + ":"));
                    int wickets = Integer.parseInt(JOptionPane.showInputDialog("Enter wickets taken by " + name + ":"));
                    team2Bowlers[i] = new Player(name, overs, runs, wickets);
                }

                // Create team objects and set the data
                Team team1Obj = new Team(team1);
                Team team2Obj = new Team(team2);

                team1Obj.setBattingData(team1Batsmen);
                team1Obj.setBowlingData(team1Bowlers);
                team2Obj.setBattingData(team2Batsmen);
                team2Obj.setBowlingData(team2Bowlers);

                // Calculate match details
                team1Obj.calculateBattingStats();
                team1Obj.calculateBowlingStats();
                team2Obj.calculateBattingStats();
                team2Obj.calculateBowlingStats();

                // Display match results
                resultArea.setText("");
                resultArea.append("Match Overs: " + totalOvers + "\n");
                resultArea.append("Toss Winner: " + tossWinner + "\n");
                resultArea.append("Toss Decision: " + tossDecision + "\n");

                resultArea.append("\nTeam 1 Batting Performance:\n");
                team1Obj.displayBattingStats(resultArea);
                resultArea.append("\nTeam 1 Bowling Performance:\n");
                team1Obj.displayBowlingStats(resultArea);

                resultArea.append("\nTeam 2 Batting Performance:\n");
                team2Obj.displayBattingStats(resultArea);
                resultArea.append("\nTeam 2 Bowling Performance:\n");
                team2Obj.displayBowlingStats(resultArea);

                resultArea.append("\nTotal Runs: " + team1Obj.totalRuns + " (Team 1) vs " + team2Obj.totalRuns + " (Team 2)\n");

                // Determine winner
                String winner = team1Obj.totalRuns > team2Obj.totalRuns ? team1 : team2;
                resultArea.append("\n\nWinner: " + winner + "!\n");
            }
        });

        // Action listener for the Cancel button
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all input fields
                oversField.setText("");
                tossWinnerField.setText("");
                tossDecisionField.setText("");
                team1Field.setText("");
                team2Field.setText("");
                resultArea.setText("");
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
