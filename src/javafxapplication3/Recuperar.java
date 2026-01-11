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
public class Recuperar{
    
    
    public Scene getScene(Stage primaryStage,String email) {
    Label titulo=new Label("Nova Senha");
    titulo.getStyleClass().add("tituloRecuperar");
    
       
    
    
    Label paragrafo=new Label("Digite a nova senha");
    paragrafo.getStyleClass().add("paragrafo");
    
    TextField Senha=new TextField();
    Senha.setPromptText("Digite a senha");
    Senha.setMaxWidth(300);
    
    TextField Senha2=new TextField();
    Senha2.setPromptText("Digite a senha novament");
    Senha2.setMaxWidth(300);
    
    Button btn=new Button("Proximo");
    btn.setMaxWidth(200);
    btn.setOnAction(e->{   
     String senha=Senha.getText();
     String senha2=Senha2.getText();
     String padraoSenha="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%]).{8,}$";
     if(!senha.equals(senha2)){
     paragrafo.setText("SENHAS INCORRETAS!");
     }else if(!senha.matches(padraoSenha)){
     paragrafo.setText("senha deve incluir letras maiúsculas, minúsculas, números ");
     }else if(senha.matches(padraoSenha)){
     Logica logica=new Logica(email,senha);    
     logica.NovaSenha();
     RecuperarSucesso tela2=new RecuperarSucesso();
     primaryStage.setScene(tela2.getScene(primaryStage));
     }
    });
    
    
    
    VBox principal=new VBox(30,titulo,paragrafo,Senha,Senha2,btn);
    principal.setAlignment(Pos.CENTER);
    
    Scene cena=new Scene(principal,700,500);
    cena.getStylesheets().add(Recuperar.class.getResource("Css.css").toExternalForm());
    
    primaryStage.setTitle("Recuperar senha");
    
    
    return cena;
    }

  
}
