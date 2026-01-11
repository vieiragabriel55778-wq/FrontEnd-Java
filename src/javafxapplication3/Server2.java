package javafxapplication3;
import java.io.*;
import java.net.*;
import org.json.JSONObject;


public class Server2{

    private String urlIniciar = "http://localhost:3000/rotas/iniciar";
    private String urlNovaSenha = "http://localhost:3000/rotas/novaSenha";
    
    
     public String IniciarVeri(String email) {
        try {
            URL url = new URL(urlIniciar);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            // Cria JSON
            String jsonInput = "{\"email\":\"" + email + "\"}";

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
    
    
    
    
    
    
   public String NovaSenha(String email, String senha) {
    try {
        URL url = new URL(urlNovaSenha);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        // Cria JSON e escapa caracteres especiais
        JSONObject json = new JSONObject();
json.put("email", email);
json.put("senha", senha);

String jsonInput = json.toString();

        // Envia JSON
        try (OutputStream os = con.getOutputStream()) {
            os.write(jsonInput.getBytes("UTF-8")); // força UTF-8
        }

        // Captura o código de status
        int status = con.getResponseCode();
        InputStream is;
        if (status >= 200 && status < 300) {
            is = con.getInputStream(); // resposta OK
        } else {
            is = con.getErrorStream(); // resposta de erro
        }

        // Lê resposta do servidor
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            StringBuilder resposta = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                resposta.append(linha);
            }
            System.out.println("Resposta do servidor: " + resposta.toString());
            return resposta.toString();
        }

    } catch (IOException e) {
        e.printStackTrace();
        return "Erro na conexão com API";
    }

   }
}