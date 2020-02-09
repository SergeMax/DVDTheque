package View;

import Controler.Controler;
import Model.Film;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.BDDManager;

import java.util.ArrayList;

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



    public ViewList(Menu model, VBox vb, Film film1) {
      //  System.out.println("constructeur liste film ok");
        filmAAfficher = new Film();
        this.root = vb;
        this.model = model;
        this.filmAAfficher = film1;



        initTitrePage();
        initImageDvd();
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

    public void init(){

        BDDManager bdd = new BDDManager();

        bdd.start();
        // bdd.lire("src/sample/BDDFilm.sql");

        //  tabListFilmLongueur =  bdd.ask("SELECT * FROM DVDTHEQUE.Film;").size();

        ArrayList<ArrayList<String>> tabListFilm = bdd.ask("SELECT * FROM DVDTHEQUE.Film;");

        VBox vboxListe = new VBox();
        vboxListe.setSpacing(20);

        tableauBtnSupprimer.clear();

        for (int i=0; i<tabListFilm.size(); i++){


            initNomFilmLabel();
            initAnneeFilmLabel();
            initNoteFilmLabel();
            initResumeFilmLabel();
            initImageLabel();
            initRealisateurLabel();


            initNomFilm(tabListFilm.get(i).get(1));
            initAnneeFilm(tabListFilm.get(i).get(2));
            initResumeFilm(tabListFilm.get(i).get(3));
            initNoteFilm(tabListFilm.get(i).get(4));

            initRealisateurFilm(tabListFilm.get(i).get(6));
            initNationalite(tabListFilm.get(i).get(7));

           // System.out.println(tabListFilm.get(1).get(5));
            HBox hbox = initBoxFilm(tabListFilm.get(i).get(5));


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

        System.out.println(tableauBtnSupprimer);
        for (int i =0; i<tableauBtnSupprimer.size(); i++) {
            tableauBtnSupprimer.get(i).setOnMouseClicked(ajout);
        }
    }

    private HBox initBoxFilm(String chemin){

        HboxFilm boxFilm = new HboxFilm(chemin);
        HBox hboxConstruite = boxFilm.gethBox();




        Font fontTitre = new Font("Sans Serif", 10 );
        Font fontTitreFilm = new Font("Sans Serif", 30 );

        Button buttonEditer = new Button();
        buttonEditer.setText("Editer");
        buttonEditer.setTranslateX(460);
        buttonEditer.setTranslateY(-34);


        Button buttonSupprimer = new Button();
        buttonSupprimer.setText("Supprimer");
        buttonSupprimer.setTranslateX(520);
        buttonSupprimer.setTranslateY(-60);

        tableauBtnSupprimer.add(buttonSupprimer);

        ImageView play = new ImageView("assets/image/play.png");

        play.setFitWidth(70);
        play.setTranslateY(-12);
        play.setPreserveRatio(true);

        nomFilm.setFont(fontTitre);
        anneeFilm.setFont(fontTitre);
        noteFilm.setFont(fontTitre);
        resumeFilm.setFont(fontTitre);
        nomRealisateur.setFont(fontTitre);

        nomFilmT.setFont(fontTitreFilm);

        anneeFilmT.setTranslateY(2);


        nomRealisateur.setTranslateX(50);
        nomRealisateur.setTranslateY(-31);

        nomRealisateurFilmT.setTranslateX(52);
        nomRealisateurFilmT.setTranslateY(-30);

        noteFilm.setTranslateX(120);
        noteFilm.setTranslateY(-62);

        noteFilmT.setTranslateX(120);
        noteFilmT.setTranslateY(-60);

        resumeFilm.setTranslateY(-40);
        resumeFilmT.setTranslateY(-40);

        VBox vboxDescription = new VBox();
        vboxDescription.getChildren().addAll(nomFilm, nomFilmT, anneeFilm, anneeFilmT,  nomRealisateur, nomRealisateurFilmT,  noteFilm, noteFilmT, resumeFilm, resumeFilmT, play, buttonEditer, buttonSupprimer);

        hboxConstruite.getChildren().addAll( vboxDescription);
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



    private void initTitrePage() {
        titrePage = new Label("Liste des Films");
        titrePage.setFont(Font.font("Amble CN", BOLD, 24));
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


        //root.getChildren().add(vboxListe);
        root.getChildren().add(scroll);

    }
    }
