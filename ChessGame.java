import java.lang.Math;
import java.awt.Color;

public class ChessGame {

    private Board board;

    public ChessGame() {
        this.board = new Board();
    }

    public void placeRook(int rank, int file) {
        board.clearBoard();

        // for (int r = 1; r <= 8; r++) {
        //     for (int f = 1; f <= 8; f++) {
        //         if ((r == rank || f == file) && !(r == rank && f == file)) {
        //             board.getSquare(r, f).toggleHighlight();
        //         }
        //     }
        // }

        for (int r = 1; r <= 8; r++)
        {
            board.getSquare(r, file).toggleHighlight();
        }
        for (int f = 1; f <= 8; f++)
        {
            board.getSquare(rank, f).toggleHighlight();
        }
        // ♜
        board.getSquare(rank, file).setRook();
    }

    public void placeKnight(int rank, int file)
    {
        board.clearBoard();

        for (int r = 1; r <= 8; r++) {
            for (int f = 1; f <= 8; f++) {
                if ((Math.abs(rank - r) == 1 && Math.abs(file - f) == 2) || 
                    (Math.abs(rank - r) == 2 && Math.abs(file - f) == 1)) {
                    board.getSquare(r, f).toggleHighlight();
                }
            }
        }
        // ♘
        board.getSquare(rank, file).setKnight();
    }

    public int makeBoard()
    {
        return board.makeBoard();
    }

    public void clearBoard()
    {
        board.clearBoard();
    }

    public static void main(String[] args)
    {
        ChessGame game = new ChessGame();
        System.out.println(game.makeBoard());
        System.out.println("");
        game.placeRook(1, 1);
        System.out.println(game.makeBoard());

        System.out.println("");
        game.clearBoard();
        game.placeKnight(8, 8);
        System.out.println(game.makeBoard());

        System.out.println("");
        game.clearBoard();
        System.out.println(game.makeBoard());
    }
}


// steps for creating a new piece
// 1) write function in ChessGame
// 2) update square possibilities
// 3) update clear board
// 4) update make board