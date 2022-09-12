using Microsoft.EntityFrameworkCore;
using ProjetoEscola_API.Data;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

// Add DbContext

/*EscolaContext refere-se ao contexto criado na classe EscolaContext.cs*/

builder.Services.AddDbContext<EscolaContext>(options =>
{
    options.UseSqlServer(builder.Configuration.GetConnectionString("StringConexaoSQLServer"));
});


var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

/* configurada para sempre abrir através do protocolo HTTPS*/
//app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
