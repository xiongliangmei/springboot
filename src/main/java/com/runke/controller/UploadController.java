package com.runke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/upload/")
public class UploadController {

    @RequestMapping("index")
    public String index(){
        return "upload";
    }

    public String singleFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){
        if (file == null){
            redirectAttributes.addAttribute("message","Please select a file to upload");
            return "redirect:index";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(file.getOriginalFilename());
            Files.write(path,bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
