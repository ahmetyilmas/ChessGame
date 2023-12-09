public class King extends Piece{
    private boolean alive = true;
    private boolean castlingDone = false;   //  Eger sah hareket etmis ise oyuncu rok yapamamali.
    public King(boolean white){
        super(white);
    }


    public boolean hasCastlingDone(){
        return this.castlingDone;
    }
    public void setCastlingDone(boolean castlingDone){
        this.castlingDone = castlingDone;
    }

    //Hareket etmesi istenirse ancak rakip tas tarafindan yenme durumu olursa belirtilen noktaya hareket edememeli.
    //Daha sonra eklenecek.
    public boolean canMove(Cell start, Cell destination, Board board){

        //  Sah X ve Y ekseninde en fazla 1er kare ilerleyebilmeli.
        if (Math.abs(start.getX() - destination.getX()) <= 1 && Math.abs(start.getY() - destination.getY()) <= 1){

            //  Hareket edecek tasin gidecegi konumda ayni renk tas var ise o konuma gidememeli.
            if (start.getPiece().isWhite() && destination.getPiece().isWhite()){
                return false;
            }
            else{
                return true;
            }

            //  Sah beyaz ise rok yapma durumu.
        }else if(start.getPiece().isWhite() && !this.hasCastlingDone() && destination.getX() == 1 && destination.getY() == 7) {

            return isCastlingMove(start, destination, board);
        }else if(start.getPiece().isWhite() && !this.hasCastlingDone() && destination.getX() == 5 && destination.getY() == 7){

            return isCastlingMove(start, destination, board);


            //  Sah siyah ise rok yapma durumu.
        }else if (!start.getPiece().isWhite() && !this.hasCastlingDone() && destination.getX() == 1 && destination.getY() == 0){

            return isCastlingMove(start, destination, board);
        } else if (!start.getPiece().isWhite() && !this.hasCastlingDone() && destination.getX() == 5 && destination.getY() == 0) {

            return isCastlingMove(start, destination, board);
        }else
            return false;
    }


    //  Girilen parametrelere gore Sah'in yaptigi hareketin rok olup olmadigini kontrol eden fonksiyon.
    //  Tehdit altinda olma durumu daha sonra eklenecek.
    public boolean isCastlingMove(Cell start, Cell destination, Board board){
        if (start.getPiece().isWhite() && !this.hasCastlingDone() && destination.getX() == 1 && destination.getY() == 7){

            return board.getCell(2, 7).getPiece() == null && board.getCell(0, 7).getPiece() instanceof Rook
                    && !((Rook) board.getCell(0, 7).getPiece()).hasCastlingDone();

        } else if (start.getPiece().isWhite() && !this.hasCastlingDone() && destination.getX() == 5 && destination.getY() == 7) {

            return board.getCell(4, 7).getPiece() == null && board.getCell(5, 7).getPiece() == null &&
                    board.getCell(6, 7).getPiece() == null && board.getCell(7, 7).getPiece() instanceof Rook &&
                    !((Rook) board.getCell(7, 7).getPiece()).hasCastlingDone();

        } else if (!start.getPiece().isWhite() && !this.hasCastlingDone() && destination.getX() == 1 && destination.getY() == 0) {

            return board.getCell(2, 0).getPiece() == null && board.getCell(0, 0).getPiece() instanceof Rook
                    && !((Rook) board.getCell(0, 0).getPiece()).hasCastlingDone();

        }else if(!start.getPiece().isWhite() && !this.hasCastlingDone() && destination.getX() == 5 && destination.getY() == 0){

            return board.getCell(4, 0).getPiece() == null && board.getCell(5, 0).getPiece() == null &&
                    board.getCell(6, 0).getPiece() == null && board.getCell(7, 0).getPiece() instanceof Rook &&
                    !((Rook) board.getCell(7, 0).getPiece()).hasCastlingDone();

        }else
            return false;
    }
}