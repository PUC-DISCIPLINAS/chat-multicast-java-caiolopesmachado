# Trabalho de Chat Multicast em java

 **Caio Lopes Machado Magnani**

## Como usar:

1. Inicialmente você precisara inicializar no mínimo 2 cmds(pronts de comando) ou 2 terminais linux na pasta dentro desse projeto chamada "out"
2. Execute o arquivo "Server.class" com o comando "java Server" em um dos terminais ou cmds e deixe-o "na paz de espírito" executando
3. Execute em outro terminal o arquivo "Client.class"com o comando "java Client"
4. Escreva o nome do usuario seguindo a mensagem do cmd ou terminal
5. No cmd ou terminal que estará com client em execução será onde o usuario(você) poderá interagir de fato com os comandos listados abaixo

## Comandos:

### Padrão dos comandos:

O padrão dos comandos são simples:

!comando;informaçõesSeNecessario

No inicio do comando sempre terá um ponto de exclamação e o comando e logo após, separado por um ponto e virgula terá informações adicionais caso seja nescessario

Use este de exemplo:

!criarSala;shulamps;228.5.6.7

No final do comando apenas precione a tecla Enter

### Comandos Emplementados:

#### Criar Sala
> !criarSala;exemploDeNomeDeSala;228.5.6.7
> 
> Descrição :
> 
> !comando; o nome da sala;Ip Multicast

#### Listar Salas Criadas
> !listarSalas
> 
> Descrição :
> 
> !comando

#### Listar Membros da Sala
> !listarParticipantes;ExemploDeNomeDeSalaJáCriada
> 
> Descrição :
> 
> !comando; o nome da sala já criada

#### Remover Sala
> !removerSala;ExemploDeNomeDeSalaJáCriada
> 
> Descrição :
> 
> !comando; o nome da sala já criada

#### Entrar na Sala
> !entrar;ExemploDeNomeDeSalaJáCriada
> 
> Descrição :
> 
> !comando; o nome da sala já criada

#### Envia/Escrever Mensagem
> Após executar o comando !entrar;nomeDaSala com sucesso você será capaz de enviar e escrever mensagens para a sala

#### Sair da Sala
> !quit
> 
> o programa será fechado e você saira da sala
> 
> ATENÇÃO -> só poderá executar este comando apos executar !entrar;nomeDaSala com sucesso

---
## Classes
1. Client
    - A classe Client.java ou Client.class é responsavel por fazer requests(usando protocolo de transporte UDP) para a classe Server e, com a ajuda da classe MulticastListener, é responsavel por tornar o cliente um peer de uma conexão multicast.


2. Server 
    - A classe Server.java ou Server.class é responsavel por interpretar os requests da classe Client e enviando um reply (usando protocolo de transporte UDP) de volta para o mesmo cliente com confirmações de execução.

3. Sala 
    - A classe Sala.java ou Sala.class é responsavel por representar uma sala, armazenar os participantes e armazenar informações sobre a sala como nome e ip Multicast

4. MulticastListener
    - A classe MulticastListener.java ou MulticastListener.class é responsavel por fazer a conexão multicast usando uma Thread para resceber e enviar mensagens.

## Extra 

No servidor será exibido toda a comunicação do servidor com cliente, uma espécie de log.
Boa diverção com o código XD

---
_Caio Lopes
