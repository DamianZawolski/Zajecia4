package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Main extends JFrame{
    Random losowa = new Random();
    int losowyX = losowa.nextInt(100);
    int losowyY = 0;
    int pozycjaX;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main aplikacja = new Main();
            aplikacja.createFrame();
        });
    }

    public void createFrame() {
        setTitle("Uciekajacy przycisk i kanwa");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        JButton clickBtn = new JButton("Kliknij mnie");
        clickBtn.setBounds(losowyX, losowyY,100,30);
        clickBtn.setVisible(true);

        Kanva cPanel = new Kanva();
        cPanel.setBounds(0, 0, 400, 300);
        var g1 = cPanel.canvas.getGraphics();
        g1.setColor(Color.LIGHT_GRAY);
        g1.fillRect(0,0,400,300);
        g1.dispose();
        cPanel.repaint();
        cPanel.setLayout(null);
        setContentPane(cPanel);

        JButton exitBtn = new JButton("Cofnij do przycisku");
        exitBtn.setBounds(0,0,150,30);
        exitBtn.setVisible(false);

        JLabel tekst1 = new JLabel("Na przycisk można najechać z prawej strony");
        tekst1.setBounds(5,240,250,30);
        tekst1.setVisible(true);

        JLabel tekst2 = new JLabel("K- kwadrat, O- okrąg, L- linia");
        tekst2.setBounds(160,0,250,30);
        tekst2.setVisible(false);

        clickBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                pozycjaX = e.getX();
                if(pozycjaX < 80)
                {
                    losowyX = losowa.nextInt(300);
                    losowyY = losowa.nextInt(200);
                    clickBtn.setLocation(losowyX, losowyY);
                }
            }
        });

        clickBtn.addActionListener((e)->{
            clickBtn.setVisible(false);
            exitBtn.setVisible(true);

            var g2 = cPanel.canvas.getGraphics();
            g2.setColor(Color.WHITE);
            g2.fillRect(0,0,400,300);
            g2.dispose();
            cPanel.repaint();
            tekst1.setVisible(false);
            tekst2.setVisible(true);
        });

        exitBtn.addActionListener((e)->{
            clickBtn.setVisible(true);
            exitBtn.setVisible(false);
            tekst1.setVisible(true);
            tekst2.setVisible(false);


            var g3 = cPanel.canvas.getGraphics();
            g3.setColor(Color.LIGHT_GRAY);
            g3.fillRect(0,0,400,300);
            g3.dispose();
            cPanel.repaint();
            cPanel.ksztalt = Kanva.Ksztalt.Brak;
        });


        cPanel.add(clickBtn);
        cPanel.add(exitBtn);
        cPanel.add(tekst1);
        cPanel.add(tekst2);
        exitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}