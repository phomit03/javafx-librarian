package assigment01.student;

import assigment01.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Student implements Serializable {
    public String maSV;
    public String hoTen;
    public Date ngaySinh;
    public Integer gioiTinh;
    public String diaChi;
    public Button editSt, deleteSt;

    //contructor
    public Student() {
    }
    public Student(String maSV, String hoTen, Date ngaySinh, Integer gioiTinh, String diaChi) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.editSt = new Button("Edit");
        this.deleteSt = new Button("Delete");

        this.editSt.setOnAction(event -> {
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("formstudent.fxml"));
                Parent root = loader.load();
                StudentInput si = loader.getController();    //gọi controller kèm giao diện
                si.setEditData(this);
                Main.rootStage.setScene(new Scene(root,1100,650));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        });

        this.deleteSt.setOnAction(event -> {
            StudentResponsitory sr = new StudentResponsitory();
            sr.delete(this);
        });
    }

    //g&s
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Button getEditSt() {
        return editSt;
    }

    public void setEditSt(Button editSt) {
        this.editSt = editSt;
    }

    public Button getDeleteSt() {
        return deleteSt;
    }

    public void setDeleteSt(Button deleteSt) {
        this.deleteSt = deleteSt;
    }
}
