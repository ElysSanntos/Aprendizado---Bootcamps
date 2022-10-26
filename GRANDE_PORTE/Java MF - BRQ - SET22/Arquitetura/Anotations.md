# Lombok
O **Lombok** é um boilerplate(e refere a seções de código que devem ser incluídas em muitos lugares com pouca ou nenhuma alteração) que gera código repetitivo em tempo de execução.

Em geral geramos os construtores, getters, setters e o método toString()e refere a seções de código que devem ser incluídas em muitos lugares com pouca ou nenhuma alteração

## O Lombok é usado com anotações:


|Anotation|Função|Observação|
| :--: |:-- |:-- |
| **@Data** | Faz o papel dos Getters, Setters e toString | **|
| **@AllArgsConstructor** | Gera o construtor com todos os atributos da classe |   **** |
| **@NoArgsConstructor** | Gera o construtor vazio |  ***  |
| **@RequestBody** | permite capturar os dados vindo do body da requisição e converter para um objeto JAVA |  ***  |
|**@Autowired** | A mais utiliza com relação a injeção de dependências. Como o próprio nome diz, o Autowired, indica um ponto na qual a injeção automática deve ser aplicada. |  Lembrando que é necessário que a classe a ser injetada pelo Spring esteja anotado com Component (**@Component**) ou uma de suas especialidades (**@Service**, **@Repository** ou **@Controller**).|
|**@Component** |é um estereótipo genérico para qualquer componente gerenciado pelo Spring  |  ***  |
| **@Service**| faz anotações de classes na camada de serviço |  em geral ficam regras de negócio da nossa aplicação  |
| **@Repository** | anota classes na camada de persistência, que atuará como um repositório de banco de dados |  ***  |
| **@Entity** |  é utilizada para informar que uma classe também é uma entidade. |  A partir disso, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados, onde os dados de objetos desse tipo poderão ser persistidos.  |
| **@Table** | permite que você especifique os detalhes da tabela que será usada para persistir a entidade no banco de dados |  ***  |
|**@Column** | utilizado para especificar a coluna mapeada para uma propriedade ou campo persistente. |  Se nenhuma anotação de coluna for especificada, os valores padrão serão aplicados.|
| **@RestCotroller** | indica que a classe é um controller que permtite criar uma interface API REST. |  ***  |
| **@GeneratedValue**| utilizada para informar a estratégia de geração do valor do identificador único da entidade será gerenciada pelo provedor de persistência. |  GenerationType.IDENTITY: Informamos ao provedor de persistência que os valores a serem atribuídos ao identificador único serão gerados pela coluna de auto incremento do banco de dados. Assim, um valor para o identificador é gerado para cada registro inserido no banco. Alguns bancos de dados podem não suportar essa opção.  |
| **@Id** |utilizada para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária da respectiva tabela no banco de dados.  |  ***  |
| **@ControllerAdvice@ControllerAdvice** | permite manipular exceções de forma global. Para cada tipo de exceção.  |  Podemos manipular desde o status até a mensagem de retorno.  |
| **@Builder** | Uma forma de construção onde ocorre a instanciação de uma classe e o uso de todos os getters e setters de forma mais elegante |  ***  |
| **ResponseEntity** |  permite retornar o status, headers e o body da requisição para o cliente|  ***  |
|**@Slf4j**  |  |  ***  |
|  |  |  ***  |
|  |  |  ***  |
|  |  |  ***  |

