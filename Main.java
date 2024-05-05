
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String texto = "Este é um exemplo de texto. Ele contém várias frases! Cada frase é separada por pontuação.";
        
        // Utilizando o princípio da inversão de dependência, criamos uma instância do analisador léxico
        AnalisadorLexico analisador = new AnalisadorLexico();

        // Chamando o método de análise para obter os tokens
        List<AnalisadorLexico.Token> tokens = analisador.analisar(texto);

        // Exibindo os tokens
        System.out.println("Token\t\tCategoria");
        System.out.println("------------------------");
        for (AnalisadorLexico.Token token : tokens) {
            System.out.println(token.getValor() + "\t\t" + token.getCategoria());
        }
    }
}
