package Controler;



import Model.Utilisateur;
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
    private Utilisateur utilisateur1;

    public Utilisateur getUtilisateur1() {
        return utilisateur1;
    }

    public Controler(ViewHandler viewHandler, Menu model) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.viewHandler.setEventHandlerInscription(this);
    }

    public Controler(ViewHandler viewHandler, Menu model, Utilisateur utilisateur1) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.utilisateur1 = utilisateur1;
        this.viewHandler.setEventHandlerInscription(this);
    }


    @Override
    public void handle(MouseEvent mouseEvent) {

        if (mouseEvent.getSource().equals(viewHandler.getMi().getButtonValider())) {


            utilisateur1 = new Utilisateur();

            utilisateur1.setLogin(viewHandler.getMi().getAreaNomFilm().getText());
            utilisateur1.setMdp(viewHandler.getMi().getAreaAnneeFilm().getText());
            utilisateur1.setNom(viewHandler.getMi().getAreaNote().getText());
            utilisateur1.setPrenom(viewHandler.getMi().getAreaResumeFilm().getText());
            utilisateur1.setAdresse(viewHandler.getMi().getAreaImageFilm().getText());
            utilisateur1.setCodePostale(viewHandler.getMi().getAreaRealisateur().getText());
            utilisateur1.setVille(viewHandler.getMi().getVille().getText());
            utilisateur1.setAdresseEmail(viewHandler.getMi().getAdresseEmail().getText());

            viewHandler.afficherConnexion();


        }

        if (mouseEvent.getSource().equals(viewHandler.getMc().getButtonConnexion())) {
       //     if(utilisateur1.getLogin() ==
         //   utilisateur1.getMdp()) {
                viewHandler.afficherProfil();
           // }

        }
}}