- A **mensagem** contém dados que serão transferidos para uma rota. Cada mensagem tem um identificador exclusivo e é construído a partir de um corpo, cabeçalhos e anexos.

- **Exchange** é criado quando uma mensagem é recebida por um consumidor durante o processo de roteamento. Este permite capturar dados da mensagem trocada entre a rota.

- **Endpoint** é um canal através do qual o sistema pode receber ou enviar uma mensagem. Ele pode se referir a um URI de serviço da Web, URI de fila, arquivo, endereço de e-mail, etc.

- **Processor** é uma interface Java que é usada para adicionar lógica de integração personalizada a uma rota. Ele contém um único método de processo usado para pré-formar a lógica de negócios personalizada em uma mensagem recebida por um consumidor.