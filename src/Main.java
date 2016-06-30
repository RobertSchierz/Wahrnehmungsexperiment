import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;

public class Main {
    public static Gui gui = new Gui();

    public static void main(String[] args) {
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
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

        Test test1 = new Test(Main.gui, 3, 3, "Test 1", new Integer[]{0, 1, 2}, new Color[]{}, 1);
        test1.initialTest();

        Main.gui.pack();

    }

    public static void testController(String testname) {
        Test.removeButtons();
        switch (testname) {
            case "Test 1":
                Test test2 = new Test(Main.gui, 4, 3, "Test 2", new Integer[]{0, 4, 5,9, 10, 11}, new Color[]{},10);
                test2.initialTest();
                break;
            case "Test 2":
                 Test test3 = new Test(gui ,4 ,4, "Test 3", new Integer[]{4,5,6,10,11}, new Color[]{},10 );
                 test3.initialTest();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Der Test wurde erfolgreich ausgeführt");
                System.exit(0);
                break;
        }
    }
}


