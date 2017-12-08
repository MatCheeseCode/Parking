package Parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ParkingList {

    private List<Vehicle> vehicleList;
    private Scanner scanner;

    private int cash;

    public ParkingList(){
        vehicleList = new ArrayList<>();
        scanner = new Scanner(System.in);
        fillStartList();
    }

    public void addCarToVehicleList(){
        vehicleList.add(new Car (vehicleList.size() + 1, true));
    }
    public void addTruckToVehicleList(){
        vehicleList.add(new Truck (vehicleList.size() + 1, true));
    }
    public void addMotorToVehicleList(){
        vehicleList.add(new Motor (vehicleList.size() + 1, true));
    }

    public void showFreePlaces(){
        int freeCarPlaces = 0;
        int freeTruckPlaces = 0;
        int freeMotorPlaces = 0;
        for(Vehicle vehicle : vehicleList){
            if(vehicle.getType().equals("Car") && vehicle.isFree() == true){
                freeCarPlaces ++;
            }
            if(vehicle.getType().equals("Parking.Truck") && vehicle.isFree() == true){
                freeTruckPlaces ++;
            }
            if(vehicle.getType().equals("Parking.Motor") && vehicle.isFree() == true){
                freeMotorPlaces ++;
            }
        }
        System.out.println();
        System.out.println("Free car places: " + freeCarPlaces);
        System.out.println("Free truck places: " + freeTruckPlaces);
        System.out.println("Free motor places: " + freeMotorPlaces);
    }
    public void fillStartList(){
        for(int i = 0; i < 50; i++){
            vehicleList.add(new Car(vehicleList.size() +1, true));
        }
        for(int i = 50; i < 80; i++){
            vehicleList.add(new Truck(vehicleList.size() + 1, true));
        }
        for(int i = 80; i < 100; i++){
            vehicleList.add(new Motor(vehicleList.size() + 1, true));
        }
    }

    public void removeVehicle(){
        removeVehicleFromPlace(chooseVehicleMenu());
    }
    public void parkNewVehicle(){
        parkVehicle(chooseVehicleMenu());
    }

    public String chooseVehicleMenu(){
        System.out.println();
        System.out.println("Choose type of vehicle");
        System.out.println("1. Car");
        System.out.println("2. Parking.Truck");
        System.out.println("3. Parking.Motor");
        System.out.println();
        System.out.print("Type your choice: ");
        String choiceTypeMenu = scanner.nextLine();

        return choiceTypeMenu;
    }

    public void parkVehicle(String choiceType){
        int i = 0;
        for(Vehicle vehicleToPark : vehicleList){
            i++;
            if(choiceType.equals("1") && vehicleToPark.getType().equals("Car") && vehicleToPark.isFree() == true){
                vehicleToPark.setFree(false);
                System.out.println("You park car");
                break;
            }
            else if(choiceType.equals("2") && vehicleToPark.getType().equals("Parking.Truck") && vehicleToPark.isFree() == true){
                vehicleToPark.setFree(false);
                System.out.println("You park truck");

                break;
            }
            else if(choiceType.equals("3") && vehicleToPark.getType().equals("Parking.Motor") && vehicleToPark.isFree() == true){
                vehicleToPark.setFree(false);
                System.out.println("You park motor");
                break;
            }
            else if(i == vehicleList.size()){
                System.out.println("Sorry there isn't free places");
            }
        }
    }

    public void removeVehicleFromPlace(String choiceType){
        int i = 0;
        for(Vehicle vehicleToPark : vehicleList){
            i++;
            if(choiceType.equals("1") && vehicleToPark.getType().equals("Car") && vehicleToPark.isFree() == false){
                vehicleToPark.setFree(true);
                System.out.println("You remove car");
                break;
            }
            else if(choiceType.equals("2") && vehicleToPark.getType().equals("Parking.Truck") && vehicleToPark.isFree() == false){
                vehicleToPark.setFree(true);
                System.out.println("You remove truck");
                break;
            }
            else if(choiceType.equals("3") && vehicleToPark.getType().equals("Parking.Motor") && vehicleToPark.isFree() == false){
                vehicleToPark.setFree(true);
                System.out.println("You remove motor");
                break;
            }
            else if(i == vehicleList.size()){
                System.out.println("All places for this vehicle is free");
            }
        }
    }

    public void collectFee(){
        System.out.print("How much do you want to collect from each vehicle: ");
        String howMuchCollectString = scanner.nextLine();

        if(Pattern.matches("[1-9][0]?", howMuchCollectString)){
            int howMuchCollect = Integer.parseInt(howMuchCollectString);
            for(Vehicle vehicle : vehicleList){
                if(vehicle.isFree() == false){
                    this.cash += howMuchCollect;
                }
            }
            System.out.println("You collected fee");
        }else{
            System.out.println("Type only number from 1 to 10");
        }
    }

    public void showCash(){
        System.out.println("Cash: " + cash);
    }

    public void clearParkingList(){
        for(Vehicle vehicle : vehicleList){
            vehicle.setFree(true);
        }
        System.out.println("Parking is clear");
    }

    public void addNewParkingPlace(){
        String typeChoice = chooseVehicleMenu();
        if(typeChoice.equals("1")){
            addCarToVehicleList();
            System.out.println("You added parking place for car");
        }
        else if(typeChoice.equals("2")){
            addTruckToVehicleList();
            System.out.println("You added parking place for truck");
        }
        else if(typeChoice.equals("3")){
            addMotorToVehicleList();
            System.out.println("You added parking place for motor");
        }
        else{
            System.out.println("Wrong choice");
        }
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public String toString() {
        return "Parking.ParkingList{" +
                "vehicleList=" + vehicleList +
                '}';
    }
}
