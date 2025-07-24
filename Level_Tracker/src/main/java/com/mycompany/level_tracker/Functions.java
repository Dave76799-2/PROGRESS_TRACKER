/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.level_tracker;

import java.util.List;

public class Functions {
    static int exp = FileSaverLevel.loadExp();
    static int level = FileSaverLevel.loadLevel();
    
    public void addExp() {
        exp += 1; 
    }

    public static void saveExpLevel() {
        FileSaverLevel.saveExp(exp);
        FileSaverLevel.saveLevel(level);
    }
    
    public void checkLevel() {
        if (exp/10 >= 1) {
            level += 1;
            exp %= 10;
        }
    }
    
    
    
}
