import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinGame extends JFrame implements ActionListener {
    final private int WIN_WIDTH = 500;
    final private int WIN_HEIGHT = 500;
    final private int WIN_POS_X = 600;
    final private int WIN_POS_Y = 400;

    private WinSettings winSettings = new WinSettings(this);
    private PnlMap pnlMap = new PnlMap();

    public WinGame() {
        super("Игра \"Крестики-Нолики\"");

        setSize(WIN_WIDTH, WIN_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setLocation(WIN_POS_X, WIN_POS_Y);

        JPanel pnlControl = new JPanel();

        JButton btnStart = new JButton("Играть");
        btnStart.setActionCommand("Start");
        btnStart.addActionListener(this);

        JButton btnExit = new JButton("Выйти");
        btnExit.setActionCommand("Exit");
        btnExit.addActionListener(this);

        pnlControl.setLayout(new GridLayout());
        pnlControl.add(btnStart);
        pnlControl.add(btnExit);

        add(pnlControl, BorderLayout.SOUTH);
        add(pnlMap, BorderLayout.CENTER);

        setVisible(true);
    }
    public void startGame(int mode, int cntX, int cntY, int cntWinPos) {           // метод будет дописан после Урок 8
        pnlMap.set(cntX, cntY);
    }
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Start":
                winSettings.openWin();
                break;
            case "Exit":
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
