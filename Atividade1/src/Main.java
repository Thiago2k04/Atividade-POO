abstract class Progressao {
    protected int valorAtual;

    public Progressao() {
        this.valorAtual = 0;
    }

    public abstract int proximoValor();
    public abstract void reiniciar();
}

class ProgressaoAritmetica extends Progressao {
    private int razao;

    public ProgressaoAritmetica(int primeiroTermo, int razao) {
        this.valorAtual = primeiroTermo;
        this.razao = razao;
    }

    @Override
    public int proximoValor() {
        int retorno = valorAtual;
        valorAtual += razao;
        return retorno;
    }

    @Override
    public void reiniciar() {
        this.valorAtual = 0;
    }
}


class ProgressaoGeometrica extends Progressao {
    private int razao;

    public ProgressaoGeometrica(int primeiroTermo, int razao) {
        this.valorAtual = primeiroTermo;
        this.razao = razao;
    }

    @Override
    public int proximoValor() {
        int retorno = valorAtual;
        valorAtual *= razao;
        return retorno;
    }

    @Override
    public void reiniciar() {
        this.valorAtual = 1;
    }
}

class ProgressaoFibonacci extends Progressao {
    private int anterior;

    public ProgressaoFibonacci() {
        this.valorAtual = 0;
        this.anterior = 1;
    }

    @Override
    public int proximoValor() {
        int proximo = valorAtual + anterior;
        anterior = valorAtual;
        valorAtual = proximo;
        return anterior;
    }

    @Override
    public void reiniciar() {
        this.valorAtual = 0;
        this.anterior = 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Progressao aritmetica = new ProgressaoAritmetica(1, 2);
        System.out.println("Progressão Aritmética:");
        for (int i = 0; i < 5; i++) {
            System.out.println(aritmetica.proximoValor());
        }
        aritmetica.reiniciar();

        Progressao geometrica = new ProgressaoGeometrica(1, 2);
        System.out.println("Progressão Geométrica:");
        for (int i = 0; i < 5; i++) {
            System.out.println(geometrica.proximoValor());
        }
        geometrica.reiniciar();

        Progressao fibonacci = new ProgressaoFibonacci();
        System.out.println("Progressão de Fibonacci:");
        for (int i = 0; i < 5; i++) {
            System.out.println(fibonacci.proximoValor());
        }
        fibonacci.reiniciar();
    }
}
