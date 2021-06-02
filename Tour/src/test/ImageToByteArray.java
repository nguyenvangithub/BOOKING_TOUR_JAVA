package test;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ImageToByteArray extends JFrame {
    private static final long serialVersionUID = -8231889836024827530L;

    public static void main(String[] args) {
        try {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Test");
            UIManager.put("ScrollBarUI", "main.CustomScrollBarUI");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
    }
    catch(InstantiationException e) {
            System.out.println("InstantiationException: " + e.getMessage());
    }
    catch(IllegalAccessException e) {
            System.out.println("IllegalAccessException: " + e.getMessage());
    }
    catch(UnsupportedLookAndFeelException e) {
            System.out.println("UnsupportedLookAndFeelException: " + e.getMessage());
    }
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                JFrame frame = new JFrame() {

                    Container c = getContentPane();
                    JButton button = new JButton("Hello");
                    {
                        button.setText("Hello");
                        button.setVisible(true);
                        button.setPreferredSize(new Dimension(100, 50));
                        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
                        button.setBackground(Color.BLACK);
                        button.setForeground(Color.WHITE);
                        button.setContentAreaFilled(false);
                        button.setOpaque(true);
                        c.add(button);
                    }

                };
                frame.setSize(500, 500);
                frame.setBackground(Color.BLACK);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}