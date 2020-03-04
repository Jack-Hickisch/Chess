import java.awt.Color;

public class Board {

    private Square[][] squares;

    /**
     * constructor
     */
    public Board() {
        squares = new Square[8][8];

        for (int row = 0; row < squares.length; row++) {
            boolean isBlack = false;
            if (row % 2 == 0) {
                isBlack = true;
            }
            for (int col = 0; col < squares[row].length; col++) {
                int rank = squares.length - row;
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
        for (int rank = 1; rank <= 8; rank++) {
            for (int file = 1; file <= 8; file++) {
                if (getSquare(rank, file).isHighlighted()) {
                    getSquare(rank, file).toggleHighlight();
                }
                if (getSquare(rank, file).getColor() == Color.RED || getSquare(rank, file).getColor() == Color.GREEN)
                {
                    getSquare(rank, file).setWhite();
                }
                if (getSquare(rank, file).getColor() == Color.PINK || getSquare(rank, file).getColor() == Color.YELLOW)
                {
                    getSquare(rank, file).setBlack();
                }
            }
        }
    }

    public Square getSquare(int rank, int file)
    {
        int realRank = 8 - rank;
        int realFile = file - 1;
        
        return squares[realRank][realFile];
    }

    public int makeBoard()
    {
        int influence = 0;
        for (int rank = 8; rank > 0; rank--)
        {
            for (int file = 1; file <= 8; file++)
            {
                // ■ = black
                // □ = white
                // ▩ = highlighted square
                
                if (file != 8)
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
                }
            }
        }
        return influence;
    }
}