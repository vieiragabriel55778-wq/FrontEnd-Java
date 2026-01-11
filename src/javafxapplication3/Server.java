package javafxapplication3;
import java.io.*;
import java.net.*;

public class Server {

    private String urlLogin = "http://localhost:3000/rotas/login";
    private String urlCadastro = "http://localhost:3000/rotas/email";
    
    
     public String Cadastrar(String email, String senha) {
        try {
            URL url = new URL(urlCadastro);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            // Cria JSON
            String jsonInput = "{\"email\":\"" + email + "\",\"senha\":\"" + senha + "\"}";

            try(OutputStream os = con.getOutputStream()){
                os.write(jsonInput.getBytes());
            }

            // Lê resposta
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))){
                StringBuilder resposta = new StringBuilder();
                String linha;
                while((linha = br.readLine()) != null){
                    resposta.append(linha);
                }
                return resposta.toString();
            }

        } catch(IOException e){
            e.printStackTrace();
            return "Erro na conexão com API";
        }
    }
    
    
    
    
    
    
    public String chamarAPI(String email, String senha) {
        try {
            URL url = new URL(urlLogin);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            // Cria JSON
           String jsonInput = "{\"email\":\"" + email.replace("\\","\\\\").replace("\"","\\\"") + 
                   "\",\"senha\":\"" + senha.replace("\\","\\\\").replace("\"","\\\"") + "\"}";

            try(OutputStream os = con.getOutputStream()){
                os.write(jsonInput.getBytes());
            }

            // Lê resposta
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))){
                StringBuilder resposta = new StringBuilder();
                String linha;
                while((linha = br.readLine()) != null){
                    resposta.append(linha);
                }
                return resposta.toString();
            }

        } catch(IOException e){
            e.printStackTrace();
            return "Erro na conexão com API";
        }
    }
}