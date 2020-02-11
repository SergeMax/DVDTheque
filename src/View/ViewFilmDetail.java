package View;

import Controler.Controler;
import Model.Film;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import sample.BDDManager;
import java.util.ArrayList;
import static javafx.scene.text.FontWeight.BOLD;

public class ViewFilmDetail {

    private final Menu model;
    private final ScrollPane scroll;
    private VBox root;

    private TextField areaRechercheFilm;
    private Text nomFilmT;
    private Text anneeFilmT;
    private Text resumeFilmT;
    private Text noteFilmT;
    private Text nomRealisateurFilmT;
    private Text genreT;

    private Label titrePage;
    private Label RechercheFilm;
    private Label nomFilm;
    private Label anneeFilm;
    private Label noteFilm;
    private Label resumeFilm;
    private Label imageFilm;
    private Label nomRealisateur;
    private Label genre;

    private Film filmAAfficher;

    private Button buttonValiderRecherche;
    private Button buttonRetourListe;
    private Button buttonAjouterFilm;

    private ImageView imageDvd;
    private ArrayList<Button> tableauBtnSupprimer= new ArrayList<>();
    private ArrayList<Button> tableauBtnEditer = new ArrayList<>();;
    private ArrayList<ArrayList<String>> tabgenreString;
    private ArrayList<ArrayList<String>> tabListFilm;

    private BDDManager bdd;

    public ArrayList<ArrayList<String>> getTabListFilm() {
        return tabListFilm;
    }
    public ArrayList<Button> getTableauBtnEditer() {
        return tableauBtnEditer;
    }
    public ViewFilmDetail (Menu model, VBox vb, Film film1) {

        filmAAfficher = new Film();
        this.root = vb;
        this.model = model;
        this.filmAAfficher = film1;

        initTitrePage();

        initImageDvd();

        initButtonAjouterFilm();
        initbuttonRetourListe();



        VBox vboxListe = new VBox();
        vboxListe.maxHeight(1200);
        vboxListe.minWidth(1400);


        vboxListe.setSpacing(100);
        VBox.setMargin(vboxListe, new Insets(100, 100, 20, 100));


        scroll = new ScrollPane();
        scroll.setContent(null);
        scroll.setContent(vboxListe);
        scroll.minWidth(1400);
        scroll.minHeight(1400);
        scroll.setTranslateY(70);

        setVueListFilm();

    }
    private void initImageDvd() {
        imageDvd = new ImageView("assets/image/DVD.png");
        imageDvd.setPreserveRatio(true);
        imageDvd.setFitHeight(50);
        imageDvd.setTranslateX(420);


    }
    public void init(){

        bdd = new BDDManager();

        bdd.start();

        tabListFilm = bdd.ask("SELECT * FROM DVDTHEQUE.Film where Id_film=1;");

        VBox vboxListe = new VBox();
        vboxListe.setSpacing(30);

        tableauBtnSupprimer.clear();
        tableauBtnEditer.clear();


        for (int i=0; i<tabListFilm.size(); i++){


            initNomFilmLabel();
            initAnneeFilmLabel();
            initNoteFilmLabel();
            initResumeFilmLabel();
            initImageLabel();
            initRealisateurLabel();

            initGenreLabel();

            tabgenreString = bdd.ask("SELECT Libelle_Genre FROM DVDTHEQUE.genre " +
                    "WHERE Id_Genre IN " +
                    "(SELECT film_genre.Genre_id FROM DVDTHEQUE.genre " +
                    "INNER JOIN DVDTHEQUE.film_genre ON genre.Id_Genre = film_genre.Film_id " +
                    "INNER JOIN DVDTHEQUE.film ON film_genre.Film_id = film.Id_Film " +
                    "Where Nom_Film = '" + tabListFilm.get(i).get(1) + "')");

            initNomFilm(tabListFilm.get(i).get(1));
            initAnneeFilm(tabListFilm.get(i).get(2));
            initResumeFilm(tabListFilm.get(i).get(3));
            initNoteFilm(tabListFilm.get(i).get(4));

            initRealisateurFilm(tabListFilm.get(i).get(6));
            initNationalite(tabListFilm.get(i).get(7));

            HBox hbox = initBoxFilm(tabListFilm.get(i).get(5), tabgenreString);

            vboxListe.getChildren().add(hbox);

        }

        scroll.setContent(null);

        scroll.setContent(vboxListe);
        scroll.setTranslateX(30);

        setVueListFilm();


    }
    public HBox initVbox(String cheminImage){
        HboxFilm hboxx = new HboxFilm(cheminImage);
        HBox hboxConstruite = hboxx.gethBox();

        return hboxConstruite;
    }

    private void initButtonAjouterFilm() {
        buttonAjouterFilm = new Button();
        buttonAjouterFilm.setText("Ajouter Film");
        buttonAjouterFilm.setTranslateX(830);


    }
    private void initbuttonRetourListe(){
        buttonRetourListe = new Button();
        buttonRetourListe.setText("Retour liste Film");
        buttonRetourListe.setTranslateX(860);
        buttonRetourListe.setTranslateY(50);
    }
    public ArrayList<Button> getTableauBtnSupprimer() {
        return tableauBtnSupprimer;
    }
    public Button getButtonAjouterFilm() {
        return buttonAjouterFilm;
    }

    public void setEvents(Controler ajout) {
        buttonAjouterFilm.setOnMouseClicked(ajout);

        for (int i =0; i<tableauBtnSupprimer.size(); i++) {
            tableauBtnSupprimer.get(i).setOnMouseClicked(ajout);
        }


        for (int i =0; i<tableauBtnSupprimer.size(); i++) {
            tableauBtnEditer.get(i).setOnMouseClicked(ajout);
        }
    }
    private HBox initBoxFilm(String chemin, ArrayList<ArrayList<String>> tabgenreString){

        genreT = new Text("");

        String phraseGenreTotale = "";
        for(int z = 0; z<tabgenreString.size(); z++) {
            phraseGenreTotale += tabgenreString.get(z).get(0) + "\n";
        }


        genreT.setText(phraseGenreTotale);
        genreT.setFont(Font.font("Amble CN", BOLD, 20));


        HboxFilm boxFilm = new HboxFilm(chemin);
        HBox hboxConstruite = boxFilm.gethBox();
        hboxConstruite.setPadding(new Insets(100, 100, 100, 100));
hboxConstruite.setMinWidth(987);



        Font fontTitre = new Font("Sans Serif", 10 );
        Font fontTitreFilm = new Font("Sans Serif", 30 );

        Button buttonEditer = new Button();
        buttonEditer.setText("Editer");
        buttonEditer.setTranslateX(460);
        buttonEditer.setTranslateY(6);
        tableauBtnEditer.add(buttonEditer);


        Button buttonSupprimer = new Button();
        buttonSupprimer.setText("Supprimer");
        buttonSupprimer.setTranslateX(520);
        buttonSupprimer.setTranslateY(-20);

        tableauBtnSupprimer.add(buttonSupprimer);

        ImageView play = new ImageView("assets/image/play.png");

        play.setFitWidth(70);
        play.setTranslateY(32);
        play.setPreserveRatio(true);

        nomFilm.setFont(fontTitre);
        nomFilm.setTranslateY(-12);

        nomFilmT.setTranslateY(-12);

        anneeFilm.setFont(fontTitre);
        noteFilm.setFont(fontTitre);
        resumeFilm.setFont(fontTitre);
        nomRealisateur.setFont(fontTitre);

        nomFilmT.setFont(fontTitreFilm);



        resumeFilm.setTranslateY(0);
        resumeFilmT.setTranslateY(0);

        VBox colonne1 = new VBox();

        colonne1.getChildren().addAll(anneeFilm, anneeFilmT);

        VBox colonne2 = new VBox();
        colonne2.getChildren().addAll(  nomRealisateur, nomRealisateurFilmT);

        VBox colonne3 = new VBox();
        colonne3.getChildren().addAll(  noteFilm, noteFilmT);


        VBox vboxGenre = new VBox();
        vboxGenre.setPrefHeight(150);
        vboxGenre.setMinHeight(150);

        vboxGenre.setPrefWidth(230);
        vboxGenre.setMaxWidth(230);

        VBox.setMargin(vboxGenre, new Insets(0, 0, 0, 100));

        HBox ligne2 = new HBox();

        ligne2.minWidth(150);
        ligne2.setSpacing(30);
        ligne2.getChildren().addAll(colonne1,colonne2,colonne3);

        VBox blocV1DansTeteBloc = new VBox();
        blocV1DansTeteBloc.getChildren().addAll( nomFilm, nomFilmT, ligne2);
        blocV1DansTeteBloc.setMinWidth(380);

        HBox teteBloc = new HBox();

        teteBloc.getChildren().addAll( blocV1DansTeteBloc, vboxGenre);


        vboxGenre.setAlignment(Pos.TOP_RIGHT);



        vboxGenre.getChildren().add(genreT);

        VBox vboxDescription = new VBox();


        vboxDescription.getChildren().addAll(teteBloc, resumeFilm, resumeFilmT,  play, buttonEditer, buttonSupprimer);


        hboxConstruite.getChildren().addAll( vboxDescription);
        hboxConstruite.setMaxHeight(250);
        hboxConstruite.setPrefHeight(250);
        VBox.setMargin(hboxConstruite, new Insets(0, 0, 0, -40));

        return hboxConstruite ;
    }
    private void initNomFilmLabel() {
        nomFilm = new Label("Titre");
        nomFilm.setFont(Font.font("Amble CN", 15));
    }
    private void initAnneeFilmLabel() {
        anneeFilm = new Label("Annee");
        anneeFilm.setFont(Font.font("Amble CN",15));
    }
    private void initNoteFilmLabel() {
        noteFilm = new Label("Note");
        noteFilm.setFont(Font.font("Amble CN", 15));
    }
    private void initResumeFilmLabel() {
        resumeFilm = new Label("Resume");
        resumeFilm.setFont(Font.font("Amble CN", 15));
    }

    private void initImageLabel() {
        imageFilm = new Label("Image Chemin");
        imageFilm.setFont(Font.font("Amble CN", 15));
    }

    private void initRealisateurLabel() {
        nomRealisateur = new Label("Realisateur");
        nomRealisateur.setFont(Font.font("Amble CN", 15));
    }

    private void initGenreLabel() {
        genre = new Label("Genre");
        genre.setFont(Font.font("Amble CN",15));
    }
    private void initTitrePage() {
        titrePage = new Label("Votre film :");
        titrePage.setFont(Font.font("Amble CN", BOLD, 30));
        titrePage.setTranslateX(-30);
        titrePage.setTranslateY(30);

    }
    private void initNomFilm(String s) {
        nomFilmT = new Text(s);
    }
    private void initAnneeFilm(String s) {

        anneeFilmT = new Text(""+filmAAfficher.getAnneeFilm());
    }
    private void initNoteFilm(String s) {

        noteFilmT = new Text(""+filmAAfficher.getNoteFilm());
    }
    private void initResumeFilm(String s) {

        resumeFilmT = new Text(filmAAfficher.getResumeFilm());
        resumeFilmT.setWrappingWidth(600);
    }
    private void initRealisateurFilm(String s) {

        nomRealisateurFilmT = new Text(filmAAfficher.getRealisateurFilm());
    }
    private void initNationalite(String s) {
    }
    public void setVueListFilm() {

        root.getChildren().clear();
        root.getChildren().add(imageDvd);

        root.getChildren().add(titrePage);

        root.getChildren().add(buttonRetourListe);

        root.getChildren().add(scroll);
    }
}
