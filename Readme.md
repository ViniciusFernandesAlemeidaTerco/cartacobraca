#Micro Serviçoapi-gerar-carta-cobranca
| Data | Autor | Comentarios | Versao |
| --- | --- | --- | --- |
| 20/01/2024 | Vinicius Fernandes de Almeida Terço | Versao inicial | 1.0.0 |

##api-gerar-carta-cobranca


Para a API em questão foi utilizado o padrão Hexagonal ou arquitetura hexagonal (Ports and Adapters),
para deixar o sistema mais flexivel e independente de frameworks externos. Temos a separação do Core (dominio),
camada com toda a regra de negócios, entidades e afins. Juntamente com os adaptadores que por meio de interfaces
vão interagir com componentes externos. Por fim as portas são a ponte entre o domínio e os adaptadores.

Para este exemplo além deste padrão utilizamos também:
- Facade: Inicialmente não fica muito interessante apenas com uma única forma de cobrança impressa,
contudo fica a possibilidade ilustrativa de utilizar o padrão deixando pronto para caso queira escalar
utilizando outra forma de cobrança por meio impresso como um telegrama dentre outros.

A forma de configuração dos resources com os devidos environment, pipeline e afins, também podem 
serguir de forma específica em cada instituição. Neste projeto deixado de ilustração o padrão que
utilizo atualmente com o CodeCommit por exemplo. Este fica com apontamente em servidor.

Dado os exemplos de utilização de URL Ex.: {aws.rest.outbound.comunicacao.transacao.parceiro}, o projeto
não está executando. Caso necessário ajustar parâmetros para rodar local.

---
## Pre-Requisitos
[Java 17](https://www.oracle.com/java/technologies/downloads/#jdk17-windows)

[Maven 3.3.9](https://maven.apache.org/download.cgi)

[Plugin Lombok instalado em sua IDE](https://projectlombok.org/)

---
##Sonar

[[Quality Gate Status]](Endereço associado)

---
## Testes de Unidade

Para executar os testes de unidade, é necessário o uso do Maven

```sh
$ mvn test
```
---
## Executando localmente

AWS_REGION=[REGION]
aws_access_key_id=[ACCESS_KEY]
aws_secret_access_key=[SECRET_KEY]
aws_session_token=[TOKEN]

---
## Serviços integrados

- SQS [NOME_DAS_FILAS]


---
## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [AWS SQS - Amazon Simple Queue Service](https://aws.amazon.com/pt/sqs/)
