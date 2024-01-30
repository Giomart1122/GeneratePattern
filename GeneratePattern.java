/*
    GeneratePattern.java

	Description:    This program can be used to draw geometric patterns
                    through the use of for-loop structures.
*/

///////////////////////////////////////////////////////////////////////////////

//  Lab:    GeneratePattern
//  Goals:  Learn standard patterns of single, double, or triple Looping
//          Complexity analysis of loop structures can be considered if needed.
//
//  STUDENT NAME: Giovanni Martinez
//  DATE: 01/24/24

///////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.Scanner;

import javax.xml.namespace.QName;

import java.util.Arrays;


public class GeneratePattern
{
    public static final int MAXPATTERN = 16;	// maximun number of patterns
    public static final int MAXROW = 8;			// maximum number of rows
    public static final int MAXCOL = 8;			// maximum number of columns

    private int[][] board;						// the drawing window


    /** the constructor: creates the boards, and opens stdin for reading from user
     */
    public GeneratePattern()
    {
        board = new int[MAXROW][MAXCOL];
    } // end of GeneratePattern()


	public void initializeBoard()
	{
		for (int row = 0; row < MAXROW; row++)
			for (int col = 0; col < MAXCOL; col++)
				board[row][col] = 0;
	} // end of initializeBoard()


	public void printBoard()
	{
		for (int row = 0; row < MAXROW; row++){
			for (int col = 0; col < MAXCOL; col++)
				System.out.format("%-3d", board[row][col]);
			System.out.println();
		}
		
    public void populateBoard(int patternNumber)
    {
		int num = 1; 
        // assume maximum number of dots in each row or col is 8
        switch (patternNumber) {
		case 1:
		case 17:
		case 18:
				for (int row = 0; row < MAXROW; row++)
					for (int col = 0; col < MAXCOL; col++)
						board[row][col] = num++;
				break;
			
		case 2:  
				for(int col=0;col< MAXCOL; col++)
					for (int row =0; row < MAXROW; row++)
						board[row][col]=num++;
				break;
		case 3: 
			    	for (int row = 1; row < MAXROW; row++)
					for (int col = 0; col < row; col++)
						board[row][col] = num++;
				break;
		case 4:
				for (int row = 0; row < MAXROW; row++)
					for (int col = row; col < MAXCOL; col++)
						board[row][col] = num++;
				break;
		case 5: 
				for (int row = 1; row < MAXROW-1; row++)
					for (int col = 1; col < MAXROW - row; col++)
						board[row][col] = num++;
				break; 
		case 6: 
				for (int row = 1; row < MAXROW; row++)
					for (int col = MAXCOL-1; col > MAXROW-row-1; col--)
						board[row][col] = num++;

				break;
		case 7: 
				for (int row = 0; row < MAXROW; row++)
					for (int col = row; col <= row; col++)
						board[row][col] = num++;
			// alternate solution
			/*for(int row = 0; row < MAXROW; row++)
					board[row][row]= num++ */
		    break;
		case 8: 
				for (int row = 0; row < MAXROW; row++){
					board[row][row] = num++; 
				}
				for(int row = 0; row < MAXROW; row++)
					board[row][MAXROW-1-row] = num++;
				break;

		case 9: 

			for (int col = 0; col < 4; col++){
				for (int row = col; row < 4*2-col;row++){
					board[row][col] = num++;
				}
			}
		break;
		
		case 10: 
			for (int col = 0; col < 4; col++){
				for(int row = col; row < 4*2-col;row++){
					board[row][col] = num++;
				}
			}

			for (int col = 4; col < 4*2; col++){
				for (int row = 4*2-col-1; row <= col; row++){
					board[row][col] = num++;
				}
			}
			break;

		case 11: 
			for (int row = 0; row < 1; row++) {
				for(int col = 0; col < MAXCOL; col++)
					board[row][col]=num++;
			}
			num = 8;
			for(int col = MAXCOL-1; col < MAXCOL; col++){				
				for (int row = 0; row < MAXROW; row++) {
					board[row][col]=num++;
			}
		}
			num = 15;
			for (int row = MAXROW - 1; row < MAXROW; row++){
				for (int col = MAXCOL - 1; col >= 0; col--){
					board[row][col] = num++;
			}
		}
			num = 22;
			for(int col = 0; col < 1; col++){
				for(int row = MAXROW-1; row > 0; row--){
					board[row][col] = num++;
				}
			}
			
		break;

		case 12:  
			for (int i = 0; i < (MAXROW + 1) / 2; i++){ 
				for (int col = i; col < MAXCOL - i; col++){
					board[i][col] = num++;
				}
			for (int row = i + 1; row < MAXROW - i; row++){
				board[row][MAXCOL -  i - 1] = num++;
			}
			for (int col = MAXCOL - i - 2; col >= i; col--){
				board[MAXROW - i - 1][col] = num++;
			}
			for (int row = MAXROW - i - 2; row > i; row--){
				board[row][i] = num++;
			}
			}
		break;		
		
		case 13: 
			for (int row = 0; row < MAXROW-7; row++) //first for loop
				for (int col = 0; col < MAXCOL - 6; col++)
			        board[row][col] = num++;

			for(int i = 0; i < 6; i++) //second for loop
				for (int row = 1 + i; row < 2 + i ; row++){
					for (int col = i; col < 3 + i; col++){
						board[row][col] = num ++;
				}
			} 
					//last for loop
			for(int row = MAXROW-1; row < MAXCOL;row++){
				for (int col = MAXCOL-2; col < MAXCOL;col++){
						board[row][col] = num++;
				}
			} 

			
		break;

		case 14: //complete

		for (int row = 0; row < MAXROW-7; row++){ //first for loop //prints 1
				for (int col = 1; col < MAXCOL - 6; col++)
			        board[row][col] = num++;
		}
			for(int i = 0; i < 6; i++){ //second for loop //prints rest of zig-zag pattern
				for (int row = 1 + i; row < 2 + i ; row++){
					for (int col = i; col < 3 + i; col++){
						board[row][col] = num ++;
				}
			}
		}
		 
					//last for loop
			for(int row = MAXROW-1; row < MAXCOL;row++){
				for (int col = MAXCOL-2; col < MAXCOL;col++){
					board[row][col] = num++;
				}
			}
			num = 21;
			for(int row = MAXROW-1; row >= 0; row--)
				board[row][row] = num++;
		break;

		case 15: 

			for(int row = 0; row < MAXROW; row++){
				board[row][row]= num++;
			}
			for (int row = 0; row < MAXROW-1; row++)
				board[row][row+1] = num++;
			break;
		
		case 16: 
			
			for(int row = 0; row < MAXROW; row++){
					board[row][row]= num++;
				}		
			 for(int i = 1; i < MAXCOL; i++){
				for(int row = 0; row < MAXROW - i ; row++)
						board[row][row+i] = num++;
			}
			break;

            default:
                System.out.println("This one hasn't been done yet.");
                break;
        }
    } // end of populateBoard()


    /**  Method to read in from the user which pattern to do next.  If the
     *  user enters an integer between 1 and MAXPATTERN this value is
     *  returned; if the user enters q it returns -1; if the user
     *  enters something else it returns the current pattern;
    */
    public int getPatternNumber()
    {
		int defaultPattern = 1;
		int newPattern = defaultPattern;

		System.out.print("Pattern number? (q to quit, [1," +  MAXPATTERN + "], otherwise it goes to " + defaultPattern + "): ");

		//read user input
		Scanner keyboard = new Scanner(System.in);
		String line = keyboard.nextLine();

		//if user did not enter RETURN
		if (line.length() != 0) {
		    // a temporary scanner just to read the line
		    Scanner lineReader = new Scanner(line);

		    //if an integer
		    if (lineReader.hasNextInt()) {
				newPattern= lineReader.nextInt();
				if (newPattern < 1 || newPattern > MAXPATTERN) {
//				    System.out.println("Pattern out of range; thus, it goes to " + defaultPattern);
				    newPattern = defaultPattern;
				}
		    } else { //not an integer
				if (line.charAt(0) == 'q') 
					newPattern = -1;
				//else newPattern = pattern;
		    }
		}
		//correctness check
		assert ((newPattern == -1)  || (newPattern >= 1 && newPattern <= MAXPATTERN)): "invalid pattern";
		return newPattern;
    } // end of getPatternNumber()



    public static void main(String args[])
    {
		System.out.println("\nWelcome to the dot pattern generator.\n");

        // OPEN THE TEXT AND DRAWING WINDOWS:
        GeneratePattern pattern = new GeneratePattern();

       	while (true){
       		int patternNumber = pattern.getPatternNumber();
       		if (patternNumber == -1)
       			break;
       		else {
				pattern.initializeBoard();
       			pattern.populateBoard(patternNumber);
       			pattern.printBoard();
       			System.out.println();
       		}
       	}

        //THAT'S IT. QUIT WHEN USER HITS RETURN
        System.out.println("Terminating Program. Good bye.\n");
        System.exit(1);

    }  // end of main()


} //end of class GeneratePattern
