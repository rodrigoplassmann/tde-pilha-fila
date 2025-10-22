# Sistema de Gerenciamento de Atendimento ao Cliente

**Instituição:** Pontifícia Universidade Católica do Paraná 

**Disciplina:** Resolução de Problemas Estruturados em Computação

**Tema:** Implementação de Pilha e Fila utilizando Lista Encadeada  

**Professor:** Andrey Cabral Meira

**Alunos:**
- Danillo Gonçalves Camargo da Silva
- Guilherme Felippe Lazari
- Rodrigo Schiavinatto Plassmann
- Thomas Manussadjian Steinhausser

---

## Descrição Geral

Este projeto implementa um sistema de gerenciamento de atendimento ao cliente utilizando estruturas de dados em Java.

O sistema foi dividido em duas partes principais:

- **Pilha de Solicitações:** armazena o histórico de atendimentos (última solicitação no topo).  
- **Fila de Atendimento:** controla a ordem de atendimento dos clientes (primeiro que chega é o primeiro a ser atendido).

Ambas as estruturas foram implementadas com listas encadeadas, através de uma classe de nó (`No`), respeitando todas as restrições impostas pelo professor.

---

## Estrutura de Classes

### Classe `Elemento`

Responsável por representar tanto uma **solicitação** (na pilha) quanto um **cliente** (na fila).

#### Atributos:
- `String id` — identificador da solicitação ou cliente.  
- `String descricao` — descrição da solicitação.  
- `String dataHora` — data e hora do registro (para histórico da pilha).  
- `String nome` — nome do cliente (usado na fila).  
- `String motivo` — motivo do atendimento (usado na fila).  

#### Métodos:
- **Construtores:** inicializam o objeto de acordo com o tipo de estrutura (pilha ou fila).  
- **Getters:** métodos de acesso para cada atributo.  
- **toString():** retorna uma representação textual do elemento, exibindo seus dados de forma legível.

---

### Classe `No`

Classe auxiliar que representa um **nó da lista encadeada**.  
Cada nó contém:
- Um objeto `Elemento` (com os dados do cliente ou solicitação).  
- Um ponteiro `No proximo`, que referencia o próximo nó da lista.

#### Métodos:
- **Construtor:** recebe um `Elemento` e define o `proximo` como `null`.  
- **getElemento():** retorna o conteúdo armazenado no nó.  
- **getProximo() / setProximo():** acessam e modificam o encadeamento entre nós.

---

### Classe `PilhaSolicitacoes`

Implementa uma **pilha manualmente**, com base em lista encadeada.  
Segue o princípio **LIFO** (*Last In, First Out*): o último elemento inserido é o primeiro a ser removido.

#### Atributo:
- `No topo` — referência ao último elemento inserido (topo da pilha).

#### Métodos:
- **`adicionarSolicitacao(String id, String descricao, String dataHora)`**  
Cria um novo objeto `Elemento`, encapsula-o em um `No`, e o adiciona no topo.  
O novo nó passa a apontar para o antigo topo.  
```java
novoNo.setProximo(topo);
topo = novoNo;
```

- **`removerSolicitacao()`**
Remove o elemento mais recente (do topo).
Se a pilha estiver vazia, exibe uma mensagem de aviso.
```java
topo = topo.getProximo();
```

- **`estaVazia()`**
Retorna true se o topo for null, indicando que não há solicitações no histórico.

- **`mostrarHistorico()`**
Percorre a lista encadeada a partir do topo, exibindo todas as solicitações armazenadas na pilha em ordem decrescente de inserção.

## Classe `FilaAtendimento`

Implementa uma fila manualmente, com base em **lista encadeada**.  
Segue o princípio **FIFO (First In, First Out)**: o primeiro cliente que entra é o primeiro a ser atendido.

### Atributos
- **No `frente`** — primeiro cliente da fila.  
- **No `tras`** — último cliente inserido (cauda da fila).

### Métodos

#### `adicionarCliente(String nome, String id, String motivo)`
Cria um novo `Elemento` e encapsula-o em um `No`.  
- Se a fila estiver vazia, `frente` e `tras` apontam para o mesmo nó.  
- Caso contrário, o último nó (`tras`) passa a apontar para o novo nó, e `tras` é atualizado.

#### `atenderCliente()`
Remove o cliente que está na frente da fila.  
O ponteiro `frente` passa a apontar para o próximo nó.  
Caso a fila fique vazia, `tras` também é definido como `null`.

#### `estaVazia()`
Retorna `true` se `frente` for `null`.

#### `mostrarFila()`
Percorre todos os nós da fila, a partir de `frente`, exibindo a ordem de atendimento atual.

---

## Classe `Main`

Classe responsável por **executar o sistema** e **demonstrar seu funcionamento**.

### Principais Operações Realizadas
- Criação de instâncias de `PilhaSolicitacoes` e `FilaAtendimento`.  
- Inserção de múltiplas solicitações no histórico (pilha).  
- Inserção de clientes na fila de atendimento.  
- Chamada dos métodos de visualização (`mostrarHistorico` e `mostrarFila`).  
- Remoção e atendimento de elementos.
  
---
## Conclusão

O projeto demonstrou, de forma prática, a implementação de duas estruturas de dados, **pilha** e **fila**, utilizando listas encadeadas em Java.  

Através do sistema de gerenciamento de atendimento ao cliente, foi possível observar claramente o comportamento das operações de **inserção**, **remoção** e **varredura** em ambas as estruturas:

- **Fila (FIFO)** — garante a ordem justa de atendimento, onde o primeiro cliente a chegar é o primeiro a ser atendido.  
- **Pilha (LIFO)** — permite o controle reverso do histórico de solicitações, priorizando as mais recentes.  

####  O projeto atende os seguintes objetivos:
- Implementa **Pilha** e **Fila** com **listas encadeadas**.  
- Utiliza apenas **tipos primitivos** e `String` para os dados. 
- Permite **adicionar**, **remover** e **visualizar** elementos.
