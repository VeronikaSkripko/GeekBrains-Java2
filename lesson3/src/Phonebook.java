import java.util.ArrayList;

public class Phonebook {
	private ArrayList<String> surname = new ArrayList<>();
	private ArrayList<String> phoneNumber = new ArrayList<>();

	public boolean add(ArrayList<String> surname_, ArrayList<String> phoneNumber_){
		if(surname_.size() == phoneNumber_.size()){
			for(int i = 0; i < surname_.size(); i++){
				this.surname.add(surname_.get(i));
				this.phoneNumber.add(phoneNumber_.get(i));
			}
			return true;
		} else {
			return false;
		}
	}
	public ArrayList<String> get(String surname1){
		ArrayList<String> numbers = new ArrayList<>();
		for(int i = 0; i < this.surname.size(); i++){
			if(surname1.equals(this.surname.get(i))){
				numbers.add(this.phoneNumber.get(i));
			}
		}
		return numbers;
	}
}
