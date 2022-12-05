import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Kanwa extends JPanel {

    private Graphics g;
    private BufferedImage i;

    public Kanwa() {
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.BLACK);
        setVisible(true);
        i = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        g = i.getGraphics();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(tryb)
                {
                    case 1:
                        g.setColor(Color.RED);
                        g.fillRect(e.getX() - 10, e.getY() - 5, 20, 10);
                        break;
                    case 2:
                        g.setColor(Color.GREEN);
                        g.fillOval(e.getX() - 10, e.getY() - 10, 20, 20);
                        break;
                }
                tryb = 0;
                getParent().repaint();
            }
        });
    }

    private int tryb;
    public void setTryb(int tryb)
    {
        this.tryb = tryb;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(i, 0, 0, 300, 300, null);
    }



}