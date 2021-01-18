import java.io.PrintWriter;

public class MyArraySizeException extends Exception{
	@Override
	public void printStackTrace() {
		System.out.println("Задан неверный размер массива");
	}
}
