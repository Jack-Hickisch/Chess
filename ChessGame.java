import java.lang.Math;
import java.awt.Color;

public class ChessGame {

    private Board board;

    public ChessGame() {
        this.board = new Board();
    }

    public ChessGame(int height, int length) {
        this.board = new Board(height, length);
    }

    public void placeRook(int rank, int file) {

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

    public void placeBishop(int rank, int file)
    {

        for (int r = 1; r <= 8; r++) {
            for (int f = 1; f <= 8; f++) {
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

    // public void findQueenInfluence()
    // {
    //     int[] ranks = new int[64];
    //     int[] files = new int[64];
    //     int maxInfluence = 0;
    //     int numWithInfluence = 0;

    //     for (int rank = 1; rank <= 8; rank++)
    //     {
    //         for (int file = 1; file <= 8; file++)
    //         {
    //             placeQueen(rank, file);
    //             maxInfluence = (makeBoard() > maxInfluence) ? makeBoard() : maxInfluence;
    //             board.clearBoardKeepQueen();
    //         }
    //     }

    //     board.clearBoard();
    //     System.out.println("-----------------------------------------");

    //     for (int rank = 1; rank <= 8; rank++)
    //     {
    //         for (int file = 1; file <= 8; file++)
    //         {
    //             placeQueen(rank, file);
    //             if (makeBoard() == maxInfluence)
    //             {
    //                 board.getSquare(rank, file).setQueen();
    //                 board.clearBoardKeepQueen();
    //             }
    //         }
    //     }

    //     board.makeBoard();

    //     // for (int rank = 1; rank <= 8; rank++)
    //     // {
    //     //     for (int file = 1; file <= 8; file++)
    //     //     {
    //     //         placeQueen(rank, file);
    //     //         if (makeBoard() > maxInfluence)
    //     //         {
    //     //             maxInfluence = makeBoard();
    //     //             numWithInfluence = 0;
    //     //             for (int num : ranks)
    //     //             {
    //     //                 num = 0;
    //     //             }
    //     //             for (int num : files)
    //     //             {
    //     //                 num = 0;
    //     //             }
    //     //             rank = 1;
    //     //             file = 1;
    //     //             ranks[0] = rank;
    //     //             files[0] = file;
    //     //             board.clearBoard();
    //     //         }
    //     //         else if (makeBoard() == maxInfluence)
    //     //         {
    //     //             numWithInfluence++;
    //     //             ranks[numWithInfluence] = rank;
    //     //             files[numWithInfluence] = file;
    //     //             board.clearBoard();
    //     //         }
    //     //         board.clearBoard();
    //     //     }
    //     // }

    //     // board.clearBoard();

    //     // for (int i = 0; i < 64; i++)
    //     // {
    //     //     if (ranks[i] != 0)
    //     //     {
    //     //         board.getSquare(ranks[i], files[i]).setQueen();
    //     //     }
    //     // }
    // }

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


        ChessGame game2 = new ChessGame(6, 6);
        game2.makeBoard();
    }
}


// steps for creating a new piece
// 1) write function in ChessGame
// 2) update square possibilities
// 3) update clear board
// 4) update make board