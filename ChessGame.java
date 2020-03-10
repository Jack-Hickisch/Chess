import java.lang.Math;
import java.awt.Color;

public class ChessGame {

    private Board board;
    private int height;
    private int length;

    public ChessGame() {
        this.board = new Board();
        this.height = 8;
        this.length = 8;
    }

    public ChessGame(int height, int length) {
        this.board = new Board(height, length);
        this.height = height;
        this.length = length;
    }

    public void placeRook(int rank, int file) {

        for (int r = 1; r <= height; r++)
        {
            board.getSquare(r, file).toggleHighlight();
        }
        for (int f = 1; f <= length; f++)
        {
            board.getSquare(rank, f).toggleHighlight();
        }
        // ♜
        board.getSquare(rank, file).setRook();
    }

    public void placeKnight(int rank, int file)
    {

        for (int r = 1; r <= height; r++) {
            for (int f = 1; f <= length; f++) {
                if ((Math.abs(rank - r) == 1 && Math.abs(file - f) == 2) || 
                    (Math.abs(rank - r) == 2 && Math.abs(file - f) == 1)) {
                    board.getSquare(r, f).toggleHighlight();
                }
            }
        }
        // ♘
        board.getSquare(rank, file).setKnight();
    }

    public void placeBishop(int rank, int file)
    {

        for (int r = 1; r <= height; r++) {
            for (int f = 1; f <= length; f++) {
                if (Math.abs(rank - r) == Math.abs(file - f) && !(file == f && rank == r))
                {
                    board.getSquare(r, f).toggleHighlight();
                }
            }
        }
        // ♗
        board.getSquare(rank, file).setBishop();
    }

    public void placeQueen(int rank, int file)
    {
        placeBishop(rank, file);
        placeRook(rank, file);
        // ♕
        board.getSquare(rank, file).setQueen();
    }

    public void findQueenInfluence()
    {
        placeQueen(3, 3);
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
        game.placeBishop(2, 6);
        System.out.println(game.makeBoard());

        System.out.println("");
        game.clearBoard();
        game.placeQueen(4, 7);
        System.out.println(game.makeBoard());
        
        // System.out.println("");
        // game.clearBoard();
        // game.findQueenInfluence();
        // System.out.println(game.makeBoard());

        System.out.println("");
        game.clearBoard();
        System.out.println(game.makeBoard());


        ChessGame game2 = new ChessGame(5, 11);
        System.out.println("");
        game2.clearBoard();
        game2.placeRook(3, 6);
        System.out.println(game2.makeBoard());

        System.out.println("");
        game2.clearBoard();
        game2.placeKnight(2, 7);
        System.out.println(game2.makeBoard());

        System.out.println("");
        game2.clearBoard();
        game2.placeBishop(3, 3);
        System.out.println(game2.makeBoard());

        System.out.println("");
        game2.clearBoard();
        game2.placeQueen(5, 11);
        System.out.println(game2.makeBoard());
        
    }
}


// steps for creating a new piece
// 1) write function in ChessGame
// 2) update square possibilities
// 3) update clear board
// 4) update make board