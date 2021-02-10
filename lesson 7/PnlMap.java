import javax.swing.*;
import java.awt.*;

public class PnlMap extends JPanel {
    public PnlMap() {
        super();

        setBackground(Color.LIGHT_GRAY);
    }
    public void set(int cntX, int cntY) {
        removeAll();
        setLayout(new GridLayout(cntX, cntY));
        for (int y = 0; y < cntY; y++)
            for (int x = 0; x < cntX; x++)
                add(new JButton());
        updateUI();
    }
}
