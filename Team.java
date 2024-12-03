package cicProject;

import javax.swing.*;

class Team {
    String name;
    Player[] battingData;
    Player[] bowlingData;
    float totalRuns;

    Team(String name) {
        this.name = name;
    }

    void setBattingData(Player[] battingData) {
        this.battingData = battingData;
    }

    void setBowlingData(Player[] bowlingData) {
        this.bowlingData = bowlingData;
    }

    void calculateBattingStats() {
        totalRuns = 0;
        for (Player player : battingData) {
            totalRuns += player.runs;
        }
    }

    void calculateBowlingStats() {
        // Example: Total Wickets or other bowling stats can be added here
    }

    void displayBattingStats(JTextArea resultArea) {
        for (Player player : battingData) {
            resultArea.append(String.format("%s\t%.0f\t%.0f\t%.2f\n", player.name, player.runs, player.balls, player.getStrikeRate()));
        }
    }

    void displayBowlingStats(JTextArea resultArea) {
        for (Player player : bowlingData) {
            resultArea.append(String.format("%s\t%.1f\t%.0f\t%d\t%.2f\n", player.name, player.overs, player.runs, player.wickets, player.getEconomyRate()));
        }
    }

    void displayBattingStatsInConsole() {
        System.out.println("Batting Performance:");
        for (Player player : battingData) {
            System.out.printf("%s\t\tRuns: %.0f\tBalls: %.0f\tStrike Rate: %.2f\n", player.name, player.runs, player.balls, player.getStrikeRate());
        }
    }

    void displayBowlingStatsInConsole() {
        System.out.println("Bowling Performance:");
        for (Player player : bowlingData) {
            System.out.printf("%s\t\tOvers: %.1f\tRuns: %.0f\tWickets: %d\tEconomy: %.2f\n", player.name, player.overs, player.runs, player.wickets, player.getEconomyRate());
        }
    }
}
