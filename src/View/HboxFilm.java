package View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class HboxFilm {

    private ImageView imageFilm;
    private HBox hBox;
    private ImageView imageViewBack;
    private final Background focusBackground = new Background( new BackgroundFill( Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY ) );


    public HboxFilm(String image){
        //System.out.println(image);
        imageFilm = new ImageView(image);

        imageFilm.setFitWidth(200);
        imageFilm.setTranslateY(2);
        imageFilm.setPreserveRatio(true);
        this.hBox =new HBox();
        this.hBox.setPrefWidth(600);
        this.hBox.getChildren().addAll(imageFilm);

        hBox.setBackground(focusBackground);
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.setSpacing(20);
        hBox.setTranslateY(0);
        hBox.setMaxWidth(890);
        hBox.setMinWidth(890);





    }

    public HBox gethBox() {
        return hBox;
    }

    public ImageView getImageViewBack() {
        return imageViewBack;
    }
}
