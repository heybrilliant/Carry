package com.project.gymcarry.mypage;

public class CarryMyPageDto {
    private String crphoto;
    private String crintro;
    private String crfield;
    private String crdepart;
    private String crplace;
    private String crbfphoto;
    private String crcerti1;
    private String crcerti2;
    private String crcerti3;
    private String crcerti4;
    private String crcerti5;

    public CarryMyPageDto() {
    }

    public CarryMyPageDto(String crphoto, String crintro, String crfield, String crdepart, String crplace, String crbfphoto, String crcerti1, String crcerti2, String crcerti3, String crcerti4, String crcerti5) {
        this.crphoto = crphoto;
        this.crintro = crintro;
        this.crfield = crfield;
        this.crdepart = crdepart;
        this.crplace = crplace;
        this.crbfphoto = crbfphoto;
        this.crcerti1 = crcerti1;
        this.crcerti2 = crcerti2;
        this.crcerti3 = crcerti3;
        this.crcerti4 = crcerti4;
        this.crcerti5 = crcerti5;
    }

    public String getCrphoto() {
        return crphoto;
    }

    public void setCrphoto(String crphoto) {
        this.crphoto = crphoto;
    }

    public String getCrintro() {
        return crintro;
    }

    public void setCrintro(String crintro) {
        this.crintro = crintro;
    }

    public String getCrfield() {
        return crfield;
    }

    public void setCrfield(String crfield) {
        this.crfield = crfield;
    }

    public String getCrdepart() {
        return crdepart;
    }

    public void setCrdepart(String crdepart) {
        this.crdepart = crdepart;
    }

    public String getCrplace() {
        return crplace;
    }

    public void setCrplace(String crplace) {
        this.crplace = crplace;
    }

    public String getCrbfphoto() {
        return crbfphoto;
    }

    public void setCrbfphoto(String crbfphoto) {
        this.crbfphoto = crbfphoto;
    }

    public String getCrcerti1() {
        return crcerti1;
    }

    public void setCrcerti1(String crcerti1) {
        this.crcerti1 = crcerti1;
    }

    public String getCrcerti2() {
        return crcerti2;
    }

    public void setCrcerti2(String crcerti2) {
        this.crcerti2 = crcerti2;
    }

    public String getCrcerti3() {
        return crcerti3;
    }

    public void setCrcerti3(String crcerti3) {
        this.crcerti3 = crcerti3;
    }

    public String getCrcerti4() {
        return crcerti4;
    }

    public void setCrcerti4(String crcerti4) {
        this.crcerti4 = crcerti4;
    }

    public String getCrcerti5() {
        return crcerti5;
    }

    public void setCrcerti5(String crcerti5) {
        this.crcerti5 = crcerti5;
    }

    @Override
    public String toString() {
        return "CarryMyPageDto{" +
                "crphoto='" + crphoto + '\'' +
                ", crintro='" + crintro + '\'' +
                ", crfield='" + crfield + '\'' +
                ", crdepart='" + crdepart + '\'' +
                ", crplace='" + crplace + '\'' +
                ", crbfphoto='" + crbfphoto + '\'' +
                ", crcerti1='" + crcerti1 + '\'' +
                ", crcerti2='" + crcerti2 + '\'' +
                ", crcerti3='" + crcerti3 + '\'' +
                ", crcerti4='" + crcerti4 + '\'' +
                ", crcerti5='" + crcerti5 + '\'' +
                '}';
    }
}
