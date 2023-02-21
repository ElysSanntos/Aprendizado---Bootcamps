# Aula 06 - Por que não funciona?

O seu amigo está aprendendo Java mas por um motivo o código abaixo não está funcionando. Primeiro, analise as duas classes (assuma que os imports estão corretos):

```
class Programa {
    public static void main(String[] args) {
        Aula aulaIntro = new Aula("Introdução às Coleções", 20);
        Aula aulaModelando = new Aula("Modelando a Classe Aula", 18);
        Aula aulaSets = new Aula("Trabalhando com Conjuntos", 16);

        List<Aula> aulas = new ArrayList<Aula>();
        aulas.add(aulaIntro);
        aulas.add(aulaModelando);
        aulas.add(aulaSets);

        Collections.sort(aulas);

        for (Aula aula : aulas) {
            System.out.println(aula);
        }
    }
}

class Aula {

    private String titulo;
    private int tempo;

    public Aula(String titulo, int tempo) {
        this.titulo = titulo;
        this.tempo = tempo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String toString() {
        return "[título: " + titulo + ", tempo: " + tempo + " minutos]";
    }
}COPIAR CÓDIGO
```

O problema é que o código nem compila. Você sabe por quê?

*Obs: Em duvida, sempre teste, experimente e verifique o resultado, não há problema nenhum, pois estamos aprendendo!*

*Selecione uma alternativa*

A classe `Aula` não implementa a interface `Comparable` e, por consequência, não implementa o método `compareTo`. Por isso o código nem compila.

Isso mesmo! A interface `Comparable` exige uma implementação do método `compareTo`, que precisa ser chamado pelo algoritmo interno do método `sort()` da lista.

- o método `sort`  é sobrecarregado. Existe uma versão do `sort`  que recebe apenas a lista e outra que recebe a lista e o comparator.
- o método `equals`  define o critério de igualdade que não é suficiente para a comparação.