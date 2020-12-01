import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать сколько раз встречается каждое слово.
 */

public class WordArray {
	public static void main(String[] args) {
		Set<String> unique = new HashSet<>(15);
		Set<String> dupe = new HashSet<>(15);
		ArrayList<String> words = new ArrayList<>(15);

		words.add("France");
		words.add("USA");
		words.add("Turkey");
		words.add("Germany");
		words.add("Norway");
		words.add("Russia");
		words.add("USA");
		words.add("Germany");
		words.add("France");
		words.add("Turkey");
		words.add("Spain");
		words.add("Italy");
		words.add("Sweden");
		words.add("Greece");
		words.add("Turkey");

		for (String s : words) {
			if(!unique.add(s)){
				dupe.add(s);
			}
		}
		unique.removeAll(dupe);

		System.out.println("Unique words:    " + unique);
		System.out.println("Duplicate words: " + dupe);
	}
}
