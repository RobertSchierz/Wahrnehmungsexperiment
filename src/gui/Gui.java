package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jan on 05.06.2016.
 */
public class Gui extends javax.swing.JFrame {


        private JButton[] jButton;
        JPanel mainPanel = new JPanel();



        /**
         * Der Konstruktor.
         */
        public Gui() {
            this.setMinimumSize(new Dimension(500,500));
            this.setResizable(true);
            this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            this.setTitle("Wahrnehmungstheorie");
            mainPanel.setSize(this.getWidth(),this.getHeight());

            mainPanel.setLayout(new BorderLayout());


            this.add(mainPanel);



        }

    public void setGridPanel(int row, int col){
        jButton = new JButton[row*col];
        ButtonListener bl = new ButtonListener();
        JPanel jPanel1 = new JPanel();
        jPanel1.setSize(mainPanel.getWidth()-120,mainPanel.getHeight());
        jPanel1.setLayout((new java.awt.GridLayout( row, col )));



        for ( int i = 0; i < row*col; i++ ) {
            jButton[i] = new javax.swing.JButton ( "JButton" + (i+1) );
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
        jPanel2.add(new JButton());

        mainPanel.add(jPanel2, BorderLayout.EAST);
        jPanel2.setVisible(true);
    }


        class ButtonListener implements java.awt.event.ActionListener {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                for (int i=0; i<jButton.length; i++) {
                    if( e.getSource() == jButton[i] ){
                        System.out.println("JButton" + (i+1) + " wurde geklickt.");
                    }
                }
            }
        }
}
