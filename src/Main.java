import java.io.PrintWriter;

public class Main {
    public static Gui gui = new Gui();

    public static void main(String[] args) {

        Main.gui.setTestpanel();
        Main.gui.setVisible(true);

        try {
            PrintWriter writer = new PrintWriter("Testergebnisse.txt", "UTF-8");
        }catch(Exception e){
            System.out.println("Fehler beim erstellen von Datei");
        }

        Test test1 = new Test(Main.gui ,3 ,3, "Test 1", new Integer[]{0,1,2} );
        test1.initialTest();

        Main.gui.pack();

    }

    public static void testController(String testname){
        Test.removeButtons();
        switch (testname){
            case "Test 1":
                Test test2 = new Test(Main.gui ,4 ,4, "Test 2", new Integer[]{3,4,5} );
                test2.initialTest();
                break;
            case "Test 2":
                Test test3 = new Test(gui ,10 ,10, "Test 3", new Integer[]{30,31,41,51,61,71,72,63,73,64,65,66,67,68,69} );
                test3.initialTest();
                break;
            default:
               System.exit(0);
                break;
        }
    }


}


