import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinSettings extends JFrame implements ActionListener {
    final private int WIN_WIDTH = 300;
    final private int WIN_HEIGHT = 300;

    final private int MAP_SIZE_MIN = 3;
    final private int MAP_SIZE_MAX = 10;
    final private int POS_CNT_MIN = 3;

    final private int MODE_HUM_VS_COMP = 0;
    final private int MODE_HUM_VS_HUM = 1;

    final private String TXT_VAL = "значение: ";

    private WinGame winGame;

    private JRadioButton btnHumVsHum;
    private JRadioButton btnHumVsComp;

    private JSlider sldMapSize;
    private JSlider sldPosCnt;

    private int mode = MODE_HUM_VS_COMP;
    private int sizeMap = MAP_SIZE_MIN;
    private int cntPos = POS_CNT_MIN;

    public WinSettings(WinGame winGame) {
        super("Параметры игры");

        this.winGame = winGame;

        setSize(WIN_WIDTH, WIN_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new GridLayout(10,1));

        addModeControl();
        addMapControl();

        JButton btn = new JButton("Ok");
        btn.setActionCommand("Ok");
        btn.addActionListener(this);

        add(btn);
    }
    private void addModeControl() {
        JLabel lbl = new JLabel("Режим игры:");
        btnHumVsHum = new JRadioButton("Игрок против Игрока");
        btnHumVsComp = new JRadioButton("Игрок против Компьютера", true);

        ButtonGroup btnGrp = new ButtonGroup();
        btnGrp.add(btnHumVsHum);
        btnGrp.add(btnHumVsComp);

        add(lbl);
        add(btnHumVsComp);
        add(btnHumVsHum);
    }
    private void addMapControl() {
        JLabel lblMapSize = new JLabel(TXT_VAL + MAP_SIZE_MIN);
        sldMapSize = new JSlider(MAP_SIZE_MIN, MAP_SIZE_MAX, MAP_SIZE_MIN);

        sldMapSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sizeMap = sldMapSize.getValue();
                lblMapSize.setText(TXT_VAL + sizeMap);
                sldPosCnt.setMaximum(sizeMap);
            }
        });

        add(new JLabel("Размер поля:"));
        add(lblMapSize);
        add(sldMapSize);

        JLabel lblPosCnt = new JLabel(TXT_VAL + MAP_SIZE_MIN);
        sldPosCnt = new JSlider(POS_CNT_MIN, MAP_SIZE_MIN, POS_CNT_MIN);

        sldPosCnt.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                cntPos = sldPosCnt.getValue();
                lblPosCnt.setText(TXT_VAL + cntPos);
            }
        });

        add(new JLabel("Длина выйгрышной позиции:"));
        add(lblPosCnt);
        add(sldPosCnt);
    }
    public void openWin() {
        int posWinX;
        int posWinY;

        Rectangle rectangle = winGame.getBounds();

        posWinX = (int) rectangle.getCenterX() - (WIN_WIDTH / 2);
        posWinY = (int) rectangle.getCenterY() - (WIN_HEIGHT / 2);

        setLocation(posWinX, posWinY);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Ok":
                if (btnHumVsComp.isSelected())
                    mode = MODE_HUM_VS_COMP;
                else if (btnHumVsHum.isSelected())
                    mode = MODE_HUM_VS_HUM;
                else
                    throw new RuntimeException("Не известный режим игры!");

                winGame.startGame(mode, sizeMap, sizeMap, cntPos);
                setVisible(false);

                break;
            default:
                break;
        }
    }
}
