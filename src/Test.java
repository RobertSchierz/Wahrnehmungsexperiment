import gui.Gui;

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

        initialTest();
    }

    public void initialTest(){
        this.gui.setGridPanel(this.row,this.col, wayArray);
        this.gui.setTestLabel(this.testname);
        this.gui.setTimerForPresentation();
    }

    public void removeButtons(){
        this.gui.removeTest();
    }




}
