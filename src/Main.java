import gui.Gui;

import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setTestpanel();
        gui.pack();
        gui.setVisible(true);

        try {
            PrintWriter writer = new PrintWriter("Testergebnisse.txt", "UTF-8");
        }catch(Exception e){
            System.out.println("Fehler beim erstellen von Datei");
        }


        //Test test1 = new Test(gui ,10 ,10, "Test 1", new Integer[]{30,31,41,51,61,71,72,63,73,64,65,66,67,68,69} );
        //test1.removeButtons();
        //Test test2 = new Test(gui ,3 ,3, "Test 2", new Integer[]{0,1,2} );
        Test test1 = new Test(gui ,10 ,10, "Test 1", new Integer[]{10,11,12,13,14,15,16,17,18,19} );


        gui.pack();



    }
}
