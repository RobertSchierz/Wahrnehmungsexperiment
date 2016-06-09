import gui.Gui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setSize(500,500);


        Test test1 = new Test(gui ,5 ,5);

        gui.setVisible(true);



    }
}
