using Microsoft.EntityFrameworkCore;
using ProjetoEscola_API.Models;


/*Nessa classe definiremos o contexto de dados na nossa aplicação, assim como as tabelas.*/

namespace ProjetoEscola_API.Data
{
    public class EscolaContext : DbContext
    {
        protected readonly IConfiguration Configuration;

        public EscolaContext(IConfiguration configuration)
        {
            Configuration = configuration;
        }
        protected override void OnConfiguring(DbContextOptionsBuilder options)
        {
            // connect to sql server with connection string from app settings
            options.UseSqlServer(Configuration.GetConnectionString("StringConexaoSQLServer"));
        }
        public DbSet<Aluno>? Aluno { get; set; }
}
}