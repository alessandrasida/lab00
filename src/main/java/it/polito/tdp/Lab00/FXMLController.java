package it.polito.tdp.Lab00;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button accedi;

    @FXML
    private Button code;

    @FXML
    private GridPane nome;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextArea txtRitorno;
    
    private String name = "";
    private String pass = "";
    private int contatore = 0;
    private String passwordValida = "";
    
    @FXML
    void doAccedi(ActionEvent event) {
    	if(this.txtNome.getText() != null) {
    		if(contatore >= 2) {
    			this.txtRitorno.setText("Premere clear per ritentare");
    		return;
    	}
    		if(this.txtPassword.getText().length()>6) {
	    		name = this.txtNome.getText();
	    		pass = this.txtPassword.getText();
	    		boolean flag1 = pass.matches(".*[0-9].*");
	    		boolean flag2 = pass.matches(".*[!?@#].*");
	    		boolean flag3 = pass.matches(".*[A-Z].*");
	    		if(flag1 == true && flag2 == true && flag3 == true) {
	    			this.txtRitorno.setText("Accesso avvenuto con successo");
	    			this.passwordValida = pass;
	    		}
	    		else {
	    			this.contatore++;
	    			this.txtRitorno.setText("\nErrore nella password" + "\nTentativi rimasti: " + (3-contatore));
	    			this.txtNome.setEditable(false);
	    			
	    		}
	    	}
    		else {
    			contatore++;
    			this.txtRitorno.setText("\nErrore nella password"+ "\nTentativi rimasti: " + (3-contatore));
    			this.txtNome.setEditable(false);
    		}
    	}
    	else {
    		this.txtRitorno.setText("Errore nell'accesso");
    	}
    	
    }

    @FXML
    void doCode(ActionEvent event) {
    	this.txtNome.setEditable(true);
    	this.contatore = 0;
    	this.txtNome.setText(null);
    	this.txtPassword.setText(null);
    }

    @FXML
    void initialize() {
        assert accedi != null : "fx:id=\"accedi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert code != null : "fx:id=\"code\" was not injected: check your FXML file 'Scene.fxml'.";
        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRitorno != null : "fx:id=\"txtRitorno\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
