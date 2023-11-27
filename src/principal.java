import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class principal extends JFrame {
    
    private JButton gerarNumero;
    private JButton testPalpite;
    private JTextField inputNumber;
    private JLabel legenda,aviso;
    private int numeroGerado, tentativa;    

    
    
    public void gerarNumeroAleatorio(){
        Random numRand = new Random();
        numeroGerado = numRand.nextInt(1000)+1;           
    }


    //o bloco try-catch é executado para capturar um erro do tipo "NumberFormatException"
    //que identifica se a string recebida no argumento pode ser identificada como número.
    //Em caso positivo é convertido em um tipo Long, que permite um número muito grande.
    //Se usar o int, o tamanho do número será linitado
    public void testarNumero(String parametro){

            aviso.setText("");   
            try {
                long n = Long.parseLong(parametro);  
                String mensagem = "ERROU !!! O Número que pensei é ";                           
                    
                    if(n < numeroGerado){
                        JOptionPane.showMessageDialog(principal.this, mensagem + " MAIOR !!!");
                        inputNumber.setText("");
                        tentativa++;
                    }else if(n > numeroGerado){
                        JOptionPane.showMessageDialog(principal.this, mensagem + " MENOR !!!");
                        inputNumber.setText("");
                        tentativa++;
                    }else{
                        JOptionPane.showMessageDialog(principal.this, "ACERTOU MISERÁVI");
                        aviso.setText("Tentativas feitas => "+ tentativa);
                        inputNumber.setEditable(false);
                    }
            } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(principal.this, "Digite APENAS NÚMEROS meu camarada !!!");
               inputNumber.setText("");
               aviso.setText("Essa tentativa não vai contar...");
            }
    }

    //criação  do construtor dessa classe  que vai criar a janela principal do aplicativo.
    // Utilizando o super, automaticamente o parametro passado vai direto para o construtor
    // que foi extendido na criação desta classe.
    public  principal(){
        super("Adivinhe o número pensado !!!");

        //DIMENSÕES DA TELA
        setSize(450,275);
        setLocationRelativeTo(null);             // <= centraliza o app na tela.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // <= SEMPRE DEVE TER ESTE MÉTODO que encerra o app ao clicar em FECHAR.
        setVisible(true);                        // <= torna o app visível na tela.

        setLayout(new GridLayout(5,0,10,10));  // <= forma como os componentes são agrupados na tela
        gerarNumeroAleatorio();

        // OS COMPONENTES SÃO AGRUPADOS NA TELA NA ORDEM EM QUE SÃO ADICIONADOS PELO COMANDO ADD
        legenda = new JLabel("Digite um numero, de 1 até 1000");
        legenda.setHorizontalAlignment(JLabel.CENTER);
        legenda.setFont(new Font("KG The Last Time",2,15));
        add(legenda);

        Handler handler = new Handler(); // <= instância da classe Handler que foi criada logo abaixo e que implementa métodos para manipulação de eventos 

        inputNumber = new JTextField(27);
        inputNumber.setHorizontalAlignment(JTextField.CENTER);
        inputNumber.addActionListener(handler); // <= permite que eventos sejam capturados neste componente
        add(inputNumber);

        testPalpite = new JButton("Testar Palpite");
        testPalpite.addActionListener(handler);
        add(testPalpite);

        gerarNumero = new JButton("Gerar Outro Número");
        gerarNumero.addActionListener(handler);
        add(gerarNumero);

        aviso = new JLabel();
        add(aviso,3); // <= nesse caso essa label tá sendo posicionada exatamente na posição 3 de um grid de 5.

    }

    //criação de uma classe de manipulação de Eventos . Com isso as classe de eventos que foram
    //atribuidas nos componentes criados, podem ser manipulados através do método de sobrecarga .
    public class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==inputNumber){         // <= se foi dado ENTER no campo de entrada
                testarNumero(e.getActionCommand());

            }else if(e.getSource()== gerarNumero){  // <= se o botão gerarNumero foi clicado
                gerarNumeroAleatorio();
                inputNumber.setEditable(true);
                inputNumber.setText("");
                aviso.setText("Gerando outro número...");   

            }else if(e.getSource()==testPalpite){   // <= se o botão testPalpite foi clicado
                 testarNumero(inputNumber.getText());
            }
        }
    
    }
    
}