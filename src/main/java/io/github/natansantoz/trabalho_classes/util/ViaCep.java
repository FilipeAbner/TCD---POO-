
package io.github.natansantoz.trabalho_classes.util;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natã
 * @version 0.0.1, 25/06/2022
 */
public class ViaCep {
    
    public static String obterEnderecoFormatadoFromCep(Endereco endereco){

        String enderecoFormatado = endereco.getLogradouro() + ", "
            + endereco.getBairro() + ". "
            + endereco.getLocalidade() + ", "
            + endereco.getUf() + ".";
        
        return enderecoFormatado;
    }

    public static Endereco obterEnderecoFromCep(String cep) {
        
        String uri = "https://viacep.com.br/ws/{cep}/json/";
        
        uri = uri.replace("{cep}", cep);
        
        try {
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET()
                    .build();
            
            HttpClient client = HttpClient.newHttpClient();
            
            HttpResponse<String> response = client
                    .send(request, BodyHandlers.ofString());
            
            Gson gson = new Gson();
            
            Endereco endereco = gson
                    .fromJson(response.body(), Endereco.class);
            
            System.out.println(">> " + endereco );
            System.out.println(">> " + endereco.getLogradouro() + ", "
                + endereco.getBairro() + ". "
                + endereco.getLocalidade() + ", "
                + endereco.getUf() + "."
            );
            
            if(endereco.getCep() == null){
                
                return null;
            }
            
            return endereco;
            
        } catch (Exception ex) {
            System.out.println("Erro ao obter endereço pelo CEP");
            Logger.getLogger(ViaCep.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
}
