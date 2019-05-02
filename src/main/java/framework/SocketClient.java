package framework;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.Date;

public class SocketClient {
    public static void main(String[] args) throws UnknownHostException{
        String servidor = "127.0.0.1"; //endereço do servidor
        int porta = 33333; // porta padrão

        // Recebendo estes valores ccomo asgumento do programa
        if(args.length >=1){
            servidor  = args[0];
            if (args.length == 2){
                porta = Integer.valueOf(args[1]);
            }
        }

        try {
            DatagramSocket socket = new DatagramSocket();

            
            // criaçao do buffer para poder enviar e receber dados
            byte[] buffer = new byte[8]; // tamanho do buffer

            // criar um ...
            InetAddress end = InetAddress.getByName(servidor);

            // criar um datagrama
            DatagramPacket pct = new DatagramPacket(buffer, buffer.length, end, porta);

            // Enviamos um pacote em branco como menssagem  para receber a data
            System.out.println("Enviando solicitação de data para: " + end.toString());
            try {
                socket.send(pct);
            } catch (IOException e) {
//                e.printStackTrace();
                System.out.println("Erro de envio de menssagem para o servidor!" + e.getMessage());
            }

            // espera e resebe o pacote com a dat no buffer
            pct = new DatagramPacket(buffer, buffer.length);
            System.out.println("Aguardando data do servidor");
            try {
                socket.receive(pct);
            } catch (IOException e) {
//                e.printStackTrace();
                System.out.println("Erro de recebimento de menssagem do servidor: " + e.getMessage());
            }

            // agora vamo decodificar o precesso é o inveço do cliente
            DataInputStream dis = new DataInputStream(new ByteArrayInputStream(buffer));
            try {
                Date data = new Date(dis.readLong());
//                System.out.println(data);
                System.out.println("Data recebida: " + data);
            } catch (IOException e) {
//                e.printStackTrace();
                System.out.println("Erro converção da data  " + e.getMessage());
            }

        } catch (SocketException e) {
//            e.printStackTrace();
            System.out.println("Erro ao criar socket" + e.getMessage());
        }


    }
}
