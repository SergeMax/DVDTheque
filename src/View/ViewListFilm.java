package View;

import Controler.Controler;
import Model.Film;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewListFilm {

    private final Menu model;
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

        initNomFilmLabel();
        initAnneeFilmLabel();
        initNoteFilmLabel();
        initResumeFilmLabel();
        initImageLabel();
        initRealisateurLabel();

        initRealisateurLabel();



        setVueCompleteProfil();

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
        titrePage.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
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

        root.getChildren().add(nomFilm);
        root.getChildren().add(nomFilmT);

        root.getChildren().add(anneeFilm);
        root.getChildren().add(anneeFilmT);

        // root.getChildren().add(login);

        root.getChildren().add(noteFilm);
        root.getChildren().add(noteFilmT);


        root.getChildren().add(resumeFilm);
        root.getChildren().add(resumeFilmT);

        root.getChildren().add(imageFilm);
        root.getChildren().add(imageFilmT);


        root.getChildren().add(nomRealisateur);

        root.getChildren().add(nomRealisateurFilmT);



    }
    }
