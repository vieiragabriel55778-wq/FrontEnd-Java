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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 *
 * @author gabri
 */
public class RecuperarSenha2{
  
    public Scene getScene(Stage primaryStage,String emailMascarado,String email) {
          
    Label titulo=new Label("/"+emailMascarado+"/");
    titulo.getStyleClass().add("tituloRecuperar");
               
    Label paragrafo=new Label("Codigo Enviado para Email");
    paragrafo.getStyleClass().add("paragrafo");
    
    TextField codigo=new TextField();
    codigo.setPromptText("Digite o codigo enviado");
    codigo.setMaxWidth(300);
    
        Button btn=new Button("Proximo");
        btn.setOnAction(e->{
        String Codigoveri="83749";
        String Codigo=codigo.getText();
        if(Codigo.equals(Codigoveri)){
        Recuperar tela=new Recuperar();    
        primaryStage.setScene(tela.getScene(primaryStage,email));
        }else{
        paragrafo.setText("Codigo Incorreto!");
        }
        
        });
        String Codigoveri="83749";
        System.out.println(Codigoveri);
        
        VBox principal=new VBox(20,titulo,paragrafo,codigo,btn);
        principal.setAlignment(Pos.CENTER);
                
               
        Scene scene = new Scene(principal, 700, 500);
        scene.getStylesheets().add(Cadastro.class.getResource("Css.css").toExternalForm());
        
        primaryStage.setTitle("Hello World!");
       
        
        return scene;
    }
  
      
}
