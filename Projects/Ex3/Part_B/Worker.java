
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
        ArrayList<Worker> workers = new ArrayList<>(5);
        workers.add(new Worker("MakeDough",15000));
        workers.add(new Worker("RollDough",8000));
        workers.add(new Worker("BakePizza",20000));
        workers.add(new Worker("MakeSauce",10000)); //lock
        workers.add(new Worker("AddSauce",3000));//lock

        System.out.println("option: ");
        for (int i = 0; i < workers.size(); i++) {
            System.out.println(i+1 + ": " + workers.get(i).TaskName);
        }

        Thread task;
        int i=0;
        int j=0;

        while(i<=2 || j!=2) {
            System.out.println( '\n' + "Enter task: ");
            Scanner console = new Scanner(System.in);
            String name = console.nextLine();

            if (name.equals("MakeSauce")) {
                if (!workers.get(3).TaskName.equals("done")) {
                    task = new Thread(workers.get(3), workers.get(3).TaskName);
                    task.start();
                    workers.get(3).TaskName = "done";
                    j++;
                } else {
                    if (name.equals("AddSauce"))
                        if (!workers.get(4).TaskName.equals("done")) {
                            task = new Thread(workers.get(4), workers.get(4).TaskName);
                            task.start();
                            workers.get(4).TaskName = "done";
                            j++;
                        } else {
                            if (name.equals(workers.get(i).TaskName))
                                if (!workers.get(i).TaskName.equals("done")) {
                                    if (name.equals("BakePizza") && j != 2) {
                                        System.out.println("try again!");
                                    } else {
                                        task = new Thread(workers.get(i), workers.get(i).TaskName);
                                        task.start();
                                        try {
                                            task.join();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        workers.get(i).TaskName = "done";
                                        i++;
                                    }
                                } else {
                                    System.out.println("try again!");
                                }
                            else {
                                System.out.println("try again!");
                            }
                        }
                    else if (name.equals(workers.get(i).TaskName)) {
                        if (!workers.get(i).TaskName.equals("done")) {
                            if (name.equals("BakePizza") && j != 2) {
                                System.out.println("try again!");
                            } else {
                                task = new Thread(workers.get(i), workers.get(i).TaskName);
                                task.start();
                                try {
                                    task.join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                workers.get(i).TaskName = "done";
                                i++;
                            }
                        } else {
                            System.out.println("try again!");
                        }
                    } else {
                        System.out.println("try again!");
                    }
                }
            } else if (name.equals("AddSauce") && !workers.get(4).TaskName.equals("done")) {
                task = new Thread(workers.get(4), workers.get(4).TaskName);
                task.start();
                workers.get(4).TaskName = "done";
                j++;
            } else if (name.equals(workers.get(i).TaskName)) {
                if (!workers.get(i).TaskName.equals("done")) {
                    if (name.equals("BakePizza") && j != 2)
                        System.out.println("try again!");
                    else {
                        task = new Thread(workers.get(i), workers.get(i).TaskName);
                        task.start();
                        try {
                            task.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        workers.get(i).TaskName = "done";
                        i++;
                    }
                } else {
                    System.out.println("try again!");
                }
            } else {
                System.out.println("try again!");
            }
        }
        System.out.println();
        System.out.println("the pizza is ready! Bon Appetit!");
    }
}


