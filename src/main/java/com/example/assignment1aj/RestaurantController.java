package com.example.assignment1aj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RestaurantController implements Initializable {

    @FXML
    private ComboBox<String> itemnameComboBox;

    @FXML
    private TableColumn<Restaurant, Integer> orderidColumn;

    @FXML
    private TableColumn<Restaurant, String> itemnameColumn;

    @FXML
    private TableColumn<Restaurant, String> CustomernameColumn;

    @FXML
    private TableColumn<Restaurant, String> orderdayColumn;

    @FXML
    private TableColumn<Restaurant, Double> priceColumn;

    @FXML
    private Label itemLabel;

    @FXML
    private CheckBox popularitemCheckBox;

    @FXML
    private TableView<Restaurant> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Fetch data from database
        List<Restaurant> restaurants = DBUtility.getDataFromDB();

        // Populate TableView
        tableView.getItems().addAll(restaurants);

        // Bind ComboBox items
        ObservableList<String> itemnames = FXCollections.observableArrayList();
        for (Restaurant restaurant : restaurants) {
            String itemname = restaurant.getitemname();
            if (!itemnames.contains(itemname)) {
                itemnames.add(itemname);
            }
        }
        itemnameComboBox.setItems(itemnames);

        // Initialize TableView columns
        orderidColumn.setCellValueFactory(new PropertyValueFactory<>("orderid"));
        itemnameColumn.setCellValueFactory(new PropertyValueFactory<>("itemname"));
        CustomernameColumn.setCellValueFactory(new PropertyValueFactory<>("Customername"));
        orderdayColumn.setCellValueFactory(new PropertyValueFactory<>("orderday"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @FXML
    void itemcodeComboBox_OnClick(ActionEvent event) {
        // Handle item code ComboBox action
    }

    @FXML
    void popularitemCheckBox_OnClick(ActionEvent event) {
        // Handle popular item CheckBox action
    }
}
