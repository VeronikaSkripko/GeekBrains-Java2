import java.util.Arrays;

/*
1) Создается одномерный длинный массив
2) Заполняют этот массив единицами;
3) Засекают время выполнения: long a = System.currentTimeMillis();
4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле
5) Проверяется время окончания метода System.currentTimeMillis();
6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 */

public class TestThread {

	static final int SIZE = 10000000;
	static final int HALF = SIZE / 2;

	//Первый метод просто бежит по массиву и вычисляет значения.
	public static void firstMethod (){
		float[] arr = new float[SIZE];
		Arrays.fill(arr, 1);
		long a = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) *
					Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		}
		System.out.println("Slow time : " + (System.currentTimeMillis() - a));
	}

	// Второй разбивает массив на два массива, в двух потоках высчитывает новые значения
	// и потом склеивает эти массивы обратно в один.
	// Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
	public static void secondMethod (){
		float[] arr = new float[SIZE];
		float[] arr1 = new float[HALF];
		float[] arr2 = new float[HALF];

		long a = System.currentTimeMillis();

		System.arraycopy(arr, 0, arr1, 0, HALF);
		System.arraycopy(arr, HALF, arr2, 0, HALF);

		Arrays.fill(arr1, 1);
		Arrays.fill(arr2, 1);

		var myRun1 = new MyRunable("Arr1", arr1);
		var myRun2 = new MyRunable("Arr2", arr2);

		Thread t1 = new Thread(myRun1);
		Thread t2 = new Thread(myRun2);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.arraycopy(arr1, 0, arr, 0, HALF);
		System.arraycopy(arr2, 0, arr, HALF, HALF);

		System.out.println("Fast time : " + (System.currentTimeMillis() - a));
	}

	public static void main(String[] args) {
		firstMethod();
		secondMethod();
	}
}
