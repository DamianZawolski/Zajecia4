import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;



public class Framka extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Framka window = new Framka();
                    window.pack();
                    window.setVisible(true);
                    window.origRunX = window.run.getX();
                    window.origRunY = window.run.getY();
                    window.repaint();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }
    private Random xy = new Random();
    private final JButton run;
    private final JButton cancel;
    private Kanwa rysuj;
    private int origRunX;
    private int origRunY;

    public Framka() {
        setSize(new Dimension(300, 600));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setOpaque(false);
        add(box);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setOpaque(false);
        run = new JButton();
        run.setLocation(0, 0);
        run.setText("RUN");
        run.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (e.getX() < run.getWidth() - 20) {
                    run.setLocation(xy.nextInt(225), xy.nextInt(225));
                }
            }
        });
        buttonPanel.add(run);

        cancel = new JButton();
        cancel.setText("CANCEL");
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                run.setLocation(origRunX,origRunY);
            }
        });

        buttonPanel.add(cancel);
        buttonPanel.setPreferredSize(new Dimension(300, 300));
        box.add(buttonPanel);
        rysuj = new Kanwa();
        box.add(rysuj);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'p') {
                    rysuj.setTryb(1);
                }
                if (e.getKeyChar() == 'k') {
                    rysuj.setTryb(2);
                }
                super.keyTyped(e);
            }
        });
        setFocusable(true);
        requestFocusInWindow();
    }



}