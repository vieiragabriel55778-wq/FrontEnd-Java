/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication3;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Cadastro{

public static Scene getScene(Stage primaryStage) {
 
        
        Label titulo=new Label("Cadastro");
        
        titulo.getStyleClass().add("Titulo");
        TextField nome=new TextField();
        
        Label erroNome=new Label("nome Incorreto");
        nome.setPromptText("Nome");
        nome.setMaxWidth(150);
        erroNome.getStyleClass().add("erroNom");
        erroNome.setVisible(false);
        
        
        TextField sobrenome=new TextField();
        Label erroSobre=new Label("Padrao Incorreto");
        erroSobre.getStyleClass().add("erroSobre");
        erroSobre.setVisible(false);
        sobrenome.setPromptText("Sobrenome");
        sobrenome.setMaxWidth(150);
        
        HBox segundario=new HBox(10);
        HBox segundarioErro=new HBox(120);
        
        
        segundarioErro.setAlignment(Pos.CENTER);
        segundarioErro.getChildren().addAll(erroNome,erroSobre);
        segundario.setAlignment(Pos.CENTER);
        segundario.getChildren().addAll(nome,sobrenome);
        
        TextField email=new TextField();
        email.setPromptText("Email");
        email.setMaxWidth(300);
        Label emailErro=new Label("Email fora do padrao");
        emailErro.getStyleClass().add("erroSobre");
        emailErro.setVisible(false);
        
        
        
        PasswordField senha=new PasswordField();
        senha.setPromptText("Digite a senha");
        senha.setMaxWidth(300);
        Label erroSenha=new Label("senha deve incluir letras maiúsculas, minúsculas, números ");
        erroSenha.getStyleClass().add("erroSobre");
        erroSenha.setVisible(false);
        
        
        
        PasswordField senha2=new PasswordField();
        senha2.setPromptText("Digite a senha novamente");
        senha2.setMaxWidth(300);
        Button btn = new Button();
        btn.setText("Cadastrar");
        btn.setMaxWidth(150);
        // troca de layout Sucesso
        btn.setOnAction(e->{
        String Dominios[]={"yahoo.com","gmail.com","outlook.com"};    
        String Nome=nome.getText();
        String Sobre=sobrenome.getText();
        String Email=email.getText();
        String Senha=senha.getText();
        String padraoNome="^[A-Za-z ]+$";
        String dominiosRegex=String.join("|", Dominios).replace(".","\\.");
        String padraoEmail="^[a-zA-Z0-9]+@("+dominiosRegex+")$";
        String padraoSenha="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%]).{8,}$";
        boolean validacaoNome=Nome.matches(padraoNome);
        boolean validacaoSobre=Sobre.matches(padraoNome);
        boolean validacaoEmail=Email.matches(padraoEmail);
        boolean validacaoSenha=Senha.matches(padraoSenha);
         if(!validacaoNome){
         erroNome.setVisible(true);
         }
         if(!validacaoSobre){
         erroSobre.setVisible(true);
         }
         if(!validacaoEmail){
          emailErro.setVisible(true);
         }
         if(!validacaoSenha){
        erroSenha.setVisible(true);
         }
         if(validacaoNome && validacaoSobre && validacaoEmail && validacaoSenha){
         primaryStage.setScene(CadastroSucesso.getScene(primaryStage));
         Logica logica=new Logica(Email, Senha);
         logica.Cadastrar();
         }    
             
     
        });
        //
        
       VBox pricipal = new VBox(10);
       pricipal.setAlignment(Pos.CENTER);
       pricipal.getChildren().addAll(titulo,segundario,segundarioErro,email,emailErro,senha,erroSenha,senha2,btn);
       Scene cena=new Scene(pricipal,700,500);
       cena.getStylesheets().add(Cadastro.class.getResource("Css.css").toExternalForm());
       primaryStage.setTitle("Cadastro");
        
      
        return cena;
    }
    
}
