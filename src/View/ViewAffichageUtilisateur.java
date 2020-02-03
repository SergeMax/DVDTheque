package View;

import Controler.Controler;
import Model.Utilisateur;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewAffichageUtilisateur {

    private final Menu model;
    private ViewHandler viewHandler;
    private Stage primaryStage;
    private VBox root;
    private Label titreFormulaire ;
    private Text login;
    private PasswordField mdp;
    private Text nom;
    private Text prenom;
    private Text adresse;
    private Text codePostale;
    private Text ville;
    private Text adresseEmail;
    private Controler controler;

    private Label  loginLabel;
    private Label  mdpLabel;
    private Label  nomLabel;
    private Label  prenomLabel;
    private Label  adresseLabel;
    private Label  codePostaleLabel;
    private Label  villeLabel;
    private Label  adresseEmailLabel;
    private Utilisateur utilisateuraafficher;




    public ViewAffichageUtilisateur(Menu model, VBox vb) {
        utilisateuraafficher = new Utilisateur();
        this.root = vb;
        this.model = model;

        initTitreFormulaire();

        initLogin();
        initNom();
        initPrenom();
        initAdresse();
        initCodePostale();
        initVille();
        initAdresseEmail();

        initLoginLabel();
        initNomLabel();
        initPrenomLabel();
        initAdresseLabel();
        initCodePostaleLabel();
        initVilleLabel();
        initAdresseEmailLabel();


        setVueCompleteProfil();

    }

    private void initLoginLabel() {
        loginLabel = new Label("Login");
        loginLabel .setFont(Font.font("Amble CN", 15));
    }

    private void initMdpLabel() {
        mdpLabel = new Label("Mots de passe");
        mdpLabel.setFont(Font.font("Amble CN",15));
    }

    private void initNomLabel() {
        nomLabel = new Label("Nom");
        nomLabel.setFont(Font.font("Amble CN", 15));
    }

    private void initPrenomLabel() {
        prenomLabel = new Label("Prenom");
        prenomLabel.setFont(Font.font("Amble CN", 15));
    }

    private void initAdresseLabel() {
        adresseLabel = new Label("Adresse");
        adresseLabel.setFont(Font.font("Amble CN", 15));
    }

    private void initCodePostaleLabel() {
        codePostaleLabel = new Label("Code Postale");
        codePostaleLabel.setFont(Font.font("Amble CN", 15));
    }

    private void initVilleLabel() {
        villeLabel = new Label("Ville");
        villeLabel.setFont(Font.font("Amble CN", 15));
    }

    private void initAdresseEmailLabel() {
        adresseEmailLabel = new Label("Adresse Email");
        adresseEmailLabel.setFont(Font.font("Amble CN",15));
    }


    private void initTitreFormulaire() {
        titreFormulaire = new Label("Formulaire d'inscription");
        titreFormulaire.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
    }


    private void initLogin() {
            login = new Text(utilisateuraafficher.getLogin());
        System.out.println("initLogin : " + utilisateuraafficher.getLogin());
    }


    private void initNom() {
            nom = new Text(utilisateuraafficher.getNom());
    }

    private void initPrenom() {

            prenom = new Text(utilisateuraafficher.getPrenom());

    }

    private void initAdresse() {

            adresse = new Text(utilisateuraafficher.getAdresse());

    }

    private void initCodePostale() {

            codePostale = new Text(utilisateuraafficher.getCodePostale());

    }

    private void initVille() {

            ville = new Text(utilisateuraafficher.getVille());


    }

    private void initAdresseEmail() {

            adresseEmail = new Text(utilisateuraafficher.getAdresseEmail());

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
        root.getChildren().add(titreFormulaire);

        root.getChildren().add(loginLabel);
        root.getChildren().add(login);

        root.getChildren().add(nomLabel);
        root.getChildren().add(nom);

        root.getChildren().add(prenomLabel);
        root.getChildren().add(prenom);

        root.getChildren().add(adresseLabel);
        root.getChildren().add(adresse);

        root.getChildren().add(codePostaleLabel);
        root.getChildren().add(codePostale);

        root.getChildren().add(villeLabel);
        root.getChildren().add(ville);

        root.getChildren().add(adresseEmailLabel);
        root.getChildren().add(adresseEmail);

    }
    }
