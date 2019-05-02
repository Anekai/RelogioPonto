package framework;

import javax.xml.crypto.Data;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class SocketServer {
    public static void main(String[] args) {
        int porta = 33333; // porta padrão
        if(args.length >=1){
            porta = Integer.valueOf(args[0]);
        }

        // Passo 1 criar
        DatagramSocket socket;
        try {
            // Obter o socket
            socket = new DatagramSocket(porta);

            while(true){
            
                // criaçao do buffer para poder enviar e receber dados
                byte[] buffer = new byte[8]; // tamanho do buffer

                // criação do data packet
                DatagramPacket pct = new DatagramPacket(buffer, buffer.length);

                // espera e recebe pacote com a data do buffer
                System.out.println("Esperando menssagem do cliente");

                try {
                    socket.receive(pct);
                } catch (IOException e) {
    //                e.printStackTrace();
                    System.out.println("Erro Recebemento de pacote");
                }

                //obter a data local
                Date data = new Date();

                // A melhor forma de escrever é utilizar streams
                // como o socket le bytes criamos o byte array
                ByteArrayOutputStream baus = new ByteArrayOutputStream();
                // usamos em conjunto

                DataOutputStream dos = new DataOutputStream(baus);
                try {
                    dos.writeLong(data.getTime());
                } catch (IOException e) {
    //                e.printStackTrace();
                    System.out.println("Erro converção da dara para array " + e.getMessage());
                }

                // enviando data para o cliente
                System.out.println("enviando data para o cliente" + pct.getAddress());
                // pct.getAddress contem o ip do cliente

                buffer = baus.toByteArray();
                pct = new DatagramPacket(buffer, buffer.length, pct.getAddress(), pct.getPort());
                try {
                    socket.send(pct);
                } catch (IOException e) {
    //                e.printStackTrace();
                    System.out.println("Erro de envio de pacote para %s. %s/n" + pct.getAddress().toString());
                }

                System.out.println("Pacote enviado para: "+ pct.getAddress());
                System.out.println("Data enviada: " + data);
            }
        } catch (SocketException e) {
//            e.printStackTrace();
            System.out.println("Erro ao criar socket");
        }
    }
}
