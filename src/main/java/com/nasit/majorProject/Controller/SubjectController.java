package com.nasit.majorProject.Controller;

import com.google.gson.Gson;
import com.nasit.majorProject.Util.Curl;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.nasit.majorProject.node.Student;
import com.nasit.majorProject.node.Subject;
import com.nasit.majorProject.service.SubjectService;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v0/subject")
@Tag(name = "subject")
public class SubjectController {

    private final SubjectService subjectService;
    private final Curl curl;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
        this.curl = Curl.getCurl();
    }

    @GetMapping("/")
    List<Subject> getSubjects() {
        return subjectService.getSubjects();
    }

    @GetMapping("/{code}")
    com.nasit.majorProject.DataHolder.Subject getSubjects(@PathVariable String code) {
        Subject s = subjectService.getSubjectByCode(code);
        curl.setUrl("https://mdm.sahajbamba.me/getcoursebycode");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",s.getCode());
        jsonObject.put("session","reg_o_20");
        curl.setJsonObject(jsonObject);
        try {
            curl.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        System.out.println(curl.getResponse());
        com.nasit.majorProject.DataHolder.Subject subject = gson.fromJson(curl.getResponse(), com.nasit.majorProject.DataHolder.Subject.class);
        return subject;
    }

    @GetMapping("/compare/{code}")
    com.nasit.majorProject.DataHolder.Subject getOldSubject(@PathVariable String code) {
        curl.setUrl("https://mdm.sahajbamba.me/getcoursebycode");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("session","reg_o_20");
        curl.setJsonObject(jsonObject);
        try {
            curl.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        System.out.println(curl.getResponse());
        com.nasit.majorProject.DataHolder.Subject subject = gson.fromJson(curl.getResponse(), com.nasit.majorProject.DataHolder.Subject.class);
        return subject;
    }

    @GetMapping("/byName/{name}")
    com.nasit.majorProject.DataHolder.Subject getSubjectByName(@PathVariable String name) {
        Subject s = subjectService.getSubjectByName(name);
        curl.setUrl("https://mdm.sahajbamba.me/getcoursebycode");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",s.getCode());
        jsonObject.put("session","reg_o_20");
        curl.setJsonObject(jsonObject);
        try {
            curl.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        System.out.println(curl.getResponse());
        com.nasit.majorProject.DataHolder.Subject subject = gson.fromJson(curl.getResponse(), com.nasit.majorProject.DataHolder.Subject.class);
        return subject;
    }

    @GetMapping("/getEnrolledStudents/{code}")
    List<Student> getEnrolledStudents(@PathVariable String code) {
        return subjectService.getStudents(code);
    }

}
