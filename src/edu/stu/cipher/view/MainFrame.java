package edu.stu.cipher.view;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel currentPanel;

    public MainFrame() {
        initComponents();
        javax.swing.SwingUtilities.invokeLater(() -> showPanel(new StartPanel(this)));
    }

    private void initComponents() {
        setTitle("CipherApp");
        setSize(830, 570);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
    }

    public void showPanel(JPanel panel) {
        // Use animated transition for smooth switching
        showPanelAnimated(panel);
    }

    public void showPanelAnimated(JPanel newPanel) {
        int w = getContentPane().getWidth();
        int h = getContentPane().getHeight();
        if (w <= 0 || h <= 0) { // fallback if not laid out yet
            w = getWidth();
            h = getHeight();
        }
        final int fw = w;
        final int fh = h;

        if (currentPanel == null) {
            currentPanel = newPanel;
            newPanel.setBounds(0, 0, w, h);
            add(newPanel);
            revalidate();
            repaint();
            return;
        }

        // place new panel to the right
        newPanel.setBounds(w, 0, w, h);
        add(newPanel);

        final int duration = 300; // ms
        final int steps = 30;
        final int delay = Math.max(1, duration / steps);
    final int totalW = fw;

    Timer timer = new Timer(delay, null);
        final int[] step = {0};
        timer.addActionListener(e -> {
            step[0]++;
            double frac = (double) step[0] / steps;
            int curX = (int) Math.round(-frac * totalW);
            int newX = (int) Math.round((1 - frac) * totalW);
            currentPanel.setBounds(curX, 0, totalW, fh);
            newPanel.setBounds(newX, 0, totalW, fh);
            revalidate();
            repaint();
            if (step[0] >= steps) {
                timer.stop();
                remove(currentPanel);
                currentPanel = newPanel;
                currentPanel.setBounds(0, 0, totalW, fh);
                revalidate();
                repaint();
            }
        });
        timer.start();
    }



}
