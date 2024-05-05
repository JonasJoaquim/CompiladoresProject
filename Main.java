
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String texto = "Este é um exemplo de texto. Ele contém várias frases! Cada frase é separada por pontuação.";
        
        // Utilizando o princípio da inversão de dependência, criamos uma instância do analisador léxico
        AnalisadorLexico analisador = new AnalisadorLexico();

        // Chamando o método de análise para obter os tokens
        List<AnalisadorLexico.Token> tokens = analisador.analisar(texto);



        AnalisadorSemantico analisadorSemantico = new AnalisadorSemantico();
        Map<AnalisadorLexico.Categoria, List<String>> tokensPorCategoria = analisadorSemantico.reorganizarTokens(tokens);
        
        System.out.println("Tokens reorganizados por categoria:");
        for (Map.Entry<AnalisadorLexico.Categoria, List<String>> entry : tokensPorCategoria.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
   }
}
