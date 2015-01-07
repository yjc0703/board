package board.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController implements ErrorController {
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@RequestMapping("/error")
	public ResponseEntity<?> error(HttpServletRequest req) {
		
		String str = String.format("error : %s", req.getAttribute("javax.servlet.error.status_code"));
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/", "/index" })
	public String index() {
		return "index";
	}
}
