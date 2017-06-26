package com.szl.springweb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.szl.springorm.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	@Qualifier(value="userServiceImpl")
	private UserService UserService;

	@RequestMapping(value = "queryUser",produces="application/json; charset=UTF-8")
	@ResponseBody
	public String queryUserList(){
		List<Map<String, Object>> queryUser = UserService.queryUser();
		System.out.println(queryUser.toString());
		return JSONObject.toJSONString(queryUser);
	}

}
