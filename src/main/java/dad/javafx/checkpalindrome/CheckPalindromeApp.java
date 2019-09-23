package dad.javafx.checkpalindrome;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindromeApp extends Application{

	private Label answerLabel;
	private Button checkButton;
	private TextField wordText;

	
	@Override
	public void start(Stage primaryStage) throws Exception {

		wordText=new TextField();
		wordText.setPromptText("introduce una palabra");
		wordText.setMaxWidth(150);
		
		checkButton= new Button("Comprobar");
		checkButton.setDefaultButton(true);
		checkButton.setOnAction(e-> onCheckButtonAction(e));
		
		answerLabel=new Label("check palindrome");
		
		VBox root=new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(wordText, checkButton, answerLabel);
		
		
		
		Scene scene=new Scene(root, 320, 200);
		

		primaryStage.setTitle("Comprobador de Palíndromos");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
	private void onCheckButtonAction(ActionEvent e) {
		if(checkPalindrome(wordText.getText()))
			answerLabel.setText("Es Palíndromo");
		else
			answerLabel.setText("No es Palíndromo");

	}
	
	boolean checkPalindrome(String inputString) {
	    boolean ans=true;
	    
	for (int i=0, j=inputString.length()-1; ans && (i<j); i++, j--){
	    if(inputString.charAt(i)!=inputString.charAt(j))
	        ans=false;
	}
	    return ans;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}


}
