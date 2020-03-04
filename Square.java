import java.awt.Color;

public class Square {

    private int rank, file;
    private Color color = Color.BLACK;
    private boolean isHighlighted = false;
    private String piece = null;

    public Square(int rank, int file, Color color) {
        this.rank = rank;
        this.file = file;
        this.color = color;
    }

    public void toggleHighlight() {
        this.isHighlighted = !this.isHighlighted;
    }
    public boolean isHighlighted() {
        return this.isHighlighted;
    }

    public int getRank() { return this.rank; }
    public int getFile() { return this.file; }
    public Color getColor() { return this.color; }
    public void setRook() { this.color = (color == Color.BLACK) ? Color.RED : Color.PINK; }
    public void setKnight() { this.color = (color == Color.BLACK) ? Color.GREEN : Color.YELLOW; }
    public void setWhite() { this.color = Color.BLACK; }
    public void setBlack() { this.color = Color.WHITE; }

    public String getPiece() { return this.piece; }
    public void setPiece(String piece) {
        // piece is one of
        // ["p", "r", "b", "k", "q", ot "K"]
        this.piece = piece;
    }

}