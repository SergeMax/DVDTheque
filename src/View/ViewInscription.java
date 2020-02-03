package View;

import Controler.Controler;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ViewInscription {

    private final Menu model;
    private Stage primaryStage;
    private VBox root;
    private Label titreFormulaire ;
    private TextField login;
    private PasswordField mdp;
    private TextField nom;
    private TextField prenom;
    private TextField adresse;
    private TextField codePostale;
    private TextField ville;
    private TextField adresseEmail;

    private Label  loginLabel;
    private Label  mdpLabel;
    private Label  nomLabel;
    private Label  prenomLabel;
    private Label  adresseLabel;
    private Label  codePostaleLabel;
    private Label  villeLabel;
    private Label  adresseEmailLabel;

    /*private String login1;
    private String nom1;
    private String prenom1;
    private String adresse1;
    private String codePostale1;
    private String ville1;

    public String getLogin1() {
        return login1;
    }

    public void setLogin1(String login1) {
        this.login1 = login1;
    }

    public String getNom1() {
        return nom1;
    }

    public void setNom1(String nom1) {
        this.nom1 = nom1;
    }

    public String getPrenom1() {
        return prenom1;
    }

    public void setPrenom1(String prenom1) {
        this.prenom1 = prenom1;
    }

    public String getAdresse1() {
        return adresse1;
    }

    public void setAdresse1(String adresse1) {
        this.adresse1 = adresse1;
    }

    public String getCodePostale1() {
        return codePostale1;
    }

    public void setCodePostale1(String codePostale1) {
        this.codePostale1 = codePostale1;
    }

    public String getVille1() {
        return ville1;
    }

    public void setVille1(String ville1) {
        this.ville1 = ville1;
    }

    public String getAdresseEmail1() {
        return adresseEmail1;
    }

    public void setAdresseEmail1(String adresseEmail1) {
        this.adresseEmail1 = adresseEmail1;
    }
*/
    private String adresseEmail1;



    private Button buttonValider;

    public ViewInscription(Menu model, VBox vb) {

        this.root = vb;
        this.model = model;

        initTitreFormulaire();
        initLogin();
        initMdp();
        initNom();
        initPrenom();
        initAdresse();
        initCodePostale();
        initVille();
        initAdresseEmail();
        initButtonValider();

        initLoginLabel();
        initMdpLabel();
        initNomLabel();
        initPrenomLabel();
        initAdresseLabel();
        initCodePostaleLabel();
        initVilleLabel();
        initAdresseEmailLabel();


        setVueCompleteInscription();

        //  initListeImage();
        // initVaisseauxCoin();
     //   setVueCompleteMenu();

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
        login = new TextField("");
        login.setMinWidth(120);
    }

    private void initMdp() {
        mdp = new PasswordField();
        mdp.setMinWidth(120);
    }

    private void initNom() {
        nom = new TextField("");
        nom.setMinWidth(120);

    }

    private void initPrenom() {
        prenom = new TextField("");
        prenom.setMinWidth(120);

    }

    private void initAdresse() {
        adresse = new TextField("");
        adresse.setMinWidth(120);

    }

    private void initCodePostale() {

        codePostale = new TextField("");
        codePostale.setMinWidth(120);

    }

    private void initVille() {
        ville = new TextField("");
        ville.setMinWidth(120);
    }

    private void initAdresseEmail() {
        adresseEmail = new TextField("");
        adresseEmail.setMinWidth(120);
    }

    private void initButtonValider() {
        buttonValider = new Button();
        buttonValider.setText("Vous inscrire maintenant");

    }

    public void setVueCompleteInscription() {
        root.getChildren().clear();
        root.getChildren().add(titreFormulaire);

        root.getChildren().add(loginLabel);
        root.getChildren().add(login);

        root.getChildren().add(mdpLabel);
        root.getChildren().add(mdp);

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


        root.getChildren().add(buttonValider);
    }

    public void setEvents(Controler inscr) {
        buttonValider.setOnMouseClicked(inscr);

    }




    public Button getButtonValider() {
        return buttonValider;
    }

    public TextField getLogin() {
        return login;
    }

    public PasswordField getMdp() {
        return mdp;
    }

    public TextField getNom() {
        return nom;
    }

    public TextField getPrenom() {
        return prenom;
    }

    public TextField getAdresse() {
        return adresse;
    }

    public TextField getCodePostale() {
        return codePostale;
    }

    public TextField getVille() {
        return ville;
    }

    public TextField getAdresseEmail() {
        return adresseEmail;
    }

}
