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

    public  principal(){
        super("Adivinhe o número pensado !!!");

        setSize(450,275);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new GridLayout(5,0,10,10));
        gerarNumeroAleatorio();

        legenda = new JLabel("Digite um numero, de 1 até 1000");
        legenda.setHorizontalAlignment(JLabel.CENTER);
        legenda.setFont(new Font("KG The Last Time",2,15));
        add(legenda);

        Handler handler = new Handler();

        inputNumber = new JTextField(27);
        inputNumber.setHorizontalAlignment(JTextField.CENTER);
        inputNumber.addActionListener(handler);
        add(inputNumber);

        testPalpite = new JButton("Testar Palpite");
        testPalpite.addActionListener(handler);
        add(testPalpite);

        gerarNumero = new JButton("Gerar Outro Número");
        gerarNumero.addActionListener(handler);
        add(gerarNumero);

        aviso = new JLabel();
        add(aviso,3);

    }

    public class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==inputNumber){
                testarNumero(e.getActionCommand());

            }else if(e.getSource()== gerarNumero){
                gerarNumeroAleatorio();
                inputNumber.setEditable(true);
                inputNumber.setText("");
                aviso.setText("Gerando outro número...");   

            }else if(e.getSource()==testPalpite){
                 testarNumero(inputNumber.getText());
            }
        }
    
    }
    
}