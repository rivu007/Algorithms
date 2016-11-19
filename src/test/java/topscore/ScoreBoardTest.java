package topscore;

import org.junit.Assert;
import org.junit.Test;

/**
 * Score Board Test
 *
 * @author Abhilash Ghosh
 */
public class ScoreBoardTest {

    private ScoreBoard scoreBoard;


    @Test
    public void add_fiveParticipant_shouldSeeOnlyTopThreePlayer() {
        scoreBoard = new ScoreBoard(3);

        scoreBoard.add(new IndividualGame("Abhilash", 700));
        scoreBoard.add(new IndividualGame("ZZZ", 1000));
        scoreBoard.add(new IndividualGame("XYZ", 200));
        scoreBoard.add(new IndividualGame("Beta", 100));
        scoreBoard.add(new IndividualGame("Gamma", 300));


        Assert.assertNotNull(scoreBoard);
        Assert.assertEquals(3, scoreBoard.size());
        Assert.assertEquals("ZZZ", scoreBoard.game[0].getName()); //First Player
        Assert.assertEquals("Abhilash", scoreBoard.game[1].getName()); //Second Player
        Assert.assertEquals("Gamma", scoreBoard.game[2].getName()); //Third Player
    }

    @Test
    public void remove_removeOnePlayerFromScoreBoard_success() {
        scoreBoard = new ScoreBoard(3);
        //adding the random player with score and it will sort as per descending order of scores
        scoreBoard.add(new IndividualGame("XYZ", 200));
        scoreBoard.add(new IndividualGame("ZZZ", 700));
        scoreBoard.add(new IndividualGame("Abhilash", 1000));

        Assert.assertEquals(3, scoreBoard.size());  //check the num of participant in the board.

        scoreBoard.remove(2);

        Assert.assertEquals(2, scoreBoard.size());  // after removing one entry.
        Assert.assertEquals("Abhilash", scoreBoard.game[0].getName());
        Assert.assertEquals("XYZ", scoreBoard.game[1].getName());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void remove_supplyingIndexOutOfTheRange_exceptionMessageShown() {
        scoreBoard = new ScoreBoard(2);

        scoreBoard.add(new IndividualGame("XYZ", 200));
        scoreBoard.add(new IndividualGame("ZZZ", 700));

        scoreBoard.remove(3);
    }
}
