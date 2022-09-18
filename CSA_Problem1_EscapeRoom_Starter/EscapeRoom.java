/*
* Problem 1: Escape Room
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Scanner;

/**
 * Create an escape room game where the player must navigate
 * to the other side of the screen in the fewest steps, while
 * avoiding obstacles and collecting prizes.
 */
public class EscapeRoom
{

      // describe the game with brief welcome message
      // determine the size (length and width) a player must move to stay within the grid markings
      // Allow game commands:
      //    right, left, up, down: if you try to go off grid or bump into wall, score decreases
      //    jump over 1 space: you cannot jump over walls
      //    if you land on a trap, spring a trap to increase score: you must first check if there is a trap, if none exists, penalty
      //    pick up prize: score increases, if there is no prize, penalty
      //    help: display all possible commands
      //    end: reach the far right wall, score increase, game ends, if game ended without reaching far right wall, penalty
      //    replay: shows number of player steps and resets the board, you or another player can play the same board
      // Note that you must adjust the score with any method that returns a score
      // Optional: create a custom image for your player use the file player.png on disk
    
      /**** provided code:
      // set up the game
      boolean play = true;
      while (play)
      {
        // get user input and call game methods to play 
        play = false;
      }
      */

  public static void main(String[] args) 
  {      
    // welcome message
    System.out.println("Welcome to EscapeRoom!");
    System.out.println("Get to the other side of the room, avoiding walls and invisible traps,pick up all of the prizes.");
    System.out.println("Press h if help is needed.\n");
    System.out.println("Enter a command");
    
    GameGUI game = new GameGUI();
    game.createBoard();

    // size of move
    int m = 60; 
    // individual player moves
    int px = 0;
    int py = 0; 
    
    int score = 0;

    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d","jumpright", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd","pickup", "p", "quit", "q", "replay", "help", "?"};
  
    // set up game
    boolean play = true;
    while (play)
    {
  
      /* TODO: get all the commands working */
      /* Your code here */
      Scanner pressed = new Scanner(System.in);
      String pressedString = UserInput.getValidInput(validCommands);
      if (pressedString.equals("l")||pressedString.equals("left")) {
        System.out.println("Going left.");
        game.movePlayer(px-15,0);
      } else if (pressedString.equals("d")||pressedString.equals("down")) {
        System.out.println("Going down.");
        game.movePlayer(0,py+15);
      } else if (pressedString.equals("r")||pressedString.equals("right")) {
        System.out.println("Going right.");
        game.movePlayer(px+15,0);
      } else if (pressedString.equals("u")||pressedString.equals("up")) {
        System.out.println("Going up.");
        game.movePlayer(0,py-15);
      } else if (pressedString.equals("jr")||pressedString.equals("jumpright")) {
        System.out.println("Jumping right.");
        game.movePlayer(m,0);
      } 
      else if (pressedString.equals("jl")||pressedString.equals("jumpleft")) {
        System.out.println("Jumping left.");
        game.movePlayer(m * -1,0);
      } else if (pressedString.equals("ju")||pressedString.equals("jumpup")) {
        System.out.println("Jumping up.");
        game.movePlayer(0,m*-1);
      }else if (pressedString.equals("jd")||pressedString.equals("jumpdown")) {
        System.out.println("Jumping down.");
        game.movePlayer(0,m);
      }else if (pressedString.equals("q")||pressedString.equals("quit")) {
        System.out.println("Quitting game.");
        game.endGame();
      }else if (pressedString.equals("replay")) {
        System.out.println("Replaying");
        game.replay();
        System.out.println(score);
      }else if (pressedString.equals("h")||pressedString.equals("help")) {
        System.out.println("r or right for right, l or left for left, u or up for up, d or down for down,jr or jumpright for jumping right, jl or jumpleft for jumping left,jd or jumpdownfor jump down, ju or jumpup for jump up, h or help for help, q or quit for quit, and replay to replay the game");
      }
      
    }

  

    score += game.endGame();

    System.out.println("score=" + score);
    System.out.println("steps=" + game.getSteps());
  }
}

        