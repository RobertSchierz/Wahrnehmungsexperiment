import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by Jan on 05.06.2016.
 */
public class Gui extends javax.swing.JFrame {


    private JButton[] jButton;
    JPanel mainPanel = new JPanel();
    JLabel testName = new JLabel();
    JLabel testpresantationTimer = new JLabel("0");
    private JButton nextTest = new JButton("Weiter");
    Integer[] testArray;
    Color[] colorArray;
    private float timervalue;
    private boolean stoptimer = false;
    private int wayFaults = 0;
    private int colorFaults = 0;
    public int zae = 0;
    public boolean success = false;
    public boolean withColor = false;
    public int presentationTimer = 0;
    public long id = 0;

    public Gui() {


        // Setze Fenster in die Mitte
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        this.setMinimumSize(new Dimension((int) dimension.getWidth() / 2, (int) dimension.getHeight() / 2));
        this.setResizable(false);
        this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        int x = (int) (((dimension.getWidth() - this.getWidth()) / 2));
        int y = (int) (((dimension.getHeight() - this.getHeight()) / 2));
        this.setLocation(x, y);


        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Wahrnehmungstheorie");


        mainPanel.setLayout(new BorderLayout());
        mainPanel.setSize(this.getWidth(), this.getHeight());
        this.testName.setFont(new Font(Font.MONOSPACED, 0, 40));
        this.testpresantationTimer.setFont(new Font(Font.MONOSPACED, 0, 40));
        this.nextTest.setFont(new Font(Font.MONOSPACED, 0, 30));
        this.nextTest.setFocusPainted(false);
        this.nextTest.setBorder(new LineBorder(Color.BLACK));


        this.add(mainPanel);


    }

    public void setGridPanel(int row, int col, Integer[] wayarray, Color[] colors, long id) {
        if (colors.length == 0) {
            this.withColor = false;
        } else if (colors.length > 0) {
            this.withColor = true;
        }

        this.testArray = wayarray;
        this.colorArray = colors;
        this.id = id;
        jButton = new JButton[row * col];
        frameButtonListener FrameButtonListener = new frameButtonListener();

        JPanel jPanel1 = new JPanel();
        jPanel1.setPreferredSize(new Dimension(mainPanel.getWidth() - 220, mainPanel.getHeight()));
        jPanel1.setLayout((new java.awt.GridLayout(row, col)));

        ArrayList wayarraylist = new ArrayList<Integer>(Arrays.asList(wayarray));

        for (int i = 0; i < row * col; i++) {

            jButton[i] = new javax.swing.JButton();
            jButton[i].setPreferredSize(new Dimension(100, 100));
            jButton[i].setEnabled(false);

            if (wayarraylist.contains(i)) {
                if (!this.withColor) {
                    jButton[i].setBackground(Color.red);
                }


            } else {
                jButton[i].setBackground(Color.black);
            }

            jButton[i].addActionListener(FrameButtonListener);
            jPanel1.add(jButton[i]);
        }
        if (this.withColor) {
            for (int i = 0; i < wayarray.length; i++){
                jButton[wayarray[i]].setBackground(colors[i]);
            }

        }


        mainPanel.add(jPanel1, BorderLayout.WEST);
        jPanel1.setVisible(true);
    }

    public void removeTest() {
        BorderLayout layout = (BorderLayout) mainPanel.getLayout();
        mainPanel.remove(layout.getLayoutComponent(BorderLayout.WEST));
    }

    public void setTestpanel() {
        nextTest next = new nextTest();
        JPanel jPanel2 = new JPanel();
        jPanel2.setPreferredSize(new Dimension(200, mainPanel.getHeight()));
        jPanel2.setLayout((new GridBagLayout()));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 5;
        c.anchor = GridBagConstraints.NORTH;
        jPanel2.add(testName, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        jPanel2.add(testpresantationTimer, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        nextTest.addActionListener(next);
        jPanel2.add(nextTest, c);


        mainPanel.add(jPanel2, BorderLayout.EAST);
        jPanel2.setVisible(true);
    }

    public void startTestTimer() {
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {

                        if (stoptimer) {
                            timer.cancel();
                        }
                        timervalue += 0.1;
                    }
                },
                0, 100
        );

    }

    public void setTimerForPresentation(int presentationTimer) {
        this.presentationTimer = presentationTimer-1;
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(
                new java.util.TimerTask() {
                    int i = 0;
                    @Override
                    public void run() {
                        nextTest.setEnabled(false);
                        testpresantationTimer.setText(Integer.toString(i++));
                        if (i == presentationTimer) {
                            timer.cancel();
                            for (int i = 0; i < jButton.length; i++) {
                                jButton[i].setBackground(Color.black);
                                jButton[i].setEnabled(true);
                                nextTest.setEnabled(true);
                                testpresantationTimer.setVisible(false);
                            }
                            startTestTimer();
                        }
                    }
                },
                0, 1000
        );
    }

    public void writeTestData() {
        String testDeclaration = "";
        String colorFaultsText = "";
        if (this.withColor) {
            testDeclaration = " (Mit Farbvariation)";
            colorFaultsText = "Farbfehler im richtigem Pfad: " + colorFaults;
        } else if (!this.withColor) {
            testDeclaration = " (Ohne Farbvariation)";
            colorFaultsText = "Keine Farbfehler möglich!";

        }



        java.util.List<String> lines = Arrays.asList("ID: " + this.id, this.testName.getText() + testDeclaration, "Testvorbereitungszeit: " + this.presentationTimer, "Zeit für Test: " + Float.toString(timervalue) + " Sekunden", "Pfadfehler: " + wayFaults, colorFaultsText, "gelöst: " + Boolean.toString(success), "---");


        Path file = Paths.get("UEG12Testergebnisse_" + Long.toString(this.id) + ".txt");
        try {
            Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setTestLabel(String testname) {
        this.testName.setText(testname);
    }

    private class nextTest implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            stoptimer = true;
            errorDetection();
            if (zae == testArray.length) {

                success = true;
            }

            writeTestData();
            success = false;
            zae = 0;
            testpresantationTimer.setVisible(true);
            Main.testController(testName.getText());
        }
    }

    public void errorDetection() {
        ArrayList wayarraylist = new ArrayList<Integer>(Arrays.asList(this.testArray));
        for (int i = 0; i < jButton.length; i++) {
            if (jButton[i].getBackground() != Color.black && !wayarraylist.contains(i)) {
                wayFaults++;
            }

            if (wayarraylist.contains(i) && jButton[i].getBackground() != Color.black) {
                zae++;
            }
        }

        if (this.withColor) {
        for(int i = 0; i < this.testArray.length; i++){
                if (jButton[this.testArray[i]].getBackground() != colorArray[i]) {
                    colorFaults++;
                }
            }
        }
    }

    public class frameButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < jButton.length; i++) {
                if (e.getSource() == jButton[i]) {

                    if (withColor) {
                        if (((JButton) e.getSource()).getBackground() == Color.black) {
                            jButton[i].setBackground(Color.red);
                        } else if (((JButton) e.getSource()).getBackground() == Color.red) {
                            jButton[i].setBackground(Color.yellow);
                        } else if (((JButton) e.getSource()).getBackground() == Color.yellow) {
                            jButton[i].setBackground(Color.blue);
                        } else if (((JButton) e.getSource()).getBackground() == Color.blue) {
                            jButton[i].setBackground(Color.black);
                        }
                    } else if (!withColor) {
                        if (((JButton) e.getSource()).getBackground() == Color.black) {
                            jButton[i].setBackground(Color.red);
                        } else if (((JButton) e.getSource()).getBackground() == Color.red) {
                            jButton[i].setBackground(Color.black);
                        }
                    }


                }
            }
        }
    }
}
