package topscore;

/**
 * Top scoreboard of the players.
 *
 * @author Abhilash Ghosh
 */
public class ScoreBoard {

    IndividualGame[] game;
    int numEntries = 0; //this should be zero at the start of the game

    public ScoreBoard(int numPlayer){
        game = new IndividualGame[numPlayer];
    }

    public IndividualGame[] displayScore() {
        return game;
    }

    public int size() {
        return numEntries;
    }

    public void add(IndividualGame individualGame) {
        int newScore = individualGame.getScore();
        //check if the current game has more players than entries
        if(numEntries < game.length || newScore > game[numEntries -1].getScore()) {
            if(numEntries < game.length) {
                numEntries++;
            }

            int j = numEntries - 1;
            while(j>0 && game[j-1].getScore() < newScore) {
                game[j] = game[j-1];
                j--;
            }

            game[j] = individualGame;
        }
    }

    public void remove(int index) {
        if( index < 1 || index > game.length) {
            throw new ArrayIndexOutOfBoundsException("No game entry found:" + index);
        }

        for (int i = index; i < game.length; i++) {
            game[i-1] = game[i];
        }
        game[game.length-1] = null;
        numEntries--;
    }
}
