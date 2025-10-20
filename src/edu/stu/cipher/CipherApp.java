package edu.stu.cipher;

import edu.stu.cipher.view.MainFrame;
import javax.swing.*;

public class CipherApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
    
}
