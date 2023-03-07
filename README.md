# ToDO App

## Informações gerais

Projeto desenvolvido em aulas do Programa START by Capgemini, durante as aulas de Lógica de Programação III. O curso é oferecido de maneira gratuita para aqueles que desejam ingressar na área de desenvolvimento de sistemas. 

## Da Descrição do projeto

Aplicação voltada para o gerenciamento de tarefas/etapas de projetos.

## Do Objetivo

Fornecer meios de organização de tarefas para facilitar as várias fazes de desenvolvimentos de projetos.

## Das Entidades

* **Projeto:** O projeto será a entidade principal da aplicação. Após a criação de um projeto, poderão ser lhes atribuídas as tarefas.
  * Atributos da entidade Projeto:
    * ID
    * Nome;
    * Descrição;
    * Data de criação;
    * Data da atualização.
* **Tarefa:** As tarefas deverão ser encaradas como uma fase a ser realizada. Um projeto é a união de várias tarefas realizadas. Grades problemas devem ser quebrados em problemas menores a fim de otimizar o tempo levado para sua resolução.
  * Atributos da entidade Tarefa:
    * ID
    * Nome;
    * Descrição;
    * Completed;
    * Notes;
    * Prazo;
    * Data de criação;
    * Data de atualização.

## Dos Requisitos funcionais

* Permitir a criação de projetos;
* Permitir a edição das informações de projetos já criados;
* Permitir excluir o projeto;
* Permitir a criação de tarefas vinculadas a projetos.
* Permitir a edição das informações de tarefas já criados;
* Permitir excluir de uma tarefa já criada;

## Das regras de negócio

* Não haverá um sistema de login.
* Não haverá conceito de usuário;
* Toda tarefa deve pertencer a um projeto;
* Deve ser possível filtrar as tarefas por tag.

## Das tecnologias utilizadas

* Java
* MySql

## Da arquitetura

MVC
