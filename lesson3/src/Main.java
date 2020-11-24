import java.util.ArrayList;
/*
 Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи.
 С помощью метода get() искать номер телефона по фамилии.
 Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 тогда при запросе такой фамилии должны выводиться все телефоны.
 */
public class Main {
	public static void main(String[] args) {

		Phonebook catalog = new Phonebook();
		ArrayList<String> surname = new ArrayList<String>();
		ArrayList<String> phonenumber = new ArrayList<String>();

		surname.add("Ivanov");
		surname.add("Ivanov");
		phonenumber.add("5487458");
		phonenumber.add("7487458");

		surname.add("Petrov");
		phonenumber.add("8487458");

		surname.add("Sidorov");
		phonenumber.add("9787458");

		catalog.add(surname, phonenumber);

		String whoWanttoFind = "Sid";
		ArrayList<String> numbers = catalog.get(whoWanttoFind);
		for(int i = 0; i < numbers.size(); i++){
			System.out.println(whoWanttoFind + " номер: " + numbers.get(i));
		}
	}
}
