import java.awt.*;
import java.awt.event.ActionEvent;

public class PassiveUpgrade extends Upgrade {
    JigglePoints points;
    int generation;
    int cost;
    public PassiveUpgrade(){

    }
    public PassiveUpgrade(int gen,int cst,JigglePoints pnts){
        generation = gen;
        points = pnts;
        cost = cst;
    }
    public void actionPerformed(ActionEvent e){
        if(points.getJP() >= cost){
            points.setPassiveJP(points.getPassiveJP() + generation);
            points.setJP(points.getJP() - cost);
        }
        else{

        }
    }
}