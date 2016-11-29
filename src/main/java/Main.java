/**
 * @author Shyshkin Vladyslav on 29.11.16.
 */
public class Main {
    public final Svetlofor svetlofor = new Svetlofor();
    public final Road road = new Road(svetlofor);

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        //initialize first 10 car
        Thread svetlofor = new Thread(main.svetlofor);
        Thread road = new Thread(main.road);
        svetlofor.start();
        road.start();
    }
}
