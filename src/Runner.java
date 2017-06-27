
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
//Currently Working on: adding Layout for Buttons & stuff
//Currently Working on: Passive Generation Thread.
public class Runner {
public static void main(String args[]){
    //This makes it so pressing spacebar does not press any of the buttons.
    InputMap inputMap1 = (InputMap)UIManager.get("Button.focusInputMap");
    inputMap1.put(KeyStroke.getKeyStroke("pressed SPACE"), "none");
    inputMap1.put(KeyStroke.getKeyStroke("released SPACE"), "none");

    JFrame frame = new JFrame("Jiggle Baby: The Game");
    frame.setSize(1000,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MainPanel MPanel = new MainPanel();
    JPanel mainJiggle = MPanel.getMainJiggle();
    mainJiggle.setLayout(new BoxLayout(mainJiggle,BoxLayout.PAGE_AXIS));
    UpgradePanel upgradePanel = MPanel.getUpgradePanel();
    final Jiggler jiggler = new Jiggler();
    final JigglePoints pointer = new JigglePoints();
    PointLabel JP = new PointLabel();
    MPanel.getPointLabel().add(JP);
    mainJiggle.add(jiggler);
    frame.add(MPanel);
    //Better Jiggler Upgrade
    upgradePanel.getContainer(0).getButton().addActionListener(new ActiveUpgrade(2,10,pointer));
    upgradePanel.getContainer(0).getButton().setText("Better Jiggle");
    upgradePanel.getContainer(0).getLabel().setText("Gives +2JP / Click  Cost: 10");
    //Learn from Trainer Upgrade
    upgradePanel.getContainer(1).getButton().addActionListener(new ActiveUpgrade(10,200,pointer));
    upgradePanel.getContainer(1).getButton().setText("Learn from Trainer");
    upgradePanel.getContainer(1).getLabel().setText("Gives +10JP / Click  Cost: 200");
    //Copy the professional upgrade
    upgradePanel.getContainer(2).getButton().addActionListener(new ActiveUpgrade(75,800,pointer));
    upgradePanel.getContainer(2).getButton().setText("Copy the Professional's Moves");
    upgradePanel.getContainer(2).getLabel().setText("Gives +75JP / Click  Cost: 800");
    //Make up own technique Upgrade
    upgradePanel.getContainer(3).getButton().addActionListener(new ActiveUpgrade(200,1200,pointer));
    upgradePanel.getContainer(3).getButton().setText("Make up your own technique");
    upgradePanel.getContainer(3).getLabel().setText("Gives +200JP / Click  Cost: 1200");
    //Contact Aliens Upgrade
    upgradePanel.getContainer(4).getButton().addActionListener(new ActiveUpgrade(500,3000,pointer));
    upgradePanel.getContainer(4).getButton().setText("Contact Aliens for the Meaning of Life");
    upgradePanel.getContainer(4).getLabel().setText("Gives +500JP / Click  Cost: 3000");
    //First Passive Upgrade
    upgradePanel.getContainer(5).getButton().addActionListener(new PassiveUpgrade(1,100,pointer));
    upgradePanel.getContainer(5).getButton().setText("Backup Jiggler");
    upgradePanel.getContainer(5).getLabel().setText("Gives +1JP / Second  Cost: 100");
    //Jiggly Trainer
    upgradePanel.getContainer(6).getButton().addActionListener(new PassiveUpgrade(10,300,pointer));
    upgradePanel.getContainer(6).getButton().setText("Jiggly Trainer");
    upgradePanel.getContainer(6).getLabel().setText("Gives +10JP / Second  Cost: 300");
    //Professional Jiggler
    upgradePanel.getContainer(7).getButton().addActionListener(new PassiveUpgrade(200,1000,pointer));
    upgradePanel.getContainer(7).getButton().setText("Professional Jiggler");
    upgradePanel.getContainer(7).getLabel().setText("Gives +200JP / Second  Cost: 1000");
    //The Russians
    upgradePanel.getContainer(8).getButton().addActionListener(new PassiveUpgrade(500,1500,pointer));
    upgradePanel.getContainer(8).getButton().setText("The Russians");
    upgradePanel.getContainer(8).getLabel().setText("Gives +500JP / Second  Cost: 1500");
    //Alien Colonists
    upgradePanel.getContainer(9).getButton().addActionListener(new PassiveUpgrade(1000,4000,pointer));
    upgradePanel.getContainer(9).getButton().setText("Alien Colonists");
    upgradePanel.getContainer(9).getLabel().setText("Gives +1000JP / Second  Cost: 4000");
    class SpaceAction extends AbstractAction{
        public void actionPerformed(ActionEvent e) {
            jiggler.change();
            pointer.setJP(pointer.getJPperClick() + pointer.getJP());
            }
    }
    jiggler.addActionListener(new SpaceAction());
    jiggler.setBorderPainted(false);
    jiggler.setContentAreaFilled(false);
    jiggler.setFocusPainted(false);
    jiggler.setOpaque(false);
    frame.setIconImage(new ImageIcon("pic/FrameIcon.png").getImage());
    /**
     *This was meant for space bar presses but resulted in being to op
     Action spaceAction = new SpaceAction();
    KeyStroke stroke = KeyStroke.getKeyStroke(' ');
    InputMap inputMap = mainJiggle.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    inputMap.put(stroke,"OPEN");
    mainJiggle.getActionMap().put("OPEN",spaceAction);
     */
    frame.setVisible(true);
    PassiveThread T1 = new PassiveThread("Thread-1",pointer);
    T1.start();
    mainJiggle.requestFocus();
    while(true){
        JP.setText(Integer.toString(pointer.getJP()));
    }
}
}
