import javax.naming.PartialResultException;

public class Main{
	public static void main(String[] args) {

		Object[] participants = {new Human("Vasya", 5, 20),
				new Robot("Robot", 15, 30),
				new Cat("Barsik", 10, 15)};
		Object[] obstacles = {new Road(20), new Wall(200)};

		boolean check;

		for (Object participant : participants) {
			check = true;
			for (Object obstacle : obstacles) {
				if (participant instanceof Human && obstacle instanceof Road && check) {
					if (((Human) participant).getLenghtRun() >= ((Road) obstacle).getLenght()) {
						((Human) participant).running();
					} else {
						((Human) participant).notRunning();
						check = false;
					}
				}
				if (participant instanceof Human && obstacle instanceof Wall && check) {
					if (((Human) participant).getHeightJump() >= ((Wall) obstacle).getHeight()) {
						((Human) participant).jumping();
					} else {
						((Human) participant).notJumping();
						check = false;
					}
				}
				if (participant instanceof Robot && obstacle instanceof Road && check) {
					if (((Robot) participant).getLenghtRun() >= ((Road) obstacle).getLenght()) {
						((Robot) participant).running();
					} else {
						((Robot) participant).notRunning();
						check = false;
					}
				}
				if (participant instanceof Robot && obstacle instanceof Wall && check) {
					if (((Robot) participant).getHeightJump() >= ((Wall) obstacle).getHeight()) {
						((Robot) participant).jumping();
					} else {
						((Robot) participant).notJumping();
						check = false;
					}
				}
				if (participant instanceof Cat && obstacle instanceof Road && check) {
					if (((Cat) participant).getLenghtRun() >= ((Road) obstacle).getLenght()) {
						((Cat) participant).running();
					} else {
						((Cat) participant).notRunning();
						check = false;
					}
				}
				if (participant instanceof Cat && obstacle instanceof Wall && check) {
					if (((Cat) participant).getHeightJump() >= ((Wall) obstacle).getHeight()) {
						((Cat) participant).jumping();
					} else {
						((Cat) participant).notJumping();
						check = false;
					}
				}
			}
		}
	}
}
