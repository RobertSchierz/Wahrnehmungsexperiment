import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;

public class Main {
    public static Gui gui = new Gui();

    public static void main(String[] args) {
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("OptionPane.buttonFont", font);

        JOptionPane.showMessageDialog(null, "Anleitung: \n Im folgenden Test werden dir Pfade auf dem Raster angezeigt. " +
                "\n Beim Ablaufen der Einprägungszeit sollst du diese Pfade nachklicken." +
                "\n Wenn du meinst das du den Pfad erfolgreich nachgeklickt hast, betätige den Button 'weiter' um zum nächsten Test zu gelangen." +
                "\n Sollten die Felder eine Farbe aufweisen, so können diese durch erneutes Klicken auf ein Feld nachgezeichnet werden.");
        Main.gui.setTestpanel();
        Main.gui.setVisible(true);


        try {
            PrintWriter writer = new PrintWriter("Testergebnisse.txt", "UTF-8");
        } catch (Exception e) {
            System.out.println("Fehler beim erstellen von Datei");
        }

        Test test1 = new Test(Main.gui, 3, 3, "Test 1", new Integer[]{0, 1, 2}, new Color[]{}, 5);
        test1.initialTest();

        Main.gui.pack();

    }

    public static void testController(String testname) {
        Test.removeButtons();
        switch (testname) {
            case "Test 1":
                Test test2 = new Test(Main.gui, 3, 3, "Test 2", new Integer[]{0, 4, 8}, new Color[]{},5);
                test2.initialTest();
                break;
            case "Test 2":
                 Test test3 = new Test(gui ,4 ,4, "Test 3", new Integer[]{4,5,10,15}, new Color[]{},5 );
                 test3.initialTest();
                break;
            case "Test 3":
                Test test4 = new Test(gui ,4 ,4, "Test 4", new Integer[]{9,10,12,15}, new Color[]{},2 );
                test4.initialTest();
                break;
            case "Test 4":
                Test test5 = new Test(gui ,4 ,4, "Test 5", new Integer[]{0,5,6,11}, new Color[]{},1 );
                test5.initialTest();
                break;
            case "Test 5":
                Test test6 = new Test(gui ,5 ,5, "Test 6", new Integer[]{4,5,6,8,12}, new Color[]{},2 );
                test6.initialTest();
                break;
            case "Test 6":
                Test test7 = new Test(gui ,5 ,5, "Test 7", new Integer[]{5,11,13,17,19}, new Color[]{},1 );
                test7.initialTest();
                break;
            case "Test 7":
                Test test8 = new Test(gui ,5 ,5, "Test 8", new Integer[]{5,8,10,11}, new Color[]{Color.red, Color.yellow, Color.red, Color.blue},3 );
                test8.initialTest();
                break;
           /* case "Test 2":
                Test test3 = new Test(gui ,4 ,4, "Test 3", new Integer[]{4,5,6,10,11}, new Color[]{},10 );
                test3.initialTest();
                break;
            case "Test 2":
                Test test3 = new Test(gui ,4 ,4, "Test 3", new Integer[]{4,5,6,10,11}, new Color[]{},10 );
                test3.initialTest();
                break;
            case "Test 2":
                Test test3 = new Test(gui ,4 ,4, "Test 3", new Integer[]{4,5,6,10,11}, new Color[]{},10 );
                test3.initialTest();
                break;
            case "Test 2":
                Test test3 = new Test(gui ,4 ,4, "Test 3", new Integer[]{4,5,6,10,11}, new Color[]{},10 );
                test3.initialTest();
                break;*/
            default:
                JOptionPane.showMessageDialog(null, "Der Test wurde erfolgreich ausgeführt");
                System.exit(0);
                break;
        }
    }
}


