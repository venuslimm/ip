package duke.controller;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

/**
 * A custom control using FXML that represents a dialog box consisting of an ImageView to represent the speaker's face
 * and a label containing text from the speaker.
 */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    /**
     * Creates DialogBox object based on the text and img passed into this constructor.
     *
     * @param text to be displayed on the DialogBox.
     * @param image to be printed on the DialogBox.
     */
    public DialogBox(String text, Image image) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        displayPicture.setImage(image);
    }

    public DialogBox getUserDialog() {
        return this;
    }

    public DialogBox getDukeDialog(boolean isError) {
        this.flip();
        dialog.setStyle("-fx-border-color: black; -fx-border-radius: 5; -fx-label-padding: 5; "
                + "-fx-background-color: D4C5E2;");
        if (isError) {
            dialog.setTextFill(Paint.valueOf("#8f001a"));
        }
        return this;
    }

    /**
     * Mirrors the entire dialog box.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }
}
