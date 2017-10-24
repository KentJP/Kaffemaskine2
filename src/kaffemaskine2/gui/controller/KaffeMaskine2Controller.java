package kaffemaskine2.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hussain
 */
public class KaffeMaskine2Controller implements Initializable
{

    //Lines for the green display.
    private final String PRETEXT = "\n  Coffee Machine!\n\n  Status:\n  ";
    private final String DEFAULT = "Choose a drink :)";
    private final String ERROR = "Error...";
    private final String REMOVE_CUP = "Remove the filled cup...";

    //Time it takes the coffee machine to make a cup of hot drink.
    private final int TIME_SLEEP = 3000;

    //URL for button images.
    private final Image BTN_BLUE = new Image("/kaffemaskine2/gui/images/btn-blue.png");
    private final Image BTN_RED = new Image("/kaffemaskine2/gui/images/btn-red.png");

    //URL for cup images.
    private final String CUP_EMPTY = "/kaffemaskine2/gui/images/cup-empty.png";
    private final String CUP_FILLED = "/kaffemaskine2/gui/images/cup-filled.png";

    //Check for the state of the cup and buttons.
    private boolean isFilled = false;
    private boolean isPressed = false;

    @FXML
    private Button btnKaffe;
    @FXML
    private Button btnKakao;
    @FXML
    private Button btnCapucino;
    @FXML
    private Button btnCaffeLatte;
    @FXML
    private TextArea txtarea;
    @FXML
    private ImageView coffeeCup;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //Set default text.
        setScreenTxt(DEFAULT);
    }

    /**
     * This metod handles the coffeemakers options.
     *
     * @param event Retrieves the button
     */
    @FXML
    private void handleDrink(ActionEvent event)
    {
        //Makes the drink which has been chosen.
        if (event.getSource().equals(btnKaffe))
        {
            makeDrink("Coffee");

            if (!isPressed && !isFilled)
            {
                setButtonImage(btnKaffe, BTN_RED);
                isPressed = true;
            }
        }
        else if (event.getSource().equals(btnKakao))
        {
            makeDrink("Cocoa");

            if (!isPressed && !isFilled)
            {
                setButtonImage(btnKakao, BTN_RED);
                isPressed = true;
            }
        }
        else if (event.getSource().equals(btnCapucino))
        {
            makeDrink("Capucino");

            if (!isPressed && !isFilled)
            {
                setButtonImage(btnCapucino, BTN_RED);
                isPressed = true;
            }
        }
        else if (event.getSource().equals(btnCaffeLatte))
        {
            makeDrink("Cafe Latte");

            if (!isPressed && !isFilled)
            {
                setButtonImage(btnCaffeLatte, BTN_RED);
                isPressed = true;
            }
        }
        else
        {
            // If none of the above matches, throw an error
            makeDrink(ERROR);
        }
    }

    /**
     * Handle drinks.
     *
     * @param str Wanted drink.
     */
    private void makeDrink(String str)
    {
        //If it is already making a dring.
        if (isPressed)
        {
            return;
        }

        //If the cup is not empty it prompts a messages telling the user to remove the cup.
        if (isFilled)
        {
            setScreenTxt(REMOVE_CUP);
            return;
        }

        //If there is an error, ERROR is printed to the green display.
        if (str.equals(ERROR))
        {
            setScreenTxt(str);
            return;
        }
        //In every other case.
        else
        {
            //Write which drink it is making.
            setScreenTxt("Making " + str + "...");
        }

        //Creates a runnable with given code to administrate countdown.
        Runnable myRunnable = new Runnable()
        {
            public void run()
            {
                try
                {
                    //Thread sleeps given milliseconds.
                    Thread.sleep(TIME_SLEEP);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(KaffeMaskine2Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Fills cup, change image and set default text.
                isFilled = true;
                isPressed = false;
                coffeeCup.setImage(new Image(CUP_FILLED));
                setScreenTxt(DEFAULT);
            }
        };

        //Creates and starts Thread with created runnable.
        Thread thread = new Thread(myRunnable);
        thread.start();
    }

    /**
     * Set text in green display.
     *
     * @param str text to write under PRETEXT.
     */
    private void setScreenTxt(String str)
    {
        txtarea.setText(PRETEXT + str);
    }

    /**
     * Change image for button.
     *
     * @param btn Button to change
     * @param img Image to use
     */
    private void setButtonImage(Button btn, Image img)
    {
        ImageView imgView = new ImageView();
        btn.setGraphic(imgView);
        imgView.imageProperty().set(img);
    }

    /**
     * Resets all buttons.
     */
    private void resetAllButtons()
    {
        setButtonImage(btnKaffe, BTN_BLUE);
        setButtonImage(btnKakao, BTN_BLUE);
        setButtonImage(btnCapucino, BTN_BLUE);
        setButtonImage(btnCaffeLatte, BTN_BLUE);
    }

    /**
     * Empty filled cup.
     *
     * @param event
     */
    @FXML
    private void handleCup(MouseEvent event)
    {
        //If filled
        if (isFilled)
        {
            resetAllButtons();

            //Set filled to false, change image and set text in green display.
            isFilled = false;
            coffeeCup.setImage(new Image(CUP_EMPTY));
            setScreenTxt(DEFAULT);
        }
    }
}
