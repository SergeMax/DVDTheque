package View;

import Controler.Controler;
import Model.Film;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.BDDManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

import static javafx.scene.text.FontWeight.BOLD;

public class ViewList {

    private final Menu model;

    private final ScrollPane scroll;
    private  VBox vBox;
    private ViewHandler viewHandler;
    private Stage primaryStage;
    private VBox root;
    private Label titrePage;
    private Text login;
    private PasswordField mdp;
    private Text nomFilmT;
    private Text anneeFilmT;
    private Text resumeFilmT;
    private Text imageFilmT;
    private Text nomRealisateurFilm;

    private Controler controler;

    private Label nomFilm;
    private Label anneeFilm;
    private Label noteFilm;
    private Label resumeFilm;
    private Label imageFilm;
    private Label nomRealisateur;

    private Film filmAAfficher;
    private Text noteFilmT;
    private Text nomRealisateurFilmT;
    private String cheminCard;
    private ImageView imageFilmm;
    private ArrayList<Film> tableauDesFilms = new ArrayList<>();
    private Button buttonAjouterFilm;
    private ImageView imageDvd;
    private ArrayList<Button> tableauBtnSupprimer= new ArrayList<>();
    private ArrayList<Button> tableauBtnEditer = new ArrayList<>();;
    private Label genre;
    private ArrayList<ArrayList<String>> tabgenreString;
    private BDDManager bdd;
    private Text genreT;
    private TextField areaRechercheFilm;
    private Label RechercheFilm;
    private Button buttonValiderRecherche;

    public ArrayList<ArrayList<String>> getTabListFilm() {
        return tabListFilm;
    }

    public ArrayList<Button> getTableauBtnEditer() {
        return tableauBtnEditer;
    }

    public void setTableauBtnEditer(ArrayList<Button> tableauBtnEditer) {
        this.tableauBtnEditer = tableauBtnEditer;
    }

    private ArrayList<ArrayList<String>> tabListFilm;


    public ViewList(Menu model, VBox vb, Film film1) {
      //  System.out.println("constructeur liste film ok");
        filmAAfficher = new Film();
        this.root = vb;
        this.model = model;
        this.filmAAfficher = film1;



        initTitrePage();
        initImageDvd();
        initareaRechercheFilm();
        initRechercheFilm();
        initbuttonValiderRecherche();
        //initLogin();



        initButtonAjouterFilm();


        VBox vboxListe = new VBox();
        vboxListe.maxHeight(600);
        vboxListe.minWidth(950);


        vboxListe.setSpacing(20);


        scroll = new ScrollPane();
        scroll.setContent(null);
        scroll.setContent(vboxListe);

        setVueListFilm();

    }

    private void initImageDvd() {
        imageDvd = new ImageView("assets/image/DVD.png");
        imageDvd.setPreserveRatio(true);
        imageDvd.setFitHeight(50);
        imageDvd.setTranslateX(420);


    }

    private  void initareaRechercheFilm() {
        areaRechercheFilm= new TextField("");
        areaRechercheFilm.setMaxWidth(650);
        areaRechercheFilm.setTranslateX(-30);
        areaRechercheFilm.setTranslateY(50);

    }
    private void initRechercheFilm() {
        RechercheFilm = new Label("Recherche :");
        RechercheFilm.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        RechercheFilm.setTranslateX(-30);
        RechercheFilm.setTranslateY(-20);
    }
    private void initbuttonValiderRecherche() {
        buttonValiderRecherche = new Button();
        buttonValiderRecherche.setText("Valider");
        buttonValiderRecherche.setTranslateX(650);
        buttonValiderRecherche.setTranslateY(-23);
    }

   // public ArrayList<ArrayList<String>> getTablistFilmActu(ArrayList<ArrayList<String>> tablistFilmActua){
   //     return tablistFilmActua;
    //}

    public void init(){

        bdd = new BDDManager();

        bdd.start();
        // bdd.lire("src/sample/BDDFilm.sql");

        //  tabListFilmLongueur =  bdd.ask("SELECT * FROM DVDTHEQUE.Film;").size();


       tabListFilm = bdd.ask("SELECT * FROM DVDTHEQUE.Film;");

      //  getTablistFilmActu(tabListFilm);

        VBox vboxListe = new VBox();
        vboxListe.setSpacing(20);

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

           // System.out.println(tabListFilm.get(1).get(5));
            HBox hbox = initBoxFilm(tabListFilm.get(i).get(5), tabgenreString);

            vboxListe.getChildren().add(hbox);

        }

        scroll.setContent(null);

        scroll.setContent(vboxListe);

        setVueListFilm();
        //root.getChildren().clear();
        //setVueListFilm();





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
      //  buttonAjouterFilm.setTranslateY();

    }

    public ArrayList<Button> getTableauBtnSupprimer() {
        return tableauBtnSupprimer;
    }

    public Button getButtonAjouterFilm() {
        return buttonAjouterFilm;
    }

    public void setEvents(Controler ajout) {
        buttonAjouterFilm.setOnMouseClicked(ajout);

       // System.out.println(tableauBtnSupprimer);
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




        Font fontTitre = new Font("Sans Serif", 10 );
        Font fontTitreFilm = new Font("Sans Serif", 30 );

        Button buttonEditer = new Button();
        buttonEditer.setText("Editer");
        buttonEditer.setTranslateX(460);
        buttonEditer.setTranslateY(5);
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
       // vboxGenre.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));


        vboxGenre.setPrefWidth(230);
        vboxGenre.setMaxWidth(230);
        //vboxGenre.setAlignment();
        //vboxGenre.setTranslateX(80);
        //vboxGenre.setTranslateY(-10);
        //vboxGenre.setLayoutX(200);
        VBox.setMargin(vboxGenre, new Insets(0, 0, 0, 100));


        // vboxGenre.setTranslateX(330);
        //vboxGenre.setTranslateY(-60);

        HBox ligne2 = new HBox();

        ligne2.minWidth(150);
        ligne2.setSpacing(30);
        ligne2.getChildren().addAll(colonne1,colonne2,colonne3);

        VBox blocV1DansTeteBloc = new VBox();
        blocV1DansTeteBloc.getChildren().addAll( nomFilm, nomFilmT, ligne2);
        blocV1DansTeteBloc.setMinWidth(380);

        HBox teteBloc = new HBox();
       // teteBloc.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
        teteBloc.getChildren().addAll( blocV1DansTeteBloc, vboxGenre);






       // vboxGenre.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        vboxGenre.setAlignment(Pos.TOP_RIGHT);
        //vBox.setTranslateY();


        vboxGenre.getChildren().add(genreT);

        VBox vboxDescription = new VBox();



        vboxDescription.getChildren().addAll(teteBloc, resumeFilm, resumeFilmT,  play, buttonEditer, buttonSupprimer);

        hboxConstruite.getChildren().addAll( vboxDescription);
        hboxConstruite.setMaxHeight(250);
        hboxConstruite.setPrefHeight(250);

        //, anneeFilmT, noteFilmT, resumeFilmT, imageFilmT, nomRealisateurFilmT););

        return hboxConstruite ;
    }

    private void initImage(){
        imageFilmm = new ImageView("assets/image/5elem.jpg");
        imageFilmm.setFitHeight(230);
        imageFilmm.setFitWidth(150);
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
        titrePage = new Label("Liste des Films");
        titrePage.setFont(Font.font("Amble CN", BOLD, 30));
        titrePage.setTranslateX(-30);
    }


  //  private void initLogin() {
  //          login = new Text(filmAAfficher.getNomFilm());
        //System.out.println("initLogin : " + filmAAfficher.getLogin());
   // }



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

    private void initImageFilm() {

            imageFilmT = new Text(filmAAfficher.getImageFilm());

    }

    private void initRealisateurFilm(String s) {

            nomRealisateurFilmT = new Text(filmAAfficher.getRealisateurFilm());


    }



    private void initNationalite(String s) {

            //adresseEmail = new Text(filmAAfficher.getAdresseEmail());

    }




  /*  public void setEvents(Controler inscr) {
        buttonValider.setOnMouseClicked(inscr);

    }
*/



    /*public Button getButtonValider() {
        return buttonValider;
    }
*/


    public void setVueListFilm() {

        root.getChildren().clear();
        root.getChildren().add(imageDvd);

        root.getChildren().add(titrePage);
        root.getChildren().add(buttonAjouterFilm);
        root.getChildren().add(areaRechercheFilm);
        root.getChildren().add(RechercheFilm);

        root.getChildren().add(buttonValiderRecherche);



        //root.getChildren().add(vboxListe);
        root.getChildren().add(scroll);

    }
    }
