package ChessGame;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private final Tile[][] Tiles;

    public Board(int var1, int var2) {
        this.Tiles = new Tile[var1][var2];
    }

    public void init(MoveListener var1) {
        this.setLayout(new GridLayout(this.Tiles.length, this.Tiles[0].length));

        for(int var2 = 0; var2 < this.Tiles.length; ++var2) {
            for(int var3 = 0; var3 < this.Tiles[var2].length; ++var3) {
                if ((var2 + var3) % 2 == 0) {
                    this.Tiles[var2][var3] = new Tile(var2, var3, Color.black);
                } else {
                    this.Tiles[var2][var3] = new Tile(var2, var3, Color.white);
                }

                this.add(this.Tiles[var2][var3]);
                this.Tiles[var2][var3].addMouseListener(var1);
            }
        }

    }

    public Tile getTileAt(int var1, int var2) {
        return this.Tiles[var1][var2];
    }

    public int getNumberOfRows() {
        return this.Tiles.length;
    }

    public int getNumberOfCols(int var1) {
        return this.Tiles[var1].length;
    }
}
