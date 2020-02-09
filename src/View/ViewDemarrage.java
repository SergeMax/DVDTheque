package View;

import Controler.Controler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewDemarrage {

    private final Menu model;

    private  VBox vBox;
    private ViewHandler viewHandler;
    private Stage primaryStage;
    private Group root;
    private ImageView imageDvdd;
    private Button buttonDemarer;

    public ViewDemarrage(Menu model, Group vb) {

        this.root = vb;
        this.model = model;

        initImageDvd();
        initButton();

        setVueDemmarrage();

    }

    private void initImageDvd() {
        imageDvdd = new ImageView("assets/image/DVD.png");
        imageDvdd.setPreserveRatio(true);
        imageDvdd.setFitHeight(600);
        imageDvdd.setTranslateX(0);
    }

    private void initButton(){


            buttonDemarer = new Button();
            buttonDemarer.setText("START DVDTHEQUE");
            buttonDemarer.setTranslateY(550);
            buttonDemarer.setTranslateX(530);

        //  buttonAjouterFilm.setTranslateY();


    }

    public void setVueDemmarrage() {
        root.getChildren().clear();
        root.getChildren().add(imageDvdd);
        root.getChildren().add(buttonDemarer);

    }

    public void setEvents(Controler ajout) {

        buttonDemarer.setOnMouseClicked(ajout);

    }

    public Button getButtonDemarer() {
        return buttonDemarer;
    }
}
