package assigment01.student;

import assigment01.database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentResponsitory implements IStudentInterface {
    @Override
    public ArrayList<Student> list() {
        try {
            //truy van sql
            String txt_sql = "SELECT * FROM sinhvien";

            Connector conn = Connector.getInstance();   //connector
            PreparedStatement stt = conn.getStatement(txt_sql);

            ResultSet rs = stt.executeQuery(txt_sql);

            ArrayList<Student> studentList = new ArrayList<>();

            while (rs.next()) {
                studentList.add(new Student(
                        rs.getString("maSV"),
                        rs.getString("hoTen"),
                        Date.valueOf(rs.getString("ngaySinh")),
                        rs.getInt("gioiTinh"),
                        rs.getString("diaChi")
                ));
            }
            return studentList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void create(Student student) {
        try {
            //truy vấn sql: thêm sv vào assigment01.database
            String sql_txt = "INSERT INTO sinhvien (maSV,hoTen,ngaySinh,gioiTinh,diaChi) " +
                    " VALUES('" + student.getMaSV() + "','" + student.getHoTen() + "','" + student.getNgaySinh() + "','" + student.getGioiTinh() + "','" + student.getDiaChi() + "')";


            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            // insert
            stt.execute(sql_txt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Student student) {
        //lỗi vì maSV setup không để tự động tăng(char) ở assigment01.database (chưa fix) nên không edit được
        String sql_txt = "update sinhvien set hoTen=?,ngaySinh=?,gioiTinh=?,diaChi=? where maSV=?";
        try{
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1, student.getHoTen());
            stt.setString(2, student.getNgaySinh().toString());
            stt.setInt(3, student.getGioiTinh());
            stt.setString(4, student.getDiaChi());
            stt.setString(5, student.getMaSV());
            // insert
            stt.execute();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Student student) {
        //
        String sql_txt = "delete from sinhvien where maSV=?";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1, student.getMaSV());
            stt.execute();
        }catch (Exception e){

        }
    }
}
