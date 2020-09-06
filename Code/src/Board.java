/**
*	@Name:	Peter Tso
*	@KUID:	2936825
*	@Email: tsopeter@ku.edu
*	@Brief:
*		The Board.java file handles the char[][] map object.
*		It allows to fill in the board with char board_marker
*		and allows to add to board, get from board, and get the
*		dimensions of the board.
*
*		It has two copy functions,
*			public char[][] getBoard() returns char[][] map
*			by referrence. Use this when you want to alter
*			the board.
*
*			public char[][] getCopy() returns char[][] map
*			by value. Use this when you want to view the board.
*	@Note:
*		There are no protections from OutOfBounds. Please
*		implement protections on your own code when using
*		Board.java.
*
*		Thank you.
*
*	@Date_Created:					09-05-2020
*/
public class Board{
	/*
		char[][] map is the 2D array
		that will be used to hold the map
	*/
	char[][] map;
	int xSize;
	int ySize;

	/*
		char board_marker holds the filler character to
		fill char[][] map
	*/
	char board_marker;

	/**
	*	@pre:	constructor
	*	@post:	creates a Board object
	*	@param: int, int, char
	*/
	public Board(int x, int y, char t_board_marker){
		/*
			initalize all values
		*/
		this.xSize = 0;
		this.ySize = 0;
		this.board_marker = '\0';

		/*
			set this object's dimensions to param
		*/
		this.xSize = x;
		this.ySize = y;

		/*
			set this object's board_marker to param
		*/
		this.board_marker = t_board_marker;

		/*
			create the map
			fill in with placeholder
			char board_marker
		*/
		this.map = new char[this.ySize][this.xSize];
		for(int i = 0; i < this.ySize; i++){
			for(int k = 0; k < this.xSize; k++){
				this.map[k][i] = this.board_marker;
			}
		}
	}

	/**
	*	@pre:	 must been constructed
	*	@post:	 pass by ref of char[][] map
	*	@return: char[][]
	*/
	public char[][] getBoard(){
		return this.map;
	}

	/**
	*	@pre:	 must been constructed
	*	@post:	 pass by val of char[][] map
	*	@return: char[][]
	*/
	public char[][] getCopyMap(){
		char[][] copy = new char[this.ySize][this.xSize];
		for(int i = 0; i < this.ySize; i++){
			for(int k = 0; k < this.xSize; k++){
				copy[k][i] = this.map[k][i];
			}
		}
		return copy;
	}
	/**
	*	@pre:	must be constructed
	*	@post: pass by val of Board copy
	*	@return: Board
	*/
	public Board getCopyBoard(){
		Board copy = new Board(this.xSize, this.ySize, this.board_marker);
		for(int i = 0; i < this.ySize; i++){
			for(int k = 0; k < this.xSize; k++){
				copy.addMarker(this.map[k][i], i, k);
			}
		}
		return copy;
	}

	/**
	*	@pre:	 must been constructed
	*	@post:	 returns the x-axis dimension
	*		 of board
	*	@return: int
	*/
	public int getXSize(){
		return this.xSize;
	}

	/**
	*	@pre:	 must been constructed
	*	@post:	 returns the y-axis dimension
	*		 of board
	*	@return: int
	*/
	public int getYSize(){
		return this.ySize;
	}

	/**
	*	@pre:	 must been constructed
	*	@post:	 adds char marker to char[y][x] map
	*	@return: NONE
	*/
	public void addMarker(char marker, int x, int y){
		this.map[y][x] = marker;
	}

	/**
	*	@pre:	 must been constructed
	*	@post:	 gets char marker from char[y][x] map
	*	@return: char
	*/
	public char getMarker(int x, int y){
		return this.map[y][x];
	}
}
