package com.example.assignment1aj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RestaurantController {

    @FXML
    private TableColumn<?, ?> categoryColumn;

    @FXML
    private ComboBox<?> itemcodeComboBox;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private TableColumn<?, ?> orderidColumn;

    @FXML
    private TableColumn<?, ?> itemnameColumn;

    @FXML
    private TableColumn<?, ?> DescriptionColumn;

    @FXML
    private Label itemLabel;

    @FXML
    private CheckBox popularitemCheckBox;

    @FXML
    private TableColumn<?, ?> phoneColumn;

    @FXML
    private TableColumn<?, ?> quantityColumn;

    @FXML
    private TableView<?> tableView;

    @FXML
    void itemcodeComboBox_OnClick(ActionEvent event) {

    }

    @FXML
    void popularitemCheckBox_OnClick(ActionEvent event) {

    }

}
