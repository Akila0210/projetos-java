import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjetoRelogioDigital extends Application {
	final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Override
	public void start(Stage palco){
		Label time = new Label();
		time.setStyle("-fx-font-size: 24pt; -fx-text-fill: white;");

		KeyFrame keyFrameUpdate = new KeyFrame(Duration.ZERO, e -> {
			time.setText(LocalDateTime.now().format(FORMATTER));
		});

		KeyFrame keyFrameUpdateGap = new KeyFrame(Duration.seconds(1));

		Timeline clock = new Timeline();
		clock.getKeyFrames().addAll(keyFrameUpdate, keyFrameUpdateGap);

		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();

		VBox layout = new VBox(time);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: black;");

		Scene scene = new Scene(layout, 250, 100);

		palco.setTitle("Digital Clock");
		palco.setScene(scene);
		palco.show();
	}
	public static void main (String[] args){
		launch(args);
	}
}