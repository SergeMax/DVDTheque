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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import sample.BDDManager;

import java.io.File;
import java.util.ArrayList;


public class ViewAjoutFilm {

    private final Menu model;
    private final BDDManager bdd;
    private Stage primaryStage;
    private VBox root;
    private Label titreFormulaire;
    private TextField areaNomFilm;
    private TextField areaAnneeFilm;
    private TextField areaNote;
    private TextArea areaResumeFilm;
    private Button areaImageFilm;
    private TextField areaRealisateurNom;
    private Label nomFilm;
    private Label anneeFilm;
    private Label noteFilm;
    private Label resumeFilm;
    private Label imageFilm;
    private Label nomRealisateur;
    private Button buttonValider;
    private Label nationaliteFilm;
    private TextField areaNationalite;
    private Button buttonRetourListe;
    private ImageView imageDvd;
    private FileChooser directoryRef;
    private HBox imageBox;
    private ImageView imagePrev = null;
    private Label label;
    private ChoiceBox<Integer> choiceBox;
    private ComboBox<String> choiceBoxAuteur;
    private Label labelRealisateur;
    private Button buttonValiderAuteur;
    private TextField areaRealisateurPrenom;
    private HBox hboxRealisateur;
    private HBox hboxNationalite;
    private ComboBox<String> choiceBoxNation;
    private Button buttonValiderNation;
    private BDDManager bdd2;
    private HBox hboxAnneeGenre;
    private TextField areaGenre;
    private Label genre;
    private Button buttonValiderGenre;
    private ComboBox choiceBoxGenre = new ComboBox();
    private String cheminFIchier;


    public ViewAjoutFilm(Menu model, VBox vb) {

        bdd = new BDDManager();
        bdd.start();

        this.root = vb;
        this.model = model;

        init();

        setVueCompleteAjout();

    }

    public void init() {
        initChoiceNationalite();
        initTitreFormulaire();
        initAreaNomFilm();
        initAreaAnneeFilm();
        initareaNote();
        initAreaResumeFilm();
        initAreaImageFilm();
        initAreaRealisateurNom();
        initAreaRealisateurPrenom();
        initButtonValiderAuteur();
        initChoiceReal();
        initHboxRealisateur();
        initAnneeFilm();

        initChoiceGenre();
        initAreaGenre();
        initGenre();
        initButtonValiderGenre();
        initHboxAnneGenre();


        initAreaNationalite();
        initButtonValiderNation();
        initChoiceNationalite();
        initHboxNationalite();

        initButtionDirectory();
        initButtonValider();
        initButtonRetourListe();
        initImageDvd();

        initNomFilm();

        initNoteFilm();
        initResumeFilm();
        initImageFilm();
        initRealisateur();
        initNationalite();

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
        anneeFilm.setFont(Font.font("Amble CN", 15));
    }

    private void initNoteFilm() {
        noteFilm = new Label("Note");
        noteFilm.setFont(Font.font("Amble CN", 15));
    }

    private void initGenre() {
        genre = new Label("Genre");
        genre.setFont(Font.font("Amble CN", 15));
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
        Integer note2 = 2;
        Integer note3 = 3;
        Integer note4 = 4;
        Integer note5 = 5;

        label = new Label("Note du film :");

        ObservableList<Integer> listeNote //
                = FXCollections.observableArrayList(note1, note2, note3, note4, note5);

        choiceBox = new ChoiceBox<Integer>(listeNote);
    }

    public void initChoiceReal() {

        bdd2 = new BDDManager();
        bdd2.start();

        ArrayList<ArrayList<String>> requeteRealisateur = bdd2.ask("SELECT Nom_Realisateur, Prenom_Realisateur  FROM DVDTHEQUE.Realisateur;");

        ArrayList<String> arrayNomPrenomAuteur = new ArrayList<>();

        for (int l = 0; l < requeteRealisateur.size(); l++) {

            String nomAuteur = requeteRealisateur.get(l).get(0);
            String prenomAteur = requeteRealisateur.get(l).get(1);
            String concatene = nomAuteur + " " + prenomAteur;
            arrayNomPrenomAuteur.add(concatene);
        }
        System.out.println(arrayNomPrenomAuteur);

        labelRealisateur = new Label("Realisateur label:");
        ObservableList<String> arraySelectAuteur //
                = FXCollections.observableArrayList(arrayNomPrenomAuteur);

        ComboBox<String> choiceBox = new ComboBox<>(FXCollections.observableArrayList("item 1", "item 2"));

        choiceBoxAuteur = new ComboBox<String>(arraySelectAuteur);
        choiceBoxAuteur.setMinWidth(380);

    }

    public void initChoiceNationalite() {

        ArrayList<ArrayList<String>> requeteNationalite = bdd.ask("SELECT Libelle_Nationnalite  FROM DVDTHEQUE.Nationnalite;");

        ArrayList<String> arrayNationalite = new ArrayList<>();

        for (int l = 0; l < requeteNationalite.size(); l++) {
            String nationalite = requeteNationalite.get(l).get(0);
            arrayNationalite.add(nationalite);
        }

        ObservableList<String> arrayNatio = FXCollections.observableArrayList(arrayNationalite);

        choiceBoxNation = new ComboBox<>(arrayNatio);
        choiceBoxNation.setMinWidth(380);
    }

    public void initChoiceGenre() {

        ArrayList<ArrayList<String>> requeteGenre = bdd.ask("SELECT Libelle_Genre  FROM DVDTHEQUE.Genre;");
        System.out.println(requeteGenre);
        ArrayList<String> arrayGenre = new ArrayList<>();

        for (int l = 0; l < requeteGenre.size(); l++) {
            String nationalite = requeteGenre.get(l).get(0);
            arrayGenre.add(nationalite);
        }

        System.out.println(arrayGenre + "kkll");

        ObservableList<String> arrayNatio = FXCollections.observableArrayList(arrayGenre);

        choiceBoxGenre = new ComboBox(arrayNatio);

        choiceBoxGenre.setMinWidth(200);

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

    private void initButtionDirectory() {

        imageBox = new HBox();
        areaImageFilm = new Button("Chercher l'image.");
        imageBox.getChildren().addAll(areaImageFilm);
        areaImageFilm.setMinWidth(100);
        areaImageFilm.setOnMouseClicked((e) -> {


            initAreaImageFilm();

            directoryRef = new FileChooser();
            // directoryRef.setInitialDirectory(new File("C:/Projet Java/DVDTheque/src/assets/image"));
            directoryRef.setInitialDirectory(new File("C:/Users/p1900110/IdeaProjects/DVDTheque/src/assets/image"));

            File file = directoryRef.showOpenDialog(primaryStage);
            cheminFIchier = file.getPath();
            cheminFIchier = System.getProperty("user.dir");

            System.out.println(cheminFIchier);

            cheminFIchier = new File(cheminFIchier).toURI().relativize(file.toURI()).getPath();

            cheminFIchier = cheminFIchier.replace("src/", "");
            areaImageFilm.setText(cheminFIchier);


            Image ne = new Image("" + cheminFIchier);

            System.out.println(imagePrev + " sout imageprev");
            System.out.println(ne + " sout ne");


            if (imagePrev == null) {
                imagePrev = new ImageView("" + cheminFIchier);
            } else {
                imagePrev.setImage(ne);
            }


            imagePrev.setFitWidth(60);
            imagePrev.setPreserveRatio(true);
            imagePrev.setTranslateX(40);
            imagePrev.setTranslateY(-25);


            initEditZoneImage(cheminFIchier);


        });

    }

    public void initEditZoneImage(String cheminFIchier) {
        areaImageFilm.setText(cheminFIchier);

        Image ne = new Image("" + cheminFIchier);

        if (imagePrev == null) {
            imagePrev = new ImageView("" + cheminFIchier);
        } else {
            imagePrev.setImage(ne);
        }


        imagePrev.setFitWidth(60);
        imagePrev.setPreserveRatio(true);
        imagePrev.setTranslateX(40);
        imagePrev.setTranslateY(-25);

        imageBox.getChildren().remove(imagePrev);


        root.getChildren().remove(imageFilm);
        root.getChildren().remove(imageBox);
        root.getChildren().remove(nomRealisateur);
        root.getChildren().remove(hboxRealisateur);
        root.getChildren().remove(nationaliteFilm);
        root.getChildren().remove(hboxNationalite);
        root.getChildren().remove(buttonValider);
        root.getChildren().remove(buttonRetourListe);


        root.getChildren().add(imageFilm);
        imageBox.getChildren().add(imagePrev);
        root.getChildren().add(imageBox);
        root.getChildren().add(nomRealisateur);
        root.getChildren().add(hboxRealisateur);
        root.getChildren().add(nationaliteFilm);
        root.getChildren().add(hboxNationalite);
        root.getChildren().add(buttonValider);
        root.getChildren().add(buttonRetourListe);

    }

    private void initAreaImageFilm() {
    }

    private void initHboxRealisateur() {
        hboxRealisateur = new HBox();
        hboxRealisateur.getChildren().addAll(choiceBoxAuteur, areaRealisateurNom, areaRealisateurPrenom, buttonValiderAuteur);
        hboxRealisateur.setSpacing(30);
    }

    private void initHboxNationalite() {
        hboxNationalite = new HBox();
        hboxNationalite.getChildren().addAll(choiceBoxNation, areaNationalite, buttonValiderNation);
        hboxNationalite.setSpacing(30);
    }

    private void initButtonValiderAuteur() {
        buttonValiderAuteur = new Button();
        buttonValiderAuteur.setText("Ajouter un réalisateur");
    }

    private void initButtonValiderNation() {
        buttonValiderNation = new Button();
        buttonValiderNation.setText("Ajouter une nationalité");

    }

    private void initButtonValiderGenre() {
        buttonValiderGenre = new Button();
        buttonValiderGenre.setText("Ajouter un genre");

    }

    private void initAreaRealisateurNom() {
        areaRealisateurNom = new TextField("Nom");
        areaRealisateurNom.setMinWidth(100);
    }

    private void initHboxAnneGenre() {
        hboxAnneeGenre = new HBox();
        hboxAnneeGenre.getChildren().addAll(anneeFilm, areaAnneeFilm, genre, choiceBoxGenre, areaGenre, buttonValiderGenre);
        hboxAnneeGenre.setSpacing(30);
    }

    private void initAreaGenre() {
        areaGenre = new TextField("Genre");
        areaGenre.setMinWidth(100);
    }

    private void initAreaRealisateurPrenom() {
        areaRealisateurPrenom = new TextField("Prénom");
        areaRealisateurPrenom.setMinWidth(100);
    }

    private void initAreaNationalite() {
        areaNationalite = new TextField("Nouvelle nationalité");
        areaNationalite.setMinWidth(120);
    }

    private void initButtonValider() {
        buttonValider = new Button();
        buttonValider.setText("Ajouter le film");
        buttonValider.setTranslateY(30);

    }

    private void initButtonRetourListe() {
        buttonRetourListe = new Button();
        buttonRetourListe.setText("Retour a la liste");
        buttonRetourListe.setTranslateX(800);
        buttonRetourListe.setTranslateY(-5);

    }

    public ChoiceBox<Integer> getChoiceBox() {
        return choiceBox;
    }

    public void setVueCompleteAjout() {
        root.getChildren().clear();
        root.getChildren().add(imageDvd);
        root.getChildren().add(titreFormulaire);
        root.getChildren().add(nomFilm);
        root.getChildren().add(areaNomFilm);
        root.getChildren().add(hboxAnneeGenre);
        root.getChildren().addAll(label, choiceBox);
        root.getChildren().add(resumeFilm);
        root.getChildren().add(areaResumeFilm);
        root.getChildren().add(imageFilm);
        root.getChildren().add(imageBox);
        root.getChildren().add(nomRealisateur);
        root.getChildren().add(hboxRealisateur);
        root.getChildren().add(nationaliteFilm);
        root.getChildren().add(hboxNationalite);
        root.getChildren().add(buttonValider);
        root.getChildren().add(buttonRetourListe);
    }

    public void setEvents(Controler ajout) {
        buttonValider.setOnMouseClicked(ajout);
        buttonRetourListe.setOnMouseClicked(ajout);
        buttonValiderAuteur.setOnMouseClicked(ajout);
        buttonValiderNation.setOnMouseClicked(ajout);
        buttonValiderGenre.setOnMouseClicked(ajout);

    }

    public TextField getAreaGenre() {
        return areaGenre;
    }

    public Button getButtonValiderGenre() {
        return buttonValiderGenre;
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

    public TextField getAreaRealisateurNom() {
        return areaRealisateurNom;
    }

    public TextField getNationaliteFilm() {
        return areaNationalite;
    }

    public Button getButtonRetourListe() {
        return buttonRetourListe;
    }

    public ComboBox<String> getChoiceBoxAuteur() {
        return choiceBoxAuteur;
    }

    public Button getButtonValiderAuteur() {
        return buttonValiderAuteur;
    }

    public TextField getAreaRealisateurPrenom() {
        return areaRealisateurPrenom;
    }

    public ComboBox<String> getChoiceBoxNation() {
        return choiceBoxNation;
    }

    public Button getButtonValiderNation() {
        return buttonValiderNation;
    }

    public Label getTitreFormulaire() {
        return titreFormulaire;
    }

    public String getCheminFIchier() {
        return cheminFIchier;
    }

    public VBox getRoot() {
        return root;
    }


}
