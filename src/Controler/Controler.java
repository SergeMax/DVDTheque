package Controler;



import Model.Film;
import View.ViewHandler;
import View.ViewAjoutFilm;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import sample.BDDManager;

import java.sql.SQLOutput;

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

    private BDDManager bdd;

    public Film getUtilisateur1() {
        return utilisateur1;
    }

    public Controler(ViewHandler viewHandler, Menu model, BDDManager bdd) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.viewHandler.setEventHandlerInscription(this);
        this.bdd = bdd;
    }

    public Controler(ViewHandler viewHandler, Menu model, Film utilisateur1) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.utilisateur1 = utilisateur1;
        this.viewHandler.setEventHandlerInscription(this);
    }


    @Override
    public void handle(MouseEvent mouseEvent) {

        if (mouseEvent.getSource().equals(viewHandler.getMi().getButtonValider())) {


            Film film1 = new Film();

            film1.setNomFilm(viewHandler.getMi().getAreaNomFilm().getText());
            film1.setAnneeFilm(Integer.parseInt(viewHandler.getMi().getAreaAnneeFilm().getText()));
            film1.setNoteFilm(Integer.parseInt(viewHandler.getMi().getAreaNote().getText()));
            film1.setResumeFilm(viewHandler.getMi().getAreaResumeFilm().getText());
            film1.setImageFilm(viewHandler.getMi().getAreaImageFilm().getText());
            film1.setRealisateurFilm(viewHandler.getMi().getAreaRealisateur().getText());
            film1.setNationaliteFilm(viewHandler.getMi().getNationaliteFilm().getText());



            String requete = "INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) " +
                    "VALUES ('"+ film1.getNomFilm() +"', "
                    + film1.getAnneeFilm() +","
                    + film1.getNoteFilm() +", '"
                    + film1.getResumeFilm()+"', '"
                    + film1.getImageFilm() +"',"
                    + film1.getRealisateurFilm() +","
                    + film1.getNationaliteFilm() +");";
            System.out.println(requete);


            bdd.edit(requete);


            viewHandler.afficherProfil(film1);


        }

}}