class Pilha{

    //Atributos da classe
    private int[] v;
    private int topo;

    //Construtor
    public Pilha(){
        v= new int[10];
        topo = -1; //-1, pq indica que esta posição é nula/vazia ou não existe
    }
    //metodos da classe - são as funções
    public void empilhar(int elementoEmpilhado) throws Exception{ //como decidir se preciso de parametro ou não:
                                                                 // perguntando o que eu preciso para empilhar?


    }
    public int desempilhar(){

    }
    public int consulta() throws Exception{//Erro da estrutura do código
        if (vazia())throw new Exception("Pilha vazia");
        return v[topo];
    }
    public boolean cheia(){//Existe alguma situação onde a pilha está cheia?
        return (topo==(v.length-1));//retorna true do contrario retorna false
    }
    public boolean vazia(){ //Existe alguma situação onde se eu retornar alguma situação eu estou mentindo?
                            // Sim, não posso retornar a pilha vazia, então eu lanço a exceção.
        return topo== -1;
    }
}