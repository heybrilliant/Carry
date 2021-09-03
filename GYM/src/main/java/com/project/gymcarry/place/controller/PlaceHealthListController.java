package com.project.gymcarry.place.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.place.PlaceDto;
import com.project.gymcarry.place.PlaceSearchDto;
import com.project.gymcarry.place.service.PlaceHealthService;

@Controller
@RequestMapping
public class PlaceHealthListController {
	
	@Autowired
	private PlaceHealthService placeHealthService;
	
	// place 리스트
	@GetMapping("/place/health")
	public String placeList(
				@RequestParam("placenum") int placenum,
				Model model
			) {
		List<PlaceDto> placeList = placeHealthService.getHealthPlaceList(placenum);
		System.out.println("placenum : " + placenum);
		
		model.addAttribute("placeHealthList", placeList);
		
		
		return "place/placeHealthList";
	}
	
	// 컨트롤러 부분
//	@RequestMapping(value = "/json", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
//	@ResponseBody
//	public String json(Locale locale, Model model) {    
//	    	String[] array = {"엽기떡볶이", "신전떡볶이", "걸작떡볶이", "신당동떡볶이"}; // 배열 생성
//	    
//	        Gson gson = new Gson();
//
//	    return gson.toJson(array); // 배열 반환
//	}
	
	
	
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
    public void search(String placename, HttpServletResponse response) throws Exception {
        List<PlaceSearchDto> list = placeHealthService.getPlaceSearch();
        // 응답해야 하는 문자열 : [{label:~,value:~},{label:~,value:~}]

        JSONArray array = new JSONArray();
        for(PlaceSearchDto dto : list) {
            JSONObject obj = new JSONObject();
            obj.put("label", dto.getPlacename());
            obj.put("value", dto.getPlacename());

            array.add(obj);
        }

	}



	
	
}
