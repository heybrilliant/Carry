package com.project.gymcarry.board;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class BoardDto {

    private int postidx;
    private String postname;
    private String postcontent;
    private String postnick;
    private int memidx;
    private MultipartFile uploadfile;
    private Date postdate;
    private int postview;
    private int postlike;
    private  String boardcategory;
}
