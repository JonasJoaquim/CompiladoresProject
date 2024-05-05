import java.io.IOException;

import org.jsoup.Jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WordAnalyzer {
    public static void main(String[] args) {
        // Palavra a ser pesquisada
        String palavra = "exemplo";

        // URL do dicionário
        String url = "https://www.dicio.com.br/" + palavra;

        try {
            // Conectando ao dicionário e obtendo o conteúdo HTML
            Document doc = Jsoup.connect(url).get();

            // Verificando se a palavra foi encontrada no dicionário
            if (doc.title().contains("Não encontrada")) {
                System.out.println("A palavra '" + palavra + "' não foi encontrada no dicionário.");
            } else {
                // Extraindo a classe gramatical da palavra
                Element classeGramaticalElement = doc.selectFirst(".significado > .classegram");
                String classeGramatical = classeGramaticalElement.text().trim();

                // Exibindo a classe gramatical da palavra
                System.out.println("A classe gramatical da palavra '" + palavra + "' é: " + classeGramatical);
            }
        } catch (IOException e) {
        }
    }
}
