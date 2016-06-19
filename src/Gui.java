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
        private float timervalue;
        private boolean stoptimer = false;
        private int fehler = 0;
        public int zae = 0;
    public boolean success = false;

        public Gui() {


            // Setze Fenster in die Mitte
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

            this.setMinimumSize(new Dimension((int) dimension.getWidth() / 2 ,(int) dimension.getHeight() / 2));
            this.setResizable(false);
            this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

            int x = (int) (((dimension.getWidth() - this.getWidth()) / 2));
            int y = (int) (((dimension.getHeight() - this.getHeight()) / 2) );
            this.setLocation(x, y);


            this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            this.setTitle("Wahrnehmungstheorie");


            mainPanel.setLayout(new BorderLayout());
            mainPanel.setSize(this.getWidth(),this.getHeight());
            this.testName.setFont(new Font(Font.MONOSPACED, 0, 40));
            this.testpresantationTimer.setFont(new Font(Font.MONOSPACED, 0, 40));
            this.nextTest.setFont(new Font(Font.MONOSPACED, 0, 30));
            this.nextTest.setFocusPainted(false);
            this.nextTest.setBorder(new LineBorder(Color.BLACK));

            this.add(mainPanel);



        }

    public void setGridPanel(int row, int col, Integer[] wayarray){
        this.testArray = wayarray;
        jButton = new JButton[row*col];
        frameButtonListener FrameButtonListener = new frameButtonListener();

        JPanel jPanel1 = new JPanel();
        jPanel1.setPreferredSize(new Dimension(mainPanel.getWidth()-220,mainPanel.getHeight()));
        jPanel1.setLayout((new java.awt.GridLayout( row, col )));

        ArrayList wayarraylist = new ArrayList<Integer>(Arrays.asList(wayarray));

        for ( int i = 0; i < row*col; i++ ) {

            jButton[i] = new javax.swing.JButton();
            jButton[i].setPreferredSize(new Dimension(100,100));
            jButton[i].setEnabled(false);

            if(wayarraylist.contains(i)){
                jButton[i].setBackground(Color.red);

            }else{
                jButton[i].setBackground(Color.black);
            }

            jButton[i].addActionListener(FrameButtonListener);
            jPanel1.add ( jButton[i] );
        }


        mainPanel.add ( jPanel1,BorderLayout.WEST ) ;
        jPanel1.setVisible(true);
    }

    public void removeTest(){
        BorderLayout layout = (BorderLayout) mainPanel.getLayout();
        mainPanel.remove(layout.getLayoutComponent(BorderLayout.WEST));
    }

    public void setTestpanel(){
        nextTest next = new nextTest();
        JPanel jPanel2 = new JPanel();
        jPanel2.setPreferredSize(new Dimension(200,mainPanel.getHeight()));
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

    public void startTestTimer(){
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {

                        if(stoptimer){
                            timer.cancel();
                        }

                        timervalue += 0.1;
                      //  System.out.println(timervalue);


                    }
                },
                0,100
        );

    }

    public void setTimerForPresentation(){


        java.util.Timer timer = new java.util.Timer();
        timer.schedule(
                new java.util.TimerTask() {
                    int i = 0;
                    @Override
                    public void run() {
                        testpresantationTimer.setText(Integer.toString (i++));
                        if(i == 2){
                            timer.cancel();
                            for ( int i = 0; i < jButton.length; i++ ) {
                                jButton[i].setBackground(Color.black);
                                jButton[i].setEnabled(true);
                            }
                            startTestTimer();
                        }
                    }
                },
                0,1000
        );


/*
        for(int i = 0; i < 3; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            testpresantationTimer.setText(Integer.toString (i + 1));
        }

        for ( int i = 0; i < jButton.length; i++ ) {
            jButton[i].setBackground(Color.black);
            jButton[i].setEnabled(true);
        }
*/
    }

    public void writeTestData(){

        java.util.List<String> lines = Arrays.asList(this.testName.getText(), "Zeit für Test: " + Float.toString(timervalue) + " Minuten", "Fehler: " + fehler, "gelöst: " + Boolean.toString(success), "---");
        Path file = Paths.get("Testergebnisse.txt");
        try {
            Files.write(file, lines, Charset.forName("UTF-8"),  StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void setTestLabel(String testname){
            this.testName.setText(testname);
    }

    private class nextTest implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            stoptimer = true;
            if(zae == testArray.length){

                success = true;
            }
            writeTestData();
            success = false;
            zae = 0;
            Main.testController(testName.getText());
        }
    }



    public class frameButtonListener implements ActionListener {

        boolean isIn = false;
        public void actionPerformed(ActionEvent e) {
            for (int i=0; i<testArray.length; i++) {
                if( e.getSource() == jButton[testArray[i]] ){
                    jButton[testArray[i]].setEnabled(false);
                    zae++;
                    isIn = true;
                }
            }
            if(!isIn){
                fehler++;
                //System.out.println(fehler);
            }else{
                isIn = false;
            }


            for (int i=0; i<jButton.length; i++) {
                if( e.getSource() == jButton[i] ){
                    jButton[i].setBackground(Color.red);

                }
            }
        }
    }
}
