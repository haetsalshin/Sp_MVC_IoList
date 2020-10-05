package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.iolist.model.IoListVO;
import com.biz.iolist.service.IoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/")
public class IoListController {

	@Autowired
	@Qualifier("service")
	private IoService ioService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model model) {

		List<IoListVO> ioList = ioService.selectAll();

		
		model.addAttribute("LISTS", ioList);
		model.addAttribute("BODY", "IO-LIST");

		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Model model) {

		model.addAttribute("BODY", "IO-WRITE");
		model.addAttribute("IoListVO", new IoListVO());

		
		
		return "home";


	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(@ModelAttribute("IoListVO") IoListVO ioListVO) {

		log.debug(ioListVO.toString());

		IoListVO ioListVO1 = new IoListVO();

		/*
		 * //BookVO bookVO = BookVO.builder().buydate(todayString).build(); int ioTotal
		 * = ioListVO1.getIo_price() * ioListVO1.getIo_quan();
		 * 
		 * ioListVO1 = IoListVO.builder().io_total(ioTotal).build();
		 */

		int ret = ioService.insert(ioListVO);

		if (ret < 1) {
			log.debug("insert되지 않았습니다");
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/datelist",method=RequestMethod.GET)
	public String datelist(String io_firstday, String io_lastday, Model model) {
		
//		IoListVO ioListVO = ioService.findByDate(io_firstday, io_lastday);
//		
		model.addAttribute("BODY", "IO-DATELIST");
		
		
		return "home";
		
	}

	@RequestMapping(value = "/detail/{io_seq}", method = RequestMethod.GET)
	public String detail(@PathVariable("io_seq") String id, Model model) {

		log.debug("PATH : {} ", id);
		long seq = Long.valueOf(id);

		IoListVO ioListVO = ioService.findById(seq);

		model.addAttribute("IoListVO", ioListVO);
		model.addAttribute("BODY", "IO-DETAIL");

		return "home";
	}

	
	  @RequestMapping(value = "/update", method=RequestMethod.GET) public String
	  update(@RequestParam("id") @ModelAttribute("IoListVO") String id, IoListVO
	  ioListVO, Model model ) {
	  
	  long seq = Long.valueOf(id);
	  
	  ioListVO = ioService.findById(seq);
	  
	  model.addAttribute("IoListVO", ioListVO);
	  model.addAttribute("BODY", "IO-WRITE");
	  
	  
	  return "home"; 
	  }
	  
	  @RequestMapping(value = "/update", method=RequestMethod.POST) public String
	  update(@ModelAttribute IoListVO ioListVO, Model model) {
	 
	  int ret = ioService.update(ioListVO);
	  
	  return "redirect:/";
	  }
	  

	  
	  @RequestMapping(value = "/delete", method=RequestMethod.GET)
	 public String delete(@RequestParam("seq") String seq) {
		  
		  ioService.delete(Long.parseLong(seq));
		  
		  return "redirect:/";
		 
	 }
	  
	  

}
