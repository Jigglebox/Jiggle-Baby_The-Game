import javax.swing.*;

public class Jiggler extends JButton{
    ImageIcon default1 = new ImageIcon("pic/jiggler1.png");
    ImageIcon default2 = new ImageIcon("pic/jiggler2.png");
    boolean count = false;
    public Jiggler(){
        this.setIcon(default2);
    }
    public void change(){
        if(count) {
        setIcon(default1);
        }
        else{
            setIcon(default2);
        }
        count = !count;
    }
}