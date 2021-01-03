import com.sendgrid.*;

import java.io.IOException;

public class MailSender {
    public MailSender(){
        Email from = new Email("phabpharmacy@gmail.com");
        String subject = "Hello World from the SendGrid Java Library!";
        Email to = new Email("craigfatfree@gmail.com");
        Content content = new Content("text/plain", "Hello, Email!");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("phabpharmacy"));
        Request request = new Request();
        try {
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            Response response = sg.api(request);
            System.out.println(response.statusCode);
            System.out.println(response.body);
            System.out.println(response.headers);
        } catch (IOException ex) {
            try {
                throw ex;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

