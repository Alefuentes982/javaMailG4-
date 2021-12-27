package mailto;

import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su correo: ");
        String from = sc.nextLine();

        System.out.println("ingrese su contraseña: ");
        String pass = sc.nextLine().console.readPassword;

        System.out.println("Ingrese la direccion de Correo de Destino: ");
        String to = sc.nextLine();

        System.out.println("Ingrese el Asunto del correo: ");
        String asunto = sc.nextLine();

        System.out.println("Ingrese el mensaje: ");
        String mensaje = sc.nextLine();

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication(from, pass);

            }

        });

        session.setDebug(true);

        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(asunto);
            message.setText(mensaje);

            System.out.println("Enviando...");

            Transport.send(message);

            System.out.println("Mensaje enviado exitosamente....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}