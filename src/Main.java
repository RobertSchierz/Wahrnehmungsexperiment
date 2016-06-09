import gui.Gui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setTestpanel(gui);

        Test test1 = new Test(gui ,3 ,3);
        Test test2 = new Test(gui, 7,7 );

        gui.pack();
        gui.setVisible(true);





    }
}
