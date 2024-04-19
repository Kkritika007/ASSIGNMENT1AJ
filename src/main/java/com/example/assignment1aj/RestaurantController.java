package com.example.assignment1aj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.*;

public class RestaurantController implements Initializable {

    @FXML
    private TableView<Restaurant> tableView;

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
    private ComboBox<String> itemnameComboBox;

    @FXML
    private CheckBox popularitemCheckBox;

    @FXML
    private PieChart pieChart;

    private List<Restaurant> currentData;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize TableView columns
        orderidColumn.setCellValueFactory(new PropertyValueFactory<>("orderid"));
        itemnameColumn.setCellValueFactory(new PropertyValueFactory<>("itemname"));
        CustomernameColumn.setCellValueFactory(new PropertyValueFactory<>("Customername"));
        orderdayColumn.setCellValueFactory(new PropertyValueFactory<>("orderday"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Populate TableView with all data initially
        currentData = DBUtility.getDataFromDB();
        populateTableView(currentData);

        // Populate ComboBox with unique item names
        populateItemNameComboBox(currentData);
    }

    @FXML
    void itemcodeComboBox_OnClick(ActionEvent event) {
        String selecteditemName = itemnameComboBox.getValue();
        if (selecteditemName != null && !selecteditemName.isEmpty()) {
            List<Restaurant> filteredData = DBUtility.getDataFromDB();
            populateTableView(filteredData);
        }
    }

    @FXML
    void popularitemCheckBox_OnClick(ActionEvent event) {
        if (popularitemCheckBox.isSelected()) {
            String mostOrderedItem = findMostOrderedItem(currentData);
            updateChartWithMostOrderedItem(mostOrderedItem);
        } else {
            // Clear the chart when the checkbox is deselected
            pieChart.getData().clear();
        }
    }

    private void populateTableView(List<Restaurant> data) {
        tableView.getItems().clear();
        tableView.getItems().addAll(data);
    }

    private void populateItemNameComboBox(List<Restaurant> data) {
        Set<String> uniqueItemNames = new TreeSet<>();
        for (Restaurant restaurant : data) {
            uniqueItemNames.add(restaurant.getitemname());
        }
        itemnameComboBox.getItems().addAll(uniqueItemNames);
    }

    private String findMostOrderedItem(List<Restaurant> data) {
        Map<String, Integer> itemCountMap = new HashMap<>();
        for (Restaurant restaurant : data) {
            String itemName = restaurant.getitemname();
            itemCountMap.put(itemName, itemCountMap.getOrDefault(itemName, 0) + 1);
        }
        // Find the item with the maximum count
        int maxCount = 0;
        String mostOrderedItem = null;
        for (Map.Entry<String, Integer> entry : itemCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostOrderedItem = entry.getKey();
            }
        }
        return mostOrderedItem;
    }

    private void updateChartWithMostOrderedItem(String mostOrderedItem) {
        pieChart.getData().clear();
        if (mostOrderedItem != null) {
            pieChart.getData().add(new PieChart.Data(mostOrderedItem, getCountOfItem(mostOrderedItem)));
        }
    }

    private int getCountOfItem(String item) {
        int count = 0;
        for (Restaurant restaurant : currentData) {
            if (restaurant.getitemname().equals(item)) {
                count++;
            }
        }
        return count;
    }
}
