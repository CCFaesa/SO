# Jantar dos Filósofos

O Jantar dos filósofos é análogo ao problema de concorrência de recursos do sistema operacional, vamos aos detalhes:

* No Jantar dos filósofos temos uma mesa com
  * 5 filósofos
  * 5 pratos de macarrão
  * 5 garfos.
<img src="jantar dos filosofos.png" width="400" height="375"/>

* Enquanto jantam, cada filósofo executa as seguintes ações(podendo váriar o tempo)
  * Pensa
  * Pega o garfo da esquerda
  * Pega o garfo da direita
  * Come macarrão
  * Solta os garfos
  * Repete o ciclo

## Problemas
Concorrência: Com uma análise rápida, percebemos que não há garfos suficiente para todos os filósofos comerem ao mesmo tempo, isto acontece pois eles compartilham recursos(garfos)
Dead lock: Imagine que todos os filósofos acabem de pensar juntos, peguem o garfo da esquerda e quando cada um tentar pegar o garfo da direita, este já vai esta sendo usado. todos os filósofos vão entrar em um estado de espera interminável, gerando um dead lock.

## Programação
* Para simular este problema, o professor Tiago Wirtti criou a seguinte solução:
  * Criou o programa jantar dos filósofos
  * Criou cinco Threads, cada uma representando um filósofo, executando as ações com tempos diferentes
  * Criou a classe Garfo
  * Cada Thread disputa dois dos cinco garfos

Dado o cenário e o problema, precisavamos criar uma solução para a concorrência de recursos, e a escolhida por mim neste trabalho foi a sincronização, para saber um pouco mais:

[Synchronized Methods - Oracle docs](https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html)

[O que é Synchronized? -Guj](http://www.guj.com.br/t/o-que-e-synchronized/139744)

[Problema com concorrência -Caelum](https://www.caelum.com.br/apostila-java-orientacao-objetos/apendice-problemas-com-concorrencia/)

## Solução
### Espera
Para cada filósofo esperar os garfos estarem disponíveis, foi usado a seguinte estratégia:
```java
// pensa
synchronized (garfos.get(primeiroGarfoAPegar)) {
  synchronized (garfos.get(segundoGarfoAPegar)) {
  // pega garfos
  // come macarrão
  // solta garfos
  }
}
```
### Evitando Dead Lock
Para não acontecer de cada filósofo segurar um garfo e travar o outro, a solução foi criar os garfos prioritários, filósofos que estiverem em posição par, pegam primeiro o garfo da direita, e posição impar, o garfo da esquerda
```java
int primeiroGarfoAPegar = filosofo % 2 == 0 ? filosofo : indexGarfoDireita;
int segundoGarfoAPegar = filosofo % 2 == 0 ?  indexGarfoDireita : filosofo;
```
