abstract class Retangulo {
    protected int largura;
    protected int altura;
    protected String texto;

    public Retangulo(int largura, int altura, String texto) {
        this.largura = largura;
        this.altura = altura;
        this.texto = texto;
    }

    public abstract void desenhar();
}

class RetanguloBordasArredondadas extends Retangulo {
    public RetanguloBordasArredondadas(int largura, int altura, String texto) {
        super(largura, altura, texto);
    }

    @Override
    public void desenhar() {
        System.out.println("╭" + "─".repeat(largura - 2) + "╮");
        for (int i = 0; i < altura - 2; i++) {
            if (i == (altura - 2) / 2) {
                int padding = (largura - texto.length() - 2) / 2;
                System.out.println("│" + " ".repeat(padding) + texto + " ".repeat(largura - padding - texto.length() - 2) + "│");
            } else {
                System.out.println("│" + " ".repeat(largura - 2) + "│");
            }
        }
        System.out.println("╰" + "─".repeat(largura - 2) + "╯");
    }
}

class RetanguloLinhasDuplas extends Retangulo {
    public RetanguloLinhasDuplas(int largura, int altura, String texto) {
        super(largura, altura, texto);
    }

    @Override
    public void desenhar() {
        System.out.println("╔" + "═".repeat(largura - 2) + "╗");
        for (int i = 0; i < altura - 2; i++) {
            if (i == (altura - 2) / 2) {
                int padding = (largura - texto.length() - 2) / 2;
                System.out.println("║" + " ".repeat(padding) + texto + " ".repeat(largura - padding - texto.length() - 2) + "║");
            } else {
                System.out.println("║" + " ".repeat(largura - 2) + "║");
            }
        }
        System.out.println("╚" + "═".repeat(largura - 2) + "╝");
    }
}

class RetanguloAsciiArt extends Retangulo {
    public RetanguloAsciiArt(int largura, int altura, String texto) {
        super(largura, altura, texto);
    }

    @Override
    public void desenhar() {
        System.out.println("+" + "-".repeat(largura - 2) + "+");
        for (int i = 0; i < altura - 2; i++) {
            if (i == (altura - 2) / 2) {
                int padding = (largura - texto.length() - 2) / 2;
                System.out.println("|" + " ".repeat(padding) + texto + " ".repeat(largura - padding - texto.length() - 2) + "|");
            } else {
                System.out.println("|" + " ".repeat(largura - 2) + "|");
            }
        }
        System.out.println("+" + "-".repeat(largura - 2) + "+");
    }
}

public class Main {
    public static void main(String[] args) {
        Retangulo retangulo1 = new RetanguloBordasArredondadas(20, 5, "Olá Mundo");
        Retangulo retangulo2 = new RetanguloLinhasDuplas(20, 5, "Java");
        Retangulo retangulo3 = new RetanguloAsciiArt(20, 5, "ASCII");

        System.out.println("Retângulo com Bordas Arredondadas:");
        retangulo1.desenhar();
        System.out.println();

        System.out.println("Retângulo com Linhas Duplas:");
        retangulo2.desenhar();
        System.out.println();

        System.out.println("Retângulo com ASCII Art:");
        retangulo3.desenhar();
    }
}
