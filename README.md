# Trabalho de Chat Multicast em java

* Caio Lopes Machado Magnani *

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
> Descrição :
> !comando; o nome da sala;Ip Multicast
> Função :
> Serve para criar salas de chat multicast.

#### Listar Salas Criadas
> !listarSalas
> Descrição :
> !comando

#### Listar Membros da Sala
> !listarParticipantes;ExemploDeNomeDeSalaJáCriada
> Descrição :
> !comando; o nome da sala já criada

#### Remover Sala
> !removerSala;ExemploDeNomeDeSalaJáCriada
> Descrição :
> !comando; o nome da sala já criada

#### Entrar na Sala
> !entrar;ExemploDeNomeDeSalaJáCriada
> Descrição :
> !comando; o nome da sala já criada

#### Envia/Escrever Mensagem
> Após executar o comando !entrar;nomeDaSala com sucesso você será capaz de enviar e escrever mensagens para a sala

#### Sair da Sala
> !quit
> o programa será fechado e você saira da sala
> ATENÇÃO -> só poderá executar este comando apos executar !entrar;nomeDaSala com sucesso

## Extra

No servidor será exibido toda a comunicação do servidor com cliente, uma espécie de log.

---
_Caio Lopes
