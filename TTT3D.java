
import java.util.Scanner;
/*
 * create a class the allows the user 
 * to play a 3D tic tac toe game against the computer
 *
 */
public class TTT3D {

    static int board[][][] = new int[4][4][4];//create a game board

    static int linesSum[] = new int[76];//create an array with all the possible winning lines

    static final int[][][] lines = {
            {{0, 0, 0}, {0, 0, 1}, {0, 0, 2}, {0, 0, 3}},  //lev 0; row 0   rows in each lev
            {{0, 1, 0}, {0, 1, 1}, {0, 1, 2}, {0, 1, 3}},  //       row 1
            {{0, 2, 0}, {0, 2, 1}, {0, 2, 2}, {0, 2, 3}},  //       row 2
            {{0, 3, 0}, {0, 3, 1}, {0, 3, 2}, {0, 3, 3}},  //       row 3
            {{1, 0, 0}, {1, 0, 1}, {1, 0, 2}, {1, 0, 3}},  //lev 1; row 0
            {{1, 1, 0}, {1, 1, 1}, {1, 1, 2}, {1, 1, 3}},  //       row 1
            {{1, 2, 0}, {1, 2, 1}, {1, 2, 2}, {1, 2, 3}},  //       row 2
            {{1, 3, 0}, {1, 3, 1}, {1, 3, 2}, {1, 3, 3}},  //       row 3
            {{2, 0, 0}, {2, 0, 1}, {2, 0, 2}, {2, 0, 3}},  //lev 2; row 0
            {{2, 1, 0}, {2, 1, 1}, {2, 1, 2}, {2, 1, 3}},  //       row 1
            {{2, 2, 0}, {2, 2, 1}, {2, 2, 2}, {2, 2, 3}},  //       row 2
            {{2, 3, 0}, {2, 3, 1}, {2, 3, 2}, {2, 3, 3}},  //       row 3
            {{3, 0, 0}, {3, 0, 1}, {3, 0, 2}, {3, 0, 3}},  //lev 3; row 0
            {{3, 1, 0}, {3, 1, 1}, {3, 1, 2}, {3, 1, 3}},  //       row 1
            {{3, 2, 0}, {3, 2, 1}, {3, 2, 2}, {3, 2, 3}},  //       row 2
            {{3, 3, 0}, {3, 3, 1}, {3, 3, 2}, {3, 3, 3}},  //       row 3
            {{0, 0, 0}, {0, 1, 0}, {0, 2, 0}, {0, 3, 0}},  //lev 0; col 0   cols in each lev
            {{0, 0, 1}, {0, 1, 1}, {0, 2, 1}, {0, 3, 1}},  //       col 1
            {{0, 0, 2}, {0, 1, 2}, {0, 2, 2}, {0, 3, 2}},  //       col 2
            {{0, 0, 3}, {0, 1, 3}, {0, 2, 3}, {0, 3, 3}},  //       col 3
            {{1, 0, 0}, {1, 1, 0}, {1, 2, 0}, {1, 3, 0}},  //lev 1; col 0
            {{1, 0, 1}, {1, 1, 1}, {1, 2, 1}, {1, 3, 1}},  //       col 1
            {{1, 0, 2}, {1, 1, 2}, {1, 2, 2}, {1, 3, 2}},  //       col 2
            {{1, 0, 3}, {1, 1, 3}, {1, 2, 3}, {1, 3, 3}},  //       col 3
            {{2, 0, 0}, {2, 1, 0}, {2, 2, 0}, {2, 3, 0}},  //lev 2; col 0
            {{2, 0, 1}, {2, 1, 1}, {2, 2, 1}, {2, 3, 1}},  //       col 1
            {{2, 0, 2}, {2, 1, 2}, {2, 2, 2}, {2, 3, 2}},  //       col 2
            {{2, 0, 3}, {2, 1, 3}, {2, 2, 3}, {2, 3, 3}},  //       col 3
            {{3, 0, 0}, {3, 1, 0}, {3, 2, 0}, {3, 3, 0}},  //lev 3; col 0
            {{3, 0, 1}, {3, 1, 1}, {3, 2, 1}, {3, 3, 1}},  //       col 1
            {{3, 0, 2}, {3, 1, 2}, {3, 2, 2}, {3, 3, 2}},  //       col 2
            {{3, 0, 3}, {3, 1, 3}, {3, 2, 3}, {3, 3, 3}},  //       col 3
            {{0, 0, 0}, {1, 0, 0}, {2, 0, 0}, {3, 0, 0}},  //cols in vert plane in front
            {{0, 0, 1}, {1, 0, 1}, {2, 0, 1}, {3, 0, 1}},
            {{0, 0, 2}, {1, 0, 2}, {2, 0, 2}, {3, 0, 2}},
            {{0, 0, 3}, {1, 0, 3}, {2, 0, 3}, {3, 0, 3}},
            {{0, 1, 0}, {1, 1, 0}, {2, 1, 0}, {3, 1, 0}},  //cols in vert plane one back
            {{0, 1, 1}, {1, 1, 1}, {2, 1, 1}, {3, 1, 1}},
            {{0, 1, 2}, {1, 1, 2}, {2, 1, 2}, {3, 1, 2}},
            {{0, 1, 3}, {1, 1, 3}, {2, 1, 3}, {3, 1, 3}},
            {{0, 2, 0}, {1, 2, 0}, {2, 2, 0}, {3, 2, 0}},  //cols in vert plane two back
            {{0, 2, 1}, {1, 2, 1}, {2, 2, 1}, {3, 2, 1}},
            {{0, 2, 2}, {1, 2, 2}, {2, 2, 2}, {3, 2, 2}},
            {{0, 2, 3}, {1, 2, 3}, {2, 2, 3}, {3, 2, 3}},
            {{0, 3, 0}, {1, 3, 0}, {2, 3, 0}, {3, 3, 0}},  //cols in vert plane in rear
            {{0, 3, 1}, {1, 3, 1}, {2, 3, 1}, {3, 3, 1}},
            {{0, 3, 2}, {1, 3, 2}, {2, 3, 2}, {3, 3, 2}},
            {{0, 3, 3}, {1, 3, 3}, {2, 3, 3}, {3, 3, 3}},
            {{0, 0, 0}, {0, 1, 1}, {0, 2, 2}, {0, 3, 3}},  //diags in lev 0
            {{0, 3, 0}, {0, 2, 1}, {0, 1, 2}, {0, 0, 3}},
            {{1, 0, 0}, {1, 1, 1}, {1, 2, 2}, {1, 3, 3}},  //diags in lev 1
            {{1, 3, 0}, {1, 2, 1}, {1, 1, 2}, {1, 0, 3}},
            {{2, 0, 0}, {2, 1, 1}, {2, 2, 2}, {2, 3, 3}},  //diags in lev 2
            {{2, 3, 0}, {2, 2, 1}, {2, 1, 2}, {2, 0, 3}},
            {{3, 0, 0}, {3, 1, 1}, {3, 2, 2}, {3, 3, 3}},  //diags in lev 3
            {{3, 3, 0}, {3, 2, 1}, {3, 1, 2}, {3, 0, 3}},
            {{0, 0, 0}, {1, 0, 1}, {2, 0, 2}, {3, 0, 3}},  //diags in vert plane in front
            {{3, 0, 0}, {2, 0, 1}, {1, 0, 2}, {0, 0, 3}},
            {{0, 1, 0}, {1, 1, 1}, {2, 1, 2}, {3, 1, 3}},  //diags in vert plane one back
            {{3, 1, 0}, {2, 1, 1}, {1, 1, 2}, {0, 1, 3}},
            {{0, 2, 0}, {1, 2, 1}, {2, 2, 2}, {3, 2, 3}},  //diags in vert plane two back
            {{3, 2, 0}, {2, 2, 1}, {1, 2, 2}, {0, 2, 3}},
            {{0, 3, 0}, {1, 3, 1}, {2, 3, 2}, {3, 3, 3}},  //diags in vert plane in rear
            {{3, 3, 0}, {2, 3, 1}, {1, 3, 2}, {0, 3, 3}},
            {{0, 0, 0}, {1, 1, 0}, {2, 2, 0}, {3, 3, 0}},  //diags left slice
            {{3, 0, 0}, {2, 1, 0}, {1, 2, 0}, {0, 3, 0}},
            {{0, 0, 1}, {1, 1, 1}, {2, 2, 1}, {3, 3, 1}},  //diags slice one to right
            {{3, 0, 1}, {2, 1, 1}, {1, 2, 1}, {0, 3, 1}},
            {{0, 0, 2}, {1, 1, 2}, {2, 2, 2}, {3, 3, 2}},  //diags slice two to right
            {{3, 0, 2}, {2, 1, 2}, {1, 2, 2}, {0, 3, 2}},
            {{0, 0, 3}, {1, 1, 3}, {2, 2, 3}, {3, 3, 3}},  //diags right slice
            {{3, 0, 3}, {2, 1, 3}, {1, 2, 3}, {0, 3, 3}},
            {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}, {3, 3, 3}},  //cube vertex diags
            {{3, 0, 0}, {2, 1, 1}, {1, 2, 2}, {0, 3, 3}},
            {{0, 3, 0}, {1, 2, 1}, {2, 1, 2}, {3, 0, 3}},
            {{3, 3, 0}, {2, 2, 1}, {1, 1, 2}, {0, 0, 3}}
    };
/*
 * reset the board
 * print the board for each round
 * play the game 
 */
    public static void main(String[] args) {

        resetBoard();

        printBoard();

        playGame();

    }
/*
 * reset each location on the board to 0 (unoccupied)
 */
    public static void resetBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    board[i][j][k] = 0;
                }
            }
        }
    }
/*
 * print the board for each round
 * 0 is unoccupied which means a "_" will be printed
 * 1 is a spot taken by the computer which means a "O" will be printed
 * 5 is a spot taken by the user which means a "X" will be printed
 */
    public static void printBoard() {
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                System.out.print(i + "" + j);
                for (int k = 0; k < 4; k++) {
                    if (board[i][j][k] == 0) {
                        System.out.print(" _ ");
                    }
                    else if (board[i][j][k] == 1) {
                        System.out.print(" O ");
                    }
                    else if (board[i][j][k] == 5) {
                        System.out.print(" X ");
                    }
                }
                System.out.println();

            }
            System.out.println();
        }

        System.out.println("   0  1  2  3");
    }
/*
 * plays the game user vs computer
 */
    public static void playGame() {

        boolean gameDone = false;
        /*
         * create a while loop to ensure game play
         */
        gameLoop:
        while (!gameDone) {

            System.out.println("Type your move as one three digit number(lrc) ");

            Scanner scan = new Scanner(System.in);
            String lrc = scan.next();// lrc means level row column
            /*
             * ensures that the lrc is valid
             */
            if (lrc.length() != 3) {
                System.out.println("Invalid Entry....try again");
                continue;
            }
            /*
             * converts the lrc string into seperate level row column integers
             */
            int l = Integer.parseInt(lrc.substring(0, 1));
            int r = Integer.parseInt(lrc.substring(1, 2));
            int c = Integer.parseInt(lrc.substring(2, 3));
            /*
             * ensures once again that the level, row, and column are valid
             */
            if (l > 3 || r > 3 || c > 3 || board[l][r][c] != 0) {
                System.out.println("Invalid Entry....try again");
                continue;
            }

            board[l][r][c] = 5;// 5 means a cell taken by the user

           
            int[] correspondingLines = getCorrespondingLines(l, r, c);// create an array that gets the lines with a specific cell 
            /*
             * loop for when the user wins
             */
            for (int i = 0; i < correspondingLines.length; i++) {
                linesSum[correspondingLines[i]] = linesSum[correspondingLines[i]] + 5;// adds 5 to the sum of the line when the user occupies a spot

                if (linesSum[correspondingLines[i]] == 20) {
                    printBoard();
                    System.out.println("USER WON!!!!" + i);
                    break gameLoop;
                }
            }

            
            /*
             * loop for when the computer wins
             */
            for (int i = 0; i < linesSum.length; i++) {
                if (linesSum[i] == 3) {
                    int[][] line = lines[i];//gets the four cells from that line
                    for (int j = 0; j < 4; j++) {//each line has four cells
                        int[] cell = line[j];//picks a single cell from the same line
                        if (board[cell[0]][cell[1]][cell[2]] == 0) {
                            board[cell[0]][cell[1]][cell[2]] = 1;
                            linesSum[i] = linesSum[i] + 1;//adds 1 to the sum of the line when the computer occupies a spot
                            printBoard();
                            System.out.println("COMPUTER WON!!!!");
                            break gameLoop;
                        }
                    }
                }
            }

            
            /*
             * loop to block the user from winning
             */
            for (int i = 0; i < linesSum.length; i++) {
                if (linesSum[i] == 15) {
                    int[][] line = lines[i];//gets the four cells from a line
                    for (int j = 0; j < 4; j++) {//each line has 4 cells
                        int[] cell = line[j];// picks a single cell from that line
                        if (board[cell[0]][cell[1]][cell[2]] == 0) {
                            makeCompMove(cell[0], cell[1], cell[2]);
                            continue gameLoop;
                        }
                    }
                    continue gameLoop;
                }
            }

            
            /*
             * creates a fork for the computer
             */
            if (playFork(2)) {
                continue gameLoop;
            }

           /*
            * blocks a possible fork for the user
            */
            if (playFork(10)) {
                continue gameLoop;
            }

            int playableLines = 0;
            /*
             * identifies the number of playable lines
             */
            for (int lineNum = 0; lineNum < lines.length; lineNum++) {
                if (linesSum[lineNum] < 4 || linesSum[lineNum] % 5 == 0) {
                    playableLines += 1;
                }
            }
            /*
             * identifies a draw if there are 0 playable lines
             */
            if (playableLines == 0) {
                printBoard();
                System.out.println("ITS A DRAW!!!!");
                break gameLoop;
            }
            
            boolean randomPlay = false;
            /*
             * selects a random unoccupied cell for the computer to choose
             */
            while (!randomPlay) {
                int randomIndex = (int) (Math.random() * 75);

                if (linesSum[randomIndex] < 4 || linesSum[randomIndex] % 5 == 0) {
                    int[][] line = lines[randomIndex];//gets the four cells from the playable line
                    for (int j = 0; j < 4; j++) {
                        int[] cell = line[j];//picks a single cell from that line
                        if (board[cell[0]][cell[1]][cell[2]] == 0) {
                            makeCompMove(cell[0], cell[1], cell[2]);
                            continue gameLoop;
                        }
                    }
                    continue gameLoop;
                }

            }

        }

    }
    /*
     * method to deal with fork situations for the user and computer
     * fork value is either a 2 (to create a fork for the computer) 
     * or a 10 (to block a fork for the user)
     */
    public static boolean playFork(int forkValue) {
        String[] lrcs = new String[76];//arrays with lrcs that have possible forks
        int lrcIndex = 0;
        for (int i = 0; i < lines.length; i++) {

            if (linesSum[i] == forkValue) {
                int[][] line = lines[i];
                for (int j = 0; j < 4; j++) {
                    int[] cell = line[j];
                    if (board[cell[0]][cell[1]][cell[2]] == 0) {
                    	//create a string to store in the lrcs array
                        String forkableLrc = "" + cell[0] + cell[1] + cell[2];
                        
                        //compare if forkable lrc exist in the lrcs array
                        for (int a = 0; a < lrcIndex; a++) {
                            if (lrcs[a].equals(forkableLrc)) {
                                makeCompMove(cell[0], cell[1], cell[2]);
                                return true;
                            }
                        }

                        lrcs[lrcIndex] = forkableLrc;//adding the forkable lrc to the lrcs array
                        lrcIndex++;

                    }
                }
            }
        }

        return false;
    }
    /*
     * create a method that plays the computers move
     */
    private static void makeCompMove(int l, int r, int c) {

        board[l][r][c] = 1;//1 means a cell taken by the computer

        int corrLines[] = getCorrespondingLines(l, r, c);//gets the lines for that lrc 
        /*
         * updates the sum for the lines with that lrc
         */
        for (int a = 0; a < corrLines.length; a++) {
            linesSum[corrLines[a]] = linesSum[corrLines[a]] + 1;
        }

        printBoard();

    }
    /*
     * creates a method that gets the lines containing the cell
     */
    public static int[] getCorrespondingLines(int l, int r, int c) {
        int[] corrLines = new int[76];//array of lines with a specific cell
        int index = 0;
        
        /*
         * loops through all the lines 
         * stores the lines with the specific cell into the corrLines array
         */
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (lines[i][j][0] == l &&
                        lines[i][j][1] == r &&
                        lines[i][j][2] == c) {
                    corrLines[index] = i;
                    index++;
                }
            }
        }

        int[] actualCorrLines = new int[index];//removes unused indexs from the corrLines array
        /*
         * copies the valid line numbers into the actualCorrLines array
         */
        for (int i = 0; i < index; i++) {
            actualCorrLines[i] = corrLines[i];
        }

        return actualCorrLines;
    }
}
