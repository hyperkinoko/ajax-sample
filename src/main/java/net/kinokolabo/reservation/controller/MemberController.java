package net.kinokolabo.reservation.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.sendgrid.Email;
import net.kinokolabo.reservation.domain.*;
import net.kinokolabo.reservation.logic.Logic;
import net.kinokolabo.reservation.mapper.MemberMapper;
import net.kinokolabo.reservation.mapper.StudentMapper;
import net.kinokolabo.reservation.mapper.VisitMapper;
import net.kinokolabo.reservation.model.MemberForm;
import net.kinokolabo.reservation.model.StudentForm;
import net.kinokolabo.reservation.model.VisitModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Hashtable;

@RestController
public class MemberController {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    VisitMapper visitMapper;

    @CrossOrigin(origins = {"https://kinokodata.net", "http://localhost:8080"})
    @GetMapping("/member")
    public Member getMember(@RequestParam(defaultValue = "0") String id) {
        Member member;
        try{
            int idInt = Integer.parseInt(id);
            if(idInt == 0) {
                member = new Member();
            } else {
                member = memberMapper.selectById(idInt);
            }
        } catch (NumberFormatException e) {
            return null;
        }
        if(member == null) {
            return null;
        }
        return member;
    }

    @CrossOrigin(origins = {"https://kinokodata.net", "http://localhost:8080"})
    @PostMapping("/member/regist")
    public int setMember(@RequestBody MemberForm form) {
        Member m = new Member();
        m.setId(form.getId());
        m.setName(form.getName());
        m.setNameKana(form.getNameKana());
        m.setZip(form.getZip());
        m.setPref(form.getPref());
        m.setAddr(form.getAddr());
        m.setTel1(form.getTel1());
        m.setTel2(form.getTel2());
        m.setMail(form.getMail());
//        m.setPasswd(form.getPasswd());

        int inserted = memberMapper.insert(m);

        if(inserted == 1) {
            return m.getId();
        } else {
            return 0;
        }
    }

    @CrossOrigin(origins = {"https://kinokodata.net", "http://localhost:8080"})
    @PostMapping("/student/regist")
    public int setStudent(@RequestBody StudentForm form) {
        int memberId = form.getMemberId();
        if(memberId == 0) {
            Member m = new Member();
            m.setId(form.getId());
            m.setName(form.getName());
            m.setNameKana(form.getNameKana());
            m.setZip(form.getZip());
            m.setPref(form.getPref());
            m.setAddr(form.getAddr());
            m.setTel1(form.getTel1());
            m.setTel2(form.getTel2());
            m.setMail(form.getMail());

            if(memberMapper.insert(m) == 1) {
                memberId = m.getId();
            } else {
                return 0;
            }
        }

        Student s = new Student();
        s.setMemberId(memberId);
        s.setGuardianId(form.getGuardianId());
        s.setNotice(form.isNotice() ? Notice.MAIL : Notice.NONE);
        LocalDateTime birthday = LocalDateTime.of(form.getbYear(), form.getbMonth(), form.getbDay(), 0, 0, 0);
        s.setBirthday(Timestamp.valueOf(birthday));

        int inserted = studentMapper.insert(s);
        if(inserted == 1) {
            return s.getId();
        } else {
            return 0;
        }
    }

    @CrossOrigin
//    @CrossOrigin(origins = {"https://kinokodata.net", "http://localhost:8080", "192.168.*"})
    @PostMapping("/student/visit")
    @ResponseBody
    public String setStudent(@RequestBody VisitModel model) {
        int studentId = model.getStudentId();
        JoinOrLeave jorl = JoinOrLeave.valueOf(model.getJoinOrLeave());
        Visit v = new Visit();
        v.setStudentId(studentId);
        v.setJoinOrLeave(jorl);
        v.setCourseId(model.getCourseId());
        v.setTime(Timestamp.valueOf(LocalDateTime.now()));

        int inserted  = visitMapper.insert(v);
        if(inserted != 1) {
            return "エラー";
        }

        //メールを送る
        Student student = studentMapper.selectById(studentId);
        Member mStudent = memberMapper.selectById(student.getMemberId());
        if(student.getNotice() == Notice.MAIL) {
            Member guardian = memberMapper.selectById(student.getGuardianId());
            String mail = guardian.getMail();
            if(mail != null && !mail.equals("")) {
                System.out.println(v.getJoinOrLeave() + " => send mail to:" + mail);
                if(!new Logic().sendMail(mStudent.getName(), jorl, new Email(mail))) {
                    return "えらー";
                }
            }
        }
        return "OK:" + v.getId();
    }

    @CrossOrigin
//    @CrossOrigin(origins = {"https://kinokodata.net", "http://localhost:8080", "192.168.*"})
    @GetMapping("/qrcode/create")
    @ResponseBody
    public HttpEntity<byte[]> getQRCode(@RequestParam int id) {
        String contents = "http://localhost:8080/#/student/visit?id=" + id;
        BarcodeFormat format = BarcodeFormat.QR_CODE;
        int width = 200;
        int height = 200;

        try {

            Hashtable hints = new Hashtable();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);

            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix bitMatrix = writer.encode(contents, format, width, height, hints);
            BufferedImage qrcode = MatrixToImageWriter.toBufferedImage(bitMatrix);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(qrcode, "png", byteArrayOutputStream);
            byte[] bytesOfImage = byteArrayOutputStream.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            headers.setContentLength(bytesOfImage.length);

            return new HttpEntity<byte[]>(bytesOfImage, headers);

        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

