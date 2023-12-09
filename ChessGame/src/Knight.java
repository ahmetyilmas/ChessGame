public class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Cell start, Cell destination, Board board) {

        // Hedef hücrede aynı renkte başka bir taş varsa
        if (start.getPiece().isWhite() == destination.getPiece().isWhite()) {
            return false;
        }

        // L şeklindeki hareketi kontrol eder
        if ((Math.abs(destination.getX() - start.getX()) == 1 && Math.abs(destination.getY() - start.getY()) == 2)
                || (Math.abs(destination.getX() - start.getX()) == 2 && Math.abs(destination.getY() - start.getY()) == 1)) {
            return true;
        }else
            return false;
}
}