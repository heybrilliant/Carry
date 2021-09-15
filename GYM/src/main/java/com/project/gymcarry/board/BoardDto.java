package com.project.gymcarry.board;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


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
    private String boardcategory;
    private int commentCnt;        //댓글 개수


    public BoardDto() {

    }


    public BoardDto(int postidx, String postname, String postcontent, String postnick, int memidx, MultipartFile uploadfile, Date postdate, int postview, int postlike, String boardcategory, int commentCnt) {
        this.postidx = postidx;
        this.postname = postname;
        this.postcontent = postcontent;
        this.postnick = postnick;
        this.memidx = memidx;
        this.uploadfile = uploadfile;
        this.postdate = postdate;
        this.postview = postview;
        this.postlike = postlike;
        this.boardcategory = boardcategory;
        this.commentCnt = commentCnt;
    }

    public int getPostidx() {
        return postidx;
    }


    public void setPostidx(int postidx) {
        this.postidx = postidx;
    }


    public String getPostname() {
        return postname;
    }


    public void setPostname(String postname) {
        this.postname = postname;
    }


    public String getPostcontent() {
        return postcontent;
    }


    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent;
    }


    public String getPostnick() {
        return postnick;
    }


    public void setPostnick(String postnick) {
        this.postnick = postnick;
    }


    public int getMemidx() {
        return memidx;
    }


    public void setMemidx(int memidx) {
        this.memidx = memidx;
    }


    public MultipartFile getUploadfile() {
        return uploadfile;
    }


    public void setUploadfile(MultipartFile uploadfile) {
        this.uploadfile = uploadfile;
    }


    public Date getPostdate() {
        return postdate;
    }


    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }


    public int getPostview() {
        return postview;
    }


    public void setPostview(int postview) {
        this.postview = postview;
    }


    public int getPostlike() {
        return postlike;
    }


    public void setPostlike(int postlike) {
        this.postlike = postlike;
    }


    public String getBoardcategory() {
        return boardcategory;
    }


    public void setBoardcategory(String boardcategory) {
        this.boardcategory = boardcategory;
    }


    public int getCommentCnt() {
        return commentCnt;
    }

    public void setCommentCnt(int commentCnt) {
        this.commentCnt = commentCnt;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "postidx=" + postidx +
                ", postname='" + postname + '\'' +
                ", postcontent='" + postcontent + '\'' +
                ", postnick='" + postnick + '\'' +
                ", memidx=" + memidx +
                ", uploadfile=" + uploadfile +
                ", postdate=" + postdate +
                ", postview=" + postview +
                ", postlike=" + postlike +
                ", boardcategory='" + boardcategory + '\'' +
                ", commentCnt=" + commentCnt +
                '}';
    }
}