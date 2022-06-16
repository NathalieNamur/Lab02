package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	/**ATTRIBUTO DI RIFERIMENTO AL MODEL:**/
	private Dizionario model; 
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancella;
    
    @FXML
    private Button btnTraduci;

    @FXML
    private TextField txtInserito;

    @FXML
    private TextArea txtTraduzione;

    
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	txtInserito.clear();
    	txtTraduzione.clear();
    }
    
    
    @FXML
    void doTraduzione(ActionEvent event) {
    	
    	/**1.ACQUISIZIONE E CONTROLLO DATI:*/
    	
		String inserito = txtInserito.getText().toLowerCase();

		if(inserito == "") {
		txtTraduzione.setText("ERRORE:\nInserire la parola aliena (e la sua traduzione).");
			return;
		}

		//Scomposizione della stringa inserita in parole distinte,
		//che vengono salvate in un elemento StringTokenizer st:
		StringTokenizer st = new StringTokenizer(inserito, " ");
	
		//Estrazione della prima parola contenuta in st.
		//E salvataggio in una stringa parolaAliena:
		String parolaAliena = st.nextToken();
		
		//Se in st vi sono più parole, quindi è stata data anche la traduzione,
		//la parolaAliena e la sua traduzione devono essere aggiunte al dizionario:
		if (st.hasMoreTokens()) {
		
			//Estrazione della seconda parola contenuta in st.
			//E salvataggio in una stringa traduzione:
			String traduzione = st.nextToken();

			//Controllo della correttezza di parolaAliena e traduzione:
			if (!parolaAliena.matches("[a-z A-Z]*") || !traduzione.matches("[a-z A-Z]*")) {
				txtTraduzione.setText("ERRORE:\nInserire solo caratteri alfabetici.");
				return;
			}

			
			/**2.ESECUZIONE DELL'OPERAZIONE DI AGGIUNTA (MODEL):*/
			model.addParola(parolaAliena, traduzione);

			
			/**3.VISUALIZZAZIONE7AGGIORNAMENTO DEL RISULTATO:*/
			txtTraduzione.setText("La parola "+parolaAliena+" con traduzione "+traduzione+" \nè stata inserita nel dizionario.");

		
		//Se invece in st c'è solo una parola, quindi è stata data solo la parolaAliena, 
		//la sua traduzione va cercata nel dizionario:
		} else {

			//Controllo della correttezza della parola:
			if (!parolaAliena.matches("[a-z A-Z]*")) {
				txtTraduzione.setText("ERRORE:\nInserire solo caratteri alfabetici.");
				return;
			}

			
			/**2.ESECUZIONE DELL'OPERAZIONE DI AGGIUNTA (MODEL):*/
			String traduzione = model.translateParola(parolaAliena);
			
			
			/**3.VISUALIZZAZIONE/AGGIORNAMENTO DEL RISULTATO:*/
			if (traduzione != null) 
				txtTraduzione.setText("La traduzione della parola "+parolaAliena+" è "+traduzione+".");
			else 
				txtTraduzione.setText("La parola cercata non esiste nel dizionario.");
		}
    }

    
    
    /**DEFINIZIONE METODO setModel():**/
    /**PER ASSOCIARE IL MODEL ALL' ATTRIBUTO DI RIFERIMENTO.**/
    public void setModel(Dizionario model) {
		this.model = model;
	}



	@FXML
    void initialize() {
        assert btnTraduci != null : "fx:id=\"btnTraduci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserito != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduzione != null : "fx:id=\"txtTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}