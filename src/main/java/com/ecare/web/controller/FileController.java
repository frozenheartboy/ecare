package com.ecare.web.controller;

import com.ecare.web.util.ResultUtil;
import com.ecare.web.vo.Constant.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
        String path = request.getSession().getServletContext().getRealPath("/" + Constant.FILE_PATH);
        String fileName = new Date().getTime() + ".jpg";
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            return ResultUtil.getResult(Constant.FAILURE, "上传失败", null);
        }
        return ResultUtil.getResult(Constant.SUCCESS, "上传成功", path + "/" + fileName);
    }

    @RequestMapping(value = "/download")

    public Map<String, Object> download(@RequestParam("url") String url, HttpServletResponse response) throws IOException {
        InputStream in = new FileInputStream(new File(url));
        OutputStream out = response.getOutputStream();
        try {
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename="+new Date().getTime()+".jpg");
            response.setContentType("application/octet-stream; charset=utf-8");
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            out.flush();
        } catch (Exception e){
            return ResultUtil.getResult(Constant.FAILURE, "下载失败", null);
        }
        finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        }
        return ResultUtil.getResult(Constant.SUCCESS, "上传成功", null);
    }
}
