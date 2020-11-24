package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {

	@FXML
	private TextField inputField;

	@FXML
	private ListView<String> listView;
	private ObservableList<String> wordList = FXCollections.observableArrayList("");

	@FXML
	public void initialize() {
		listView.setItems(wordList);
	}

	@FXML
	public void addWordToList(){
		String word = inputField.getText();
		if (!word.isBlank()){
			listView.getItems().add(word);
		}
		inputField.setText("");
	}

	@FXML
	public void exit(){
		System.exit(0);
	}
}
