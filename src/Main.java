import gui.Gui;

public class Main {

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setTestpanel();

        Test test1 = new Test(gui ,10 ,10);
        test1.removeButtons();
        Test test2 = new Test(gui ,3 ,3);



        gui.pack();
        gui.setVisible(true);





    }
}
