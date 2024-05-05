
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalisadorSemantico {
    public Map<AnalisadorLexico.Categoria, List<String>> reorganizarTokens(List<AnalisadorLexico.Token> tokens) {
        Map<AnalisadorLexico.Categoria, List<String>> tokensPorCategoria = new HashMap<>();
        
        for (AnalisadorLexico.Token token : tokens) {
            if (!tokensPorCategoria.containsKey(token.getCategoria())) {
                tokensPorCategoria.put(token.getCategoria(), new ArrayList<>());
            }
            tokensPorCategoria.get(token.getCategoria()).add(token.getValor());
        }
        
        return tokensPorCategoria;
    }
}
