import javax.swing.*;
import java.awt.*;

public class UpgradeContainer extends JPanel{
    JButton button;
    JLabel descrip;
    public UpgradeContainer(String btn,String description){
        this.setLayout(new FlowLayout());
        descrip = new JLabel(description);
        button = new JButton(btn);

        this.add(button);
        this.add(descrip);
    }
    public UpgradeContainer(){
        descrip = new JLabel();
        button = new JButton();
        this.add(button);
        this.add(descrip);
    }
    public JButton getButton(){
        return button;
    }
    public void setButtonText(String txt){
        button.setText(txt);
    }
    public JLabel getLabel(){
        return descrip;
    }
    public void setLabel(String txt){
        descrip.setText(txt);
    }
}