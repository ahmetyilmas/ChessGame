/*
 * Oyun tahtasinda 64 Cell bulunacak ve bu 64 Cell X ve Y ekseninde Cell[][] dizisinide saklanacak.
 * */
public class Board {
    private Cell[][] cells;

    public Board(){
        this.resetBoard();
    }
    public Cell getCell(int x, int y){
        return this.cells[x][y];

    }

    public void resetBoard(){

        //  Siyah taslarin baslatilmasi
        cells[0][0] = new Cell(0, 0, new Rook(false));
        cells[0][1] = new Cell(0, 1, new Knight(false));
        cells[0][2] = new Cell(0, 2, new Bishop(false));
        cells[0][3] = new Cell(0, 3, new King(false));
        cells[0][4] = new Cell(0, 4, new Queen(false));
        cells[0][5] = new Cell(0, 5, new Bishop(false));
        cells[0][6] = new Cell(0, 6, new Knight(false));
        cells[0][7] = new Cell(0, 7, new Rook(false));

        cells[1][0] = new Cell(0, 0, new Pawn(false));
        cells[1][1] = new Cell(0, 0, new Pawn(false));
        cells[1][2] = new Cell(0, 0, new Pawn(false));
        cells[1][3] = new Cell(0, 0, new Pawn(false));
        cells[1][4] = new Cell(0, 0, new Pawn(false));
        cells[1][5] = new Cell(0, 0, new Pawn(false));
        cells[1][6] = new Cell(0, 0, new Pawn(false));
        cells[1][7] = new Cell(0, 0, new Pawn(false));


        //  Beyaz taslarin baslatilmasi.
        cells[6][0] = new Cell(6, 0, new Pawn(true));
        cells[6][1] = new Cell(6, 1, new Pawn(true));
        cells[6][2] = new Cell(6, 2, new Pawn(true));
        cells[6][3] = new Cell(6, 3, new Pawn(true));
        cells[6][4] = new Cell(6, 4, new Pawn(true));
        cells[6][5] = new Cell(6, 5, new Pawn(true));
        cells[6][6] = new Cell(6, 6, new Pawn(true));
        cells[6][7] = new Cell(6, 7, new Pawn(true));

        cells[7][0] = new Cell(7, 0, new Rook(true));
        cells[7][1] = new Cell(7, 1, new Knight(true));
        cells[7][2] = new Cell(7, 2, new Bishop(true));
        cells[7][3] = new Cell(7, 3, new King(true));
        cells[7][4] = new Cell(7, 4, new Queen(true));
        cells[7][5] = new Cell(7, 5, new Bishop(true));
        cells[7][6] = new Cell(7, 6, new Knight(true));
        cells[7][7] = new Cell(7, 7, new Rook(true));

        //  Kalan hucrelerin tas olmadan baslatilmasi
        for (int x = 2; x < 6; x++){
            for (int y = 0; y < 8; y++){
                cells[x][y] = new Cell(x, y, null);
            }
        }
    }
}