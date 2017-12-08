package Parking;

public class Vehicle {

    private String type;
    private int id;
    private boolean isFree;

    public Vehicle(String type, int id, boolean isFree){
        this.type = type;
        this.id = id;
        this.isFree = isFree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
