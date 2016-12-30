/**
 * Created by Shlomi Alon on 26/12/2016.
 */
public class Player extends  Thread {
    int id;
    String name;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void Play(){
        System.out.println("Player id: " + id + "Player Name: " + this.name);
        try {
            this.sleep(100*(int)Math.random());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Player id: " + id + "Player Name: " + this.name + "Done");
    }

    @Override
    public void run() {
        Play();
        super.run();
    }
}
