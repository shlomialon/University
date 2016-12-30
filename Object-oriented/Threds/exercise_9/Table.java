import java.util.ArrayList;

/**
 * Created by Shlomi Alon on 30/12/2016.
 */
public class Table extends Thread{

    private ArrayList<Player> players;
    private int num;
    private boolean isGame = false;

    Table(int num){
        players = new ArrayList<>();
        this.num = num;
        for (int i = 0; i < num; i++){
            Player p = new Player(i+1);
            players.add(p);
        }
        isGame = true;
    }

    @Override
    public void run() {
        if (!players.isEmpty()) {
            while(isGame){
                for (int i = 0; i < num; i++) {
                    players.get(i).run();
                }
            }
        }
    }
        void finishGame(){
        isGame = false;
        this.stop();
    }
}
