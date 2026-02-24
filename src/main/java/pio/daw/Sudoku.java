package pio.daw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import pio.daw.Playable.InvalidUserInputException;

public class Sudoku implements Playable {
    private Integer[][] matrix; // Holds info about the number in the sudoku
    private List<SudokuChange> changes; // Register every change
    private Boolean isFinish = false;
    private Boolean playerWin = false;

    //del ejercicio anterior
    Byte[][] tablero; // tablero array de array Byte[columna][fila]
    List<String> changes; //guarda en formato B37 (filaB col3 numero7)
     private final Map<Character,Integer> rowMap = Map.of( //para pasar la letra de la fila a int
        'A',0,
        'B',1,
        'C',2,
        'D',3,
        'E',4,
        'F',5,
        'G',6,
        'H',7,
        'I',8

     );


    /**
     * Data structure to store information about changes accesible
     */
    private record SudokuInput(Integer row, Integer col, Integer value) { 

        public SudokuInput(String input) throws Playable.InvalidUserInputException {//divido string en 3: compruebo que el primero es letra y los otros dos numeros
            // TODO Take an input of the form "B37" and store row = 1, col = 2, value = 7

            //asigno un indice a cada parte
            char rowValue = Character.toUpperCase(input.charAt(0));//por si lo pone en minusculas que no de problema
            char colValue = input.charAt(1);
            char n = input.charAt(2);

            
         
            //comprobaciones
            if (input == null || input.length() != 3) {
            throw new Playable.InvalidUserInputException(input, "El formato debe tener 3 valores. Ejemplo: B37");
            }
            
            if (!Character.isLetter(rowValue)) {
            throw new Playable.InvalidUserInputException(input, "El primer valor debe ser una letra (A-I).");
            }

            if (!Character.isDigit(colValue) || !Character.isDigit(n)) {
            throw new Playable.InvalidUserInputException(input, "El segundo y tercer valor deben ser numeros(1-9)");
            }


            int row = ;
            int col= Integer.parseInt(colValue);
            int value= n;

           
          this(row, col, value);
          
        }

        @Override
        public final String toString() {
            Character rowChar = (char) ('A' + this.row);
            return String.format("%c%d%d", rowChar, this.col + 1, this.value);
        }
    }


    private record SudokuChange(SudokuInput before, SudokuInput after) {
    }

    public Sudoku(){ //TODO Create a Sudoku with the matrix fill with 0 and an empty list of changes;
        
       this.tablero = new Byte[9][9]; //inicializacion
       this.changes = new ArrayList<>();

        for(Byte []row : this.tablero){//rellena el array de arrays con ceros
            Arrays.fill(row,0);
       }
       /* otra opcion: for(int row=0; row<9;row++){
                            for(int col =0;col<9;col++){
                            this.tablero[row][col]=0;}
                            
                            } 
        */

    }
    }

    public Sudoku(String sudokuString){
        //TODO Create a sudoku from a string of len 9x9 where every 9 chars correspond to a row
    }

    @Override
    public Boolean isFinished() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean didPlayerWin() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void surrender() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void renderToConsole() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub
        
    }

    private Boolean checkRows(){
        // TODO Return true if there is no error related to rows;
        return false;
    }

    private Boolean checkCols(){
        // TODO Return true if there is no error related to columns;
        return false;
    }

    private Boolean checkSquares(){
        // TODO Return true if there is no error related to squares;
        return false;
    }

    @Override
    public void nextRound(String userInput) throws InvalidUserInputException, InvalidMovementException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void printRules() {
        // TODO Auto-generated method stub
    }

    @Override
    public String toString() {
        // TODO Convert the sudoku matrix in a one line string of len 9x9;
        return "";
    }

}
