package net.kinokolabo.reservation.logic;

import com.sendgrid.Email;
import net.kinokolabo.reservation.domain.JoinOrLeave;
import net.kinokolabo.reservation.domain.Mail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Logic {

    public boolean sendMail(String name, JoinOrLeave joinOrLeave, Email to) {
        Mail mail = new Mail();
        mail.setTo(to);
        mail.setFrom(new Email("kinokolabo-visit@kinokodata.net"));
        mail.setSubject("【もくもく会】" + name + "さんが" +joinOrLeave.getActionName() + "しました");
        String mess = LocalDateTime.now().format(DateTimeFormatter.ofPattern("H時M分、", Locale.JAPAN));
        if(joinOrLeave == JoinOrLeave.JOIN) {
            mess += "もくもく会に" + name + "さんが入室しました。";
        } else {
            mess += "もくもく会を" + name + "さんが退室しました。";
        }
        mail.setMessage(mess);
        return mail.send();
    }
}
