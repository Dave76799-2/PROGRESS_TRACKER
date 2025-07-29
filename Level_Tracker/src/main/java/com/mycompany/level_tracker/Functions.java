/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.level_tracker;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Functions {
    static int exp = FileSaverLevel.loadExp();
    static int level = FileSaverLevel.loadLevel();
    
    public static void addExp() {
        exp += 1; 
    }

    public static void saveExpLevel() {
        FileSaverLevel.saveExp(exp);
        FileSaverLevel.saveLevel(level);
    }
    
    public static void updateAll(JLabel JL, JProgressBar JPB) {
        checkLevel();
        saveExpLevel();
        updateLevelText(JL);
        checkProgressBar(JPB);
    }
    
    public static void updateLevelText(JLabel JL) {
        JL.setText("LEVEL: " + level);
    }
    
    public static void checkLevel() {
        if (exp/10 >= 1) {
            level += 1;
            exp %= 10;
        }
    }

    
    public static void checkProgressBar(JProgressBar JPB) {
        int progress = exp % 10;
        JPB.setValue(progress);
    }
    
    
}
