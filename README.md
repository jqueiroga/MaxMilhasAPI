# DesafioQA - MarketPay

Considerações sobre a realização do desafio.

1. O Desafio proposto foi realizado procurando atenter ao solicitado. Devido a alguns problemas (que não vem ao caso detalhar)
não foi possível apresentar toda a solução de forma que desejada, mas apresento a resolução do desafio da melhor forma que
pude realizar.

2. Para a criação dos casos de testes automáticos do FrontEnd, foi utilizado Java+Selenium WebDriver com padrão  de
melhoria de código o Data Driver Testing e o PageObject. Para critério de implementação desses padrões foi escolha a class
de RealizarLogin, para as demais classes não foi possível tempo para implementar tudo.

3. Para a criação de testes automáticos do BackEnd, foi utilizado Java+RestAssured que é bastante utilizado nas validações
de API de forma simples e segura.

4. Foi gerado um documento de Plano de Testes especificando todos as abordagens de testes e todas as informações necessárias
para a realização dos testes do Desafio. Devido ao tempo o documento está com a especificação dos Casos de Testes incompletos
porém foi apresentados alguns para critério de avaliação da estrutura de escrita de Casos de Testes.

5. Para o gerenciamento de defeitos, foi utilizado o Mantis Bug Tracker, uma ferramenta free e online, nela é possível registrar
todas as ocorrências de defeitos encontradas, sendo possível ser visualizado por mais de um usuáros, inclusive para que ficar
no papel de resolucionar o defeito.
No Mantis foi criado 3 tipos de defeitos encontradados, sendo esses suficiente para análise da estrutra e a forma de escrita
de um defeito.
Todos os defeitos encontrados estão listados em um arquivo .txt em anexo, como também apresentados no Status Report, apresentando
o prioridade e o situação.

6. O Status Report gerado, foi feito no excel, nesse documento está apresentado todos os casos de testes e a situação e criticidade,
a lista de todos os defeitos identificados durante esses 2 dias e uma analise gráfica da evolução da execução, como também o 
resultado dos testes. Ao final há um parecer dos testes realizados.

Espero que o que foi apresentado, mesmo que de forma incompleta (não querendo arrumar desculpas, mas passei por um contratempo
não planejado) e que seja satisfatório para avaliação da equipe de seleção da Conductor. 

Agradeço a oportunidade e fico a disposição para qualquer questionamento.



#PARA EXECUTAR OS TESTES AUTOMATICOS CRIADOS.

Siga os passos abaixos para executar a Suite de Teste Automáticos do DesafioQA - MarketPay

Instruções:

* Baixar e Instale o Java SE Development Kit (Ou certifique que o mesmo esteja devidamente instalado e atualizado) http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html

* Baixar o Maven https://maven.apache.org/download.cgi ou baixe do repositorio no bitbucker compartilhado

* Extrair o Maven no diretório "C:\Program Files (x86)\Java"

* Adicionar o diretório "bin" do Maven à variável de ambiente PATH

* Baixar o Driver do Chrome (Arquivo disponível repositorio no bitbucker compartilhado - "chromedriver.exe")

* Copie o arquivo do Driver do Chrome na pasta "C:\Users\driver"

* Baixe os arquivos do projeto DesafioQA - MarketPay e copie em qualquer pasta, indico colocar na raiz unidade c:\

* Abra a tela de Prompt de Comando

* Vá para a pasta raiz do projeto DesafioQA - MarketPay

* Para rodar os Testes do FrontEnd
Digite o comando mvn test -Dtest="NomedaClassedosTestes" 

NomedaClassedosTestes   - CadastrarCliente
                        - CadastrarTransicao
                        - ListarClientes
                        - ListarTransacao
                        - RealizarLoginSistema

* Para rodar os Testes do BackEnd (API)
Digite o comando mvn test -Dtest=testBackEndAPI, 

