/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.level_tracker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSaverLevel {

    private static final String FILE_NAME_EXP = "exp.csv";
    private static final String FILE_NAME_LEVEL = "level.csv";

    
    public static void saveExp(int exp) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME_EXP))) {
            bw.write(String.valueOf(exp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void saveLevel(int level) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME_LEVEL))) {
            bw.write(String.valueOf(level)); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static int loadExp() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_EXP))) {
            String line = br.readLine();
            if (line != null) {
                return Integer.parseInt(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("No saved EXP.");
        }
        return 0;
    }

    
    public static int loadLevel() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_LEVEL))) {
            String line = br.readLine();
            if (line != null) {
                return Integer.parseInt(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("No saved Level found. Defaulting to 0.");
        }
        return 0;
    }

}
