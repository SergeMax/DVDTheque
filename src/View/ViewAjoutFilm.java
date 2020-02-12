package View;

import Controler.Controler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.File;


public class ViewAjoutFilm {

    private final Menu model;
    private Stage primaryStage;
    private VBox root;
    private Label titreFormulaire ;
    private TextField areaNomFilm;
    private TextField areaAnneeFilm;
    private TextField areaNote;
    private TextArea areaResumeFilm;
    private Button areaImageFilm;
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
    private FileChooser directoryRef;
    private HBox imageBox;
    private ImageView imagePrev = null;
    private FlowPane flowpan;
    private Label label;
    private ChoiceBox<Integer> choiceBox;

    public String getCheminFIchier() {
        return cheminFIchier;
    }

    private String cheminFIchier;

    public void setImagePrev(ImageView imagePrev) {
        this.imagePrev = imagePrev;
    }

    public Label getTitreFormulaire() {
        return titreFormulaire;
    }

    public void setTitreFormulaire(Label titreFormulaire) {
        this.titreFormulaire = titreFormulaire;
    }

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
        initButtionDirectory();
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

    public VBox getRoot() {
        return root;
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
        titreFormulaire.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
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


        Integer note1 = 1;
        Integer note2 =2;
        Integer note3 = 3;
        Integer note4 = 4;
        Integer note5 =5;



       label = new Label("Note du film :");

        ObservableList<Integer> listeNote //
                = FXCollections.observableArrayList(note1, note2, note3, note4, note5);

       choiceBox = new ChoiceBox<Integer>(listeNote);



    }

    private void initAreaResumeFilm() {
        areaResumeFilm = new TextArea("");

        areaResumeFilm.setMinWidth(120);
        areaResumeFilm.setMinHeight(80);
        areaResumeFilm.setMaxHeight(80);


    }

    public ImageView getImagePrev() {
        return imagePrev;
    }

    private void initButtionDirectory(){

        imageBox = new HBox();

        areaImageFilm = new Button("Chercher l'image.");
        imageBox.getChildren().addAll(areaImageFilm);
        areaImageFilm.setMinWidth(100);


        areaImageFilm.setOnMouseClicked((e) -> {


            initAreaImageFilm();

            directoryRef = new FileChooser();

            directoryRef.setInitialDirectory(new File("C:/Users/p1900110/DVDTheque3/src/assets/image"));

            File file = directoryRef.showOpenDialog(primaryStage);
            cheminFIchier = file.getPath();
            cheminFIchier = System. getProperty("user.dir");

            System.out.println(cheminFIchier);

            cheminFIchier = new File(cheminFIchier).toURI().relativize(file.toURI()).getPath();

            cheminFIchier = cheminFIchier.replace("src/", "");
            areaImageFilm.setText(cheminFIchier);



            Image ne = new Image(""+cheminFIchier);

            if (imagePrev == null){
                imagePrev = new ImageView(""+cheminFIchier);
            }else {
                imagePrev.setImage(ne);
            }



            imagePrev.setFitWidth(60);
            imagePrev.setPreserveRatio(true);
            imagePrev.setTranslateX(40);
            imagePrev.setTranslateY(-25);


            root.getChildren().remove(imageBox);

            imageBox.getChildren().remove(imagePrev);

            root.getChildren().remove(nomRealisateur);
            root.getChildren().remove(areaRealisateur);

            root.getChildren().remove(nationaliteFilm);
            root.getChildren().remove(areaNationalite);



            root.getChildren().remove(buttonValider);
            root.getChildren().remove(buttonRetourListe);

            imageBox.getChildren().addAll(imagePrev);

            System.out.println(cheminFIchier);
            root.getChildren().add(imageBox);

            root.getChildren().add(nomRealisateur);
            root.getChildren().add(areaRealisateur);

            root.getChildren().add(nationaliteFilm);
            root.getChildren().add(areaNationalite);



            root.getChildren().add(buttonValider);
            root.getChildren().add(buttonRetourListe);
        });
        // areaImageFilm.setMinWidth(120);
    }

    public void initEditZoneImage(String cheminFIchier){
        initAreaImageFilm();

        areaImageFilm.setText(cheminFIchier);

        Image ne = new Image(""+cheminFIchier);

        if (imagePrev == null){
            imagePrev = new ImageView(""+cheminFIchier);
        }else {
            imagePrev.setImage(ne);
        }



        imagePrev.setFitWidth(60);
        imagePrev.setPreserveRatio(true);
        imagePrev.setTranslateX(40);
        imagePrev.setTranslateY(-25);

        imageBox.getChildren().remove(imagePrev);

        imageBox.getChildren().addAll(imagePrev);

        System.out.println(cheminFIchier);

    }

    private void initAreaImageFilm() {
     //   areaImageFilm = new TextField("deplacer votre image ici");
       // areaImageFilm.setMinWidth(120);







      //  System.out.println(selectedDirectory);

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

    public ChoiceBox<Integer> getChoiceBox() {
        return choiceBox;
    }

    public void setVueCompleteInscription() {
        root.getChildren().clear();

        root.getChildren().add(imageDvd);

        root.getChildren().add(titreFormulaire);

        root.getChildren().add(nomFilm);
        root.getChildren().add(areaNomFilm);

        root.getChildren().add(anneeFilm);
        root.getChildren().add(areaAnneeFilm);

        root.getChildren().addAll(label, choiceBox);


        root.getChildren().add(resumeFilm);
        root.getChildren().add(areaResumeFilm);

        root.getChildren().add(imageFilm);
        root.getChildren().add(imageBox);


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




    public Button getButtonValiderAjoutModif() {
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

    public TextArea getAreaResumeFilm() {
        return areaResumeFilm;
    }

    public Button getAreaImageFilm() {
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

    public HBox getImageBox() {
        return imageBox;
    }
}
