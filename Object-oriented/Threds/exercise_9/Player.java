/**
 * Created by Shlomi Alon on 30/12/2016.
 */
public class Player extends Thread{
    private int id;

    Player(int id){
        this.id = id;
    }

    private void Play(){
        System.out.println("Player number: " + id);
        int r = (int)(Math.random()*1000);
        try {
            sleep(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        Play();
        super.run();
    }
}
