package cns;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CryptoGUI {
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window();
            }
        });
    }  
}

class Window extends JFrame {
    
//    JButton encryption  = new JButton("Encryption");
//    JButton decryption = new JButton("Decryption");
//    ContainerPanel containerPanel = new ContainerPanel();
    EncryptionPanel encryptionPanel = new EncryptionPanel(this);
    DecryptionPanel decryptionPanel = new DecryptionPanel(this);
    CardLayout cardLayout;
    
    Window(){
        
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        
        ImageIcon icon = new ImageIcon("D:\\NetBeans Projects\\CNS\\image\\logo.png");
        setIconImage(icon.getImage());
        
//        add(encryption);
//        encryption.setBounds(68, 6, 100, 23);
//        
//        add(decryption);
//        decryption.setBounds(213, 6, 100, 23);
        
//        add(containerPanel);
//        containerPanel.setBounds(10, 40, 380, 280);
        
        add(encryptionPanel,"encryptionPanel");
        add(decryptionPanel,"decryptionPanel");
        
        setLocationRelativeTo(null);
    }
    
    public void switchToPanel(String panelName) {
        cardLayout.show(this.getContentPane(), panelName);
    }
    
//    encryption.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                containerPanel.switchToPanel("encryptionPanel");
//            }
//        });
//}

//class ContainerPanel extends JPanel {
//
//    static CardLayout cardLayout;
//    EncryptionPanel encryptionPanel = new EncryptionPanel();
//    DecryptionPanel decryptionPanel = new DecryptionPanel();
//    
//    public ContainerPanel() {
//        cardLayout = new CardLayout();
//        setLayout(cardLayout);
//        
//        add(encryptionPanel,"encryptionPanel");
//        add(decryptionPanel,"decryptionPanel");
//    }
//    
//    public void switchToPanel(String panelName) {
//        cardLayout.show(ContainerPanel.this, panelName);
//    }
}

class EncryptionPanel extends JPanel {
    EncryptionPanel(Window window){
        
        setPreferredSize(new java.awt.Dimension(300, 200));
        
        JButton encryption  = new JButton("Encryption");
        JButton decryption = new JButton("Decryption");
        JButton encrypt = new JButton("Encrypt");
        JLabel l1 = new JLabel("Type or paste the text here");
        JScrollPane jScrollPane1 = new JScrollPane();
        JTextArea jTextArea1 = new JTextArea();
        JLabel l2 = new JLabel("Encrypted text");
        JScrollPane jScrollPane2 = new JScrollPane();
        JTextArea jTextArea2 = new JTextArea();
        JLabel l3 = new JLabel("Key");
        JTextField key = new JTextField();
        
        setLayout(null);
        
        add(encryption);
        encryption.setBounds(68, 6, 100, 23);
        
        add(decryption);
        decryption.setBounds(213, 6, 100, 23);
        
        l1.setBackground(new java.awt.Color(255, 255, 255));
        add(l1);
        l1.setBounds(30, 40, 160, 16);
        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);
        
        add(jScrollPane1);
        jScrollPane1.setBounds(30, 60, 298, 86);
        
        add(l3);
        l3.setBounds(30, 150, 37, 16);
        
        add(key);
        key.setBounds(70, 150, 71, 22);
        
        add(encrypt);
        encrypt.setBounds(200, 157, 80, 23);
        
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setLineWrap(true);
        jTextArea2.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea2);
        
        add(jScrollPane2);
        jScrollPane2.setBounds(30, 210, 300, 86);
        
        l2.setBackground(new java.awt.Color(255, 255, 255));
        add(l2);
        l2.setBounds(30, 190, 90, 16);
        
        encryption.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                window.switchToPanel("encryptionPanel");
            }
        });
        
        decryption.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                window.switchToPanel("decryptionPanel");
            }
        });
        
        encrypt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String alpha = "abcdefghijklmnopqrstuvwxyz";
                String plainText = jTextArea1.getText();
                plainText = plainText.toLowerCase();
                String cipherText="";
                int k = Integer.parseInt(key.getText());
                
//                converting plainText into cipherText
                for(int i=0; i<plainText.length(); i++){
                    int charPosition = alpha.indexOf(plainText.charAt(i));
                    if(charPosition == -1){
                        cipherText += " ";
                        continue;
                    }
                    int keyValue = (charPosition + k)%26;
                    char replacedValue = alpha.charAt(keyValue);
                    cipherText += replacedValue;
                }
                jTextArea2.setText(cipherText);
            }
        });
    }  
}

class DecryptionPanel extends JPanel {
    DecryptionPanel(Window window){
        
        setPreferredSize(new java.awt.Dimension(300, 200));
        
        JButton encryption  = new JButton("Encryption");
        JButton decryption = new JButton("Decryption");
        JButton decrypt = new JButton("Decrypt");
        JLabel l1 = new JLabel("Type or paste the text here");
        JScrollPane jScrollPane1 = new JScrollPane();
        JTextArea jTextArea1 = new JTextArea();
        JLabel l2 = new JLabel("Decrypted text");
        JScrollPane jScrollPane2 = new JScrollPane();
        JTextArea jTextArea2 = new JTextArea();
        JLabel l3 = new JLabel("Key");
        JTextField key = new JTextField();
        
        setLayout(null);
        
        add(encryption);
        encryption.setBounds(68, 6, 100, 23);
        
        add(decryption);
        decryption.setBounds(213, 6, 100, 23);
        
        l1.setBackground(new java.awt.Color(255, 255, 255));
        add(l1);
        l1.setBounds(30, 40, 160, 16);
        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);
        
        add(jScrollPane1);
        jScrollPane1.setBounds(30, 60, 298, 86);
        
        add(l3);
        l3.setBounds(30, 150, 37, 16);
        
        add(key);
        key.setBounds(70, 150, 71, 22);
        
        add(decrypt);
        decrypt.setBounds(200, 157, 80, 23);
        
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setLineWrap(true);
        jTextArea2.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea2);
        
        add(jScrollPane2);
        jScrollPane2.setBounds(30, 210, 300, 86);
        
        l2.setBackground(new java.awt.Color(255, 255, 255));
        add(l2);
        l2.setBounds(30, 190, 90, 16);
        
        encryption.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                window.switchToPanel("encryptionPanel");
            }
        });
        
        decryption.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                window.switchToPanel("decryptionPanel");
            }
        });
        
        decrypt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String alpha = "abcdefghijklmnopqrstuvwxyz";
                String cipherText = jTextArea1.getText();
                cipherText = cipherText.toLowerCase();
                String plainText="";
                int k = Integer.parseInt(key.getText());
                
//                converting cipherText into plainText
                for(int i=0; i<cipherText.length(); i++){
                    int charPosition = alpha.indexOf(cipherText.charAt(i));
                    if(charPosition == -1){
                        plainText += " ";
                        continue;
                    }
                    int a = charPosition - k;
                    if(a < 0){
                        a = 26 - ((-1*a)%26);
                    }
                    int keyValue = (a)%26;
                    char replacedValue = alpha.charAt(keyValue);
                    plainText += replacedValue;
                }
                jTextArea2.setText(plainText);
            }
        });
    }
}
