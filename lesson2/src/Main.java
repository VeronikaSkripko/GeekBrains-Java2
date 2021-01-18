import java.util.Arrays;
import java.util.zip.DataFormatException;

import static java.lang.System.*;

public class Main {
	public static void main(String[] args) {
		String[][] twoDimArray = {{"7", "0", "1", "2"}, {"7", "0", "1", "2"},
				{"7", "0", "1", "2"},{"7", "0", "1", "2"}};
		try {
			System.out.println(checkArr(twoDimArray));
		} catch (MyArraySizeException e) {
			e.printStackTrace();
		} catch (MyArrayDataException e) {
			e.printStackTrace();
		}
	}
	
	public static int checkArr(String[][] arr)throws MyArraySizeException, MyArrayDataException{
		int x;
		int sum = 0;
		for (int i = 0; i < arr.length; i++){
			if (arr.length != 4) throw new MyArraySizeException();
			for (int j = 0; j < arr[i].length; j++){
				if (arr[i].length != 4) throw new MyArraySizeException();
				try{
					x = Integer.parseInt(arr[i][j]);
				} catch(NumberFormatException e) {
					throw new MyArrayDataException(i, j);
				}
				sum += x;
			}
		}
		return(sum);
	}
}