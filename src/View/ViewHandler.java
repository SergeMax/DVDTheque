package View;


import Controler.Controler;
import Model.Film;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.BDDManager;

import java.util.ArrayList;

public class ViewHandler extends Application {

    private Stage primaryStage;
    private VBox vb;
    private Controler controlerInscr;
    private ViewAjoutFilm viewAjoutFilm;
    private ViewList viewList;
    private Menu model;
    private  VBox root;
    private VBox rootVueList;
    private Film filmTest;
    private Scene ajoutFilm;
    private Scene listFilm;
    private int tabListFilmLongueur;
    private ArrayList<ArrayList<String>> tabListFilm;
    private ViewDemarrage viewDemarrage;
    private Scene demarage;
    private Group rootVueDemmarage;

    public ViewList getViewList() {
        return viewList;
    }



    public Controler getControlerInscr() {
        return controlerInscr;
    }


    public ViewDemarrage getViewDemarrage() {
        return viewDemarrage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


       primaryStage.setTitle("DVD Theque Super Sonic");


        this.primaryStage = primaryStage;

        root = new VBox();
        rootVueList = new VBox();
        rootVueDemmarage = new Group();
        rootVueDemmarage.prefWidth(1000);
        rootVueDemmarage.minWidth(1000);
        rootVueDemmarage.minHeight(800);
        rootVueDemmarage.maxHeight(800);




        root.setPadding(new Insets(50, 50, 50, 50));
        root.setSpacing(10);
        root.setMinWidth(1000);
        root.setMaxWidth(1000);
        root.setMinHeight(800);

        root.setMaxHeight(800);

        rootVueList.setPadding(new Insets(50, 50, 50, 50));
        rootVueList.setSpacing(10);
        rootVueList.setMinWidth(1000);
        rootVueList.setMaxWidth(1000);
        rootVueList.setMaxHeight(800);
        rootVueList.setMinHeight(800);




        ajoutFilm = new Scene(root, Color.WHITE);
        listFilm = new Scene(rootVueList, Color.WHITE);
        demarage = new Scene(rootVueDemmarage, Color.WHITE);

        filmTest = new Film();


        viewList = new ViewList(model, rootVueList, filmTest);
        viewDemarrage = new ViewDemarrage(model, rootVueDemmarage);


        viewList.setVueListFilm();


        model = new Menu();

        viewAjoutFilm = new ViewAjoutFilm(model, root);


        BDDManager bdd = new BDDManager();

        bdd.start();
       // bdd.lire("src/sample/BDDFilm.sql");

        tabListFilmLongueur =  bdd.ask("SELECT * FROM DVDTHEQUE.Film;").size();

        tabListFilm = bdd.ask("SELECT * FROM DVDTHEQUE.Film;");

        System.out.println(tabListFilm);
        for (int i = 0; i< tabListFilmLongueur-1; i++){


        }

        controlerInscr = new Controler(this, model, bdd, root, tabListFilm);


        //bdd.edit("INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) VALUES ('5eme element', 4444, 5, 'ferofk_elrfkeref', 'assets/image/5elem.png', 1, 1);");
        //bdd.edit("INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) VALUES ('ment', 4444, 5, 'ferofk_elrfkeref', 'assets/image/Kill.png', 1, 1);");

        // bdd.lire("src/sample/BDDFilm.sql");

       // bdd.stop();

       // afficherViewList(filmTest, tabListFilm);

        afficherViewDemarrage();





       // primaryStage.setScene(demarage);
        primaryStage.setResizable(true);
        primaryStage.show();


    }

    public ArrayList<ArrayList<String>> getTabListFilm() {
        return tabListFilm;
    }


    private void afficherInscription() {
        viewAjoutFilm.setVueCompleteInscription();
        System.out.println("ca passer par la");
    }

    public void setEventHandlerAjoutFilm(Controler ajout) {
        viewAjoutFilm.setEvents(ajout);
        viewList.setEvents(ajout);
        viewDemarrage.setEvents(ajout);

    }


    public ViewAjoutFilm getViewAjoutFilm() {
        return viewAjoutFilm;
    }


    public void afficherViewList(Film film1, ArrayList<ArrayList<String>> tabListFilm) {

        viewList.init();
        viewList.setVueListFilm();

        primaryStage.setScene(listFilm);

    }
    public void afficherViewDemarrage() {


     //   viewDemarrage.setVueDemmarrage();

       primaryStage.setScene(demarage);

    }


    public void afficherAjoutFilm() {

        primaryStage.setScene(ajoutFilm);

    }



}