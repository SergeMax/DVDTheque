package View;

import Controler.Controler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ViewConnexion {

        private final Menu model;
        private Stage primaryStage;
        private VBox root;
        private Label titreFormulaire ;
        private TextField loginTextField;
        private TextField mdpTextField;
        private TextField prenom;
        private TextField adresse;
        private TextField codePostale;
        private TextField ville;
        private TextField adresseEmail;
        private Button buttonConnexion;
        private Label seConnecter;
        private Label labelMdp;
        private Label labelLogin;


    public ViewConnexion(Menu model, VBox vb) {

            this.root = vb;
            this.model = model;

            initLabelSeConnecter();
            initButtonConnexion();
            initLabelLogin();
            initTextFieldLogin();
            initLabelMdp();
            initTextFieldMdp();
            setVueCompleteConnexion();

        }

    private void initLabelMdp() {
        labelMdp = new Label("Mots de passe");
        labelMdp.setFont(Font.font("Amble CN", FontWeight.BOLD, 18));
    }

    private void initLabelLogin() {
        labelLogin = new Label("Login");
        labelLogin.setFont(Font.font("Amble CN", FontWeight.BOLD, 18));
    }

    private void initTextFieldLogin() {
        loginTextField = new TextField("");
        loginTextField.setMinWidth(120);
    }

    private void initTextFieldMdp() {
        mdpTextField = new TextField("");
        mdpTextField.setMinWidth(120);
    }

    private void initButtonConnexion() {
        buttonConnexion = new Button();
        buttonConnexion.setText("Connexion");
    }

    private void initLabelSeConnecter() {
            seConnecter = new Label("Formulaire d'inscription");
            seConnecter.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
        }

        public void setVueCompleteConnexion() {
            root.getChildren().clear();

            root.getChildren().add(labelLogin);
            root.getChildren().add(loginTextField);

            root.getChildren().add(labelMdp);

            root.getChildren().add(mdpTextField);
            root.getChildren().add(buttonConnexion);
        }

        public void setEvents(Controler inscr) {
             buttonConnexion.setOnMouseClicked(inscr);
        }

        public Button getButtonConnexion() {
            return buttonConnexion;
        }

    }




