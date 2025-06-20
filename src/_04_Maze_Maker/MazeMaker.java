
package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

    private static int rows;
    private static int cols;

    private static Maze maze;

    private static Random randGen = new Random();
    private static Stack<Cell> uncheckedCells = new Stack<Cell>();

    public static Maze generateMaze(int r, int c) {
        rows = r;
        cols = c;
        maze = new Maze(rows, cols);

        // 1. Pick a random cell along the border and remove its exterior wall.
        //    This will be the starting point. Then select a random cell along
        //    the opposite wall and remove its exterior wall. This will be the
        //    finish line.
        int rar = randGen.nextInt(c-1);
        removeWalls(maze.getCell(0, rar), maze.getCell(0, rar+1));
        removeWalls(maze.getCell(r-1, rar), maze.getCell(r-1, rar+1));
        // 2. select a random cell in the maze to start 
        Cell n = maze.getCell(randGen.nextInt(r), rar);
        // 3. call the selectNextPath method with the randomly selected cell
        selectNextPath(n);
        return maze;
    }

    // 4. Complete the selectNextPathMethod
    private static void selectNextPath(Cell currentCell ) {
    	
        // A. SET currentCell as visited
    	ArrayList<Cell> visited = new ArrayList<Cell>();
    	currentCell.setBeenVisited(true);
    	System.out.println(currentCell.getCol()+" "+currentCell.getRow());
        // B. check for unvisited neighbors using the cell
    	Cell cell = maze.getCell(currentCell.getRow()+1, currentCell.getCol());
       			if(  cell != null && cell.hasBeenVisited() == false ){
        				System.out.println("has yet to be visited and to the left of current cell");
        				visited.add(cell);
        			}
       		Cell cell1 =	maze.getCell(currentCell.getRow()-1, currentCell.getCol());
        		if(  cell1 != null && cell1.hasBeenVisited() == false ){
        				System.out.println("has yet to be visited and to the right of current cell");
        				visited.add(cell1);
        			}
        		Cell 	cell2 =	maze.getCell(currentCell.getRow(), currentCell.getCol()+1);
        		if( cell2 != null && cell2.hasBeenVisited() == false ){
        				System.out.println("has yet to be visited and to the under of current cell");
        				visited.add(cell2);
        			}
        		Cell  cell3 =		maze.getCell(currentCell.getRow(), currentCell.getCol()-1);
        		if(  cell3 != null && cell3.hasBeenVisited() == false ){
        				System.out.println("has yet to be visited and to the top of current cell");
        				visited.add(cell3);
        			}
    	
        		if(visited.size() > 0) {
        // C. if has unvisited neighbors,
        		
        		int st = randGen.nextInt(visited.size());
        		
        // C1. select one at random. 
        		Cell ste = uncheckedCells.push(visited.get(st));
        		System.out.println(ste.getRow()+" "+ste.getCol());
        		 removeWalls(ste, currentCell);
        		 ste.setBeenVisited(true);
        		 selectNextPath( ste );
        		}
        // C2. push it to the stack

        // C3. remove the wall between the two cells

        // C4. make the new cell the current cell and SET it as visited

        // C5. call the selectNextPath method with the current cell


        // D. if all neighbors are visited
        		if( visited.size() == 0 ) {
        			if( uncheckedCells.size() > 0 ) {
        			selectNextPath(	uncheckedCells.pop() );
        			}
        		}
        // D1. if the stack is not empty

        // D1a. pop a cell from the stack

        // D1b. make that the current cell

        // D1c. call the selectNextPath method with the current cell

    }

    // This method will check if c1 and c2 are adjacent.
    // If they are, the walls between them are removed.
    private static void removeWalls(Cell c1, Cell c2) {
    	if( c1 != null && c2 != null ) {
        if (c1.getRow() == c2.getRow() ) {
            if (c1.getCol() > c2.getCol()) {
                c1.setWestWall(false);
                c2.setEastWall(false);
            } else {
                c1.setEastWall(false);
                c2.setWestWall(false);
            }
        } else {
            if (c1.getRow() > c2.getRow()) {
                c1.setNorthWall(false);
                c2.setSouthWall(false);
            } else {
                c1.setSouthWall(false);
                c2.setNorthWall(false);
            }
        }
    	}
    }

    // This method returns a list of all the neighbors around the specified
    // cell that have not been visited. There are up to 4 neighbors per cell.
    //          1
    //       2 cell 3
    //          4
    private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
        int row = c.getRow();
        int col = c.getCol();

        ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();

        if (row > 0 && !maze.getCell(row - 1, col).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row - 1, col));
        }

        if (col > 0 && !maze.getCell(row, col - 1).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row, col - 1));
        }

        if (row < rows - 1 && !maze.getCell(row + 1, col).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row + 1, col));
        }

        if (col < cols - 1 && !maze.getCell(row, col + 1).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row, col + 1));
        }

        return unvisitedNeighbors;
    }
}
