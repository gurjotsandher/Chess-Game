package ChessGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Tile extends Canvas {
    private final int row;
    private final int col;
    private Piece piece;
    private boolean isActive;

    public Tile(int var1, int var2, Color var3) {
        this.row = var1;
        this.col = var2;
        this.setBackground(var3);
    }

    public void setActive(boolean var1) {
        this.isActive = var1;
    }

    public void paint(Graphics var1) {
        super.paint(var1);
        if (this.piece != null) {
            Font var2 = var1.getFont();
            var2 = var2.deriveFont(1, 28.0F);
            var1.setFont(var2);
            var1.setColor(this.piece.getOwner().colour);
            var1.drawString(this.piece.getImage(), this.getWidth() / 2, this.getHeight() / 2);
        }

    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setPiece(Piece var1) {
        if (this.piece != null) {
            this.piece.Tile((Tile)null);
        }

        this.piece = var1;
        if (this.piece != null) {
            this.piece.setTile(this);
        }

    }

    public Piece getPiece() {
        return this.piece;
    }
}
