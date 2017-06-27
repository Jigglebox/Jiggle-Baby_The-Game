public class PassiveThread extends Thread{
    private Thread t;
    private String threadName;
    private JigglePoints points;
    PassiveThread( String name,JigglePoints pnts) {
        threadName = name;
        System.out.println("Creating " +  threadName );
        points = pnts;
    }

    public void run() {
        System.out.println("Running " +  threadName );
        while(true){
            try {
                points.setJP(points.getJP() + points.getPassiveJP());
                Thread.sleep(1000);
            }
            catch(Exception e){

            }
        }
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}