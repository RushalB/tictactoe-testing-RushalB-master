package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
  private String BoardState="";
  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {
    BoardState = board;
    if (BoardState.length() != 9){  //Assuming n=3
      //throw new IllegalArgumentException;
    }
  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    return Evaluation.UnreachableState;
  }
}
