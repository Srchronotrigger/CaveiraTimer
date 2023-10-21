# CaveiraTimer
Um cronômetro e temporizador 2 em 1 para lives com temática do Canal RenanPlay

[**Click Here for instructions in English**](https://github.com/Srchronotrigger/CaveiraTimer/tree/main)

## 📢 Uma breve introdução
O CaveiraTimer é um cronômetro e temporizador que foi criado com o propósito de facilitar a contagem de tempo em livestreams de desafios, como é o caso de lives infinitas, lives de 24 horas e afins. Desse modo, a ideia surgiu ao observar certas dificuldades que o youtuber RenanPlay teve com o uso de cronômetros genéricos, o CaveiraTimer consegue efetivamente mitigar a maior parte dessas problemáticas com o uso de mecânicas apropriadas para esse tipo de uso.

## 🛠️ Pré-requisitos e instalação
O CaveiraTimar é baseado no JDK 8 do Java, portanto é preciso ter o Java 8 ou superior instalado para executar o software, o Java 8 pode ser obtido no site oficial da Oracle:

[https://www.java.com/pt-BR/download/ie_manual.jsp](https://www.java.com/pt-BR/download/ie_manual.jsp)

Após a instalação do Java 8 não é necessário mais nenhuma intervenção ou configuração extra, basta um clique duplo em cima do arquivo "CaveiraTimer.jar", a instalação do Java deve bastar para o funcionamento do CaveiraTimer e a tela de seleção de modo deve ser exibida:

[![Tela de seleção](https://i.postimg.cc/jSG2xcZr/Screenshot-2.png)](https://postimg.cc/QFJhSp26)

Ao clicar em um dos modos uma tela correspondente ao modo selecionado será exibida, sendo um cronômetro para para progressivo e um temporizador para regressivo:

[![Caveira-Timer.png](https://i.postimg.cc/rwbB7Yg5/Caveira-Timer.png)](https://postimg.cc/PCWVwygq)

(da esquerda para direita: Progressivo e Regressivo)

## 🕹️ Controles
```+``` adiciona mais horas

```-``` subtrai horas

```Botões``` oculta/exibe a Barra de título do programa

```Visível``` ativa/desativa o modo sempre visível do programa

```Começar``` inicia o contador

```Pausar``` pausa o contador

## 📌 Arquivo tempo.txt
O arquivo tempo.txt possui basicamente três funções: Salvar o tempo do relógio, Definir o tempo do relógio e Definir a Frequência de salvamento.
o arquivo tempo.txt conterá os seguintes parâmetros ao ser iniciado pela primeira vez:
```
segundos=0
minutos=0
horas=0
dias=0
horasParaoFimDaLive=0
FrequenciaDeSaveEmMinutos=1
 ```
```segundos=0``` define os segundos no relógio 

```minutos=0``` define os minutos no relógio 

```horas=0``` define as horas no relógio 

```dias=0``` define os dias no relógio 

```horasParaoFimDaLive=0``` define as horas totais da live 

```FrequenciaDeSaveEmMinutos=1``` define de quanto em quanto tempo o tempo o estado atual do CaveiraTimer será salvo automaticamente.

Deletar o arquivo tempo.txt com o programa fechado implicará na perca do estado salvo, o programa irá gerar um novo tempo.txt ao detectar a ausência do mesmo.

## 🕷️ Bugs conhecidos
Por conta de uma caracterísitca do Java Swing o componente jPanel não consegue atualizar a janela enquanto minimizado, isso gera um bug visual no OBS de que o relógio "congelou", mas não é o caso, pois a Thread continua em funcionamento mesmo que minimizada o que faz o relógio retornar o tempo correto ao maximizar novamente, uma forma de contornar isso é simplesmente não minimizando a janela ou clicando em outra para dessa maneira a janela do CaveiraTimer ficar em segundo plano.

## 📜 Licença e Créditos
O CaveiraTimer é distribuido gratuitamente sob a licença MIT, é permitido a modificação e a redistribuição desde que mantido os créditos ao autor (Srchronotrigger).
Email para contato: [sr.chronotrigger@gmail.com](mailto:sr.chronotrigger@gmail.com)

fonte alarm_clock.ttf por David J Patterson. Disponível em: [https://www.dafont.com/pt/alarm-clock.font](https://www.dafont.com/pt/alarm-clock.font)
