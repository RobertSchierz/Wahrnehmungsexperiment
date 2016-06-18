/**
 * Created by Robert on 09.06.2016.
 */
public class Test {
    private Gui gui;
    private int col;
    private int row;
    private String testname;
    private Integer[] wayArray;

    public Test(Gui gui, int col, int row, String testname, Integer[] wayArray){
        this.gui = gui;
        this.row = row;
        this.col = col;
        this.testname = testname;
        this.wayArray = wayArray;
    }

    public void initialTest(){
        this.gui.setGridPanel(this.row,this.col, this.wayArray);
        this.gui.setTestLabel(this.testname);
        this.gui.setTimerForPresentation();
    }

    public static void removeButtons(){
        Main.gui.removeTest();
    }




}
