package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.OnTheTopService;

@Controller
public class OnTheTopController {
	@Autowired
	private OnTheTopService onTheTopService;

	@RequestMapping(value = "/lol.do", method = RequestMethod.GET)
	public ModelAndView goMain() {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("list", onTheTopService.getLolRankingInfo());
		return mav;
	}
}
