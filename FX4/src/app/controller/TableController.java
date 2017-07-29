package app.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.model.TableModel;
import database.DBConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController {
	@FXML
    private TableView<TableModel> Table;
    @FXML
    private TableColumn<TableModel,Integer> tb_id;
    @FXML
    private TableColumn<TableModel,String> tb_firstname;
    @FXML
    private TableColumn<TableModel,String> tb_lastname;
    @FXML
    private TableColumn<TableModel,String> tb_gsalary;
    @FXML
    private Button btn_refresh;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_insert;

    @FXML
    private Button btn_commitupd;
    @FXML
    private TextField tf_firstname;
    @FXML
    private TextField tf_lastname;
    @FXML
    private TextField tf_gsalary;
    @FXML
    private Button btn_commit;
    
    public DBConnector db;
    public ObservableList<TableModel> data=FXCollections.observableArrayList();
    
    @FXML
    void btncommitactionupd(ActionEvent event) throws ClassNotFoundException, SQLException {
    	java.sql.PreparedStatement preparedStatement= null;
    	int id_update= Table.getSelectionModel().getSelectedItem().getId();
    	Connection conn=db.Connection(); 
        
    	String sql="UPDATE employee SET firstName_employee=?,lastName_employee=?,gross_salary=? where id_employee=?";
    	preparedStatement=conn.prepareStatement(sql);
    	preparedStatement.setString(1, tf_firstname.getText());
    	preparedStatement.setString(2, tf_lastname.getText());
    	preparedStatement.setString(3, tf_gsalary.getText());
    	preparedStatement.setInt(4, id_update);
    	preparedStatement.executeUpdate();
    	tf_firstname.clear();
    	tf_lastname.clear();
    	tf_gsalary.clear();
 
    }
    
    @FXML
    void btncommitaction(ActionEvent event) throws ClassNotFoundException, SQLException {
    	java.sql.PreparedStatement preparedStatement= null;
    	Connection conn=db.Connection(); 	
    	String sql="INSERT into employee (firstName_employee,lastName_employee,gross_salary) values (?,?,?)";
    	preparedStatement=conn.prepareStatement(sql);
    	preparedStatement.setString(1, tf_firstname.getText());
    	preparedStatement.setString(2, tf_lastname.getText());
    	preparedStatement.setString(3, tf_gsalary.getText());
    	
    	preparedStatement.executeUpdate();
    	tf_firstname.clear();
    	tf_lastname.clear();
    	tf_gsalary.clear();
    }
    @FXML
    void btndeleteactioc(ActionEvent event) throws SQLException, ClassNotFoundException{
    	java.sql.PreparedStatement preparedStatement= null;
    	int id_del= Table.getSelectionModel().getSelectedItem().getId();
    	Connection conn=db.Connection();
    	
    	String sql= "DELETE FROM employee WHERE id_employee="+id_del+";";
    	preparedStatement=conn.prepareStatement(sql);
    	preparedStatement.executeUpdate();
    }

    @FXML
    void btninsertaction(ActionEvent event) {
    	tf_firstname.clear();
    	tf_lastname.clear();
    	tf_gsalary.clear();
    
    	
    	tf_firstname.setDisable(false);
    	tf_lastname.setDisable(false);
    	tf_gsalary.setDisable(false);
    	btn_commit.setDisable(false);
    	btn_commitupd.setDisable(true);
    	
    }

    @FXML
    void btnrefreshaction(ActionEvent event) throws ClassNotFoundException {
	try{ 
		Connection conn= db.Connection();
		data= FXCollections.observableArrayList();
		ResultSet rs=conn.createStatement().executeQuery("SELECT * from employee");
		while(rs.next()){
		data.add(new TableModel(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4))); 
		}
	}catch (Exception ex){
		System.out.println("Error"+ ex);
	}
	tb_id.setCellValueFactory(new PropertyValueFactory<TableModel, Integer>("id"));
	tb_firstname.setCellValueFactory(new PropertyValueFactory<TableModel, String>("firstName"));
	tb_lastname.setCellValueFactory(new PropertyValueFactory<TableModel, String>("lastName"));
	tb_gsalary.setCellValueFactory(new PropertyValueFactory<TableModel, String>("salary"));
    
	Table.setItems(null);
	Table.setItems(data);
    
    }

    @FXML
    void btnupdateaction(ActionEvent event) throws ClassNotFoundException, SQLException {
    	tf_firstname.setDisable(false);
    	tf_lastname.setDisable(false);
    	tf_gsalary.setDisable(false);
    	btn_commit.setDisable(true);
    	btn_commitupd.setDisable(false);
    	
    	java.sql.PreparedStatement preparedStatement= null;
    	int id_update= Table.getSelectionModel().getSelectedItem().getId();
    	Connection conn=db.Connection(); 
    	tf_firstname.setText(Table.getSelectionModel().getSelectedItem().getFirstName());
    	tf_lastname.setText(Table.getSelectionModel().getSelectedItem().getLastName());
    	tf_gsalary.setText(Table.getSelectionModel().getSelectedItem().getSalary());

    }
   public void initialize(){
	   db=new DBConnector();
   }

}
