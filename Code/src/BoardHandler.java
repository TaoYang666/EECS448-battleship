public class BoardHandler implements BoardInterface{
  private int xNum;
  private int yNum;
  private int xOffset;
  private int yOffset;
  private int indexOffset;

  private int xBoard;
  private int yBoard;
  private Board ui;

  public BoardHandler(int t_xNum, int t_yNum, int t_xOffset, int t_yOffset, int t_indexOffset){
    this.xNum = t_xNum;
    this.yNum = t_yNum;

    this.xOffset = t_xOffset;
    this.yOffset = t_yOffset;
    this.indexOffset = t_indexOffset;
  }

  public void create(int x, int y, char t_board_marker){
    this.xBoard = x;
    this.yBoard = y;
    int xdimensions = this.xNum * (x + indexOffset);
    xdimensions = xdimensions + this.xOffset * (this.xNum + 1);

    int ydimensions = this.yNum * (y + indexOffset);
    ydimensions = ydimensions + this.yOffset * (this.yNum + 1);

    char marker = 183;
    ui = new Board(xdimensions, ydimensions, t_board_marker);
  }

  public void addBoard(Board g, int x, int y, boolean indexed){
    if(g.getXSize() != this.xBoard || g.getYSize() != this.yBoard){
        String msg = "BoardHandler::addBoard() :Board size does not fit\n";
        throw new RuntimeException(msg);
    }
      int xInput = 0;
      int yInput = 0;

      char x_ui = '0';
      char y_ui = 'A';

      xInput = this.xOffset + (x * (this.xOffset + g.getXSize())) + (x+1) * this.indexOffset;
      yInput = this.yOffset + (y * (this.yOffset + g.getYSize())) + (y+1) * this.indexOffset;
      for(int i = -1; i < g.getYSize(); i++){
        for(int k = -1; k < g.getXSize(); k++){
          if(i == -1 && indexed){
            ui.addMarker(x_ui, k + xInput, i + yInput);
            x_ui ++;
          }
          else if(k == -1 && indexed){
            ui.addMarker(y_ui, k + xInput, i + yInput);
            y_ui++;
          }
        }
      }

      xInput = this.xOffset + (x * (this.xOffset + g.getXSize())) + (x+1) * this.indexOffset;
      yInput = this.yOffset + (y * (this.yOffset + g.getYSize())) + (y+1) * this.indexOffset;
      for(int i = 0; i < g.getYSize(); i++){
        for(int k = 0; k < g.getXSize(); k++){
            ui.addMarker(g.getMarker(k, i), xInput + k, yInput + i);
        }
      }
  }

  public void addElement(char marker, int x, int y){
    this.ui.addMarker(marker, x, y);
  }

  public char getElement(int x, int y){
    return this.ui.getMarker(x, y);
  }

  public Board getCopyBoard(){
    char marker = 183;
    Board copy = new Board(ui.getXSize(), ui.getYSize(), marker);
    for(int i = 0; i < ui.getYSize(); i++){
      for(int k = 0; k < ui.getXSize(); k++){
        copy.addMarker(ui.getMarker(k, i), k, i);
      }
    }
    return copy;
  }
  
}
