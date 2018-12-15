
# Universidade Federal do Rio Grande do Norte
### Instituto Metrópole Digital - IMD
### Bacharelado em Tecnologia da Informação – BTI

## Polinômios

- Aluno: João Vítor Venceslau Coelho
- Professor: Frederico Araujo Da Silva Lopes

### Resumo
Este programa tem como objetivo trabalhar os conhecimentos sobre JUnit. Implementando uma classe que simula um polinômio e testando-a com testes unitários no JUnit.

### Descrição da Atividade:
Considere um polinômio de grau n: 
 - P (x) = an xn + an−1 xn−1 + . . . + a1 x1 + a0 x0

Escreva uma classe Termo que represente um termo deste polinômio com os seguintes métodos:

- construtor:
Recebe dois parâmetros : ai e i, e cria um objeto em memória na forma ai xi . 

- insere:
Recebe um objeto da classe Termo e substitui os valores ai xi do termo corrente por aqueles do termo recebido como parâmetro. 

- calcula:
Recebe um valor de x como parâmetro e retorna o valor do termo calculado. 

Escreva uma classe Polinomio que representa polinômio completo na forma de uma sequência de objetos da classe Termo, com os seguintes métodos:

- construtor:
Recebe um objeto da classe Termo e cria um polinômio em memória na forma: P(x) = ai xi.

- insere:
Recebe um objeto da classe Termo e adiciona o termo ai xi ao polinômio recebido como parâmetro. O polinômio pode ter um terno aq xq cujo valor de q seja igual a i, neste caso o método deve unificar ambos em um único termo.

- calcula:
Recebe como parâmetro outro objeto da classe Polinomio e realiza a fusão do polinômio recebido como parâmetro com o polinômio corrente. 		

Acrescente os métodos que achar necessários nas classes solicitadas. Utilize alguma coleção Java para armazenar os termos na classe Polinomio.

Em seguida, escreva casos de teste JUnit para sua classe polinômio. Crie pelo menos um teste positivo e um teste negativo para cada um dos métodos solicitados.

Obs: DOCUMENTE SEU CÓDIGO. Javadoc não é apenas opcional, ele é essêncial para manter a organização e a transparência do seu código. Código não documentado terá redução na pontuação.

### O que foi feito:
- [x] Classe _Termo_
  - [x] Construtor Parametrizado de _Termo_
  - [x] Método **_insere_** de _Termo_
  - [x] Método **_calcula_** de _Termo_
  - [x] Método **_some_** de _Termo_
  - [x] _Getters_ e _Setters_ de _Termo_
  - [x] **_ToString_** de _Termo_
  - [x] Exceções de Overflow do **_calcula_** e **_some_**
  - [x] Documentação Básica do _Termo_

- [x] Classe _Polinomio_
  - [x] Construtor Parametrizado de _Polinomio_
  - [x] Método **_insere_** de _Polinomio_
  - [x] Método **_calcula_** de _Polinomio_
  - [x] _Getter_ para um termo específico
  - [x] _Getter_ para a lista de termos
  - [x] Método **_resultado_** de _Polinomio_
  - [x] **_ToString_** de _Polinomio_
  - [x] Exceções de Overflow do **_resultado_**
  - [x] Documentação Básica do _Polinomio_

- [x] Classe de Teste para _Termo_
  - [x] Teste do **_Construtor_** de _Termo_
  - [x] Teste do **_insere_** de _Termo_
  - [x] Teste do **_some_** de _Termo_
  - [x] Teste do **_calcula_** de _Termo_

- [x] Classe de Teste para _Polinomio_
  - [x] Teste do **_Construtor_** de _Polinomio_
  - [x] Teste do **_insere_** de _Polinomio_
  - [x] Teste do **_calcula_** de _Polinomio_
  - [x] Teste do **_resultado_** de _Polinomio_
