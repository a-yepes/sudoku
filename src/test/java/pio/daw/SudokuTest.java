package pio.daw;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SudokuTest {
    private Sudoku sudoku;
    private final String sudokuStr = "020900000009820000000005000030000000000040710000000000090701300000000001072050000";

    @BeforeEach
    public void createNewSudoku(){
        this.sudoku = new Sudoku(sudokuStr);
        assertTrue(this.sudoku.toString().equals(sudokuStr));
    }

    @Test
    public void emptySudokuTest(){
        String sudoString = "0".repeat(81);
        this.sudoku = new Sudoku();
        assertTrue(this.sudoku.toString().equals(sudoString));
    }

    @Test
    public void didPlayerWinTest(){
        this.sudoku = new Sudoku("034126857516798432278354619785263941129475386463819725642931578357682194891547263");
        assertFalse(this.sudoku.didPlayerWin());
        assertDoesNotThrow(() -> {this.sudoku.nextRound("A19");});
        assertTrue(this.sudoku.isFinished());
        assertTrue(this.sudoku.didPlayerWin());
    }

    @Test
    public void surrenderTest(){
        assertFalse(this.sudoku.isFinished());
        this.sudoku.surrender();
        assertTrue(this.sudoku.isFinished());
        assertFalse(this.sudoku.didPlayerWin());
    }

    @Test
    public void nextRoundTest(){
        assertThrows(Playable.InvalidUserInputException.class, () -> {this.sudoku.nextRound("adsfds");});
        assertThrows(Playable.InvalidMovementException.class, () -> {this.sudoku.nextRound("A12");});
        assertDoesNotThrow(() -> this.sudoku.nextRound("A18"));
        assertTrue(this.sudoku.toString().startsWith("8"));
    }
}
