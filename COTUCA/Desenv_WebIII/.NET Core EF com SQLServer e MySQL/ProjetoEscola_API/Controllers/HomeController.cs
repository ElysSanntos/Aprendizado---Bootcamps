
using Microsoft.AspNetCore.Mvc;

namespace ProjetoEscola_API.Controllers
{
   // [ApiController]
    [Route ("/")]
    public class HomeController: ControllerBase
    {
        [HttpGet]
        public String Inicio()
        {
            return "Funcionou!";
        }
    }
}