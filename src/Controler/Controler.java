package Controler;



import Model.Film;
import View.ViewHandler;
import View.ViewAjoutFilm;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

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
    private Film film1;

    public Film getUtilisateur1() {
        return utilisateur1;
    }

    public Controler(ViewHandler viewHandler, Menu model) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.viewHandler.setEventHandlerInscription(this);
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


            film1 = new Film();

            film1.setNomFilm(viewHandler.getMi().getAreaNomFilm().getText());
            film1.setAnneeFilm(Integer.parseInt(viewHandler.getMi().getAreaAnneeFilm().getText()));
            film1.setNoteFilm(Integer.parseInt(viewHandler.getMi().getAreaNote().getText()));
            film1.setResumeFilm(viewHandler.getMi().getAreaResumeFilm().getText());
            film1.setImageFilm(viewHandler.getMi().getAreaImageFilm().getText());
            film1.setRealisateurFilm(viewHandler.getMi().getAreaRealisateur().getText());

            viewHandler.afficherProfil(film1);


        }

}}