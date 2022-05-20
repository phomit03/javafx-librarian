package assigment01;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void studentsScreen(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("student/studentlist.fxml"));
        Main.rootStage.setScene(new Scene(root, 1100, 650));
    }

    public void booksScreen() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("book/booklist.fxml"));
        Main.rootStage.setScene(new Scene(root, 1100, 650));
    }

    public void bookRentsScreen() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("rentsbook/bookrentslist.fxml"));
        Main.rootStage.setScene(new Scene(root, 1100, 650));
    }

}
