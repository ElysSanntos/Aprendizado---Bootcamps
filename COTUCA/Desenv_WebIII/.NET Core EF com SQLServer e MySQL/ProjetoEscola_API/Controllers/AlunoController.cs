using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ProjetoEscola_API.Data;
using ProjetoEscola_API.Models;

namespace ProjetoEscola_API.Controllers
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
            [HttpGet("{AlunoId}")]
            public ActionResult<List<Aluno>> Get(int AlunoId)
            {
                try
                {
                    var result = _context.Aluno.Find(AlunoId);
                    if (result == null)
                    {
                        return NotFound();
                    }
                    return Ok(result);
                }
                catch
                {
                    return this.StatusCode(StatusCodes.Status500InternalServerError, "Falha no acesso ao banco de dados.");
                }
            }
            [HttpPost]
            /*
            Através do atributo [HttpPost] informamos que esse método será acessado por uma requisição POST.
            Alteramos a declaração do método, para que funcione de forma assíncrona
            */
            public async Task<ActionResult> post(Aluno model)
            {
                try
                {
                _context.Aluno.Add(model);
                if (await _context.SaveChangesAsync() == 1)
                {
                //return Ok();
                return Created($"/api/aluno/{model.RA}", model);
                        }
                    }
                catch
                {
                    return this.StatusCode(StatusCodes.Status500InternalServerError, "Falha no acesso ao banco de dados.");
                }

                    // retorna BadRequest se não conseguiu incluir
                    return BadRequest();
             }


            [HttpPut("{AlunoId}")]
            public async Task<IActionResult> put(int AlunoId, Aluno dadosAlunoAlt)
            {
                try
                {
                    //verifica se existe aluno a ser alterado
                    var result = await _context.Aluno.FindAsync(AlunoId);
                    if (AlunoId != result.id)
                    {
                        return BadRequest();
                    }
                    result.ra = dadosAlunoAlt.ra;
                    result.nome = dadosAlunoAlt.nome;
                    result.codCurso = dadosAlunoAlt.codCurso;
                    await _context.SaveChangesAsync();
                    return Created($"/api/aluno/{dadosAlunoAlt.ra}", dadosAlunoAlt);
                }
                catch
                {
                    return this.StatusCode(StatusCodes.Status500InternalServerError, 
                    "Falha no acesso ao banco de dados.");
                }
            }


            [HttpDelete("{AlunoId}")]
            public async Task<ActionResult> delete(int AlunoId)
            {
                try
                {
                    //verifica se existe aluno a ser excluído
                    var aluno = await _context.Aluno.FindAsync(AlunoId);
                    if (aluno == null)
                    {
                        //método do EF
                        return NotFound();
                    }
                    _context.Remove(aluno);
                    await _context.SaveChangesAsync();
                    return NoContent();
                }
                catch
                {
                    return this.StatusCode(StatusCodes.Status500InternalServerError, 
                    "Falha no acesso ao banco de dados.");
                }
            }
    }
  }

