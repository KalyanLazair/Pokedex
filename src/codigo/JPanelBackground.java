/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.io.File;

/**
 *
 * @author Thomas
 */
public class JPanelBackground extends JPanel {
    
    private BufferedImage image;
    
    public JPanelBackground(){
      
        try{
          image= ImageIO.read(new File("/imagenes/pokedex.png"));
        } catch(IOException e){}
    }
     @Override
    protected void paintComponent(Graphics g){
      super.paint(g);
      g.drawImage(image, 0,0,this);
    }
    
    /*
    private Image background;
    
    public void paintComponent(Graphics g){
      int ancho=this.getSize().width;
      int alto= this.getSize().height;
      
      if(this.background != null){
        g.drawImage(this.background, 0, 0, ancho, alto, null);
      }
      
      super.paintComponent(g);
      
    }
      
      public void setBackground(String imagePath){
        this.setOpaque(false);
        this.background = new ImageIcon(imagePath).getImage();
        repaint();
      }
    */
    
    
}
