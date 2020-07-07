import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.BorderLayout;

public class NBodyApp {
    JFrame jFrame;
    JPanel jPanel;
    NBody nBody;
    public static void main(String[] args) throws Exception {
        NBodyApp nbody = new NBodyApp();
        
        System.out.println("Hello, World!");
        nbody.go();
    }

    public void go() {
        nBody = new NBody(10, 30, new NBody.Position(100, 100), new NBody.Velocity(10, 0), new NBody.Accelerate(0, 0));
        jFrame = new JFrame();
        jPanel = new JPanel();       
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().add(BorderLayout.SOUTH, jPanel);
        MyDrawPanel drawPanel = new MyDrawPanel();
        jFrame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        jFrame.setSize(1000, 1000); 
        jFrame.setVisible(true);
    }

    public class MyDrawPanel extends JPanel{
        public void paintComponent(Graphics g) {
            try {
                g.setColor(Color.red);
                
                ArrayList<NBody> nbodyList = new ArrayList<NBody>();
                nbodyList.add(nBody);
                double time = 0;
                double dt = 0.5;

                NBody.begin(nbodyList, dt);
                for (int i = 0; i < nbodyList.size(); i++) {
                    NBody tempnBody = nbodyList.get(i);                   
                    g.fillOval((int)tempnBody.position.x,(int)tempnBody.position.y,(int)tempnBody.size,(int)tempnBody.size);
                    Thread.sleep(15);
                }
                time = time + dt;
                jFrame.repaint();
                       
            } catch (Exception e) {
                //TODO: handle exception
            }
             
            
        } 
    }
}
