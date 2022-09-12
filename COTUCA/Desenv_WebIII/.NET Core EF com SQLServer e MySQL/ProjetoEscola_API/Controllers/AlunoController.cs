using Microsoft.AspNetCore.Mvc;
using ProjetoEscola_API.Data;
using ProjetoEscola_API.Models;


namespace ProjetoEscola_API.Controllers
{
    public class AlunoController
    {
        [Route("api/[controller]")]
        [ApiController]
        public class AlunoControllers : ControllerBase
        {
            /*Definimos aqui qual contexto  de dados usaremos nesse controlador e relacionamos juntamente ao controlador.*/
            private EscolaContext _context;
            public AlunoControllers(EscolaContext context)
            {
                // construtor
                _context = context;
            }
            /*Alteramos o método GetAll() para que, através do método ToList() do Entity Framework os dados da tabela sejam resgatados */

            [HttpGet]
            public ActionResult<List<Aluno>> GetAll()
            {
                return _context.Aluno.ToList();
            }
        }
    }
}