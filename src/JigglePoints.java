public class JigglePoints{
    int JPcount = 0;
    int JPperClick = 1;
    int PassiveJP = 0;
    public JigglePoints() {

    }
    public int getJP(){
        return JPcount;
    }
    public void setJP(int jpAmount){
        JPcount = jpAmount;
    }
    public int getJPperClick(){
        return JPperClick;
    }
    public void setJPperClick(int jpPer){
        JPperClick = jpPer;
    }
    public int getPassiveJP(){
        return PassiveJP;
    }
    public void setPassiveJP(int set){
        PassiveJP = set;
    }

}