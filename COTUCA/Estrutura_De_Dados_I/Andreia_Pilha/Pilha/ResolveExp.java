class ResolveExp{

    public static boolean estaBoa(String expressao) throws Exception
    { 
        Pilha minhaPilha = new Pilha();

        for (int i=0; i<expressao.length(); i++){
            if (expressao.charAt(i)=='(')
                minhaPilha.empilhar('(');
            else
                if (expressao.charAt(i)==')'){
                    if (minhaPilha.vazia())
                        return false;
                        
                    minhaPilha.desempilhar();
                }
        }
        if (!minhaPilha.vazia())
            return false;
        
        return true;
    }

    public static String geraPolonesa(String expressao)throws Exception
    { 
        Pilha minhaPilha = new Pilha();

        String invertida="";
        for (int i=0; i<expressao.length(); i++){
            if ("+-*/()".indexOf(expressao.charAt(i)) != -1 ){
                invertida += '|';
                if (expressao.charAt(i)==')'){
                    while (!minhaPilha.vazia() && 
                            ("+-*/".indexOf(minhaPilha.consulta()) != -1)){
                        invertida += minhaPilha.desempilhar();
                      }
                      if (minhaPilha.vazia())
                          throw new Exception("Expressao Mal Formada");
                      minhaPilha.desempilhar();
                }
                else{
                    if (minhaPilha.vazia())
                        minhaPilha.empilhar(expressao.charAt(i));
                    else
                        resolveComPrioridade(expressao.charAt(i), 
                                            minhaPilha, 
                                            invertida);
                }
            } else{
                invertida += expressao.charAt(i);
            }

        }

        return invertida;
    }


    private static void resolveComPrioridade(char operacao, 
                                            Pilha minhaPilha, 
                                               String invertida)throws Exception{
        switch (operacao){
            case '+':
            case '-': while (!minhaPilha.vazia() && 
                            ("+-*/".indexOf(minhaPilha.consulta()) != -1)){
                        invertida += minhaPilha.desempilhar();
                      }
                      minhaPilha.empilhar(operacao);
                      break;

            case '*':
            case '/': while (!minhaPilha.vazia() && 
                            ("*/".indexOf(minhaPilha.consulta()) != -1)){
                        invertida += minhaPilha.desempilhar();
                      }
                      minhaPilha.empilhar(operacao);
                      break;

            case '(': minhaPilha.empilhar(operacao);
                      break;
        }
    }
}