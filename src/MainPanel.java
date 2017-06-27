import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{
    JPanel MainJiggle;
    UpgradePanel UpgradePanel;
    JPanel points;
    public MainPanel() {
        this.setLayout(new FlowLayout());
        MainJiggle = new JPanel();
        points = new JPanel(new FlowLayout());
        UpgradePanel = new UpgradePanel(10);
        MainJiggle.add(points);
    this.add(MainJiggle);
    this.add(UpgradePanel);

    }
    public JPanel getPointLabel(){
        return points;
    }
    public JPanel getMainJiggle() {
        return MainJiggle;
    }
    public UpgradePanel getUpgradePanel() {
        return UpgradePanel;
    }
}