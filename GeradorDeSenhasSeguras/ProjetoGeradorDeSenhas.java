import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.security.SecureRandom;
import java.util.Scanner;

public class ProjetoGeradorDeSenhas extends Application{
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%&*()_+-=[]|,./?<>";

	public static String generatePassword(int length){
		SecureRandom randowPasswordGenerator = new SecureRandom();
		StringBuilder password = new StringBuilder(length);

		for (int i = 0; i < length; i++){
			int index = randowPasswordGenerator.nextInt(CHARACTERS.length());
			password.append(CHARACTERS.charAt(index));
		}

		return password.toString();
	}

	@Override
	public void start(Stage palco) {
		palco.setTitle("Gerador de Senhas");

		Label label = new Label("Tamanho da senha: ");
		TextField passwordLengthField = new TextField();
		passwordLengthField.setText("8");
		passwordLengthField.setStyle("-fx-text-fill: green; -fx-background-color: black");

		Label generatedPassword = new Label("Senha gerada");
		TextField passwordGeneratedField = new TextField();
		passwordGeneratedField.setEditable(false);
		passwordGeneratedField.setStyle("-fx-text-fill: green; -fx-background-color: black");

		Button generatePasswordButton = new Button("Gerar senha");
		generatePasswordButton.setOnAction(e ->{
			try{
				int passwordLength = Integer.parseInt(passwordLengthField.getText());
				String password = ProjetoGeradorDeSenhas.generatePassword(passwordLength);
				passwordGeneratedField.setText(password);
			} catch(NumberFormatException ex){
				passwordGeneratedField.setText("Erro! Digite um número");
			}
		});

		VBox layout = new VBox(label, passwordLengthField, generatePasswordButton, generatedPassword, passwordGeneratedField);
		layout.setSpacing(10);
		layout.setPadding(new Insets(10));

		Scene scene = new Scene(layout, 300, 200);
		palco.setScene(scene);
		palco.show();

	}

	public static void main (String[] args){
		launch(args);
	}
}