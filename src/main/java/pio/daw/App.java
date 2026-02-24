package pio.daw;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sudokuStr = "020900000009820000000005000030000000000040710000000000090701300000000001072050000";
        Playable game = new Sudoku(sudokuStr);
        game.printRules();
        while(!game.isFinished()){
            game.renderToConsole();
            System.out.print("Insert next movement, undo(u) or surrender(s): ");
            String input = sc.nextLine().toLowerCase();
            if(input.equals("u") || input.equals("undo")){
                game.undo();
            }
            else if(input.equals("s") || input.equals("surrender")){
                game.surrender();
            }
            else {
                try {
                    game.nextRound(input);
                }
                catch(Playable.InvalidUserInputException e){
                    System.out.println(e.getMessage());
                }
                catch(Playable.InvalidMovementException e){
                    System.out.println(e.getMessage());
                }  
            }
        }
        if(game.didPlayerWin()){
            System.out.println("YOU WIN");
        }
        else{
            System.out.println("YOU LOSE");
        }
        sc.close();
    }
}
