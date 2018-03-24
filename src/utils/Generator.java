/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Cátia
 */
public class Generator {
    
    public static void main(String[] args) throws IOException {
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("routes.txt", true));
        
        for(int i = 1; i <= 159; i++){
            //each city has 5 routes
            //first route
            int randomNumberForCity = ThreadLocalRandom.current().nextInt(1, 159);
            int time = ThreadLocalRandom.current().nextInt(1, 200);
            int cost = ThreadLocalRandom.current().nextInt(1, 200);
            writer.append(i + ";" + randomNumberForCity + ";" + time + ";" + cost);
            writer.newLine();
            
            //second route
            randomNumberForCity = ThreadLocalRandom.current().nextInt(1, 159);
            time = ThreadLocalRandom.current().nextInt(1, 200);
            cost = ThreadLocalRandom.current().nextInt(1, 200);
            writer.append(i + ";" + randomNumberForCity + ";" + time + ";" + cost);
            writer.newLine();
            
            //third route
            randomNumberForCity = ThreadLocalRandom.current().nextInt(1, 159);
            time = ThreadLocalRandom.current().nextInt(1, 200);
            cost = ThreadLocalRandom.current().nextInt(1, 200);
            writer.append(i + ";" + randomNumberForCity + ";" + time + ";" + cost);
            writer.newLine();
            
            //fourth route
            randomNumberForCity = ThreadLocalRandom.current().nextInt(1, 159);
            time = ThreadLocalRandom.current().nextInt(1, 200);
            cost = ThreadLocalRandom.current().nextInt(1, 200);
            writer.append(i + ";" + randomNumberForCity + ";" + time + ";" + cost);
            writer.newLine();
            
            //fifth route
            randomNumberForCity = ThreadLocalRandom.current().nextInt(1, 159);
            time = ThreadLocalRandom.current().nextInt(1, 200);
            cost = ThreadLocalRandom.current().nextInt(1, 200);
            writer.append(i + ";" + randomNumberForCity + ";" + time + ";" + cost);
            writer.newLine();
            
        }

        writer.flush();
        writer.close();
    }
}
