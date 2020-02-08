package View;

import Controler.Controler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ViewAjoutFilm {

    private final Menu model;
    private Stage primaryStage;
    private VBox root;
    private Label titreFormulaire ;
    private TextField areaNomFilm;
    private PasswordField areaAnneeFilm;
    private TextField areaNote;
    private TextField areaResumeFilm;
    private TextField areaImageFilm;
    private TextField areaRealisateur;
    private TextField ville;
    private TextField adresseEmail;

    private Label nomFilm;
    private Label anneeFilm;
    private Label  noteFilm;
    private Label resumeFilm;
    private Label imageFilm;
    private Label  nomRealisateur;
    private Label nation;
    private Label  adresseEmailLabel;

    private final Background focusBackground = new Background( new BackgroundFill( Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY ) );


    private String adresseEmail1;



    private Button buttonValider;
    private HboxFilm vboxx;
    private VBox vboxConstruite;
    private VBox boxFilm;

    public ViewAjoutFilm(Menu model, VBox vb) {

        this.root = vb;
        this.model = model;

        initTitreFormulaire();
        initAreaNomFilm();
        initAreaAnneeFilm();
        initareaNote();
        initAreaResumeFilm();
        initAreaImageFilm();
        initAreaRealisateur();
        initButtonValider();

        initNomFilm();
        initAnneeFilm();
        initNoteFilm();
        initResumeFilm();
        initImageFilm();
        initRealisateur();



        setVueCompleteInscription();

        //  initListeImage();
        // initVaisseauxCoin();
     //   setVueCompleteMenu();

    }




    private void initNomFilm() {
        nomFilm = new Label("Titre Film");
        nomFilm.setFont(Font.font("Amble CN", 15));
    }

    private void initAnneeFilm() {
        anneeFilm = new Label("Année Film");
        anneeFilm.setFont(Font.font("Amble CN",15));
    }

    private void initNoteFilm() {
        noteFilm = new Label("Note");
        noteFilm.setFont(Font.font("Amble CN", 15));
    }

    private void initResumeFilm() {
        resumeFilm = new Label("Resumé");
        resumeFilm.setFont(Font.font("Amble CN", 15));
    }

    private void initImageFilm() {
        imageFilm = new Label("Image");
        imageFilm.setFont(Font.font("Amble CN", 15));
    }

    private void initRealisateur() {
        nomRealisateur = new Label("Réalisateur");
        nomRealisateur.setFont(Font.font("Amble CN", 15));
    }





    private void initTitreFormulaire() {
        titreFormulaire = new Label("Ajouter Film");
        titreFormulaire.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
    }


    private void initAreaNomFilm() {
        areaNomFilm = new TextField("");
        areaNomFilm.setMinWidth(120);
    }

    private void initAreaAnneeFilm() {
        areaAnneeFilm = new PasswordField();
        areaAnneeFilm.setMinWidth(120);
    }

    private void initareaNote() {
        areaNote = new TextField("");
        areaNote.setMinWidth(120);

    }

    private void initAreaResumeFilm() {
        areaResumeFilm = new TextField("");
        areaResumeFilm.setMinWidth(120);

    }

    private void initAreaImageFilm() {
        areaImageFilm = new TextField("");
        areaImageFilm.setMinWidth(120);

    }

    private void initAreaRealisateur() {

        areaRealisateur = new TextField("");
        areaRealisateur.setMinWidth(120);

    }

    private void initButtonValider() {
        buttonValider = new Button();
        buttonValider.setText("Ajouter le film");

    }

    public void setVueCompleteInscription() {
        root.getChildren().clear();
        root.getChildren().add(titreFormulaire);

        root.getChildren().add(nomFilm);
        root.getChildren().add(areaNomFilm);

        root.getChildren().add(anneeFilm);
        root.getChildren().add(areaAnneeFilm);

        root.getChildren().add(noteFilm);
        root.getChildren().add(areaNote);

        root.getChildren().add(resumeFilm);
        root.getChildren().add(areaResumeFilm);

        root.getChildren().add(imageFilm);
        root.getChildren().add(areaImageFilm);


        root.getChildren().add(nomRealisateur);
        root.getChildren().add(areaRealisateur);





        root.getChildren().add(buttonValider);
    }

    public void setEvents(Controler inscr) {
        buttonValider.setOnMouseClicked(inscr);

    }




    public Button getButtonValider() {
        return buttonValider;
    }

    public TextField getAreaNomFilm() {
        return areaNomFilm;
    }

    public PasswordField getAreaAnneeFilm() {
        return areaAnneeFilm;
    }

    public TextField getAreaNote() {
        return areaNote;
    }

    public TextField getAreaResumeFilm() {
        return areaResumeFilm;
    }

    public TextField getAreaImageFilm() {
        return areaImageFilm;
    }

    public TextField getAreaRealisateur() {
        return areaRealisateur;
    }

    public TextField getVille() {
        return ville;
    }

    public TextField getAdresseEmail() {
        return adresseEmail;
    }

}
