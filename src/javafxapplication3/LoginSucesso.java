/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication3;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author gabri
 */
 public class LoginSucesso{
    
  public static Scene getScene(Stage stage){
  Label label=new Label("Sucesso no login");
  label.getStyleClass().add("Titulo2");
      
  VBox root=new VBox(20,label);
  root.setAlignment(Pos.CENTER);
  Scene scene=new Scene(root,700,500);
  scene.getStylesheets().add(LoginSucesso.class.getResource("Css.css").toExternalForm());
 
  return scene; 
  }
}
