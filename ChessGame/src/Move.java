public class Move {
    private Cell start;
    private Cell destination;
    private Piece movingPiece;
    private Player player;
    public Move(Cell start, Cell destination, Player player){
        this.start = start;
        this.destination = destination;
        this.player = player;
        this.movingPiece = start.getPiece();
    }
    public Cell getStart(){
        return this.start;
    }
    public Cell getDestination(){
        return this.destination;
    }
}
