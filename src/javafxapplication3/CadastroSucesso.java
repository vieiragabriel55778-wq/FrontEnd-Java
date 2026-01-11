/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author gabri
 */
public class CadastroSucesso {
    
    
    public  static Scene getScene(Stage primaryStage) {
        Label Sucesso=new Label("Cadastrado com Sucesso");
        Sucesso.getStyleClass().add("TituloCadas");
        Hyperlink Logar=new Hyperlink("Fazer Login");
        Logar.setOnAction(e->{  
        primaryStage.setScene(JavaFXApplication3.getLoginScene());
        });
        Logar.getStyleClass().add("Logar");
        VBox leyout=new VBox(10,Sucesso,Logar);
        leyout.setAlignment(Pos.CENTER);
        Scene scene=new Scene(leyout,700,500);
        scene.getStylesheets().add(CadastroSucesso.class.getResource("Css.css").toExternalForm());
        primaryStage.setTitle("SucessoCadastro");
       
     
       return scene;       
    }


}
