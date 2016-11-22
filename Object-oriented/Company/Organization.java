<<<<<<< HEAD

import java.util.Arrays;

public class Organization{

	private Worker[] marketing,engineering;
	private Manager[] managers;
	private CEO ceo;

	public Organization(){
		marketing = new Worker[5];
		marketing[0] = new Worker("W1",25,20000);
		marketing[1] = new Worker("W2",26,20000);
		marketing[2] = new Worker("W3",27,20000);
		marketing[3] = new Worker("W4",28,20000);
		marketing[4] = new Worker("W5",29,20000);

		engineering = new Worker[4];
		engineering[0] = new Worker("E1",25,20000);
		engineering[1] = new Worker("E2",26,20000);
		engineering[2] = new Worker("E3",27,20000);
		engineering[3] = new Worker("E4",28,20000);

		managers = new Manager[2];
		managers[0] = new Manager("M1",40,40000);
		managers[1] = new Manager("M2",40,45000);

		for (int i = 0; i < marketing.length; i++) {
			managers[0].addWorker(marketing[i]);
		}
		managers[1] = new Manager("Man2", 11, 6000);
		for (int i = 0; i < engineering.length; i++) {
			managers[1].addWorker(engineering[i]);
		}
		ceo = new CEO("CEO", 1234, 100000);
		for (int i = 0; i < managers.length; i++) {
			ceo.addManager(managers[i]);
		}
	}
	public void printAll() {
		System.out.println(Arrays.toString(marketing));
		System.out.println(Arrays.toString(engineering));
		System.out.println(Arrays.toString(managers));
		System.out.println(ceo);
	}

	public static void main(String[] args) {
		new Organization().printAll();
	}
}
=======

import java.util.Arrays;

public class Organization{

	private Worker[] marketing,engineering;
	private Manager[] managers;
	private CEO ceo;

	public Organization(){
		marketing = new Worker[5];
		marketing[0] = new Worker("W1",25,20000);
		marketing[1] = new Worker("W2",26,20000);
		marketing[2] = new Worker("W3",27,20000);
		marketing[3] = new Worker("W4",28,20000);
		marketing[4] = new Worker("W5",29,20000);

		engineering = new Worker[4];
		engineering[0] = new Worker("E1",25,20000);
		engineering[1] = new Worker("E2",26,20000);
		engineering[2] = new Worker("E3",27,20000);
		engineering[3] = new Worker("E4",28,20000);

		managers = new Manager[2];
		managers[0] = new Manager("M1",40,40000);
		managers[1] = new Manager("M2",40,45000);

		for (int i = 0; i < marketing.length; i++) {
			managers[0].addWorker(marketing[i]);
		}
		managers[1] = new Manager("Man2", 11, 6000);
		for (int i = 0; i < engineering.length; i++) {
			managers[1].addWorker(engineering[i]);
		}
		ceo = new CEO("CEO", 1234, 100000);
		for (int i = 0; i < managers.length; i++) {
			ceo.addManager(managers[i]);
		}
	}
	public void printAll() {
		System.out.println(Arrays.toString(marketing));
		System.out.println(Arrays.toString(engineering));
		System.out.println(Arrays.toString(managers));
		System.out.println(ceo);
	}

	public static void main(String[] args) {
		new Organization().printAll();
	}
}
>>>>>>> 323d3bf833cc672933e09df82e17c05aeb5cb374
