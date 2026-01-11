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
 public class RecuperarSucesso{
    
  public static Scene getScene(Stage stage){
  Label label=new Label("Senha Alterada com Sucesso");
  label.getStyleClass().add("Titulo2");
  Hyperlink Login=new Hyperlink("Fazer Login");
  Login.setOnAction(e->{
  stage.setScene(JavaFXApplication3.getLoginScene());
  });
  
      
  VBox root=new VBox(20,label,Login);
  root.setAlignment(Pos.CENTER);
  Scene scene=new Scene(root,700,500);
  scene.getStylesheets().add(LoginSucesso.class.getResource("Css.css").toExternalForm());
 
  return scene; 
  }
}
