package View;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class HboxFilm {

    private final ViewHandler viewHandler = new ViewHandler();
    private ImageView imageFilm;
    private HBox hBox;
    private ImageView imageViewBack;
    private final Background focusBackground = new Background( new BackgroundFill( Color.MINTCREAM, CornerRadii.EMPTY, Insets.EMPTY ) );
    private ArrayList<Integer> listeId = new ArrayList<>();




    public HboxFilm(String image, ImageView imageFilmm){
        //System.out.println(image);
        imageFilm = new ImageView(image);

        imageFilm.setFitHeight(300);
        imageFilm.setTranslateY(2);
        imageFilm.setPreserveRatio(true);


        imageFilm.setOnMouseClicked(e->{

        });


        this.hBox =new HBox();
        this.hBox.setPrefWidth(600);
        this.hBox.getChildren().addAll(imageFilm);

        hBox.setBackground(focusBackground);
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.setSpacing(20);
        hBox.setTranslateY(0);
        hBox.setMaxWidth(890);
        hBox.setMinWidth(890);
        hBox.setMaxHeight(250);
        this.imageFilm = imageFilmm;




    }

    private void recupIdImageClique() {



    }

    private EventHandler<? super MouseEvent> afficheViewFilm() {

        System.out.printf("imageclique");

        return null;
    }

    public HBox gethBox() {
        return hBox;
    }

    public ImageView getImageViewBack() {
        return imageViewBack;
    }
}
