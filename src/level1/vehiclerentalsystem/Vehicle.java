package level1.vehiclerentalsystem;

public class Vehicle {
    private  String vehicleId;
    private String make;
    private String model;
    private int year;
    private double dailyRate;
    private boolean isAvailable;

    Vehicle(String vehicleId , String make, String model , int year,double dailyRate, boolean isAvailable){
        this.vehicleId=vehicleId;
        this.make=make;
        this.model=model;
        this.year=year;
        this.dailyRate=dailyRate;
        this.isAvailable=isAvailable;

    }



    public String getVehicleInfo() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", dailyRate=" + dailyRate +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
