

namespace ProjetoEscola_API.Models
{
    public class Aluno
    {
        /*Vamos usar o Entity Framework toda tabela precisa ter o campo Id */
        public int id { get; set; }
        public string? ra { get; set; }
        public string? nome { get; set; }
        public int codCurso { get; set; }
    }
}