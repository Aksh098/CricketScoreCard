package cicProject;
class Player {
    String name;
    float runs;
    float balls;
    float overs;
    int wickets;

    // Constructor for batsman
    Player(String name, float runs, float balls) {
        this.name = name;
        this.runs = runs;
        this.balls = balls;
    }

    // Constructor for bowler
    Player(String name, float overs, float runs, int wickets) {
        this.name = name;
        this.overs = overs;
        this.runs = runs;
        this.wickets = wickets;
    }

    // Get Strike Rate (for batsman)
    float getStrikeRate() {
        return (balls > 0) ? (runs / balls) * 100 : 0;
    }

    // Get Economy Rate (for bowler)
    float getEconomyRate() {
        return (overs > 0) ? (runs / overs) : 0;
    }
}
