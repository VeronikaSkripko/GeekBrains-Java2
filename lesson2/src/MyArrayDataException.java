public class MyArrayDataException extends Exception{
	int i;
	int j;
	public MyArrayDataException(int i, int j){
		this.i = i;
		this.j = j;
	}
	@Override
	public void printStackTrace() {
		System.out.println("Ошибка в элементе i[" + this.i + "] " + "j[" + this.j + "]");
	}
}
