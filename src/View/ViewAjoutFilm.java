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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;



public class ViewAjoutFilm {

    private final Menu model;
    private Stage primaryStage;
    private VBox root;
    private Label titreFormulaire ;
    private TextField areaNomFilm;
    private TextField areaAnneeFilm;
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
    private Label nationaliteFilm;
    private TextField areaNationalite;
    private Text filmAjoute;
    private Button buttonRetourListe;
    private ImageView imgDvd;
    private ImageView imageDvd;

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
        initAreaNationalite();
        initButtonValider();
        initButtonRetourListe();
        initImageDvd();


        initNomFilm();
        initAnneeFilm();
        initNoteFilm();
        initResumeFilm();
        initImageFilm();
        initRealisateur();
        initNationalite();



        setVueCompleteInscription();

        //bdd.edit("INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) VALUES ('ment', 4444, 5, 'ferofk_elrfkeref', 'assets/image/Kill.png', 1, 1);");


        //  initListeImage();
        // initVaisseauxCoin();
     //   setVueCompleteMenu();

    }



    private void initImageDvd() {
        imageDvd = new ImageView("assets/image/DVD.png");
        imageDvd.setPreserveRatio(true);
        imageDvd.setFitHeight(50);
        imageDvd.setTranslateX(420);


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

    private void initNationalite() {
        nationaliteFilm = new Label("Nationalite");
        nationaliteFilm.setFont(Font.font("Amble CN", 15));
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
        areaAnneeFilm = new TextField();
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
        areaImageFilm = new TextField("deplacer votre image ici");
        areaImageFilm.setMinWidth(120);

    }

    private void initAreaRealisateur() {

        areaRealisateur = new TextField("");
        areaRealisateur.setMinWidth(120);

    }

    private void initAreaNationalite() {

        areaNationalite = new TextField("");
        areaNationalite.setMinWidth(120);

    }

    public void initTextFilmBienAjoute() {

        filmAjoute = new Text("Film bien ajouté!");
       }

    private void initButtonValider() {
        buttonValider = new Button();
        buttonValider.setText("Ajouter le film");

    }

    private void initButtonRetourListe() {
        buttonRetourListe = new Button();
        buttonRetourListe.setText("Retour a la liste");
        buttonRetourListe.setTranslateX(800);
        buttonRetourListe.setTranslateY(-35);

    }

    public void setVueCompleteInscription() {
        root.getChildren().clear();

        root.getChildren().add(imageDvd);

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

        root.getChildren().add(nationaliteFilm);
        root.getChildren().add(areaNationalite);



        root.getChildren().add(buttonValider);
        root.getChildren().add(buttonRetourListe);


    }

    public void setEvents(Controler ajout) {
        buttonValider.setOnMouseClicked(ajout);
        buttonRetourListe.setOnMouseClicked(ajout);

    }




    public Button getButtonValider() {
        return buttonValider;
    }

    public TextField getAreaNomFilm() {
        return areaNomFilm;
    }

    public TextField getAreaAnneeFilm() {
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

    public TextField getNationaliteFilm() {
        return areaNationalite;
    }

    public Button getButtonRetourListe() {
        return buttonRetourListe;
    }
}
