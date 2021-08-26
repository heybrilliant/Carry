package com.project.gymcarry.place;

public class PlaceDto {

	private int placeidx;
	private String placename;
	private String openhour;
	private String parking;
	private String placeaddress;
	private String placephone;
	
	// 기본 생성자
	public PlaceDto() {}
	
	
	public PlaceDto(int placeidx, String placename, String openhour, String parking, String placeaddress,
			String placephone) {
		this.placeidx = placeidx;
		this.placename = placename;
		this.openhour = openhour;
		this.parking = parking;
		this.placeaddress = placeaddress;
		this.placephone = placephone;
	}
	
	
	public int getPlaceidx() {
		return placeidx;
	}
	public void setPlaceidx(int placeidx) {
		this.placeidx = placeidx;
	}
	public String getPlacename() {
		return placename;
	}
	public void setPlacename(String placename) {
		this.placename = placename;
	}
	public String getOpenhour() {
		return openhour;
	}
	public void setOpenhour(String openhour) {
		this.openhour = openhour;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getPlaceaddress() {
		return placeaddress;
	}
	public void setPlaceaddress(String placeaddress) {
		this.placeaddress = placeaddress;
	}
	public String getPlacephone() {
		return placephone;
	}
	public void setPlacephone(String placephone) {
		this.placephone = placephone;
	}
	
	
	@Override
	public String toString() {
		return "PlaceDto [placeidx=" + placeidx + ", placename=" + placename + ", openhour=" + openhour + ", parking="
				+ parking + ", placeaddress=" + placeaddress + ", placephone=" + placephone + "]";
	}
	
	
	
}