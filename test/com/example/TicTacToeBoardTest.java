package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {

  @Test
  public void testValidBoardStartGame() {
    TicTacToeBoard board = new TicTacToeBoard(".........");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testValidBoardXWinscol() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardXWinsrow() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardXWinsdiagnol() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardOWinscol() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardOWinsrow() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardOWinsdiagnol() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardGameInProgress() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testInvalidBoardXTwoWins() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testInvalidBoardOTwoWins() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testInvalidBoardMultipleWinners() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testInvalidDoublePlaybyX() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testInvalidDoublePlaybyO() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }
}
