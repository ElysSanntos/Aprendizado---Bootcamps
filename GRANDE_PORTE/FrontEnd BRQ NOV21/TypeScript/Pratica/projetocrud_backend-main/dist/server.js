"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const database_1 = __importDefault(require("./database"));
const dotenv_1 = __importDefault(require("dotenv"));
dotenv_1.default.config({
    path: process.env.NODE_ENV === "development" ? ".env.development" : ".env"
});
database_1.default.schema.createTableIfNotExists('usuarios', (table) => {
    table.increments();
    table.string('username');
    table.string('email');
    table.string('password');
    table.timestamps();
}).then(() => console.log('Tabela de usuários criada com sucesso'))
    .catch((erro) => console.log(erro));
const app = (0, express_1.default)();
app.use(express_1.default.json());
const port = process.env.PORT;
//leitura dos usuarios
app.get('/usuarios', (req, res) => {
    res.json({
        status: 'ok',
        mensagem: 'requisição com GET'
    });
});
//criação de usuários
app.post('/usuarios', (req, res) => {
    let usuario = req.body;
    usuario.created_at = new Date();
    (0, database_1.default)('usuarios').insert(usuario)
        .then((dados) => {
        console.log('Usuário inserido com sucesso!');
        res.json({
            status: 'ok',
            mensagem: 'Usuário inserido com sucesso',
            dados: dados
        });
    })
        .catch(erro => {
        res.json({
            status: 'erro',
            mensagem: 'Erro ao inserir usuário',
            erro: erro
        });
    });
});
app.patch('/usuarios/:id', (req, res) => {
    let id = req.params.id;
    res.json({
        status: 'ok',
        mensagem: 'requisição com PATCH',
        id: id
    });
});
app.delete('/usuarios/:id', (req, res) => {
    const id = req.params.id;
    (0, database_1.default)('usuarios').where('id', id).delete()
        .then(() => {
        res.json({
            status: 'ok',
            mensagem: 'Usuário deletado com sucesso'
        });
    })
        .catch(erro => {
        res.json({
            status: 'erro',
            mensagem: erro
        });
    });
});
app.listen(port, () => console.log('Servidor rodando normalmente ...'));
