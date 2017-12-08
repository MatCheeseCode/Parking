package Parking;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private ParkingList parkingList;

    public Menu(){
        scanner = new Scanner(System.in);
        parkingList = new ParkingList();
    }

    public void showMenu(){

        String choice ;

        System.out.println("Hello !");

        do{
            System.out.println();
            System.out.println("1. Show free places");
            System.out.println("2. Park vehicle");
            System.out.println("3. Remove vehicle");
            System.out.println("4. Collect a fee");
            System.out.println("5. Show cash");
            System.out.println("6. Clear parking");
            System.out.println("7. Add new parking place");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Type your choice: ");
            choice = scanner.nextLine();

            switchMenu(choice);

        }while(!choice.equals("0"));{
            System.out.println("Bye !");
        }
    }

    public void switchMenu(String choice){
        switch(choice) {
            case "1":
                parkingList.showFreePlaces();
                break;
            case "2":
                parkingList.parkNewVehicle();
                break;
            case "3":
                parkingList.removeVehicle();
                break;
            case "4":
                parkingList.collectFee();
                break;
            case "5":
                parkingList.showCash();
                break;
            case "6":
                parkingList.clearParkingList();
                break;
            case "7":
                parkingList.addNewParkingPlace();
                break;
        }
    }
}
