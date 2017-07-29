package app.controller;
import database.DBConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField tf1;

    @FXML
    private Label lbl;

    @FXML
    private Label lbll;

    @FXML
    private Label lblp;

    @FXML
    private Button btn;

    @FXML
    private PasswordField tf2;

    @FXML
    private TextField tf11;

    @FXML
    private CheckBox cb;
    
    @FXML
    private Label lbli;
    
    public DBConnector db;
    String logowanie;

    public void Login(ActionEvent event) throws IOException, ClassNotFoundException, SQLException{
    	Connection conn1 = db.Connection();	
		Statement stat = conn1.createStatement();
        ResultSet rs = stat.executeQuery("select * from log where login= '"+tf1.getText()+"';");
        
        while (rs.next()) {
        	  logowanie = rs.getString("login");
        }
        System.out.println(logowanie);
		if(!logowanie.equals(null)){
			Stage stageTable = new Stage();
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/TableView.fxml"));
	        Scene sceneTable = new Scene(root);
	        stageTable.setScene(sceneTable);
	        stageTable.setTitle("Table page");
	        stageTable.show();	
		} else {
			System.out.println("Logowanie błędne");
			lbl.setText(lbl.getText() + " - błędne hasło lub login!");	
			tf1.setText(null);
			tf2.setText(null);
			tf11.setText(null);
		}
    }
			
    @FXML
    void show(MouseEvent event) {
    	if (cb.isSelected()){
    		tf2.setDisable(true);
    		tf11.setVisible(true);
    		tf11.setText(tf2.getText());    		
    		}
    	if (cb.isSelected()==false){
    		tf2.setDisable(false);
    		tf11.setVisible(false);
    		tf2.setText(tf11.getText());
    	}
    	
    	
    	}
    public void initialize(){
 	   db=new DBConnector();
    }

    }


