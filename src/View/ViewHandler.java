package View;


import Controler.Controler;
import Model.Film;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.BDDManager;

public class ViewHandler extends Application {

    private Stage primaryStage;
    private VBox vb;
    private Controler controlerInscr;
    private ViewAjoutFilm mi;
    private ViewListFilm viewList;
    private Menu model;
    private  VBox root;
    private VBox rootVueList;
    private Film filmTest;

    public ViewListFilm getViewList() {
        return viewList;
    }



    public Controler getControlerInscr() {
        return controlerInscr;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("hello");
       primaryStage.setTitle("Formulaire d'inscription pour le site de M. Boutboul");


        this.primaryStage = primaryStage;

        root = new VBox();
        rootVueList = new VBox();


        root.setPadding(new Insets(50, 50, 50, 50));
        root.setSpacing(10);
        root.setMinWidth(500);

        rootVueList.setPadding(new Insets(50, 50, 50, 50));
        rootVueList.setSpacing(10);
        rootVueList.setMinWidth(1000);
        rootVueList.setMaxHeight(800);


        Scene ajoutFilm = new Scene(root, Color.WHITE);
        Scene listFilm = new Scene(rootVueList, Color.WHITE);


        model = new Menu();

        mi = new ViewAjoutFilm(model, root);



        filmTest = new Film();

        BDDManager bdd = new BDDManager();
        controlerInscr = new Controler(this, model, bdd);

        bdd.start();
       // bdd.lire("src/sample/BDDFilm.sql");

        System.out.println(bdd.ask("SELECT * FROM DVDTHEQUE.Film;").get(0).toString());

        //bdd.edit("INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) VALUES ('5eme element', 4444, 5, 'ferofk_elrfkeref', 'assets/image/5elem.png', 1, 1);");
        //bdd.edit("INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) VALUES ('ment', 4444, 5, 'ferofk_elrfkeref', 'assets/image/Kill.png', 1, 1);");

        // bdd.lire("src/sample/BDDFilm.sql");

       // bdd.stop();



       // afficherProfil(filmTest);

        primaryStage.setScene(ajoutFilm);
        primaryStage.setResizable(true);
        primaryStage.show();


    }

    private void afficherInscription() {
        mi.setVueCompleteInscription();
        System.out.println("ca passer par la");
    }

    public void setEventHandlerInscription(Controler inscr) {
        mi.setEvents(inscr);

    }


    public ViewAjoutFilm getMi() {
        return mi;
    }


    public void afficherProfil(Film film1) {
        viewList = new ViewListFilm(model, rootVueList, filmTest);

        viewList.setVueCompleteProfil();
    }

}