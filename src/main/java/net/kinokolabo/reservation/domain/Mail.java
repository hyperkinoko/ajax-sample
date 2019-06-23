package net.kinokolabo.reservation.domain;

import com.sendgrid.*;

import java.io.IOException;

public class Mail {
    private String message;
    private Email to;
    private Email from;
    private String subject;
    private String contentType = "text/plain";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Email getTo() {
        return to;
    }

    public void setTo(Email to) {
        this.to = to;
    }

    public Email getFrom() {
        return from;
    }

    public void setFrom(Email from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean send() {
        com.sendgrid.Mail mail = new com.sendgrid.Mail(from, subject, to, new Content(contentType, message));
        SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sendGrid.api(request);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
