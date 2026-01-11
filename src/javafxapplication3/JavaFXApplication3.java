/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication3;

import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import static javafx.geometry.Pos.CENTER;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author gabri
 */
public class JavaFXApplication3 extends Application {
    
    private static Scene loginScene;
    
       @Override
    
       public void start(Stage primaryStage) {
        Label Login=new Label("Login");
        Login.getStyleClass().add("Titulo");
              
        TextField email=new TextField();
        email.setPromptText("Digite o Email");
        email.setMaxWidth(300);
        
        PasswordField senha=new PasswordField();
        senha.setPromptText("Digite a senha");
        senha.setMaxWidth(300);
        
        Hyperlink cadas=new Hyperlink("Fazer cadastro");
        cadas.setOnAction(e->{
        primaryStage.setScene(Cadastro.getScene(primaryStage));
        });
        Hyperlink esque=new Hyperlink("Esqueceu a senha");
        esque.setOnAction(e->{
        primaryStage.setScene(RecuperarSenha.getScene(primaryStage));
        
        });
        
        
        Button btn = new Button();
        btn.setMaxWidth(200);
        btn.setText("enter");
        //Evento
        btn.setOnAction(e->{
        String Email=email.getText();
        String Senha=senha.getText();
        Logica logica=new Logica(Email,Senha); 
        boolean sucesso=logica.Enviar();
        
        
        if(sucesso){
        primaryStage.setScene(LoginSucesso.getScene(primaryStage));
        }else{
            System.out.println("Login invalido");
        }
        
        
        });
        //
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(Login,email,senha,cadas,esque,btn);
        
        Scene scene = new Scene(root, 700, 500);
        scene.getStylesheets().add(getClass().getResource("Css.css").toExternalForm());
        
       loginScene=scene;
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Scene getLoginScene(){
    return loginScene;
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
