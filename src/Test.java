import gui.Gui;

/**
 * Created by Robert on 09.06.2016.
 */
public class Test {
    private Gui gui;
    private int col;
    private int row;

    public Test(Gui gui, int col, int row){
        this.gui = gui;
        this.row = row;
        this.col = col;

        initialTest();
    }

    public void initialTest(){
       this.gui.setGridPanel(this.gui, this.row,this.col);

    }




}
