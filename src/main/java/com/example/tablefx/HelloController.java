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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloController {
    @FXML
    TableView<Triangle> tableView;
    @FXML
    Button button;


    public void initialize()
    {
        try {
            makeTable(read("1.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("не открылось");
        }
    }
    public ObservableList<Triangle> read(String filename) throws FileNotFoundException {
        File file=new File(filename);
        Scanner scanner=new Scanner(file);
        ObservableList<Triangle> triangleObservableList = FXCollections.observableArrayList();
        String a,b,c;
        while (scanner.hasNext()){
            a = scanner.next();
            b= scanner.next();
            c= scanner.next();
            triangleObservableList.add(new Triangle(a,b,c));
        }
        return triangleObservableList;
    }

    public void makeTable(ObservableList<Triangle> triangleObservableList)
    {
        //TableView<Triangle> tableView=new TableView<>(triangleObservableList);
        TableColumn<Triangle, String> aColumn=new TableColumn<>("A");
        aColumn.setCellValueFactory(new PropertyValueFactory<Triangle,String>("x"));
        tableView.getColumns().add(aColumn);
        TableColumn<Triangle, String> bColumn=new TableColumn<>("B");
        bColumn.setCellValueFactory(new PropertyValueFactory<Triangle,String>("y"));
        tableView.getColumns().add(bColumn);
        TableColumn<Triangle, String> cColumn=new TableColumn<>("C");
        cColumn.setCellValueFactory(new PropertyValueFactory<Triangle,String>("z"));
        tableView.getColumns().add(cColumn);

        tableView.setItems(triangleObservableList);
    }

    public  List<String> read() throws FileNotFoundException {
        String a=null;
        String b=null;
        String c =null;
        int line=0;
        File file=new File("1.txt");
        Scanner scanner=new Scanner(file);
        List<String> list = List.of(scanner.next().split(" "));
        while (scanner.hasNext()){
            list.add(scanner.next());
            a=list.get(0);
            b=list.get(1);
            c=list.get(2);
            line++;
        }

        ObservableList<Triangle> triangleObservableList = FXCollections.observableArrayList(
                new Triangle(a,b,c),
                new Triangle(a,b,c),
                new Triangle(a,b,c)
        );
        TableView<Triangle> tableView=new TableView<>(triangleObservableList);
        TableColumn<Triangle, String> aColumn=new TableColumn<>("A");
        aColumn.setCellValueFactory(new PropertyValueFactory<Triangle,String>("a"));
        tableView.getColumns().add(aColumn);
        TableColumn<Triangle, String> bColumn=new TableColumn<>("B");
        bColumn.setCellValueFactory(new PropertyValueFactory<Triangle,String>("b"));
        tableView.getColumns().add(bColumn);
        TableColumn<Triangle, String> cColumn=new TableColumn<>("C");
        cColumn.setCellValueFactory(new PropertyValueFactory<Triangle,String>("c"));
        tableView.getColumns().add(cColumn);

        return list;
    }
    public void doPloshad() throws FileNotFoundException {
        int a,b,c;
        int area,pl;
        File file=new File("1.txt");
        Scanner scanner=new Scanner(file);
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.next());
        }
        String[] array = list.toArray(new String[0]);
        for (int i = 0; i < array.length; i=i+3) {
            a= Integer.parseInt(array[i]);
            b= Integer.parseInt(array[i+1]);
            c= Integer.parseInt(array[i+2]);
            pl=(a+b+c)/2;
            area= (int) Math.sqrt(pl*(pl-a)*(pl-b)*(pl-c));
            }
    }

}