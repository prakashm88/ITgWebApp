package com.itechgenie.apps.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.itechgenie.apps.dtos.ItgRequestDTO;
import com.itechgenie.apps.dtos.ItgResponseDTO;

@RestController
@RequestMapping("/apis")
public class ITGController {

	private ObjectMapper objectMapper = new ObjectMapper();

	@PostMapping("/check")
	@ResponseBody
	public ItgResponseDTO postResponseController(@RequestBody ItgRequestDTO request) throws Exception {
		/* ItgResponseDTO resp = new ItgResponseDTO();
		//resp.setData("{  \"connection\": \"keep-alive\",  \"content-type\": \"application/json\",  \"date\": \"Sun, 11 Jul 2021 14:25:44 GMT\",  \"keep-alive\": \"timeout=60\",  \"transfer-encoding\": \"chunked\"}");
		resp.setData("hello at " + System.currentTimeMillis());
		ItgStatusDTO status = new ItgStatusDTO("Successful api call", "00", true);
		resp.setApiStatus(status); */
		
		//String respStr = "{\"apiStatus\":{\"message\":\"Successful api call\",\"code\":\"00\",\"success\":true},\"data\":\"hello at 1626014254227\"}\r\n" ;
		String respStr = "{\"apiStatus\":{\"message\":\"Successful api call\",\"code\":\"00\",\"success\":true}}\r\n" ;
		ItgResponseDTO resp = null;
		
		try {
			objectMapper.registerModule(new Jdk8Module());

			resp = objectMapper.readValue(respStr, ItgResponseDTO.class);
			System.out.println(objectMapper.writeValueAsString(resp));
			if (resp.getData().isPresent() == false)  {
				resp.setData(Optional.of("hello at " + System.currentTimeMillis()));
			}
			System.out.println("NewResp: " + objectMapper.writeValueAsString(resp));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
		return resp;
	}

}
