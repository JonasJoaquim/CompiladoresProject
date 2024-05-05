import java.util.ArrayList;
import java.util.List;

public class AnalisadorLexico {
    public enum Categoria {
        SUBSTANTIVO,
        VERBO,
        ADJETIVO,
        ADVERBIO,
        PREPOSICAO,
        PONTUACAO_FINAL,
        PONTUACAO_INTERMEDIARIA,
        OUTRO
    }
    
    public List<Token> analisar(String texto) {
        List<Token> tokens = new ArrayList<>();
        
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {
                token.append(c);
            } else if (c == '.' || c == ',' || c == '!' || c == '?') {
                if (token.length() > 0) {
                    tokens.add(new Token(token.toString(), classificarToken(token.toString())));
                    token.setLength(0);
                }
                tokens.add(new Token(String.valueOf(c), classificarToken(String.valueOf(c))));
            } else if (!Character.isWhitespace(c)) {
                // Ignorar outros caracteres não alfanuméricos
            } else {
                if (token.length() > 0) {
                    tokens.add(new Token(token.toString(), classificarToken(token.toString())));
                    token.setLength(0);
                }
            }
        }
        
        if (token.length() > 0) {
            tokens.add(new Token(token.toString(), classificarToken(token.toString())));
        }
        
        return tokens;
    }
    
    private Categoria classificarToken(String token) {
        if (token.matches("[A-Za-z]+")) {
            // Verificar se é uma palavra conhecida de alguma categoria
            // Aqui você pode implementar uma lógica mais sofisticada de classificação de palavras
            return Categoria.SUBSTANTIVO;
        } else if (token.equals(".") || token.equals("!") || token.equals("?")) {
            return Categoria.PONTUACAO_FINAL;
        } else if (token.equals(",")) {
            return Categoria.PONTUACAO_INTERMEDIARIA;
        } else {
            return Categoria.OUTRO;
        }
    }
    public static class Token {
        private String valor;
        private Categoria categoria;
        
        public Token(String valor, Categoria categoria) {
            this.valor = valor;
            this.categoria = categoria;
        }

        public Token(Categoria categoria, String valor) {
            this.categoria = categoria;
            this.valor = valor;
        }
        
        public String getValor() {
            return valor;
        }
        
        public Categoria getCategoria() {
            return categoria;
        }

        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }
    }
   

}
