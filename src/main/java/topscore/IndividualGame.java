package topscore;

/**
 * Contains the individual player name and score
 *
 * @author Abhilash Ghosh
 */
public class IndividualGame {

    private String name;
    private int score;

    IndividualGame(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
