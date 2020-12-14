package com.nasit.majorProject.Controller;

import com.google.gson.Gson;
import com.nasit.majorProject.DataHolder.Data;
import com.nasit.majorProject.Util.Curl;
import com.nasit.majorProject.node.File;
import com.nasit.majorProject.service.FileRepository;
import com.nasit.majorProject.service.StudentService;
import com.squareup.okhttp.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import okhttp3.MultipartBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v0/student")
@Tag(name = "student")
public class StudentController {

    private StudentService studentService;
    private Curl curl;
    private FileRepository fileRepository;

    StudentController(StudentService studentService, FileRepository fileRepository){
        this.studentService = studentService;
        this.fileRepository = fileRepository;
        curl = Curl.getCurl();
    }

    @GetMapping("/{regno}")
    com.nasit.majorProject.DataHolder.Student getStudentByRegno(@PathVariable String regno) {
        com.nasit.majorProject.node.Student s = studentService.getByRegno(regno);
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://localhost:8000/api/v1/getData").newBuilder();
        urlBuilder.addQueryParameter("regno", s.getRegno());
        String url = urlBuilder.build().toString();
        curl.setUrl(url);
        curl.setMethod("GET");
        try {
            curl.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        System.out.println(curl.getResponse());
        com.nasit.majorProject.DataHolder.Student student = gson.fromJson(curl.getResponse(), com.nasit.majorProject.DataHolder.Student.class);
        return student;
    }

    @GetMapping("/compare/{regno}")
    com.nasit.majorProject.DataHolder.Student getStudentByRegnoOld(@PathVariable String regno) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://localhost:8000/api/v1/getData").newBuilder();
        urlBuilder.addQueryParameter("regno", regno);
        String url = urlBuilder.build().toString();
        curl.setUrl(url);
        curl.setMethod("GET");
        try {
            curl.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        System.out.println(curl.getResponse());
        com.nasit.majorProject.DataHolder.Student student = gson.fromJson(curl.getResponse(), com.nasit.majorProject.DataHolder.Student.class);
        return student;
    }

    @GetMapping("/byName/{name}")
    com.nasit.majorProject.DataHolder.Student getStudentByName(@PathVariable String name) {
        com.nasit.majorProject.node.Student s = studentService.getByName(name);
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://localhost:8000/api/v1/getData").newBuilder();
        urlBuilder.addQueryParameter("regno", s.getRegno());
        String url = urlBuilder.build().toString();
        curl.setUrl(url);
        curl.setMethod("GET");
        try {
            curl.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        System.out.println(curl.getResponse());
        com.nasit.majorProject.DataHolder.Student student = gson.fromJson(curl.getResponse(), com.nasit.majorProject.DataHolder.Student.class);
        return student;
    }

    @GetMapping("/getFile/{id}")
    com.nasit.majorProject.DataHolder.File getFileById(@PathVariable String id) {
        Optional<File> file = fileRepository.findById(id);
//        OkHttpClient client = new OkHttpClient();
//        MediaType mediaType = MediaType.parse("text/plain");
//        MultipartBody multipartBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("ID", file.get().getId())
//                .build();
//        Request request = new Request.Builder()
//                .url("https://adityaprovider.pythonanywhere.com/media_retriever/api/get/")
//                .post(multipartBody)
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Gson gson = new Gson();
//        System.out.println(curl.getResponse());
//        com.nasit.majorProject.DataHolder.Student student = gson.fromJson(curl.getResponse(), com.nasit.majorProject.DataHolder.Student.class);
        com.nasit.majorProject.DataHolder.File fileSend = new com.nasit.majorProject.DataHolder.File();
        if(id.equals("1"))
            fileSend.setData(new Data().setId(id).setMedia("media/Project_proposal_final_1.pdf").setName("proposal").setType("pdf")).setStatus(0);
        else
            fileSend.setData(new Data().setId(id).setMedia("media/research_paper.pdf").setName("Paper").setType("pdf")).setStatus(0);
        return fileSend;
    }
}
