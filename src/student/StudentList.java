package assigment01.student;

import assigment01.database.Connector;
import assigment01.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentList implements Initializable {
    public TableView<Student> tbStudent;
    public TableColumn<Student, String> sMaSV;
    public TableColumn<Student, String> sName;
    public TableColumn<Student, String> sDate;
    public TableColumn<Student, String> sGender;
    public TableColumn<Student, String> sAddress;
    public TableColumn<Student, Button> sEdit;
    public TableColumn<Student, Button> sDel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sMaSV.setCellValueFactory(new PropertyValueFactory<>("maSV"));
        sName.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        sDate.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        sGender.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        sAddress.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
        sEdit.setCellValueFactory(new PropertyValueFactory<>("editSt"));
        sDel.setCellValueFactory(new PropertyValueFactory<>("deleteSt"));

        try{
            StudentResponsitory sr = new StudentResponsitory();
            ArrayList<Student> as = sr.list();

            ObservableList<Student> studentList = FXCollections.observableArrayList();

            studentList.addAll(as);

            tbStudent.setItems(studentList);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void backHome(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setScene(new Scene(root, 1100, 650));
    }

    public void addSt(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("formstudent.fxml"));
        Main.rootStage.setScene(new Scene(root, 1100, 650));
    }

}
