/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.level_tracker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSaver {

    private static final String FILE_NAME = "missions.csv";

    //Diri save mission
    public static void saveMission(String mission) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(mission);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Diri read missions
    public static List<String> loadMissions() {
        List<String> missions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                missions.add(line);
            }
        } catch (IOException e) {
            System.out.println("No saved missions found.");
        }
        return missions;
    }

    //delete tanan missions
    public static void clearMissions() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeMission(String missionToRemove) {
        List<String> missions = loadMissions();
        
        for (int i = 0; i < missions.size(); i++) {
            if (missions.get(i).equals(missionToRemove)) {
                missions.remove(i);
                break;  
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String mission : missions) {
                bw.write(mission);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
