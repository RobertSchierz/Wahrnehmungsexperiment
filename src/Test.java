import java.awt.*;

/**
 * Created by Robert on 09.06.2016.
 */
public class Test {
    private Gui gui;
    private int col;
    private int row;
    private String testname;
    private Integer[] wayArray;
    private Color[] colors;

    public Test(Gui gui, int col, int row, String testname, Integer[] wayArray, Color[] colors) {
        this.gui = gui;
        this.row = row;
        this.col = col;
        this.testname = testname;
        this.wayArray = wayArray;
        this.colors = colors;
    }

    public void initialTest() {
        this.gui.setGridPanel(this.row, this.col, this.wayArray, this.colors);
        this.gui.setTestLabel(this.testname);
        this.gui.setTimerForPresentation();
    }

    public static void removeButtons() {
        Main.gui.removeTest();
    }


}
