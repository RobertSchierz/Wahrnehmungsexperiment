import gui.Gui;

/**
 * Created by Robert on 09.06.2016.
 */
public class Test {
    private Gui gui;
    private int col;
    private int row;
    private String testname;

    public Test(Gui gui, int col, int row, String testname){
        this.gui = gui;
        this.row = row;
        this.col = col;
        this.testname = testname;

        initialTest();
    }

    public void initialTest(){
       this.gui.setGridPanel(this.row,this.col);
        this.gui.setTestLabel(this.testname);
    }

    public void removeButtons(){
        this.gui.removeTest();
    }




}
