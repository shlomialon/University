
/**
 * Created by Shlomi Alon on 10/03/2017.
 */
package Part_B;
import java.util.ArrayList;
import java.util.Scanner;

class Worker implements Runnable {
    public String TaskName;
    public long Duration;

    public Worker(String Name,long Duration) {
        this.TaskName=Name;
        this.Duration= Duration;
    }

    public void run(){
        switch (this.TaskName) {
            case "MakeSauce":
                try {
                    Lock1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "AddSauce":
                try {
                    Lock2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println(this.TaskName + " Is Running.");
                try {
                    Thread.sleep(this.Duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.TaskName + " Is Done.");
                break;
        }
    }

    private static final Object Lock1 = new Object();
    private static final Object Lock2 = new Object();

    private void Lock1() throws InterruptedException {
        synchronized (Lock1) {
            System.out.println("MakeSauce: Holding MakeSauce...");
            Thread.sleep(1000);
            synchronized (Lock2) {
                System.out.println("MakeSauce: Holding lock AddSauce...");
            }
        }
    }
    private void Lock2() throws InterruptedException {
        synchronized (Lock2) {
            System.out.println("AddSauce: Holding AddSauce...");
            Thread.sleep(3000);
            synchronized (Lock1) {
                System.out.println("AddSauce: Holding lock MakeSauce...");
            }
        }
    }

    public static void main(String args[]) {
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new Worker("MakeDough",15000));
        workers.add(new Worker("RollDough",8000));
        workers.add(new Worker("BakePizza",20000));
        workers.add(new Worker("MakeSauce",10000)); //lock
        workers.add(new Worker("AddSauce",3000));//lock

        System.out.println("Menu: ");
        for (int index = 0; index < workers.size(); index++) {
            System.out.println(index+1 + ": " + workers.get(index).TaskName);
        }

        Thread thread;
        int i = 0,j = 0;
        while(i < 3 || j != 2) {
            System.out.println( '\n' + "Enter task: ");
            Scanner console = new Scanner(System.in);
            String name = console.nextLine();

            if(name.equals(workers.get(i).TaskName) && !workers.get(i).TaskName.equals("done")){
                if(name.equals("BakePizza") && j != 2){
                    System.out.println("Error in the preparation stages, try again.");
                }
                else{
                    thread = new Thread(workers.get(i),workers.get(i).TaskName);
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    workers.set(i, new Worker( "done",0));
                    i++;
                }
            }
            else if(name.equals("MakeSauce") && !workers.get(3).TaskName.equals("done")){
                thread = new Thread(workers.get(3),workers.get(3).TaskName);
                thread.start();
                workers.set(3, new Worker( "done",0));
                j++;
            }
            else if(name.equals("AddSauce") && !workers.get(4).TaskName.equals("done")){
                thread = new Thread(workers.get(4),workers.get(4).TaskName);
                thread.start();
                workers.set(3, new Worker( "done",0));
                j++;
            }
            else
                System.out.println("We made this step, please try again.");
        }
        System.out.println('\n' + "The pizza is ready!");
    }
}
