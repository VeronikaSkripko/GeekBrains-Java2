import java.util.Arrays;

public class MyRunable implements Runnable{
	private String name;
	private float[] arr;

	public MyRunable(String name, float[] arr) {
		this.name = name;
		this.arr = arr;
	}
	@Override
	public void run() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) *
					Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		}
	}
}
