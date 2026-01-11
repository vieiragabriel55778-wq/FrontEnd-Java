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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author gabri
 */
public class RecuperarSenha {
    
        
    public static Scene getScene(Stage primaryStage) {
    Label titulo=new Label("Esqueceu a senha?");
    titulo.getStyleClass().add("tituloRecuperar");
    
    Label paragrafo=new Label("Redefina a senha em duas etapas");
    paragrafo.getStyleClass().add("paragrafo");
    
    TextField Email=new TextField();
    Email.setPromptText("Digite o deu Email");
    Email.setMaxWidth(300);
    
    Button btn=new Button("Proximo");
    btn.setMaxWidth(200);
    btn.setOnAction(e->{
    String senha="senha";    
    String email=Email.getText();
    Logica logica=new Logica(email,senha);
    if(logica.iniciar()){
    String EmailMascarado=logica.marcararEmail(email);
    RecuperarSenha2 tela=new RecuperarSenha2();
    primaryStage.setScene(tela.getScene(primaryStage,EmailMascarado,email));
    }else{
    paragrafo.setText("Email nao encontrado");
    }
    });
    
    
    
    VBox principal=new VBox(20,titulo,paragrafo,Email,btn);
    principal.setAlignment(Pos.CENTER);
    
    Scene cena=new Scene(principal,700,500);
    cena.getStylesheets().add(Cadastro.class.getResource("Css.css").toExternalForm());
    primaryStage.setTitle("Recuperar Senha");
    
    return cena;
    }

    

}
