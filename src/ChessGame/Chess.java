package ChessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Chess extends JFrame {
    private static final String WHITE_Tile_KEY = "WhiteTile";
    private static final String BLACK_Tile_KEY = "BlackTile";
    private static final String WHITE_ROOK_KEY = "WhiteRook";
    private static final String BLACK_ROOK_KEY = "BlackRook";
    private static final String WHITE_BISHOP_KEY = "WhiteBishop";
    private static final String BLACK_BISHOP_KEY = "BlackBishop";
    private static final String WHITE_KNIGHT_KEY = "WhiteKnight";
    private static final String BLACK_KNIGHT_KEY = "BlackKnight";
    private static final String WHITE_KING_KEY = "WhiteKing";
    private static final String BLACK_KING_KEY = "BlackKing";
    private static final String WHITE_QUEEN_KEY = "WhiteQueen";
    private static final String BLACK_QUEEN_KEY = "BlackQueen";
    private static final String WHITE_PAWN_KEY = "WhitePawn";
    private static final String BLACK_PAWN_KEY = "BlackPawn";
    private final Board board = new Board(8, 8);
    private final Player whitePlayer;
    private final Player blackPlayer;
    private Player currentPlayer;

    public static void main(String[] var0) {
        Chess var1 = new Chess();
        var1.init();
        var1.centre();
        var1.setVisible(true);
    }

    public Chess() {
        super("ChessGame.Chess");
        this.whitePlayer = new Player(Color.RED);
        this.blackPlayer = new Player(Color.BLUE);
    }

    public static void access$000(Chess this$0, int i) {
    }

    private void init() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent var1) {
                Chess.this.shutdown(0);
            }
        });
        this.board.init(new MoveListener(this));
        this.initPieces();
        this.currentPlayer = this.whitePlayer;
        this.getContentPane().setLayout(new GridLayout(1, 1));
        this.getContentPane().add(this.board);
    }

    private void initPieces() {
        this.setPiece(0, 0, new Rook(this.whitePlayer));
        this.setPiece(0, 1, new Bishop(this.whitePlayer));
        this.setPiece(0, 2, new Knight(this.whitePlayer));
        this.setPiece(0, 3, new King(this.whitePlayer));
        this.setPiece(0, 4, new Queen(this.whitePlayer));
        this.setPiece(0, 5, new Knight(this.whitePlayer));
        this.setPiece(0, 6, new Bishop(this.whitePlayer));
        this.setPiece(0, 7, new Rook(this.whitePlayer));

        int var1;
        for(var1 = 0; var1 < this.board.getNumberOfCols(1); ++var1) {
            this.setPiece(1, var1, new Pawn(this.whitePlayer));
        }

        for(var1 = 0; var1 < this.board.getNumberOfCols(6); ++var1) {
            this.setPiece(6, var1, new Pawn(this.blackPlayer));
        }

        this.setPiece(7, 0, new Rook(this.blackPlayer));
        this.setPiece(7, 1, new Bishop(this.blackPlayer));
        this.setPiece(7, 2, new Knight(this.blackPlayer));
        this.setPiece(7, 3, new King(this.blackPlayer));
        this.setPiece(7, 4, new Queen(this.blackPlayer));
        this.setPiece(7, 5, new Knight(this.blackPlayer));
        this.setPiece(7, 6, new Bishop(this.blackPlayer));
        this.setPiece(7, 7, new Rook(this.blackPlayer));
    }

    private void setPiece(int var1, int var2, Piece var3) {
        this.board.getTileAt(var1, var2).setPiece(var3);
    }

    private void shutdown(int var1) {
        System.exit(var1);
    }

    private void centre() {
        Dimension var2 = Toolkit.getDefaultToolkit().getScreenSize();
        int var3 = (int)Math.min((double)var2.width * 0.75D, (double)var2.height * 0.75D);
        Rectangle var1 = new Rectangle();
        var1.width = var3;
        var1.height = var3;
        var1.x = (var2.width - var3) / 2;
        var1.y = (var2.height - var3) / 2;
        this.setBounds(var1);
    }

    public void move(Tile var1, Tile var2) {
        Piece var3 = var1.getPiece();
        var1.setPiece((Piece)null);
        var2.setPiece(var3);
        var1.repaint();
        var2.repaint();
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void switchPlayers() {
        if (this.currentPlayer == this.blackPlayer) {
            this.currentPlayer = this.whitePlayer;
        } else {
            this.currentPlayer = this.blackPlayer;
        }

    }
}

