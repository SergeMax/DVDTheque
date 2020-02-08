package View;

import Controler.Controler;
import Model.Film;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

import java.util.ArrayList;

import static javafx.scene.text.FontWeight.BOLD;

public class ViewListFilm {

    private final Menu model;
    private final VBox vboxListe;
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
    private HBox boxFilm;
    private final Background focusBackground = new Background( new BackgroundFill( Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY ) );

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
    private HboxFilm hboxx;
    private String cheminCard;
    private HBox hboxConstruite;
    private ImageView imageFilmm;
    private HBox hboxTitreImage;
    private VBox vboxDescription;
    private ArrayList<Film> tableauDesFilms = new ArrayList<>();


    public ViewListFilm(Menu model, VBox vb, Film film1) {
        System.out.println("constructeur liste film ok");
        filmAAfficher = new Film();
        this.root = vb;
        this.model = model;
        this.filmAAfficher = film1;



        initTitrePage();

        //initLogin();
        initNomFilm();
        initAnneeFilm();
        initResumeFilm();
        initNoteFilm();
        initImageFilm();
        initRealisateurFilm();
        initNationalite();

        initImage();

        initNomFilmLabel();
        initAnneeFilmLabel();
        initNoteFilmLabel();
        initResumeFilmLabel();
        initImageLabel();
        initRealisateurLabel();

        initRealisateurLabel();

        vboxListe = new VBox();
        vboxListe.maxHeight(600);
        vboxListe.minWidth(950);


        vboxListe.setSpacing(20);


        scroll = new ScrollPane();
        scroll.setContent(vboxListe);



        for (int i =0; i<5; i++){

           HBox hbox = initBoxFilm("assets/image/5elem.png");

            vboxListe.getChildren().add(hbox);

        }




        setVueCompleteProfil();

    }

    public HBox initVbox(String cheminImage){
        hboxx = new HboxFilm(cheminImage);
        hboxConstruite = hboxx.gethBox();

        return hboxConstruite;
    }

    private HBox initBoxFilm(String chemin){


        boxFilm = initVbox(chemin);
        boxFilm.setBackground(focusBackground);
        boxFilm.setPadding(new Insets(20, 20, 20, 20));
        boxFilm.setSpacing(20);
        boxFilm.setTranslateY(30);


        Font fontTitre = new Font("Sans Serif", 10 );
        Font fontTitreFilm = new Font("Sans Serif", 30 );



        nomFilm.setFont(fontTitre);
        anneeFilm.setFont(fontTitre);
        noteFilm.setFont(fontTitre);
        resumeFilm.setFont(fontTitre);
        nomRealisateur.setFont(fontTitre);

        nomFilmT.setFont(fontTitreFilm);


        vboxDescription = new VBox();
        vboxDescription.getChildren().addAll(nomFilm, nomFilmT, anneeFilm, anneeFilmT,  nomRealisateur, nomRealisateurFilmT,  noteFilm, noteFilmT, resumeFilm, resumeFilmT);



        boxFilm.getChildren().addAll( vboxDescription);
              //, anneeFilmT, noteFilmT, resumeFilmT, imageFilmT, nomRealisateurFilmT););

        return boxFilm;
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


    private void initNomFilm() {
            nomFilmT = new Text(filmAAfficher.getNomFilm());
    }

    private void initAnneeFilm() {

            anneeFilmT = new Text(""+filmAAfficher.getAnneeFilm());

    }

    private void initNoteFilm() {

        noteFilmT = new Text(""+filmAAfficher.getNoteFilm());

    }

    private void initResumeFilm() {

            resumeFilmT = new Text(filmAAfficher.getResumeFilm());

    }

    private void initImageFilm() {

            imageFilmT = new Text(filmAAfficher.getImageFilm());

    }

    private void initRealisateurFilm() {

            nomRealisateurFilmT = new Text(filmAAfficher.getRealisateurFilm());


    }

    private void initNationalite() {

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


    public void setVueCompleteProfil() {



        root.getChildren().clear();
        root.getChildren().add(titrePage);

        root.getChildren().add(vboxListe);
        root.getChildren().add(scroll);






    }
    }
