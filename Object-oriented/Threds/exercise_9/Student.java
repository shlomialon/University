import java.util.ArrayList;

/**
 * Created by Shlomi Alon on 30/12/2016.
 */
public class Student extends Thread{
    private int id;
    private Luach board;
    public ArrayList<Integer> students;

    public int sizeStudent(ArrayList<Integer>students){
        return students.size();
    }

    public Student(int id, Luach board){
        this.id = id;
        this.board = board;
        students = new ArrayList<Integer>();
        students.add(id);
    }

    @Override
    public void run() {
        super.run();
    }
}
