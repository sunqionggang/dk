package dockerproj.dkject.filrUpload;/**
 * @Author:sqg
 * @Description
 * @Date:${Time} ${Date}
 * @Modified By:
 **/

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @description: 文件上传和下载
 * @author: module
 * @create: 2020-09-27 18:03
 */
@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){

        String type=file.getContentType();
        String fileName=file.getName();

        //源文件名
        String originFileName=file.getOriginalFilename();
        Long size=file.getSize();
        try {
            file.transferTo(new File("d:\\"+originFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传成功";
    }
}
