package com.wfs.amazon.backtracking;

import java.util.HashSet;
import java.util.Set;

public class _37SudokuSolver {
    private char[][] sudokuBoard;

    private Set<Integer> setOfImmutableRows[];

    private Set<Integer> setOfImmutableCols[];

    Set<Integer> setOfRows[];

    Set<Integer> setOfCols[];

    Set<Integer> setOfSquareIndexes[];

    public _37SudokuSolver(char[][] sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        for(int i=0;i<sudokuBoard.length;i++){
            this.setOfImmutableRows[i] =new HashSet<>();
            this.setOfImmutableCols[i] =new HashSet<>();
            this.setOfRows[i] = new HashSet<>();
            this.setOfCols[i]=new HashSet<>();
            this.setOfSquareIndexes[i]=new HashSet<>();
        }
        for(int i=0;i<sudokuBoard.length;i++)
            for(int j=0;j<sudokuBoard[i].length;j++){
                this.setOfImmutableRows[i].add((int)sudokuBoard[i][j]);
                this.setOfImmutableRows[j].add((int)sudokuBoard[i][j]);
            }
    }

    public void solveSudoku() {
         solveSudoku(sudokuBoard,0,0);
    }

    private boolean isImmutablePosition(int i,int j){
        return setOfImmutableRows[i].size()>0 && setOfImmutableCols[j].size()>0 ;
    }

    private boolean isValidNumber(int i ,int j, int num){
        int midIndex = (i/3)*3 + j/3;
        return !setOfRows[i].contains(num) && !setOfCols[j].contains(num) && setOfSquareIndexes[midIndex].contains(num);
    }

    private boolean  solveSudoku(char[][] sudokuBoard,int i , int j) {
        if(i==sudokuBoard.length-1 && j== sudokuBoard[0].length-1){
            printSudoku(sudokuBoard);
            return true;
        }
        if(isImmutablePosition(i,j)){
            return solveSudoku(sudokuBoard,j==sudokuBoard[0].length-1  ?  i+1 :i , j==sudokuBoard[0].length-1  ? 0 : j+1);
        }
        int midIndex = (i/3)*3 + j/3;
        for(int K=1;K<=9;K++){
            if(isValidNumber(i,j, K)){
                setOfRows[i].add(K);
                setOfCols[j].add(K);
                setOfSquareIndexes[midIndex] .add(K);
                if(!solveSudoku(sudokuBoard,j==sudokuBoard[0].length-1  ?  i+1 :i , j==sudokuBoard[0].length-1  ? 0 : j+1)){
                    setOfRows[i].remove(K);
                    setOfCols[j].remove(K);
                    setOfSquareIndexes[midIndex] .remove(K);
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    private void printSudoku(char[][] sudokuBoard){
        for(int i=0;i<sudokuBoard.length;i++){
            System.out.println();
            for(int j=0;i<sudokuBoard[i].length;j++)
                System.out.println(sudokuBoard[i][j]+" ");
        }
    }

}
