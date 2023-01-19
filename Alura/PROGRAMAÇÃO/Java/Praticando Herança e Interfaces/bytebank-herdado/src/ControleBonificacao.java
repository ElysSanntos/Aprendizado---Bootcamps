public class ControleBonificacao {

    private  double soma;
        public void registra(Funcionario funcionario){
            double boni = funcionario.getBonificacao();
            this.soma += boni;
      }

      public double getSoma(){
            return soma;
      }

}
