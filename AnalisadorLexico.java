import java.util.ArrayList;
import java.util.List;

public class AnalisadorLexico {
    
    public List<String> analisar(String texto) {
        List<String> tokens = new ArrayList<>();
        
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {
                token.append(c);
            } else if (c == '.' || c == ',' || c == '!' || c == '?') {
                if (token.length() > 0) {
                    tokens.add(token.toString());
                    token.setLength(0);
                }
                tokens.add(String.valueOf(c));
            } else if (!Character.isWhitespace(c)) {
                // Ignorar outros caracteres não alfanuméricos
            } else {
                if (token.length() > 0) {
                    tokens.add(token.toString());
                    token.setLength(0);
                }
            }
        }
        
        if (token.length() > 0) {
            tokens.add(token.toString());
        }
        
        return tokens;
    }
}
