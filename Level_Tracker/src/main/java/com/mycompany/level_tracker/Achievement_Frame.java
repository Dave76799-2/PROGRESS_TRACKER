/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.level_tracker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Achievement_Frame extends javax.swing.JFrame {

    private static final String FILE_NAME = "achievement.csv";
    String[] achievementList = {"Level_10.png", "Level_25.png", "Level_50.png", "Mission_1.png", "Mission_10.png",
        "Mission_25.png", "achievement 7", "achievement 8", "achievement 9"};

    String[] savedAchievementArray = {"Level_10.png", "Level_25.png", "Level_50.png", "Mission_1.png", "Mission_10.png",
        "Mission_25.png", "achievement 7", "achievement 8", "achievement 9"};

    String[] iconDescription = {"Reach level 10!", "Reach level 25!", "Reach level 50!", "Finished 1 mission!", "Finished 10 missions!",
        "Finished 25 missions!", "desc 7", "desc 8", "desc 9"};

    int iconNum;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Achievement_Frame.class.getName());

    public Achievement_Frame() {
        initComponents();
    }

    public Achievement_Frame(int num) {
        initComponents();
        List<String> loader = loadAchievement(); //loader for achievements csv
        savedAchievementArray = loader.toArray(new String[0]);
        claimChecker(savedAchievementArray[num]);
        setFrameDisplay(num);
        if (!checkIfClaimable(iconNum)) {
            jButton1.setText("Claim");
            jButton1.setEnabled(false);
        }
        setLocationRelativeTo(null);
    }

    public void setFrameDisplay(int iconNum) {
        this.iconNum = iconNum;
        String iconAddress = achievementList[iconNum];

        jLabel1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\Images\\" + iconAddress));
        jLabel2.setText(iconDescription[iconNum]);
    }

    public static void saveAchievement(String[] achievementAddress) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String achievement : achievementAddress) {
                bw.write(achievement);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> loadAchievement() {
        List<String> achievementAddress = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                achievementAddress.add(line);
            }
        } catch (IOException e) {
            System.out.println("No saved missions found.");
        }
        return achievementAddress;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ACHIEVEMENT");
        setMinimumSize(new java.awt.Dimension(205, 215));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\Images\\Missions.png"));
        jLabel1.setText("photo");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 100));

        jLabel2.setBackground(new java.awt.Color(255, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("description");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 170, 50));

        jButton1.setBackground(new java.awt.Color(0, 204, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Claim");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        savedAchievementArray[iconNum] = "claimed";
        saveAchievement(savedAchievementArray);

        jButton1.setText("Claimed");
        jButton1.setEnabled(false);
        
        Functions.exp += 5  ;
        FileSaverLevel.saveExp(Functions.exp);
        
        revalidate();
        repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static boolean checkIfClaimable(int iconNum) {
        boolean claimable = false;
        int missionCount = FileSaverLevel.loadMissionCount();
        System.out.print(missionCount);
        switch (iconNum) {
            case 0:
                claimable = (Functions.level >= 10);
                break;
            case 1:
                claimable = (Functions.level >= 25);
                break;
            case 2:
                claimable = (Functions.level >= 50);
                break;

            case 3:
                claimable = (missionCount > 0);
                break;
            case 4:
                claimable = (missionCount >= 10);
                break;
            case 5:
                claimable = (missionCount >= 25);
                break;

//            case 6:
//                claimable = (Functions.other >= X);
//                break;
//            case 7:
//                claimable = (Functions.other >= Y);
//                break;
//            case 8:
//                claimable = (Functions.other >= Z);
//                break;
        }

        return claimable;
    }

    public void claimChecker(String s) {
        if (s.equals("claimed")) {
            jButton1.setText("Claimed");
            jButton1.setEnabled(false);
        }
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        saveAchievement(savedAchievementArray);
        Frame4 f4 = new Frame4();
        f4.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    //String[] iconAddress = {//name sa photo sa achievement/s};
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Achievement_Frame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
