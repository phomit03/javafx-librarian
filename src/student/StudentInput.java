package assigment01.student;

import assigment01.database.Connector;
import assigment01.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.sql.Date;
import java.sql.PreparedStatement;

public class StudentInput {
    public TextField inputsMaSV, inputsName, inputsDate, inputsGender;
    public TextArea inputsAddress;
    public Text errorMsg;

    public Student editData;

    public void setEditData(Student editData) {
        this.editData = editData;
        this.inputsMaSV.setText(editData.getMaSV());
        this.inputsName.setText(editData.getHoTen());
        this.inputsDate.setText(editData.getNgaySinh().toString());
        this.inputsGender.setText(editData.getGioiTinh().toString());
        this.inputsAddress.setText(editData.getDiaChi());
        this.inputsMaSV.setDisable(true);
    }

    public void backListSt() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("studentlist.fxml"));
        Main.rootStage.setScene(new Scene(root, 1100, 650));
    }

    public void submitSt() {   //cơ chế event-listener;
        //input
        String ma = this.inputsMaSV.getText();
        String name = this.inputsName.getText();
        String date = this.inputsDate.getText();
        String gender = this.inputsGender.getText();
        String address = this.inputsAddress.getText();


        try {
            if (ma.isEmpty() || name.isEmpty() || date.equals("")  || gender.equals("") || address.isEmpty()){
                throw new Exception("Please enter full product information!");
            }

            StudentResponsitory sr = new StudentResponsitory();
            if(this.editData == null){ //nếu input rỗng thì add
                Student s = new Student(ma, name, Date.valueOf(date), Integer.parseInt(gender),address);
                sr.create(s);
            } else {    //edit
                sr.update(this.editData);
            }

            //dữ liệu đổ vào assigment01.database, từ assigment01.database tiếp tục đổ ngược lại tbStudent
            this.backListSt();  //tự động back lại nếu dữ liệu up lên và đổ về thành công

        } catch (NumberFormatException nf){
            errorMsg.setVisible(true);
            errorMsg.setFill(Color.RED);
            errorMsg.setText(nf.getMessage());
        }
        catch (Exception e) {
            errorMsg.setVisible(true);
            errorMsg.setFill(Color.RED);
            errorMsg.setText(e.getMessage());
        }
    }

        //không cần render vì tự động back lại list nếu ok
//    //reset input sau khi nhập xong
//    private void renderList() {
//        inputsName.setText("");
//        inputsName.setText("");
//        inputsDate.setText("");
//        inputsGender.setText("");
//        inputsAddress.setText("");
//    }

}
