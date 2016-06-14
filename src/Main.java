import gui.Gui;

public class Main {

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setTestpanel();
        gui.pack();
        gui.setVisible(true);


        Test test1 = new Test(gui ,10 ,10, "Test 1", new Integer[]{30,31,41,51,61,71,72,63,73,64,65,66,67,68,69} );
        //test1.removeButtons();
        //Test test2 = new Test(gui ,3 ,3, "Test 2", new Integer[]{0,1,2} );

        gui.pack();



    }
}
