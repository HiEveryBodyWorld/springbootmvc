package com.test.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/depart")
public class DepartCtrl extends AbstracController {
	@RequestMapping("/get/{id}")
	Object getdepart(@PathVariable("id") Integer id)
	{
		return  departRepo.findOne(id);
	}
}
