package Controler;


import Model.Film;
import View.HboxFilm;
import View.ViewHandler;
import View.ViewAjoutFilm;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import sample.BDDManager;

import java.util.ArrayList;

public class Controler implements EventHandler<MouseEvent> {

    private ViewHandler viewHandler;
    private ViewAjoutFilm viewInscription;
    private Menu model;
    private String login;
    private PasswordField mdp;
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostale;
    private String ville;
    private String adresseEmail;
    private Film utilisateur1;
    private VBox root;

    private BDDManager bdd;
    private Text filmAjoute = new Text();
    private Film film1;
    private ArrayList<ArrayList<String>> tabListFilm;
    private boolean efface = false;
    private int sizeTab;
    private boolean modeModif = false;
    private int numeroAModif;
    private String cheminEditImage;
    private ArrayList<ArrayList<String>> tabListFilmViewdetail;


    public ArrayList<ArrayList<String>> getTabListFilm() {
        return tabListFilm;
    }

    public Film getUtilisateur1() {
        return utilisateur1;
    }

    public Controler(ViewHandler viewHandler, Menu model, BDDManager bdd, VBox root, ArrayList<ArrayList<String>> tabListFilm) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.viewHandler.setEventHandlerAjoutFilm(this);
        this.bdd = bdd;
        this.root = root;
        this.tabListFilm = tabListFilm;
        sizeTab = tabListFilm.size();

    }

    public Controler(ViewHandler viewHandler, Menu model, Film utilisateur1) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.utilisateur1 = utilisateur1;
        this.viewHandler.setEventHandlerAjoutFilm(this);
    }


    @Override
    public void handle(MouseEvent mouseEvent) {

        if (mouseEvent.getSource().equals(viewHandler.getViewAjoutFilm().getButtonValiderAjoutModif())) {

            root.getChildren().remove(filmAjoute);

            if (modeModif == false) {


                filmAjoute.setText("Erreur verifier votre saisie!!");
                filmAjoute.setTranslateY(-24);
                // root.getChildren().add(filmAjoute);


                root.getChildren().add(filmAjoute);
                film1 = new Film();

                film1.setNomFilm(viewHandler.getViewAjoutFilm().getAreaNomFilm().getText());
                film1.setAnneeFilm(Integer.parseInt(viewHandler.getViewAjoutFilm().getAreaAnneeFilm().getText()));
                //film1.setNoteFilm(Integer.parseInt(viewHandler.getViewAjoutFilm().getAreaNote().getText()));

                film1.setNoteFilm(viewHandler.getViewAjoutFilm().getChoiceBox().getSelectionModel().getSelectedIndex());


                film1.setResumeFilm(viewHandler.getViewAjoutFilm().getAreaResumeFilm().getText());
                film1.setImageFilm(viewHandler.getViewAjoutFilm().getCheminFIchier());
                film1.setRealisateurFilm(viewHandler.getViewAjoutFilm().getAreaRealisateur().getText());
                film1.setNationaliteFilm(viewHandler.getViewAjoutFilm().getNationaliteFilm().getText());


                String requete = "INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) " +
                        "VALUES ('" + film1.getNomFilm() + "', "
                        + film1.getAnneeFilm() + ","
                        + film1.getNoteFilm() + ", '"
                        + film1.getResumeFilm() + "', '"
                        + film1.getImageFilm() + "',"
                        + film1.getRealisateurFilm() + ","
                        + film1.getNationaliteFilm() + ");";
                System.out.println(requete);


                // tabListFilm.add();

                // viewInscription.initTextFilmBienAjoute();


                Boolean succes = bdd.edit(requete);


               // viewHandler.afficherViewList(film1, tabListFilm);
                viewHandler.afficherAjoutFilm();


                //   root.getChildren().add(filmAjoute);
                sizeTab = viewHandler.getViewList().getTableauBtnSupprimer().size();

                if (succes == true) {
                    filmAjoute.setText("Film bien ajouté ! ");
                    sizeTab = viewHandler.getViewList().getTableauBtnSupprimer().size() + 1;

                } else {
                    filmAjoute.setText("Erreur ! ");
                }
                sizeTab = viewHandler.getViewList().getTableauBtnSupprimer().size();

            } else {


                film1 = new Film();

                film1.setNomFilm(viewHandler.getViewAjoutFilm().getAreaNomFilm().getText());
                film1.setAnneeFilm(Integer.parseInt(viewHandler.getViewAjoutFilm().getAreaAnneeFilm().getText()));
                film1.setNoteFilm(Integer.parseInt(viewHandler.getViewAjoutFilm().getAreaNote().getText()));
                film1.setResumeFilm(viewHandler.getViewAjoutFilm().getAreaResumeFilm().getText());
                film1.setImageFilm(viewHandler.getViewAjoutFilm().getCheminFIchier());
                film1.setRealisateurFilm(viewHandler.getViewAjoutFilm().getAreaRealisateur().getText());
                film1.setNationaliteFilm(viewHandler.getViewAjoutFilm().getNationaliteFilm().getText());

                System.out.println(cheminEditImage);


                String cheminValide;

                System.out.println(cheminEditImage);
                System.out.println("film.getimagefilm" + film1.getImageFilm());

                if (viewHandler.getViewAjoutFilm().getCheminFIchier() == null) {

                    cheminValide = cheminEditImage;
                } else {
                    cheminValide = film1.getImageFilm();
                }


                String requete = "UPDATE dvdtheque.Film SET Nom_Film = '" +
                        film1.getNomFilm() +
                        "', Annee_Film = " + film1.getAnneeFilm() +
                        ", Note_Film = " + film1.getNoteFilm() +
                        ", Resume_Film = '" + film1.getResumeFilm() +
                        "', Image_Film = '" + cheminValide +
                        "', Realisateur_id = " + film1.getRealisateurFilm() +
                        ", Nationnalite_id= " + film1.getNationaliteFilm() +
                        " WHERE Nom_Film = '" + tabListFilm.get(numeroAModif).get(1) + "';";

                System.out.println(requete);


                // tabListFilm.add();

                // viewInscription.initTextFilmBienAjoute();


                Boolean succes = bdd.edit(requete);


                viewHandler.getViewAjoutFilm().getAreaNomFilm().setText("");
                viewHandler.getViewAjoutFilm().getAreaAnneeFilm().setText("");
                viewHandler.getViewAjoutFilm().getAreaNote().setText("");
                viewHandler.getViewAjoutFilm().getAreaResumeFilm().setText("");
                viewHandler.getViewAjoutFilm().getAreaImageFilm().setText("");
                viewHandler.getViewAjoutFilm().getAreaRealisateur().setText("");
                viewHandler.getViewAjoutFilm().getNationaliteFilm().setText("");

                viewHandler.afficherViewList(film1, tabListFilm);

                viewHandler.getViewAjoutFilm().getTitreFormulaire().setText("Ajouter un film");
                viewHandler.getViewAjoutFilm().getButtonValiderAjoutModif().setText("Ajouter");

                viewHandler.getViewAjoutFilm().getAreaNomFilm().setText("");
                viewHandler.getViewAjoutFilm().getAreaAnneeFilm().setText("");
                viewHandler.getViewAjoutFilm().getAreaNote().setText("");
                viewHandler.getViewAjoutFilm().getAreaResumeFilm().setText("");
                viewHandler.getViewAjoutFilm().getAreaImageFilm().setText("Chercher l'image");
                viewHandler.getViewAjoutFilm().getRoot().getChildren().remove(viewHandler.getViewAjoutFilm().getImagePrev());

                viewHandler.getViewAjoutFilm().getAreaRealisateur().setText("");
                viewHandler.getViewAjoutFilm().getNationaliteFilm().setText("");

                modeModif = false;
                sizeTab = viewHandler.getViewList().getTableauBtnSupprimer().size();
            }

        }

        if (mouseEvent.getSource().equals(viewHandler.getViewAjoutFilm().getButtonRetourListe())) {
            filmAjoute.setText("");

            viewHandler.afficherViewList(film1, tabListFilm);

        }

        if (mouseEvent.getSource().equals(viewHandler.getViewAjoutFilm().getButtonRetourListe())) {


            viewHandler.afficherViewList(film1, tabListFilm);

        }


        if (mouseEvent.getSource().equals(viewHandler.getViewDemarrage().getButtonDemarer())) {

            viewHandler.afficherViewList(film1, tabListFilm);
            //  viewHandler.getViewList().setEvents();

        }

        if (mouseEvent.getSource().equals(viewHandler.getViewList().getButtonAjouterFilm())) {
            filmAjoute.setText("");

            viewHandler.afficherAjoutFilm();
            for (int i = 0; i < viewHandler.getViewList().getTableauBtnSupprimer().size(); i++) {

                viewHandler.getViewList().getTableauBtnSupprimer().get(i).setText("" + i);
            }


        }


        for (int i = 0; i < sizeTab; i++) {

            if (mouseEvent.getSource().equals(viewHandler.getViewList().getTableauBtnDetail().get(i))) {



                tabListFilmViewdetail = bdd.ask("SELECT * FROM DVDTHEQUE.Film;");

                tabListFilmViewdetail = bdd.ask("SELECT * FROM DVDTHEQUE.Film where Nom_Film='"+tabListFilm.get(i).get(1)+"';");


                viewHandler.getViewFilmDetail().setTabListFilm(tabListFilmViewdetail);

                viewHandler.afficherViewFilmDetail();
            }
        }


//        for (int y = 0; y < sizeTab; y++) {
//
//              int finalY = y;
//              viewHandler.getViewList().getTableauDesImages().get(finalY).setOnMouseClicked((e) -> {
//                  if (mouseEvent.getSource().equals(viewHandler.getViewList().getTableauDesImages().get(finalY))) {
//                  System.out.println("imageclique");
//                  viewHandler.afficherViewFilmDetail();}
//              });
//


        //voici ma fonction qui m'indique une erreur


        for (int i = 0; i < sizeTab; i++) {

            if (mouseEvent.getSource().equals(viewHandler.getViewList().getTableauBtnSupprimer().get(i))) {

                efface = true;

                System.out.println("cliqué");

                if (efface == true) {

                    String titreFilm = viewHandler.getViewList().getTabListFilm().get(i).get(1);
                    viewHandler.getViewList().getTableauBtnSupprimer().remove(i);
                    //  viewHandler.getViewList().getTablistFilmActu()

                    viewHandler.getViewList().getTabListFilm().get(i).get(1);
                    System.out.println(titreFilm);
                    String requete = "DELETE FROM DVDTHEQUE.Film WHERE Nom_Film ='" + titreFilm + "';";
                    bdd.edit(requete);


                    tabListFilm = viewHandler.getViewList().getTabListFilm();

                    viewHandler.afficherViewList(film1, tabListFilm);
                    //  viewHandler.getViewList().getTableauBtnSupprimer().get(i).setText("" + i);

                    sizeTab = viewHandler.getViewList().getTableauBtnSupprimer().size();


                }

            }

            if (efface == true) {

                efface = false;
                break;

            }
            //   i = i - 1;

        }


        if (mouseEvent.getSource().equals(viewHandler.getViewFilmDetail().getButtonRetourListe())) {


            viewHandler.afficherViewList(film1, tabListFilm);

            System.out.println("beton click");
        }


        for (int i = 0; i < sizeTab; i++) {

            if (mouseEvent.getSource().equals(viewHandler.getViewList().getTableauBtnEditer().get(i))) {

                System.out.println("cliqué edite numero" + i);

                numeroAModif = i;

                viewHandler.getViewAjoutFilm().getTitreFormulaire().setText("Modifier le film");
                viewHandler.getViewAjoutFilm().getButtonValiderAjoutModif().setText("Valider la modification");

                modeModif = true;


                viewHandler.getViewAjoutFilm().getAreaNomFilm().setText("" + tabListFilm.get(i).get(1));
                viewHandler.getViewAjoutFilm().getAreaAnneeFilm().setText("" + tabListFilm.get(i).get(2));
                viewHandler.getViewAjoutFilm().getAreaNote().setText("" + tabListFilm.get(i).get(3));
                viewHandler.getViewAjoutFilm().getAreaResumeFilm().setText("" + tabListFilm.get(i).get(4));
                viewHandler.getViewAjoutFilm().getAreaImageFilm().setText("" + tabListFilm.get(i).get(5));
                cheminEditImage = tabListFilm.get(i).get(5);
                viewHandler.getViewAjoutFilm().initEditZoneImage(tabListFilm.get(i).get(5));
                viewHandler.getViewAjoutFilm().getAreaRealisateur().setText("" + tabListFilm.get(i).get(6));
                viewHandler.getViewAjoutFilm().getNationaliteFilm().setText("" + tabListFilm.get(i).get(7));

                viewHandler.afficherAjoutFilm();

            }
        }
    }
}