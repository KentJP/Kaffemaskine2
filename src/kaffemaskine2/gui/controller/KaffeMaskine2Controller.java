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

    /**
     * This metod handæles the coffeemakers options
     *
     * @param event Retrieves the button
     */
    @FXML
    private void makeDrink(ActionEvent event) throws InterruptedException
    {
        if (event.getSource().equals(btnKaffe))
        {
            System.out.println("Laver kaffe");
            Thread.sleep(20000);
            System.out.println("Værsgo");
        }
        else if (event.getSource().equals(btnKakao))
        {
            System.out.println("Laver Kakao");
            Thread.sleep(20000);
            System.out.println("Værsgo");
        }
        else if (event.getSource().equals(btnCapucino))
        {
            System.out.println("Laver Capucino");
            Thread.sleep(20000);
            System.out.println("Værsgo");
        }
        else if (event.getSource().equals(btnCaffeLatte))
        {
            System.out.println("Laver CaffeLatte");
            Thread.sleep(20000);
            System.out.println("Værsgo");
        }
        else
        {
            // If none of the above matches, throw an error
            System.out.println("Error");
        }
        System.out.println("");
    }

}
