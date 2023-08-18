package com.example.tablefx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;

public class HelloController {
    @FXML
    TableView<Triangle> tableView;
    @FXML
    Button button;

    public void initialize()
    {
        try {
            makeTable(read("1.txt"));
        } catch (IOException e) {
            System.out.println(":((");
        }
    }
    public ObservableList<Triangle> read(String filename) throws IOException {
        File file=new File(filename);
        Scanner scanner=new Scanner(file);
        ObservableList<Triangle> triangleObservableList = FXCollections.observableArrayList();
        double a,b,c;
        while (scanner.hasNext()){
            a = scanner.nextDouble();
            b= scanner.nextDouble();
            c= scanner.nextDouble();
            triangleObservableList.add(new Triangle(a,b,c));
        }
        return triangleObservableList;


    }

    public void makeTable(ObservableList<Triangle> triangleObservableList)
    {
        tableView.getColumns().clear();
        TableColumn<Triangle, Double> aColumn=new TableColumn<>("C");
        aColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        tableView.getColumns().add(aColumn);
        TableColumn<Triangle, Double> bColumn=new TableColumn<>("B");
        bColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
        tableView.getColumns().add(bColumn);
        TableColumn<Triangle, Double> cColumn=new TableColumn<>("C");
        cColumn.setCellValueFactory(new PropertyValueFactory<>("z"));
        tableView.getColumns().add(cColumn);
        TableColumn<Triangle, Double> columnArea = new TableColumn<>("Area");
        columnArea.setCellValueFactory(new PropertyValueFactory<>("area"));
        tableView.setItems(triangleObservableList);
    }

}