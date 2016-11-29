import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Shyshkin Vladyslav on 29.11.16.
 */
public class Road implements Runnable {
    private final ArrayBlockingQueue<Car> blockingQueue = new ArrayBlockingQueue<>(100);
    private boolean exit = false;
    private int currentNumber = 1;
    private final Svetlofor svetlofor;

    public Road(Svetlofor svetlofor) {
        this.svetlofor = svetlofor;
    }

    @Override
    public void run() {
        //generate car
        Thread thread = new Thread(() -> {
            try {
                while (!exit) {
                    Random random = new Random();
                    Car car = Car.generateRandomCarWithNumber(currentNumber++);
                    blockingQueue.put(car);
                    System.out.println("Added new car to queue " + car.getCarNumber() + " " + car.getModel());
                    Thread.sleep(random.nextInt(5000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            initializeCar();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        while (!exit) {
            if (svetlofor.canDrive()){
                Car car = blockingQueue.poll();
                if(car!=null) {
                    System.out.println("Car " + car.getModel() + " " + car.getCarNumber() + " travaled");
                }
            }
            //drive time
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public void initializeCar() throws InterruptedException {
        for (int i = currentNumber; i < 10; i++) {
            blockingQueue.put(Car.generateRandomCarWithNumber(i));
            currentNumber = i;
        }
    }
}
