

package com.mycompany.simplechildcarescheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleChildCareScheduling{
    
    static class Schedule {
        int id;
        String childName;
        String date;
        String time;
        String activity;
        
        Schedule(int id, String childName, String date, String time, String activity) {
            this.id = id;
            this.childName = childName;
            this.date = date;
            this.time = time;
            this.activity = activity;
        }
    }
    
    static List<Schedule> schedules = new ArrayList<>();
    static int nextId = 1;
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== Simple Child Care Scheduling System ===\n");
        
        while(true) {
            System.out.println("1. Add Schedule");
            System.out.println("2. View All");
            System.out.println("3. Update Schedule");
            System.out.println("4. Delete Schedule");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch(choice) {
                case 1: add(); break;
                case 2: viewAll(); break;
                case 3: update(); break;
                case 4: delete(); break;
                case 5: 
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
    
    static void add() {
        System.out.print("Child's name: ");
        String name = scanner.nextLine();
        
        System.out.print("Date ");
        String date = scanner.nextLine();
        
        System.out.print("Time: ");
        String time = scanner.nextLine();
        
        System.out.print("Activity: ");
        String activity = scanner.nextLine();
        
        Schedule s = new Schedule(nextId++, name, date, time, activity);
        schedules.add(s);
        System.out.println("Added! ID: " + s.id + "\n");
    }
    
    static void viewAll() {
        if(schedules.isEmpty()) {
            System.out.println("No schedules\n");
            return;
        }
        
        for(Schedule s : schedules) {
            System.out.println("ID: " + s.id);
            System.out.println("Child: " + s.childName);
            System.out.println("Date: " + s.date + " at " + s.time);
            System.out.println("Activity: " + s.activity);
            System.out.println("---");
        }
    }
    
    static void update() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        for(Schedule s : schedules) {
            if(s.id == id) {
                System.out.print("New date (DD/MM): ");
                s.date = scanner.nextLine();
                
                System.out.print("New time: ");
                s.time = scanner.nextLine();
                
                System.out.print("New activity: ");
                s.activity = scanner.nextLine();
                
                System.out.println("Updated!\n");
                return;
            }
        }
        System.out.println("ID not found\n");
    }
    
    static void delete() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        for(int i = 0; i < schedules.size(); i++) {
            if(schedules.get(i).id == id) {
                schedules.remove(i);
                System.out.println("Deleted!\n");
                return;
            }
        }
        System.out.println("ID not found\n");
    }
}