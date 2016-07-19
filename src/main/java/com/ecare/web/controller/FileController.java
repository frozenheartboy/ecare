package com.ecare.web.controller;

import com.ecare.web.util.ResultUtil;
import com.ecare.web.vo.Constant.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 * Created by L on 2016/7/19.
 */
@Controller
@RequestMapping("/File")
public class FileController {
    @RequestMapping(value = "/upload")
    @ResponseBody
    public Map<String, Object> upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        String path = request.getContextPath() + "/" + Constant.FILE_PATH;
        String fileName = new Date().getTime()+".jpg";
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            return ResultUtil.getResult(Constant.FAILURE,"上传失败",null);
        }
        return ResultUtil.getResult(Constant.SUCCESS,"上传成功",path+"/"+fileName);
    }
}
