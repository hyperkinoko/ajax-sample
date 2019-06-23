package net.kinokolabo.reservation.controller;

import net.kinokolabo.reservation.domain.Member;
import net.kinokolabo.reservation.domain.Notice;
import net.kinokolabo.reservation.domain.Student;
import net.kinokolabo.reservation.mapper.MemberMapper;
import net.kinokolabo.reservation.mapper.StudentMapper;
import net.kinokolabo.reservation.model.MemberForm;
import net.kinokolabo.reservation.model.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
public class MemberController {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    StudentMapper studentMapper;

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
        System.out.println("member: " + member.getName());
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
        if(memberId != 0) {
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
                System.out.println("memberid:" + memberId);
            } else {
                return 0;
            }
        }

        Student s = new Student();
        s.setMemberId(memberId);
        System.out.println("gid:" + form.getGardianId());
        s.setGuardianId(form.getGardianId());
        s.setNotice(form.isNotice() ? Notice.MAIL : Notice.NONE);
        LocalDateTime birthday = LocalDateTime.of(form.getbYear(), form.getbMonth(), form.getbDay(), 0, 0, 0);
        s.setBirthday(Timestamp.valueOf(birthday));

        int inserted = studentMapper.insert(s);
        if(inserted == 1) {
            System.out.println("studentid:" + s.getId());
            return s.getId();
        } else {
            return 0;
        }
    }
}

