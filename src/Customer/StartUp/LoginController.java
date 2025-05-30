package Customer.StartUp;

import Customer.CustomerDatabaseHandler;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;

public class LoginController {

    @FXML
    private Button btn_create;

    @FXML
    private Button btn_submit;

    @FXML
    private PasswordField pf_password;

    @FXML
    private TextField tf_email;

    @FXML
    private Button btn_close;

    private Stage stage;
    private Scene scene; 
    private Parent root;

    @FXML
    public void toSignUpPageHandler(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void toStartUpPageHandler(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartUp.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toValidateLogin(ActionEvent event) throws IOException{

        String email = tf_email.getText();
        String password = pf_password.getText();

        if (CustomerDatabaseHandler.validateLoginCredentials(email, password)) {
            System.out.println("Succesful");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Customer/Home/Home.fxml"));

                root = loader.load();

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        } else {
            System.out.println("Unsuccesful");
        }
    }    
}
