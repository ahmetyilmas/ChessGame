public class Queen extends Piece {
    private String type = "Q";
    public Queen(boolean white) {
        super(white);
    }

    public String getType(){
        return this.type;
    }
    @Override
    public boolean canMove(Cell start, Cell destination, Board board) {

        // Hedef hücrede aynı renkte başka bir taş varsa
        if (start.getPiece().isWhite() && destination.getPiece() != null && destination.getPiece().isWhite()) {
            return false;
        }

        int diffX = Math.abs(destination.getX() - start.getX());
        int diffY = Math.abs(destination.getY() - start.getY());

        // yatay, dikey veya çapraz hareket edebilir
        if ((diffX == 0 && diffY > 0) || (diffX > 0 && diffY == 0) || (diffX == diffY)) {
            // dikey hareket
            if (diffX == 0) {
                int yDir = (destination.getY() - start.getY()) > 0 ? 1 : -1;
                int y = start.getY() + yDir;

                // yolda taş var mı
                while (y != destination.getY()) {
                    if (board.getCell(start.getX(), y).getPiece() != null) {
                        return false;
                    }
                    y += yDir;
                }
            }
            // yatay hareket
            else if (diffY == 0) {
                int xDir = (destination.getX() - start.getX()) > 0 ? 1 : -1;
                int x = start.getX() + xDir;

                // yolda taş var mı
                while (x != destination.getX()) {
                    if (board.getCell(x, start.getY()).getPiece() != null) {
                        return false;
                    }
                    x += xDir;
                }
            }
            // çapraz hareket
            else {
                int xDir = (destination.getX() - start.getX()) > 0 ? 1 : -1;
                int yDir = (destination.getY() - start.getY()) > 0 ? 1 : -1;
                int x = start.getX() + xDir;
                int y = start.getY() + yDir;

                //yolda taşi var mı
                while (x != destination.getX() && y != destination.getY()) {
                    if (board.getCell(x, y).getPiece() != null) {
                        return false;
                    }
                    x += xDir;
                    y += yDir;
                }
            }
        }
        return false;
    }
}