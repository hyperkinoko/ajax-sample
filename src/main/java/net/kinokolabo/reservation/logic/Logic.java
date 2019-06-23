package net.kinokolabo.reservation.logic;

import com.sendgrid.Email;
import net.kinokolabo.reservation.domain.JoinOrLeave;
import net.kinokolabo.reservation.domain.Mail;

public class Logic {

    public boolean sendMail(String name, JoinOrLeave joinOrLeave, Email to) {
        Mail mail = new Mail();
        mail.setTo(to);
        mail.setFrom(new Email("kinokolabo-visit@kinokodata.net"));
        mail.setSubject("【もくもく会】" + name + "さんが" +joinOrLeave.getActionName() + "しました");
        mail.setMessage("もくもく会に" + name + "さんが" +joinOrLeave.getActionName() + "しました");

        return mail.send();
    }
}
