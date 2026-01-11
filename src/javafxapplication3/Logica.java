/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication3;
/**
 *
 * @author gabri
 */
public class Logica {
    private Server server;
    private Server2 server2;
    private String Email;
    private String Senha;

    public Logica(String Email, String Senha) {
        this.Email=Email;
        this.Senha=Senha;
        this.server=new Server();
        this.server2=new Server2();
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    public String Cadastrar(){
    String resposta=server.Cadastrar(getEmail(), getSenha());
        
    
     return resposta;
    }
    
    public String NovaSenha(){
    String resposta=server2.NovaSenha(getEmail(),getSenha());
        System.out.println("Senha enviada");
    return resposta;
    }
    
    
    
    
    
    boolean iniciar(){
    String resposta=server2.IniciarVeri(getEmail());
        System.out.println(resposta);
        
   if(resposta==null)return false;
   
   if(resposta.contains("\"mensagem\":\"Email encontrado\"")){
      return true;
    }else{
          return false;  
         }
    }
    
    String marcararEmail(String Email){
     if(Email==null||!Email.contains("@")){
      return "email invalido";
     }          
        
        
        
    String[] partes=Email.split("@",2);
    
    String nome=partes[0];
    
    String visivel=nome.length()<= 2
    ?nome.charAt(0)+"*"
    :nome.substring(0,2)+"****";
    
    return visivel+"@"+partes[1];  
    }
    
    
    
    
    
  public boolean Enviar(){
      String resposta=server.chamarAPI(getEmail(), getSenha());
      System.out.println(resposta);
      
      if(resposta==null)return false;
      
      if(resposta.contains("\"status\":\"ok\"")){
      return true;
      }
      return false;
  }
}
