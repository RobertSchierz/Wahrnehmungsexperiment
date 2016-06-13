package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Jan on 05.06.2016.
 */
public class Gui extends javax.swing.JFrame {


        private JButton[] jButton;
        JPanel mainPanel = new JPanel();
        JLabel testName = new JLabel();




        /**
         * Der Konstruktor.
         */
        public Gui() {
            this.setMinimumSize(new Dimension(500,500));
            this.setResizable(true);

            // Setze Fenster in die Mitte
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) (((dimension.getWidth() - this.getWidth()) / 2) - (this.getWidth()/2));
            int y = (int) (((dimension.getHeight() - this.getHeight()) / 2) - (this.getHeight()/2));
            this.setLocation(x, y);


            this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            this.setTitle("Wahrnehmungstheorie");
            mainPanel.setSize(this.getWidth(),this.getHeight());

            mainPanel.setLayout(new BorderLayout());
            this.testName.setFont(new Font(Font.MONOSPACED, 0, 40));

            this.add(mainPanel);



        }

    public void setGridPanel(int row, int col, Integer[] wayarray){
        jButton = new JButton[row*col];
        ButtonListener bl = new ButtonListener();
        JPanel jPanel1 = new JPanel();
        jPanel1.setSize(mainPanel.getWidth()-120,mainPanel.getHeight());
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

            jButton[i].addActionListener ( bl );
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
        JPanel jPanel2 = new JPanel();
        jPanel2.setSize(100,mainPanel.getHeight());
        jPanel2.setLayout((new java.awt.FlowLayout()));
        jPanel2.add(testName);



        mainPanel.add(jPanel2, BorderLayout.EAST);
        jPanel2.setVisible(true);
    }

    public void setTimerForPresentation(){
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        for ( int i = 0; i < jButton.length; i++ ) {
                            jButton[i].setBackground(Color.black);
                            jButton[i].setEnabled(true);
                        }
                    }
                },
                5000
        );
    }

    public void setTestLabel(String testname){
            this.testName.setText(testname);
    }


        class ButtonListener implements java.awt.event.ActionListener {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                for (int i=0; i<jButton.length; i++) {
                    if( e.getSource() == jButton[i] ){
                        System.out.println("JButton" + (i) + " wurde geklickt.");
                        jButton[i].setBackground(Color.red);
                    }
                }
            }
        }
}
