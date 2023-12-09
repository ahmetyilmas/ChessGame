public class Pawn extends Piece{
    private boolean moved = false;  //Eger hareket etmemis ise ilk hareketinde iki kare ilerleyebilme opsiyonu olmali
    public Pawn(boolean white){
        super(white);
    }
    public boolean hasMoved(){
        return this.moved;
    }
    public void setMoved(boolean moved){
        this.moved = moved;
    }


    //  Piyonun secili kareye hareket edip edemeyecegini kontrol eden fonksiyon.
    @Override
    public boolean canMove(Cell start, Cell destination, Board board) {

            //  Beyazsa ve hareket etmis ise 1 kare ilerleme durumu:
        if (hasMoved() && start.getPiece().isWhite() && (destination.getY() - start.getY() == 1) && destination.getX() == start.getX()){
            return destination.getPiece() == null;

            //  Siyahsa ve hareket etmis ise 1 kare ilerleme durumu:
        } else if (hasMoved() && !start.getPiece().isWhite() && (destination.getY() - start.getY() == -1) && start.getX() == destination.getX()) {
            return destination.getPiece() == null;

            //  Beyaz icin carprazindaki tasi yeme durumu:
        } else if (start.getPiece().isWhite() && Math.abs(destination.getX() - start.getX()) == 1 && destination.getY() - start.getY() == 1) {
            return !destination.getPiece().isWhite();

            //  Siyah icin carprazindaki tasi yeme durumu:
        }else if (!start.getPiece().isWhite() && Math.abs(destination.getX()) - start.getX() == 1 && destination.getY() - start.getY() == -1){
            return destination.getPiece().isWhite();

            //  Beyaz icin iki kare ilerleme durumu:
        }else if (!hasMoved() && start.getPiece().isWhite() && destination.getY() - start.getY() == 2 && destination.getX() == start.getX()){
            return board.getCell(start.getX(), start.getY() + 1).getPiece() == null && board.getCell(start.getX(), start.getY() + 2).getPiece() == null;

            //  Siyah icin iki kare ilerleme durumu:
        }else if (!hasMoved() && !start.getPiece().isWhite() && destination.getY() - start.getY() == -2 && destination.getX() == start.getX()){
            return board.getCell(start.getX(), start.getY() - 1).getPiece() == null && board.getCell(start.getX(), start.getY() - 2).getPiece() == null;

            //  Beyaz icin gecerken alma durumu:
        }else if (start.getPiece().isWhite() && (board.getCell(start.getX() + 1, start.getY()).getPiece() instanceof Pawn
                && !board.getCell(start.getX() + 1, start.getY()).getPiece().isWhite() ||
                board.getCell(start.getX() - 1 , start.getY()).getPiece() instanceof Pawn)
                && !board.getCell(start.getX() - 1 , start.getY()).getPiece().isWhite()){

            return Math.abs(destination.getX()) - start.getX() == 1 && destination.getY() - start.getY() == 1 && destination.getPiece() == null;

            //  Siyah icin gecerken alma durummu:
        }else if (!start.getPiece().isWhite() && (board.getCell(start.getX() + 1, start.getY()).getPiece() instanceof Pawn
                && board.getCell(start.getX() + 1, start.getY()).getPiece().isWhite() ||
                board.getCell(start.getX() - 1 , start.getY()).getPiece() instanceof Pawn)
                && board.getCell(start.getX() -1 , start.getY()).getPiece().isWhite()) {

            return Math.abs(destination.getX()) - start.getX() == 1 && destination.getY() - start.getY() == -1 && destination.getPiece() == null;

        }else {
            return false;
        }

    }
}