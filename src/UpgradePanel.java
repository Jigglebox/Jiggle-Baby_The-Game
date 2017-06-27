
import javax.swing.*;
import java.util.ArrayList;

public class UpgradePanel extends JPanel{
    ArrayList<UpgradeContainer> contain = new ArrayList<UpgradeContainer>();
    public UpgradePanel(int amountOfSpaces){
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        //add an amount of UpgradeContainers to the UpgradePanel to get from Later on
        for(int x = 0;x < amountOfSpaces;x++){
            UpgradeContainer temp = new UpgradeContainer();
            contain.add(temp);
            this.add(temp);
        }
    }
    public UpgradeContainer getContainer(int get){
        return contain.get(get);
    }
}