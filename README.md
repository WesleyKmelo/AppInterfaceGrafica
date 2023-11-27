# Aplicativo Interface Gráfica JAVA

Aplicativo feito com Java [OpenJDK 11](https://openjdk.org/projects/jdk/11/). Construido na plataforma [Visual Studio Code](https://code.visualstudio.com/download).

## Objetivo
A finalidade deste app é interagir com usuário solicitando que adivinhe um número pensado aleatoriamente e através de mensagens popup orientar sobre o acerto da resposta.

## Estrutura do aplicativo

Criada uma classe que importa  da classe [JFrame](https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html).

Essa classe é responsável por fornecer alguns elementos gráficos do pacote Swing. Esse pacote é responsável por fornecer elementos de GUI para uso com o Java.

No caso, são acrecentados os componentes *JLabel*, *JTextField*, *JFrame* e *JButton*.

***

Através do método *Random* do ***java.util*** é gerado um número aleatório que em seguida é testado através de uma lógica que primeiro identifica se o dado a ser testado é ***um número ou não*** e em se o dado for validado como número, é testado pra saber se foi digitado o número pensado.

***

### Observações

Para que os componentes do aplicativo possam funcionar é necessário acrescentar um ***HANDLER*** para cada componente que precisa ser tratado. O ***HANDLER*** é uma classe que foi criada no app para poder importar métodos de manutenção de eventos , como o *ActionListener*.

Para funcionar é necessário criar uma instância da classe ***HANDLER*** e em seguida atribuir ao componente os métodos necessários. No caso deste aplicativo foi foi implementado a interface *ActionListener* que automaticamente pede que seja feita uma sobrecarga do método *actionPeformed(ActionEvent e)*. 

## Uso do Aplicativo

Para uso deste aplicativo , basta ter instalado no local de execução a plataforma [OpenJDK 11](https://openjdk.org/projects/jdk/11/). 

Para uso pelo Terminal ou prompt , primeiro faça um build do projeto com o comando *javac* seguido do nome da classe onde está o método *Main*.

`javac App.java`

Esse comando DEVE ser executado na pasta onde está o arquivo *App.java* e então vai ser compilado o programa pra que possa rodar em qualquer plataforma através do comando:

`java App`


***

**Obs =>** *Código comentado em PT-BR para facilitar entendimento. Quaisquer comentários favor fazer um Pull Request.*

*Se lhe ajudou não esqueça de deixar uma estrelinha.*