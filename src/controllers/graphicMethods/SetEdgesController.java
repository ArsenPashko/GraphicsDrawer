package controllers.graphicMethods;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Bohdan Pashko on 04.04.2016.
 */
public class SetEdgesController implements Initializable {
    @FXML
    public Label labelHeader, labelXTo, labelYFrom, labelYTo, labelXFrom;

    @FXML
    public TextField textFieldYFrom, textFieldYTo, textFieldXTo, textFieldXFrom;

    @FXML
    public Button buttonOk, buttonCancel;


    private Double xFrom;
    private Double xTo;
    private Double yFrom;
    private Double yTo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void action_buttonOk(ActionEvent event) {
        xFrom = Double.parseDouble(textFieldXFrom.getText());
        xTo = Double.parseDouble(textFieldXTo.getText());
        yFrom = Double.parseDouble(textFieldYFrom.getText());
        yTo = Double.parseDouble(textFieldYTo.getText());

        labelHeader.getScene().getWindow().hide();
    }

    public void action_buttonCancel(ActionEvent event) {
        xFrom = null;
        xTo = null;
        yFrom = null;
        yTo = null;

        labelHeader.getScene().getWindow().hide();
    }

    public boolean isCoordinatePresent() {
        return xFrom != null && xTo != null && yFrom != null && yTo != null;
    }

    public Double getXFrom() {
        return xFrom;
    }

    public void setXFrom(Double xFrom) {
        this.xFrom = xFrom;
    }

    public Double getXTo() {
        return xTo;
    }

    public void setXTo(Double xTo) {
        this.xTo = xTo;
    }

    public Double getYFrom() {
        return yFrom;
    }

    public void setYFrom(Double yFrom) {
        this.yFrom = yFrom;
    }

    public Double getYTo() {
        return yTo;
    }

    public void setYTo(Double yTo) {
        this.yTo = yTo;
    }
}
