package pack1;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Kanva extends JPanel implements MouseInputListener {
    public enum Ksztalt {
        Okrag, Kwadrat, Linia, Brak
    }
    public final BufferedImage canvas ;

    public Ksztalt ksztalt = Ksztalt.Brak;
    public Kanva() {
        super();
        requestFocusInWindow();
        canvas = new BufferedImage(400,300, BufferedImage.TYPE_INT_RGB);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyChar() == 'o') {
                    ksztalt = Ksztalt.Okrag;
                } else if(e.getKeyChar() == 'k') {
                    ksztalt = Ksztalt.Kwadrat;
                }
                else if(e.getKeyChar() == 'l') {
                    ksztalt = Ksztalt.Linia;
                }
            }
        });

        addMouseListener(this);
        setVisible(true);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas,0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        var g = canvas.getGraphics();
        if(ksztalt == Ksztalt.Okrag) {
            g.setColor(Color.BLUE);
            g.fillOval(e.getX(),e.getY(),10,10);
            g.setColor(Color.WHITE);
            g.drawOval(e.getX(),e.getY(),10,10);
        } else if(ksztalt == Ksztalt.Kwadrat) {
            g.setColor(Color.GREEN);
            g.fillRect(e.getX(),e.getY(),40,40);
            g.setColor(Color.BLACK);
            g.drawRect(e.getX(),e.getY(),40,40);
        }
        else if(ksztalt == Ksztalt.Linia) {
            g.setColor(Color.RED);
            g.drawLine(e.getX(),e.getY(),20,20);
        }
        g.dispose();
        Kanva.this.repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}