package ChessGame;

public abstract class Piece {
    private final String image;
    protected final Player owner;
    protected Tile Tile;

    protected Piece(Player var1, String var2) {
        this.owner = var1;
        this.image = var2;
    }

    public String getImage() {
        return this.image;
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setTile(Tile var1) {
        this.Tile = var1;
    }

    public Tile getTile() {
        return this.Tile;
    }

    public abstract boolean isValidMove(Tile var1, Board var2);

    public abstract void Tile(Tile tile);
}
