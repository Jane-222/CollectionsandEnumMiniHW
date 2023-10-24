/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package collections.and.enums.mini.hw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author zhiya
 */
public class CollectionsAndEnumsMiniHW {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // Initialize a map to store teams and a set to store data
        Map<String, List<String>> teams = new HashMap<>();
        Set<String> data = new HashSet<>();
        
        // Try to read data from a CSV file
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/zhiya/Downloads/MOCK_DATA.csv"))) {
            String line;
            // Read each line of the CSV file and add it to the 'data' set
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            
            System.out.println(e);
            return;// Exit the program if an exception occurs
        }

        // Convert the 'data' set to a list and shuffle it to randomize the order
        List<String> dataList = new ArrayList<>(data);
        Collections.shuffle(dataList);

        // Create 5 teams
        for (int i = 0; i < 5; i++) {
            List<String> team = new ArrayList<>();
            // Assign 20 members to each team
            for (int j = 0; j < 20; j++) {
                if (!dataList.isEmpty()) {
                     // If there's data available, add it to the team and remove from 'dataList'
                    team.add(dataList.remove(0));
                }
            }
              // Assign a name to each team (e.g., "Team 1", "Team 2", etc.) and store it in the 'teams' map
            teams.put("Team " + (i + 1), team); // Assign each team a name
        }

         // Access and print the members of a specific team (e.g., "Team 3")
        List<String> team3 = teams.get("Team 3");
        if (team3 != null) {
            System.out.println("Team 3:");
            for (String row : team3) {
                System.out.println(row);
            }
        }
    }
}



