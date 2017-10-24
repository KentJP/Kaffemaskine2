package kaffemaskine2.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Hussain
 */
public class KaffeMaskine2Controller implements Initializable
{

    @FXML
    private Button btnKaffe;
    @FXML
    private Button btnKakao;
    @FXML
    private Button btnCapucino;
    @FXML
    private Button btnCaffeLatte;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void makeDrink(ActionEvent event)
    {
        if (event.getSource().equals(btnKaffe))
        {
            System.out.println("Laver kaffe");
        }
        else if (event.getSource().equals(btnKakao))
        {
            System.out.println("Laver Kakao");
        }
        else if (event.getSource().equals(btnCapucino))
        {
            System.out.println("Laver Capucino");
        }
        else if (event.getSource().equals(btnCaffeLatte))
        {
            System.out.println("Laver CaffeLatte");
        }
        else
        {
            System.out.println("Error");
        }
    }

}
