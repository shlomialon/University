import com.sun.org.apache.xerces.internal.impl.dv.xs.TypeValidator;

import java.util.ArrayList;

/**
 * Created by Shlomi Alon on 26/12/2016.
 */
public class Table extends Thread {

    ArrayList<Player> players;
    int num;
    boolean isgame = false;

    public Table(int num){
        players = new ArrayList<Player>();
        for (int i = 0; i < num; i++) {
            Player tmp = new Player( i + 1,"");
            players.add(tmp);
        }
        isgame = true;
    }

    @Override
    public void run() {
        if (!players.isEmpty()) {
            while (isgame) {
                for (int i = 0; i < players.size(); i++) {
                    players.get(i).run();
                }
            }
        }
    }

    synchronized public void finishGame(){
        isgame = false;
        System.out.println("game over");
        this.stop();
    }
}
