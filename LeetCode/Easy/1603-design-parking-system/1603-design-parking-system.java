
import java.lang.ScopedValue.Carrier;class ParkingSystem {
    int bigSpot, mediumSpot, smallSpot;

    public ParkingSystem(int big, int medium, int small) {
        this.bigSpot = big;
        this.mediumSpot = medium;
        this.smallSpot = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1 && bigSpot > 0){
            bigSpot--;
            return true;
        }else if (carType == 2 && mediumSpot > 0){
            mediumSpot--;
            return true;
        }else if( carType == 3 && smallSpot > 0){
            smallSpot--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */