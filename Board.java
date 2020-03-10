import java.awt.Color;

public class Board {

    private Square[][] squares;

    /**
     * constructor
     */
    public Board() {
        squares = new Square[8][8];

        for (int row = 0; row < squares[0].length; row++) {
            boolean isBlack = false;
            if (row % 2 == 0) {
                isBlack = true;
            }
            for (int col = 0; col < squares[row].length; col++) {
                int rank = squares[0].length - row;
                int file = col + 1;
                Color color = Color.WHITE;
                if (isBlack) {
                    color = Color.BLACK;
                }

                squares[row][col] = new Square(rank, file, color);
                isBlack = !isBlack;
            }
        }
    }

    public Board(int height, int length) {
        squares = new Square[height][length];

        for (int row = 0; row < squares.length; row++) {
            boolean isBlack = false;
            if (row % 2 == 0) {
                isBlack = true;
            }
            for (int col = 0; col < squares[row].length; col++) {
                int rank = squares[0].length - row;
                int file = col + 1;
                Color color = Color.WHITE;
                if (isBlack) {
                    color = Color.BLACK;
                }

                squares[row][col] = new Square(rank, file, color);
                isBlack = !isBlack;
            }
        }
    }

    public void clearBoard()
    {
        for (int rank = 1; rank <= squares.length; rank++) {
            for (int file = 1; file <= squares[0].length; file++) {
                if (getSquare(rank, file).isHighlighted()) {
                    getSquare(rank, file).toggleHighlight();
                }
                if (getSquare(rank, file).getColor() == Color.RED || getSquare(rank, file).getColor() == Color.GREEN || getSquare(rank, file).getColor() == Color.ORANGE || getSquare(rank, file).getColor() == Color.GRAY)
                {
                    getSquare(rank, file).setWhite();
                }
                if (getSquare(rank, file).getColor() == Color.PINK || getSquare(rank, file).getColor() == Color.YELLOW || getSquare(rank, file).getColor() == Color.BLUE || getSquare(rank, file).getColor() == Color.MAGENTA)
                {
                    getSquare(rank, file).setBlack();
                }
            }
        }
    }

    public void clearBoardKeepQueen()
    {
        for (int rank = 1; rank <= squares.length; rank++) {
            for (int file = 1; file <= squares[0].length; file++) {
                if (getSquare(rank, file).isHighlighted()) {
                    getSquare(rank, file).toggleHighlight();
                }
            }
        }
    }

    public Square getSquare(int rank, int file)
    {
        int realRank = squares.length - rank;
        int realFile = file - 1;
        
        return squares[realRank][realFile];
    }

    public int makeBoard()
    {
        int influence = 0;
        for (int rank = squares.length; rank > 0; rank--)
        {
            for (int file = 1; file <= squares[0].length; file++)
            {
                // ■ = black
                // □ = white
                // ▩ = highlighted square
                
                if (file != squares[0].length)
                {
                    if (getSquare(rank, file).isHighlighted())
                    {
                        System.out.print("* ");
                        influence++;
                    }
                    else if (getSquare(rank, file).getColor() == Color.WHITE)
                    {
                        System.out.print("□ ");
                    }
                    else if (getSquare(rank, file).getColor() == Color.BLACK)
                    {
                        System.out.print("■ ");
                    }
                    else if (getSquare(rank, file).getColor() == Color.RED || getSquare(rank, file).getColor() == Color.PINK)
                    {
                        System.out.print("♜ ");
                    }
                    else if (getSquare(rank, file).getColor() == Color.GREEN || getSquare(rank, file).getColor() == Color.YELLOW)
                    {
                        System.out.print("♘ ");
                    }
                    else if (getSquare(rank, file).getColor() == Color.ORANGE || getSquare(rank, file).getColor() == Color.BLUE)
                    {
                        System.out.print("♗ ");
                    }
                    else if (getSquare(rank, file).getColor() == Color.GRAY || getSquare(rank, file).getColor() == Color.MAGENTA)
                    {
                        System.out.print("♕ ");
                    }
                }
                else
                {
                    if (getSquare(rank, file).isHighlighted())
                    {
                        System.out.println("* ");
                        influence++;
                    }
                    else if (getSquare(rank, file).getColor() == Color.WHITE)
                    {
                        System.out.println("□ ");
                    }
                    else if (getSquare(rank, file).getColor() == Color.BLACK)
                    {
                        System.out.println("■ ");
                    }
                    else if (getSquare(rank, file).getColor() == Color.RED || getSquare(rank, file).getColor() == Color.PINK)
                    {
                        System.out.println("♜ ");
                    }
                    else if (getSquare(rank, file).getColor() == Color.GREEN || getSquare(rank, file).getColor() == Color.YELLOW)
                    {
                        System.out.println("♘ ");
                    }
                    else if (getSquare(rank, file).getColor() == Color.ORANGE || getSquare(rank, file).getColor() == Color.BLUE)
                    {
                        System.out.println("♗ ");
                    }
                    else if (getSquare(rank, file).getColor() == Color.GRAY || getSquare(rank, file).getColor() == Color.MAGENTA)
                    {
                        System.out.println("♕ ");
                    }
                }
            }
        }
        return influence;
    }

    public int findInfluence()
    {
        int influence = 0;
        for (int rank = squares.length; rank > 0; rank--)
        {
            for (int file = 1; file <= squares[0].length; file++)
            {
                if (getSquare(rank, file).isHighlighted())
                {
                    influence++;
                }
            }
        }
        return influence;
    }
}