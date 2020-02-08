package View;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HboxFilm {

    private ImageView imageFilm;
    private HBox hBox;
    private ImageView imageViewBack;

    public HboxFilm(String image){
        imageFilm = new ImageView(image);

        imageFilm.setFitWidth(150);
        imageFilm.setPreserveRatio(true);
        this.hBox =new HBox();
        this.hBox.setPrefWidth(400);
        this.hBox.getChildren().addAll(imageFilm);

    }

    public HBox gethBox() {
        return hBox;
    }

    public ImageView getImageViewBack() {
        return imageViewBack;
    }
}
