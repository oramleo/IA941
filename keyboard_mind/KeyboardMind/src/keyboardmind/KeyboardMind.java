/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardmind;

import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.World;
import ws3dproxy.model.WorldPoint;

import javax.swing.*;

import keyboardmind.*;

/**
 *
 * @author ia941
 */
public class KeyboardMind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        

        WS3DProxy proxy = new WS3DProxy();
        try {
                World w = World.getInstance();
                w.reset();
       //         World.createFood(0, 350, 75);
       //         World.createFood(0, 100, 220);
       //         World.createFood(0, 250, 210);
                Creature c = proxy.createCreature(100,450, 0);
                c.start();
                
                JFrame frame = new JFrame("Mouse Control");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //Add content to the window.
                frame.add(new KMPanel(c));

                //Display the window.
                frame.pack();
                frame.setVisible(true);
                
//                WorldPoint position = c.getPosition();
//                double pitch = c.getPitch();
//                c.moveto(1, 400, 300);
            } catch (CommandExecException e) {
                System.out.println("Erro capturado"); 
            }
    }
    
    
    
}
