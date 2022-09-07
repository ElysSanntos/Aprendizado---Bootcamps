import knex from 'knex';

const dbConfig = {
    client: 'mysql2',
    connection: {
        host: 'localhost',
        user: 'root',
        password: 'mysql',
        database: 'projetocrud'
    }
}

const connection = knex(dbConfig);

export default connection;