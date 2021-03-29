![Logo Porto](https://institucional.portoseguro.com.br/visual/logo/porto-seguro/institucional/marca/inst-bgl.png)
#PORTO-MS-PERFIL

## Sobre o Projeto
Projeto padrão para criação de Microserviços Java utilizando Spring boot e Maven
nesta área deverá conter uma breve descrição do seu projeto.


#### Como abrir o projeto na sua IDE
- Crie uma pasta em seu computador
- Baixe o arquivo zip deste projeto em: [https://gitportoprd.portoseguro.brasil/portais/Microservicos/porto-ms-perfil](https://gitportoprd.portoseguro.brasil/portais/Microservicos/porto-ms-perfil)
- Descompacte e salve a pasta do arquivo no diretório criado para o projeto
- Solicite Criação do repositório no GitHub e associe ao projeto salvo em seu computador

#### Como Executar o projeto
- Descrever como executar o projeto (Local ou Servidor)

#### Como realizar o BUILD manual 
- Descrever ações necessárias para realização do build

#### Como Realizar o DEPLOY manual
- Descrever ações necessárias para realização do deploy

#### Dependências
##### Integrações
- Informar quais microserviços ou projetos estão integrados a este projeto
- Portal-commons / 0.0.1-SNAPSHOT
- Portal commons Banco de dados

##### Maven
- Listar todos as dependências que não sejam outros microserviços ou projetos
- springfox-swagger2 / 2.8.0
- springfox-swagger-ui / 2.8.0
- reactor-test / 3.2.9.RELEASE
- slf4j / 1.7.16
- spring-cloud-sleuth-zipkin / 2.1.2.RELEASE
- spring-boot-starter-test / 2.1.5.RELEASE
- spring-boot-starter-actuator / 2.1.5.RELEASE
- spring-boot-starter-data-redis / 2.1.5.RELEASE
- Jedis / 2.9.3

#### Pluggins para IDE Eclipse
- Lombok / 1.18.8 (Deve instalar o jar do Lombok na ide para que seja possível sua utilização no desenvolvimento)
- Sonar (Deverá ser instalado na IDE para que projeto seja inspecionado durante o desenvolvimento, evitando retrabalho para correção de código durante a inspeção realizado pelo SonarQube na integração com o Jenkins da Porto.

#### Configuração SonarQube para integração com Jenkins
- Dentro da raiz do projeto contém um arquivo chamado *"SONAR-PROJECT.PROPERTIES"* que deverá ser configurado com as informações do Jenkins do projeto para que seja realizado verificação do código durante a integração contínua.

#### Git FLow
- Para melhor organização e rastreabilidade das alterações nos códigos, utilizar o fluxo padrão para todos os projetos de acordo com as etapas abaixo.

**Ao iniciar uma nova atividade**
1.	Faça o checkout para a branch *DEVELOP*
2.	Atualize sua branch com a *DEVELOP* remota
3.	Crie sua nova branch a partir da *DEVELOP* seguindo a seguinte nomenclatura:

>3.1 **ECD-222-Atividade-teste**, onde: *"ECD-222"* é o código da sua atividade no Jira da Porto e *"Atividade-teste"* é o título atribuído a ela no card

**Ao Finalizar a atividade**
1.  Envie sua branch local com seus comites para o git remoto do projeto, criando uma nova branch com o codigo gerado na sua branch local
2.  Abra um **MR**(Merge request) para a branch *DEVELOP* a partir da sua branch recém criada no git(remoto) do projeto
3.  Aguardar a aprovação do **MR** ou intruções para resolução de conflitos 

  


### Urls uteis
    
   Documentação arquitetural da Porto - ([How-to](https://sites.google.com/a/portoseguro.com.br/integracaocontinua/home/how-to))
 
   Registros do Swagguer - ([Swagguer](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api))
  e.g: http://{host}:{port}/{context}/v2/api-docs
 
   Registros do Swagguer na interface gráfica - ([Swagguer](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api))
 e.g:  http://{host}:{port}/{context}/swagger-ui.html#
   
   Métricas da Api -  ([Actuators](https://www.baeldung.com/spring-boot-actuators))
e.g: http://{host-defined-to-status}:{port-defined-to-status}/{context-defined-to-status}/health
 
 
