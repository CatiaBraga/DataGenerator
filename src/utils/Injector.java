/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Cátia
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Injector {
    
    public static void main(String[] args) {
        
        injectUsers();
        injectCities();
        injectRoutes();

    }
    
    
    public static void injectUsers(){

        try(BufferedReader bf = new BufferedReader(new FileReader("users.txt"));
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deliveryservice", "root", "root");){

            while(bf.ready()){
                StringTokenizer st = new StringTokenizer(bf.readLine(), ";");
                String username = st.nextToken();
                int admin = Integer.parseInt(st.nextToken());
                
                try(PreparedStatement stmt = conn.prepareStatement("insert into users(username, is_admin) values (?,?)");){
                    stmt.setString(1, username);
                    stmt.setInt(2, admin);

                    stmt.executeUpdate();
                }
            }

            //auto-commit
            //conn.commit();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(Injector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void injectCities(){

        try(BufferedReader bf = new BufferedReader(new FileReader("cities.txt"));
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deliveryservice", "root", "root");){

            while(bf.ready()){
                StringTokenizer st = new StringTokenizer(bf.readLine(), ";");
                int id = Integer.parseInt(st.nextToken());
                String city = st.nextToken();
                
                try(PreparedStatement stmt = conn.prepareStatement("insert into cities(id, city_name) values (?,?)");){
                    stmt.setInt(1, id);
                    stmt.setString(2, city);

                    stmt.executeUpdate();
                }
            }

            //auto-commit
            //conn.commit();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(Injector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void injectRoutes(){

        try(BufferedReader bf = new BufferedReader(new FileReader("routes.txt"));
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deliveryservice", "root", "root");){

            while(bf.ready()){
                StringTokenizer st = new StringTokenizer(bf.readLine(), ";");
                int origin = Integer.parseInt(st.nextToken());
                int destination = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                
                try(PreparedStatement stmt = conn.prepareStatement("insert into routes(origin, destination, time, cost) values (?,?,?,?)");){
                        //+ " on duplicate key update time=? and cost=?");){
                    stmt.setInt(1, origin);
                    stmt.setInt(2, destination);
                    stmt.setInt(3, time);
                    stmt.setInt(4, cost);
                    //stmt.setInt(5, time);
                    //stmt.setInt(6, cost);

                    stmt.executeUpdate();
                }
            }

            //auto-commit
            //conn.commit();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(Injector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
