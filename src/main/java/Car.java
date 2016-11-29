import java.util.Random;

/**
 * @author Shyshkin Vladyslav on 29.11.16.
 */
public class Car {
    private String model;
    private int carNumber;

    public Car(String model, int carNumber) {
        this.model = model;
        this.carNumber = carNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public static Car generateRandomCarWithNumber(int number){
        String [] cars = {"BMW","NISSAN","AUDI","FORD"};
        Random random = new Random();
        return new Car(cars[random.nextInt(cars.length-1)],number);
    }
}
