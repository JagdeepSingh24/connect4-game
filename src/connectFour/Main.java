package connectFour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private  Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Application Started");

       FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();

         controller = loader.getController();
         controller.createPlayground();

         MenuBar menuBar = createMenu();
         menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

         Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
         menuPane.getChildren().add(menuBar);


         Scene scene = new Scene(rootGridPane);

         primaryStage.setScene(scene);
         primaryStage.setTitle("Connect Four");
         primaryStage.setResizable(false);
         primaryStage.show();
    }

    private MenuBar createMenu(){

        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(actionEvent -> resetGame());


        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(actionEvent -> resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit Game");
        exitGame.setOnAction(actionEvent -> exitGame());

        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem ,exitGame);

        //Help menu
        Menu helpMenu = new Menu("Help");

        MenuItem aboutGame = new MenuItem("About Connect Four");
        aboutGame.setOnAction(actionEvent -> aboutGame());

        SeparatorMenuItem separatorMenuItem2 = new SeparatorMenuItem();
        MenuItem aboutOwner = new MenuItem("About Owner");
        aboutOwner.setOnAction(actionEvent -> aboutOwner());

        helpMenu.getItems().addAll(aboutGame,  separatorMenuItem2 ,aboutOwner);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;

    }

    private void aboutOwner() {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Jagdeep Singh");
        alert.setContentText("Hi! I am Jagdeep Singh, a developer focused on crafting" +
                " great web/app experiences.  Being an Engineer" +
                " I believe in using science to find creative practical solutions.");
        alert.show();
    }

    private void aboutGame() {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How To Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the \" +\n" +
                "\t\t\t\t\"players first choose a color and then take turns dropping colored discs \" +\n" +
                "\t\t\t\t\"from the top into a seven-column, six-row vertically suspended grid. \"+\n" +
                "\t\t\t\t\"The pieces fall straight down, occupying the next available space within the column. \"+\n" +
                "\t\t\t\t\"The objective of the game is to be the first to form a horizontal, vertical, \" +\n" +
                "\t\t\t\t\"or diagonal line of four of one's own discs. Connect Four is a solved game. \" +\n" +
                "\t\t\t\t\"The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exitGame() {

        Platform.exit();
        System.exit(0);
    }

    public  void resetGame(){
        //TODO
    }

    public static void main(String[] args) {
        launch(args);
    }
}
