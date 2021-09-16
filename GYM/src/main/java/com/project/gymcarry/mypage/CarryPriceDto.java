package com.project.gymcarry.mypage;

public class CarryPriceDto {
    private int cridx;
    private int procount;
    private int proprice1;
    private int proprice2;
    private int proprice3;
    private int proprice4;

    public CarryPriceDto() {
    }

    public CarryPriceDto(int cridx, int procount, int proprice1, int proprice2, int proprice3, int proprice4) {
        this.cridx = cridx;
        this.procount = procount;
        this.proprice1 = proprice1;
        this.proprice2 = proprice2;
        this.proprice3 = proprice3;
        this.proprice4 = proprice4;
    }

    public int getCridx() {
        return cridx;
    }

    public void setCridx(int cridx) {
        this.cridx = cridx;
    }

    public int getProcount() {
        return procount;
    }

    public void setProcount(int procount) {
        this.procount = procount;
    }

    public int getProprice1() {
        return proprice1;
    }

    public void setProprice1(int proprice1) {
        this.proprice1 = proprice1;
    }

    public int getProprice2() {
        return proprice2;
    }

    public void setProprice2(int proprice2) {
        this.proprice2 = proprice2;
    }

    public int getProprice3() {
        return proprice3;
    }

    public void setProprice3(int proprice3) {
        this.proprice3 = proprice3;
    }

    public int getProprice4() {
        return proprice4;
    }

    public void setProprice4(int proprice4) {
        this.proprice4 = proprice4;
    }


}
