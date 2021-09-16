package com.project.gymcarry.mypage;

public class CarryMyPageDto2 {

    private String crintro;
    private String crfield;
    private String crplace;
    private String crcerti1;
    private String crcerti2;
    private String crcerti3;
    private String crcerti4;
    private String crcerti5;
    private int cridx;

    public CarryMyPageDto2() {
    }

    public CarryMyPageDto2( String crintro, String crfield, String crplace,  String crcerti1, String crcerti2, String crcerti3, String crcerti4, String crcerti5, int cridx) {

        this.crintro = crintro;
        this.crfield = crfield;

        this.crplace = crplace;

        this.crcerti1 = crcerti1;
        this.crcerti2 = crcerti2;
        this.crcerti3 = crcerti3;
        this.crcerti4 = crcerti4;
        this.crcerti5 = crcerti5;
        this.cridx = cridx;
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



    public String getCrplace() {
        return crplace;
    }

    public void setCrplace(String crplace) {
        this.crplace = crplace;
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

    public int getCridx() {
        return cridx;
    }

    public void setCridx(int cridx) {
        this.cridx = cridx;
    }


}
