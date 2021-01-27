package ChessGame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Chess$1 extends WindowAdapter {
    private final Chess this$0;

    Chess$1(Chess var1) {
        this.this$0 = var1;
    }

    public void windowClosing(WindowEvent var1) {
        Chess.access$000(this.this$0, 0);
    }
}
