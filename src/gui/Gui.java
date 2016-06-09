package gui;

import java.awt.*;

/**
 * Created by Jan on 05.06.2016.
 */
public class Gui extends javax.swing.JFrame {

        private javax.swing.JButton[] jButton;

        /**
         * Der Konstruktor.
         */
        public Gui() {

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            pack();

        }

    public void setGridPanel(Gui gui, int row, int col){


        this.jButton = new javax.swing.JButton[row*col];
        ButtonListener bl = new ButtonListener();

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jPanel1.setPreferredSize(new Dimension(200,200));
        jPanel1.setMinimumSize(jPanel1.getPreferredSize());
        jPanel1.setLayout((new java.awt.GridLayout( row, col )));




        for ( int i = 0; i<row*col; i++ ) {
            jButton[i] = new javax.swing.JButton ( "JButton" + (i+1) );
            jButton[i].addActionListener ( bl );
            jPanel1.add ( jButton[i] );
        }


        gui.getContentPane().add ( jPanel1 ) ;


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
