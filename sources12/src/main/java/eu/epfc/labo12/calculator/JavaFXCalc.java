package eu.epfc.labo12.calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXCalc extends Application {

    // Pour mes calculs
    private double nb1, nb2, resultat;
    private final Label num1 = new Label("Number 1 :");
    private final TextField tfNum1 = new TextField();
    private final Label num2 = new Label("Number 2 :");
    private final TextField tfNum2 = new TextField();
    private final Label result = new Label("Result :") ;
    private final TextField tfResult = new TextField();
    private final Button btAdd = new Button("Add");
    private final Button btSous = new Button("Soustract");
    private final Button btnMult = new Button("Multiply");
    private final Button btnDivide = new Button("Divide");
    private final VBox root = new VBox(10);
    private final HBox ligne1 = new HBox(10); // espace entre les éléments
    private final HBox ligne2 = new HBox(10);

    @Override
    public void start(Stage primaryStage) {

        ligne2.setAlignment(Pos.CENTER); // centrer les boutons
        root.setAlignment(Pos.CENTER);

        layout();
        Scene scene = new Scene(root, 700, 100);
        mesBoutons();
        primaryStage.setTitle("Calculatrice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void layout() {
        root.getChildren().add(ligne1);
        root.getChildren().add(ligne2);

        ligne1.getChildren().addAll(num1, tfNum1, num2, tfNum2, result, tfResult);
        ligne2.getChildren().addAll(btAdd, btSous, btnMult, btnDivide);
        tfResult.setEditable(false);
    }
    // Actions ---------------------------------------------
    private void mesBoutons() {

            EventHandler<ActionEvent> evenement = (ActionEvent e) -> {
                if(!tfNum1.getText().equals("") && !tfNum1.getText().equals("") ) {
                    nb1 = Double.parseDouble(tfNum1.getText());
                    nb2 = Double.parseDouble(tfNum2.getText());
                    if (e.getSource() == btSous) { // Soustraction
                        resultat = nb1 - nb2;
                        tfResult.setText(Double.toString(resultat));
                    } else if (e.getSource() == btnDivide) {
                        if (nb2 == 0) {
                            System.out.println("Division par 0 pas autorisé");
                        }
                        resultat = nb1 / nb2;
                        tfResult.setText(Double.toString(resultat));
                    } else if (e.getSource() == btnMult) {
                        resultat = nb1 * nb2;
                        tfResult.setText(Double.toString(resultat));
                    } else if (e.getSource() == btAdd) {
                        resultat = nb1 + nb2;
                        // Un textfield s'attend à recevoir un string
                        tfResult.setText(Double.toString(resultat));
                    }
                }
            };

        btAdd.setOnAction(evenement);
        btSous.setOnAction(evenement);
        btnDivide.setOnAction(evenement);
        btnMult.setOnAction(evenement);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
