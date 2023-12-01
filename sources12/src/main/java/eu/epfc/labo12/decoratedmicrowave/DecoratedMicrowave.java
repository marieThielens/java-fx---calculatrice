package eu.epfc.labo12.decoratedmicrowave;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DecoratedMicrowave extends Application {

    private final HBox root = new HBox();
    private final BorderPane gauche = new BorderPane();
    private final Pane gaucheTest = new FlowPane();
    private final VBox droite = new VBox();
    private final TextField time = new TextField("Time to be displayed here");
    private final GridPane grille = new GridPane();
    private final Button un = new Button("un");
    private final Button deux = new Button("deux");
    private final Button trois = new Button("trois");
    private final Button quatre = new Button("quatre");
    private final Button cinq = new Button("cinq");
    private final Button six = new Button("six");
    private final Button sept = new Button("sept");
    private final Button huit = new Button("huit");
    private final Button neuf = new Button("neuf");
    private final Button zero = new Button("zero");
    private final Button start = new Button("start");
    private final Button stop = new Button("Stop");
    private final Integer LIGNES = 2;
    private final Integer COLONES = 3;
    private final Button[] tabBouton= {un, deux, trois, quatre, cinq, six, sept, huit, neuf, zero, start, stop};


    @Override
    public void start(Stage primaryStage) {

        layout();
        Scene scene = new Scene(root, 700, 200);
        primaryStage.setTitle("micro-onde");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private void layout() {
       //  Image imageBurger = new Image("file:images/burger.jpg");
        Image imageBurger = new Image("burger.jpg");
        ImageView imageViewBurger = new ImageView(imageBurger);

        root.getChildren().addAll(gauche, droite);
        gauche.setCenter(imageViewBurger);
        gauche.setPrefSize(350, 200);
        droite.getChildren().addAll(time, grille);



        for (int i = 0; i < tabBouton.length; i++) {
            tabBouton[i].setPrefSize(50, 50);
            tabBouton[i].setPrefHeight(50);
            tabBouton[i].setOnAction(e-> {
                /* POur qu'il me dise sur quel bouton j'ai cliqué ((Button)) pcq j'aurais
                * plus cliquer sur autre chose */
                System.out.println(((Button)e.getSource()).getText());
            });
        }

        int index = 0;
        for (int i = 0; i <= COLONES ; i++) {
            for (int j = 0; j <= LIGNES ; j++) {
                grille.add(tabBouton[index], j, i);
                index++;
            }
        }
        // couleurs des boutons
        start.setStyle("-fx-text-fill: green;");
        stop.setStyle("-fx-text-fill: red");
    }

    public static void main(String[] args) {
        launch(args);
    }

}

