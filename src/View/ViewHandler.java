package View;


import Controler.Controler;
import Model.Film;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.*;
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
    private Scene filmDetail;
    private ViewFilmDetail viewFilmDetail;
    private VBox rootVueFilmDetail;

    public ViewList getViewList() {
        return viewList;
    }



    public Controler getControlerInscr() {
        return controlerInscr;
    }


    public ViewDemarrage getViewDemarrage() {
        return viewDemarrage;
    }

    public ViewFilmDetail getViewFilmDetail() {
        return viewFilmDetail;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

       primaryStage.setTitle("DVD Theque Super Sonic");

        this.primaryStage = primaryStage;

        root = new VBox();
        rootVueList = new VBox();
        rootVueDemmarage = new Group();
        rootVueDemmarage.prefWidth(1200);
        rootVueDemmarage.minWidth(1200);
        rootVueDemmarage.minHeight(1000);
        rootVueDemmarage.maxHeight(1000);

        rootVueList.setStyle("-fx-background-image: url('/assets/image/pho.png'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: cover;");

        root.setPadding(new Insets(50, 150, 50, 150));
        root.setSpacing(10);
        root.setMinWidth(1200);
        root.setMaxWidth(1200);
        root.setMinHeight(900);

        root.setMaxHeight(900);
        root.setStyle("-fx-background-image: url('/assets/image/pho.png'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: cover;");

        rootVueList.setPadding(new Insets(50, 150, 50, 150));
        rootVueList.setSpacing(10);
        rootVueList.setMinWidth(1200);
        rootVueList.setMaxWidth(1200);
        rootVueList.setMaxHeight(900);
        rootVueList.setMinHeight(900);
        rootVueList.setTranslateY(-30);

        rootVueFilmDetail = new VBox();
        rootVueFilmDetail.setPadding(new Insets(50, 150, 0, 100));

        rootVueFilmDetail.setSpacing(10);
        rootVueFilmDetail.setMinWidth(1200);
        rootVueFilmDetail.setMaxWidth(1200);
        rootVueFilmDetail.setMinHeight(900);

        rootVueFilmDetail.setMaxHeight(900);

        rootVueFilmDetail.setStyle("-fx-background-image: url('/assets/image/pho.png'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: cover;");

        ajoutFilm = new Scene(root, Color.WHITE);
        listFilm = new Scene(rootVueList, Color.WHITE);
        demarage = new Scene(rootVueDemmarage, Color.WHITE);
        filmDetail = new Scene(rootVueFilmDetail, Color.WHITE);

        filmTest = new Film();

        viewList = new ViewList(model, rootVueList, filmTest);
        viewDemarrage = new ViewDemarrage(model, rootVueDemmarage);
        viewFilmDetail = new ViewFilmDetail(model, rootVueFilmDetail, filmTest);

        viewList.setVueListFilm();

        model = new Menu();

        viewAjoutFilm = new ViewAjoutFilm(model, root);

        BDDManager bdd = new BDDManager();

        bdd.start();

        System.out.println(bdd.ask("SELECT Libelle_Genre FROM DVDTHEQUE.genre " +
                "WHERE Id_Genre IN " +
                "(SELECT film_genre.Genre_id FROM DVDTHEQUE.genre " +
                "INNER JOIN DVDTHEQUE.film_genre ON genre.Id_Genre = film_genre.Film_id " +
                "INNER JOIN DVDTHEQUE.film ON film_genre.Film_id = film.Id_Film " +
                "Where Nom_Film = 'CInquieme Element')"));

        tabListFilmLongueur =  bdd.ask("SELECT * FROM DVDTHEQUE.Film;").size();

        tabListFilm = bdd.ask("SELECT * FROM DVDTHEQUE.Film;");

        controlerInscr = new Controler(this, model, bdd, root, tabListFilm);

        afficherViewDemarrage();
        primaryStage.setResizable(true);

        primaryStage.show();


    }

    public ArrayList<ArrayList<String>> getTabListFilm() {
        return tabListFilm;
    }

    public void setEventHandlerAjoutFilm(Controler ajout) {
        viewAjoutFilm.setEvents(ajout);
        viewDemarrage.setEvents(ajout);
        viewList.setEvents(ajout);
        viewFilmDetail.setEvents(ajout);
    }

    public ViewAjoutFilm getViewAjoutFilm() {
        return viewAjoutFilm;
    }

    public void afficherViewList(Film film1, ArrayList<ArrayList<String>> tabListFilm) {

        viewList.init();

        viewList.setVueListFilm();

        setEventHandlerAjoutFilm(controlerInscr);

        primaryStage.setScene(listFilm);

    }
    public void afficherViewDemarrage() {
       primaryStage.setScene(demarage);
    }


    public void afficherViewFilmDetail() {

        viewFilmDetail.init();
        viewFilmDetail.setVueListFilm();
        setEventHandlerAjoutFilm(controlerInscr);
        primaryStage.setScene(filmDetail);

    }

    public void afficherAjoutFilm() {

        primaryStage.setScene(ajoutFilm);

    }



}