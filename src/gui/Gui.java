package gui;

import java.awt.*;

/**
 * Created by Jan on 05.06.2016.
 */
public class Gui extends javax.swing.JFrame {


        private javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        private int coln;
        private int rown;


        private javax.swing.JButton[] jButton;

        /**
         * Der Konstruktor.
         */
        public Gui(int rown, int coln) {

            this.rown = rown;
            this.coln = coln;
            int buttonanz = this.coln * this.rown;
            this.jButton = new javax.swing.JButton[buttonanz];

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


            jPanel1.setPreferredSize(new Dimension(500,500));
            jPanel1.setMaximumSize(jPanel1.getPreferredSize());
            jPanel1.setLayout(new java.awt.GridLayout( this.rown, this.coln ) );




            ButtonListener bl = new ButtonListener();


            for ( int i = 0; i<buttonanz; i++ ) {
                jButton[i] = new javax.swing.JButton ( "JButton" + (i+1) );
                jButton[i].addActionListener ( bl );
                jPanel1.add ( jButton[i] );
            }


            this.getContentPane().add ( jPanel1 ) ;


            pack();

        }


        class ButtonListener implements java.awt.event.ActionListener {
            public void actionPerformed(java.awt.event.ActionEvent e) {

                for (int i=0; i<9; i++) {
                    if( e.getSource() == jButton[i] ){
                        System.out.println("JButton" + (i+1) + " wurde geklickt.");
                    }
                }
            }
        }
}
