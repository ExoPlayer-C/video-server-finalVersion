package service;
import javax.mail.Authenticator;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;

// EmailSender e=new EmailSender("收件人","内容");
// e.sendAnEmail();
class MyAuthenticator extends Authenticator {
    String name;
    String password;

    public MyAuthenticator(String name, String password) {
        this.name = name;
        this.password = password;
        this.getPasswordAuthentication();
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(name, password);
    }
}

public class EmailSender {
    String receive;
    String body;

    public EmailSender(String receive, String body) {
        this.receive = receive;
        this.body = body;
    }

    public void sendAnEmail() throws Exception {
        // 发件人和许可证
        String name = "1062964308";
        String password = "pntncmzgihxubbch";
        Properties props = System.getProperties();
        // 协议
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.smtp.auth", "true");
        // 发送邮件
        MyAuthenticator auth = new MyAuthenticator(name, password);
        Session session = Session.getDefaultInstance(props, auth);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("1062964308@qq.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receive));
        message.setSubject("You have a new Email:");
        message.setText(body);
        Transport transport = session.getTransport("smtp");
        transport.connect((String) props.get("mail.smtp.host"), name, password);
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }

}
