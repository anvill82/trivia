package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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
				"They are player number 1\n", stream.toString().replaceAll("\r", ""));
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
	public void t1() {
		Game game = new Game();

	}
}
