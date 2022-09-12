
using Microsoft.AspNetCore.Mvc;

namespace ProjetoEscola_API.Controllers
{
    /*Esses comandos em colchetes [] são atributos.
      Servem para configurar características do controlador. 
      O atributo [ApiController] indica que esta classe se refere à um controlador da API. Ou seja, esta classe irá tratar requisições HTTP que poderão chegar até a API pela rota especificada. */
   [ApiController]
    [Route ("/")]

    /*A classe ControllerBase fornece muitas funcionalidades padrão
        para lidar com solicitações HTTP*/
    public class HomeController: ControllerBase
    {
        /*Este método responderá às requisições GET que chegarem a este
        controlador, de acordo com a respectiva rota (Route). Este método retornará uma string que será processada pelo navegador/usuário requisitante.*/

        [HttpGet]

        // Primeiro método -- Simples
        //public String Inicio()
        // {
        //     return "Funcionou!";
        // };

        // Segundo método -- Com tipo de retorno ActionResult

        public ActionResult Inicio()
            {
                return new ContentResult
                {
                    ContentType = "text/html",
                    Content = "<h1>API Projeto Escola: funcionou!!!!</h1>"
                };

            }
    } 
}