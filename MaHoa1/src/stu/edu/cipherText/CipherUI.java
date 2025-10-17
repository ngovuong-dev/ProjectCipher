package stu.edu.cipherText;

public class CipherUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CipherUI.class.getName());

    public CipherUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Text = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Result = new javax.swing.JTextArea();
        PublicKey = new javax.swing.JLabel();
        CipherKey = new javax.swing.JTextField();
        Encrypt = new javax.swing.JButton();
        Decrypt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CipherFrame");

        Text.setColumns(20);
        Text.setRows(5);
        jScrollPane1.setViewportView(Text);

        Result.setColumns(20);
        Result.setRows(5);
        jScrollPane2.setViewportView(Result);

        PublicKey.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        PublicKey.setText("Key");

        CipherKey.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CipherKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CipherKeyActionPerformed(evt);
            }
        });

        Encrypt.setText("Encrypt");
        Encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptActionPerformed(evt);
            }
        });

        Decrypt.setText("Decrypt");
        Decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PublicKey, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CipherKey, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(Encrypt)
                        .addGap(18, 18, 18)
                        .addComponent(Decrypt)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(PublicKey)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CipherKey, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Encrypt)
                            .addComponent(Decrypt))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CipherKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CipherKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CipherKeyActionPerformed

    private void EncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptActionPerformed
        // TODO add your handling code here:
            String PlainText=Text.getText();
            CeasarCipher cc = new CeasarCipher();
           
            ShiftCipher sc = new ShiftCipher();
            
            String CipherTextAfterEncrypt= sc.encrypt(PlainText,CipherKey.getText());
            Result.setText(CipherTextAfterEncrypt);
    }//GEN-LAST:event_EncryptActionPerformed

    private void DecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptActionPerformed
        // TODO add your handling code here:
            String PlainText=Text.getText();
            CeasarCipher cc = new CeasarCipher();
            
            ShiftCipher sc = new ShiftCipher();
            
            String CipherTextAfterEncrypt= sc.decrypt(PlainText, CipherKey.getText());
            Result.setText(CipherTextAfterEncrypt);  
    }//GEN-LAST:event_DecryptActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new CipherUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CipherKey;
    private javax.swing.JButton Decrypt;
    private javax.swing.JButton Encrypt;
    private javax.swing.JLabel PublicKey;
    private javax.swing.JTextArea Result;
    private javax.swing.JTextArea Text;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
