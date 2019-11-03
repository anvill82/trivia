package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.containsString;

public class GameTest {

    public static final String testPlayerName = "TestPlayer";
    private ByteArrayOutputStream stream;

    @Before
    public void getOutputStreamFromConsole() {
        stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
    }

    @Test
    public void whenGameIsCreatedStreamIsEmpty() {
        Game game = new Game();
        assertEquals("", stream.toString());
    }

    @Test
    public void whenPlayerIsAddedHisNameIsWritten() {
        Game game = new Game();
        game.add("TestPlayer");
        assertEquals("TestPlayer was added\n" +
                "They are player number 1\n", getStreamFromGame());
    }

    @Test
    public void whenGameCreatedWithOnePlayerTotalPlayersIsOne() {
        Game game = new Game();
        game.add(testPlayerName);
        assertEquals(1, game.howManyPlayers());
    }

    @Test
    public void whenGameCreatedWithMoreThanSixPlayersExceptionIsThrown() {
        Game game = new Game();

        try {
            for (int i = 0; i < 7; i++) {
                game.add(testPlayerName);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assertThat(e.getMessage(), containsString("6"));
        }
    }

    @Test
    public void whenOnePlayerIsAddedGameIsNotPlayable() {
        Game game = new Game();
        game.add(testPlayerName);
        assertEquals(false, game.isPlayable());
    }

    @Test
    public void whenTwoPlayersAreAddedGameIsPlayable() {
        Game game = new Game();
        game.add(testPlayerName);
        game.add(testPlayerName);
        assertEquals(true, game.isPlayable());
    }

    @Test
    public void gameAdd() {
        Game game = new Game();
    }

    @Test
    public void gameRollOne() {
		Game game = new Game();
		game.add(testPlayerName);
		game.roll(1);
		assertEquals("TestPlayer was added\n" +
				"They are player number 1\n" +
				"TestPlayer is the current player\n" +
				"They have rolled a 1\n" +
				"TestPlayer's new location is 1\n" +
				"The category is Science\n" +
				"Science Question 0\n", getStreamFromGame());
    }

    @Test
    public void gameRollTwo() {
		Game game = new Game();
		game.add(testPlayerName);
		game.roll(2);
		assertEquals("TestPlayer was added\n" +
				"They are player number 1\n" +
				"TestPlayer is the current player\n" +
				"They have rolled a 2\n" +
				"TestPlayer's new location is 2\n" +
				"The category is Sports\n" +
				"Sports Question 0\n", getStreamFromGame());
    }

    @Test
    public void gameRollThree() {
		Game game = new Game();
		game.add(testPlayerName);
		game.roll(3);
		assertEquals("TestPlayer was added\n" +
				"They are player number 1\n" +
				"TestPlayer is the current player\n" +
				"They have rolled a 3\n" +
				"TestPlayer's new location is 3\n" +
				"The category is Rock\n" +
				"Rock Question 0\n", getStreamFromGame());
    }

	@Test
    public void gameAskQuestion() {
		fail();
    }

    @Test
    public void gameCreateRockQuestion() {
        Game game = new Game();
        //game.add(testPlayerName);
        //game.roll(1);
        game.createRockQuestion(1);

        assertEquals("Rock Question 1", getStreamFromGame());
        // Rock Question " + index
    }



    @Test
    public void gameDidPlayerWin() {
		fail();
    }

    @Test
    public void gameHowManyPlayers() {
		fail();
    }

    @Test
    public void gameIsPlayable() {
		fail();
    }

    @Test
    public void gameWasCorrectlyAnswered() {
		fail();
    }

    @Test
    public void gameWrongAnswer() {
        fail();
    }

	private String getStreamFromGame() {
		return stream.toString().replaceAll("\r", "");
	}
}
