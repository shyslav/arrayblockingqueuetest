/**
 * @author Shyshkin Vladyslav on 29.11.16.
 */
public class Svetlofor implements Runnable {
    private long sleepTime = 500;
    private SvetloforEnum currentColor = SvetloforEnum.GREEN;
    private long changeColorTime = 10000;
    private boolean exit = false;
    public enum SvetloforEnum{
        RED,
        YELLOW,
        GREEN,
    }

    @Override
    public void run() {
        long timeStart = System.currentTimeMillis();
        while (!exit){
            if(System.currentTimeMillis()-timeStart > changeColorTime){
                timeStart = System.currentTimeMillis();
                switchColor();
            }
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Switch color
     */
    private void switchColor(){
        if (currentColor==SvetloforEnum.GREEN){
            currentColor = SvetloforEnum.YELLOW;
        }else if(currentColor == SvetloforEnum.YELLOW){
            currentColor = SvetloforEnum.RED;
        }else if(currentColor==SvetloforEnum.RED){
            currentColor = SvetloforEnum.GREEN;
        }
        System.out.println("Svitlofor changed color to " + currentColor.toString());
    }

    /**
     * Check if car can drive
     * @return true if can
     */
    public boolean canDrive(){
        return currentColor == SvetloforEnum.GREEN;
    }
}
