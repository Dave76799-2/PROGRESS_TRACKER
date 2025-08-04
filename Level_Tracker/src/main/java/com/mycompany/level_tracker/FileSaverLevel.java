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
    private static final String FILE_NAME_MISSION_COUNT = "missionCount.csv";
    private static final String FILE_NAME_STREAK = "streak.csv";

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

    public static void saveMissionCount(int missionCount) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME_MISSION_COUNT))) {
            bw.write(String.valueOf(missionCount));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveStreak(int postStreak, int workoutStreak, int studyStreak) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME_STREAK))) {
            bw.write(String.valueOf(postStreak));
            bw.newLine();
            bw.write(String.valueOf(workoutStreak));
            bw.newLine();
            bw.write(String.valueOf(studyStreak));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int loadMissionCount() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_MISSION_COUNT))) {
            String line = br.readLine();
            if (line != null) {
                return Integer.parseInt(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("No saved Level found. Defaulting to 0.");
        }
        return 0;
    }

    public static int[] loadStreak() {
        int[] streaks = new int[3];
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_STREAK))) {
            for (int i = 0; i < 3; i++) {
                String line = br.readLine();
                if (line != null) {
                    streaks[i] = Integer.parseInt(line.trim());
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("No saved streak data.");
        }
        return streaks;
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
