import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActiveUpgrade extends Upgrade {
    int generation;
    int cost;
    JigglePoints points;
    public ActiveUpgrade(){

    }
    public ActiveUpgrade(int gen,int cst,JigglePoints pnts){
        generation = gen;
        points = pnts;
        cost = cst;
    }
    public void actionPerformed(ActionEvent e){
        if(points.getJP() >= cost) {
            points.setJP(points.getJP() - cost);
            points.setJPperClick(points.getJPperClick() + generation);
        }
        else{

        }
    }
}
