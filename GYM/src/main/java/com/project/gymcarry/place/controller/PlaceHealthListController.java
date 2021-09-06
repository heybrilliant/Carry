package com.project.gymcarry.place.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.place.PlaceDto;
import com.project.gymcarry.place.service.PlaceHealthService;

@Controller
@RequestMapping
public class PlaceHealthListController {
	
	@Autowired
	private PlaceHealthService placeHealthService;
	
	// place 리스트
	@GetMapping("/place/health")
	public String placeList(
				//@RequestParam("placenum") int placenum,
				Model model
			) {
		List<PlaceDto> placeList = placeHealthService.getHealthPlaceList();
		//System.out.println("placenum : " + placenum);
		model.addAttribute("placeHealthList", placeList);
		
		return "place/placeHealthList";
	}
	
	// 플레이스 자동 완성 검색
	@RequestMapping(value = "/autocomplete", produces = "application/text; charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public void AutoSearch(Locale locale, Model model, HttpServletRequest request,
		 HttpServletResponse resp, PlaceDto dto) throws IOException {
		 
		 String result = request.getParameter("term");
		 
		 List<PlaceDto> list = placeHealthService.getHealthPlaceSearch(result);
		 
		 JSONArray arr = new JSONArray();
		 for (int i = 0; i < list.size(); i++) {
			 arr.add(list.get(i).getPlacename());
		 }
		 
		 resp.setHeader("Content-Type", "application/xml"); 
		 resp.setContentType("text/xml;charset=UTF-8"); 
		 resp.setCharacterEncoding("utf-8");

		 PrintWriter out = resp.getWriter();
		 
		 out.print(arr);
	}
	



	
	
}