package de.panschk.androidutil;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class CoordinatesHelper {
    static String filename = "C:/workspaces/git/android/de.panschk.mapquiz/res/drawable/north_africa.png";
    static String[] strings = new String[]{
        "Burkina Faso",
        "Mali"
        

    };
    
    private static JFrame myJFrame;
    static int count = 0;
    static HashMap<String, Point> coordinates = new HashMap<String, Point>();
    
    static class ImagePanel extends JComponent {
        private Image image;
        public ImagePanel(Image image) {
            this.image = image;
            this.addMouseListener(new MouseListener() {
                
                public void mouseReleased(MouseEvent arg0) {
                    // TODO Auto-generated method stub
                    
                }
                
                public void mousePressed(MouseEvent arg0) {
                    // TODO Auto-generated method stub
                    
                }
                
                public void mouseExited(MouseEvent arg0) {
                    // TODO Auto-generated method stub
                    
                }
                
                public void mouseEntered(MouseEvent arg0) {
                    // TODO Auto-generated method stub
                    
                }
                
                public void mouseClicked(MouseEvent arg0) {
                    if (arg0.getButton() == MouseEvent.BUTTON3) {
                        count--;
                    } else {
                        
                        coordinates.put(strings[count], new Point(arg0.getX(), arg0.getY()));
                        count++;
                        if (count >= strings.length) {
                            printCoordinates();

                        }
                        
                        
                    }
                    updateTitle();
                    
                    
                }

            });
            updateTitle();
        }
        protected void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
        
    }

    
    public static void main(String args[]) throws IOException {
        BufferedImage myImage = ImageIO.read(new File(filename));
        myJFrame = new JFrame("Image pane");
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setContentPane(new ImagePanel(myImage));
        myJFrame.setSize(new Dimension(1000,  700));
        myJFrame.setVisible(true);
        
        
    }
    

    private static void updateTitle() {
        if (count > -1 && count < strings.length) {
            myJFrame.setTitle(strings[count]);
        } else {
            
//            printCoordinates();
        }
        
    }


    private static void printCoordinates() {
        for (int  i = 0; i < strings.length;i++) {
            String key = strings[i];
            Point p = coordinates.get(key);
            if (p != null) {
                System.out.println("entries.add(new Entry( "+((int)p.getX())+",  "+((int)p.getY())+", \""+key+"\"));");
            }
        }
    }
    
    


}
