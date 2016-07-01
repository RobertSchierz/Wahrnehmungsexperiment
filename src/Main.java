import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;

public class Main {
    public static Gui gui = new Gui();
    public static long id = System.currentTimeMillis();
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
            PrintWriter writer = new PrintWriter("UEG12Testergebnisse_" + Long.toString(id) + ".txt", "UTF-8");
        } catch (Exception e) {
            System.out.println("Fehler beim erstellen von Datei");
        }

        Test test1 = new Test(Main.gui, 3, 3, "Test 1", new Integer[]{0, 1, 2}, new Color[]{}, 5, id);
        test1.initialTest();

        Main.gui.pack();

    }

    public static void testController(String testname) {
        Test.removeButtons();
        switch (testname) {
            case "Test 1":
                Test test2 = new Test(Main.gui, 3, 3, "Test 2", new Integer[]{0, 4, 8}, new Color[]{},5, id);
                test2.initialTest();
                break;
            case "Test 2":
                 Test test3 = new Test(gui ,4 ,4, "Test 3", new Integer[]{4,5,10,15}, new Color[]{},5, id );
                 test3.initialTest();
                break;
            case "Test 3":
                Test test4 = new Test(gui ,4 ,4, "Test 4", new Integer[]{9,10,12,15}, new Color[]{},2, id );
                test4.initialTest();
                break;
            case "Test 4":
                Test test5 = new Test(gui ,4 ,4, "Test 5", new Integer[]{0,5,6,11}, new Color[]{},1, id );
                test5.initialTest();
                break;
            case "Test 5":
                Test test6 = new Test(gui ,5 ,5, "Test 6", new Integer[]{4,5,6,8,12}, new Color[]{},2, id );
                test6.initialTest();
                break;
            case "Test 6":
                Test test7 = new Test(gui ,7 ,5, "Test 7", new Integer[]{7,13,15,17,19,23,25}, new Color[]{},2, id );
                test7.initialTest();
                break;
            case "Test 7":
                Test test8 = new Test(gui ,4 ,4, "Test 8", new Integer[]{5,8,10,11}, new Color[]{Color.red, Color.yellow, Color.red, Color.blue},3, id );
                test8.initialTest();
                break;
            case "Test 8":
                Test test9 = new Test(gui ,4 ,4, "Test 9", new Integer[]{6,9,11,12}, new Color[]{Color.red, Color.yellow, Color.blue, Color.yellow},3, id );
                test9.initialTest();
                break;
            case "Test 9":
                Test test10 = new Test(gui ,5 ,5, "Test 10", new Integer[]{0,1,7,9,13}, new Color[]{Color.red,Color.red,Color.yellow,Color.blue,Color.red},3, id );
                test10.initialTest();
                break;
            case "Test 10":
                Test test11 = new Test(gui ,6 ,5, "Test 11", new Integer[]{2,7,9,11,12,16}, new Color[]{Color.blue,Color.yellow,Color.yellow,Color.red,Color.blue,Color.yellow},4, id );
                test11.initialTest();
                break;
            case "Test 11":
                Test test12 = new Test(gui ,6 ,6, "Test 12", new Integer[]{6,11,13,14,16,21}, new Color[]{Color.blue,Color.red,Color.red,Color.yellow,Color.yellow,Color.blue},8, id );
                test12.initialTest();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Der Test wurde erfolgreich ausgeführt");
                System.exit(0);
                break;
        }
    }
}


