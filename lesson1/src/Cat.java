public class Cat implements Run, Jump{
	private String name;
	private int heightJump;
	private int lenghtRun;

	public Cat(String name, int heightJump, int lenghtRun){
		this.name = name;
		this.heightJump = heightJump;
		this.lenghtRun = lenghtRun;
	}
	public String getName() {
		return name;
	}
	public int getHeightJump() {
		return heightJump;
	}
	public int getLenghtRun() {
		return lenghtRun;
	}
	public void running(){
		System.out.println(name + " смог пробежать");
	}
	public void notRunning(){ System.out.println (name + " не смог пробежать");}

	public void jumping(){
		System.out.println(name + " смог перепрыгнуть");
	}
	public void notJumping(){ System.out.println(name + " не смог перепрыгнуть"); }
}
