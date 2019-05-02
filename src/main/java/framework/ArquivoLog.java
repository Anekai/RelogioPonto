package framework;

import java.io.*;
import java.text.DateFormat;
import java.util.Vector;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ArquivoLog {

    File arquivo;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWritter;
    BufferedWriter bufferedWriter;

    public ArquivoLog(String erros)
    {
        escreverLog(erros);
    }

    private void escreverLog(String erros)
    {
        try {
            
            final DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            final Calendar cal = Calendar.getInstance();
            String usavel = df.format(cal.getTime());
                       
            arquivo = new File("exceptions.log");
            fileReader = new FileReader(arquivo);
            bufferedReader = new BufferedReader(fileReader);
            Vector texto = new Vector();
            while (bufferedReader.ready()){
                texto.add(bufferedReader.readLine());
            }
            fileWritter = new FileWriter(arquivo);
            bufferedWriter = new BufferedWriter(fileWritter);
            for (int i = 0; i<texto.size();i++){
                bufferedWriter.write(texto.get(i).toString());
                bufferedWriter.newLine();
                bufferedWriter.newLine();
            }
            bufferedWriter.write(usavel + " - " + erros);
            bufferedReader.close();
            bufferedWriter.close();

        }
        catch (FileNotFoundException e) {
            try {
                arquivo.createNewFile();
                escreverLog(erros);
            } catch (IOException e1) {
                System.out.println("oi");
                System.exit(0);
            }
            System.out.println("file");
        }
        catch (IOException er)
        {
            System.out.println("OI");
            System.exit(0);
        }
    }
}
