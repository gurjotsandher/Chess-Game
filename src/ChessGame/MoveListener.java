package ChessGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MoveListener extends MouseAdapter {
    private final Chess game;
    private Tile startTile;

    public MoveListener(Chess var1) {
        this.game = var1;
    }

    public void mouseClicked(MouseEvent var1) {
        Tile var2 = (Tile)var1.getSource();
        Piece var3;
        if (this.startTile == null) {
            var3 = var2.getPiece();
            if (var3 != null && var3.getOwner() == this.game.getCurrentPlayer()) {
                this.startTile = var2;
                this.startTile.setActive(true);
                this.startTile.repaint();
            }
        } else {
            var3 = var2.getPiece();
            Piece var4 = this.startTile.getPiece();
            if (var3 != null && var4.getOwner() == var3.getOwner()) {
                this.startTile.setActive(false);
                this.startTile.repaint();
                this.startTile = var2;
                this.startTile.setActive(true);
                this.startTile.repaint();
            } else if (var4.isValidMove(var2, this.game.getBoard())) {
                this.game.move(this.startTile, var2);
                this.startTile.setActive(false);
                this.startTile.repaint();
                this.startTile = null;
                this.game.switchPlayers();
            }
        }

    }
}
