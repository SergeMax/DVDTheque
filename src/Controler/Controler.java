package Controler;



import Model.Film;
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
    private Text filmAjoute;
    private Film film1;
    private ArrayList<ArrayList<String>> tabListFilm;

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
    }

    public Controler(ViewHandler viewHandler, Menu model, Film utilisateur1) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.utilisateur1 = utilisateur1;
        this.viewHandler.setEventHandlerAjoutFilm(this);
    }


    @Override
    public void handle(MouseEvent mouseEvent) {

        if (mouseEvent.getSource().equals(viewHandler.getViewAjoutFilm().getButtonValider())) {

            if (filmAjoute == null){
                 filmAjoute = new Text("Erreur verifier votre saisie!!");
                root.getChildren().add(filmAjoute);
            }


             film1 = new Film();

            film1.setNomFilm(viewHandler.getViewAjoutFilm().getAreaNomFilm().getText());
            film1.setAnneeFilm(Integer.parseInt(viewHandler.getViewAjoutFilm().getAreaAnneeFilm().getText()));
            film1.setNoteFilm(Integer.parseInt(viewHandler.getViewAjoutFilm().getAreaNote().getText()));
            film1.setResumeFilm(viewHandler.getViewAjoutFilm().getAreaResumeFilm().getText());
            film1.setImageFilm(viewHandler.getViewAjoutFilm().getAreaImageFilm().getText());
            film1.setRealisateurFilm(viewHandler.getViewAjoutFilm().getAreaRealisateur().getText());
            film1.setNationaliteFilm(viewHandler.getViewAjoutFilm().getNationaliteFilm().getText());



            String requete = "INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) " +
                    "VALUES ('"+ film1.getNomFilm() +"', "
                    + film1.getAnneeFilm() +","
                    + film1.getNoteFilm() +", '"
                    + film1.getResumeFilm()+"', '"
                    + film1.getImageFilm() +"',"
                    + film1.getRealisateurFilm() +","
                    + film1.getNationaliteFilm() +");";
            System.out.println(requete);

           // viewInscription.initTextFilmBienAjoute();





          Boolean succes = bdd.edit(requete);

          if (succes == true){
              filmAjoute.setText("Film bien ajouté ! ");
          }else {
              filmAjoute.setText("Erreur ! ");
          }
        }

        if (mouseEvent.getSource().equals(viewHandler.getViewAjoutFilm().getButtonRetourListe())) {

            viewHandler.afficherViewList(film1, tabListFilm);

        }

        if (mouseEvent.getSource().equals(viewHandler.getViewDemarrage().getButtonDemarer())) {

            viewHandler.afficherViewList(film1, tabListFilm);

        }

        if (mouseEvent.getSource().equals(viewHandler.getViewList().getButtonAjouterFilm())) {

            viewHandler.afficherAjoutFilm();

        }

}}