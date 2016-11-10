/****************************************************
 * This program serves as a search shell for various games.
 * Main drives the process, calling the various searches
 * and games. 
 * @author Jackie Nobbe
 * @version 10 November 2016
 ****************************************************/

package main;

public class Main 
{
	public static void main(String[] args)
	{
		//Matrix of peg solitaire beginning and goal states
		int[][] originalBoard = {	
				{2, 2, 1, 1, 1, 2, 2},
				{2, 2, 1, 1, 1, 2, 2},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 0, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{2, 2, 1, 1, 1, 2, 2},
				{2, 2, 1, 1, 1, 2, 2}
		};

		int[][] goalState = {	
				{2, 2, 0, 0, 0, 2, 2},
				{2, 2, 0, 0, 0, 2, 2},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{2, 2, 0, 0, 0, 2, 2},
				{2, 2, 0, 0, 0, 2, 2}
		};
		
		// To see BFS finish in a reasonable amount of time, 
		// use this half played board.
		int[][] intermediateBoard = {	
				{2, 2, 0, 1, 1, 2, 2},
				{2, 2, 1, 1, 0, 2, 2},
				{1, 1, 0, 0, 0, 1, 0},
				{1, 0, 0, 1, 0, 1, 1},
				{0, 1, 0, 1, 0, 0, 1},
				{2, 2, 0, 0, 0, 2, 2},
				{2, 2, 0, 0, 0, 2, 2}
		};

		//Uncomment these two to search/solve a peg solitaire game
			//BoardState initialBoardState = new PegSolBoardState(originalBoard); 			
			//BoardState goalBoardState = new PegSolBoardState(goalState);

		//Use this for a half-solved peg solitaire game
			//BoardState initialBoardState = new PegSolBoardState(intermediateBoard, 0); 	

		//Uncomment to search/solve Missionaries and Cannibals
		BoardState initialBoardState = new MCBoardState(3, 3, 1, 0); 			
		BoardState goalBoardState = new MCBoardState(0, 0, 0, 0);

		//Depth First Search
		DepthFirstSearch dfs = new DepthFirstSearch();  
		dfs.find(initialBoardState, goalBoardState); 

		//Greedy Best First
		GreedyBestFirstSearch gbf = new GreedyBestFirstSearch(); 
		gbf.find(initialBoardState, goalBoardState); 

		//A* Search
		AStarSearch aStar = new AStarSearch(); 
		aStar.find(initialBoardState, goalBoardState);
		
		//Breadth FIrst Search
		BreadthFirstSearch bfs = new BreadthFirstSearch();  
		bfs.find(initialBoardState, goalBoardState); 
	}
}

