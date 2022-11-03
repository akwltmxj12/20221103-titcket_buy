package pend.aurrius.study22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {
	
	private TicketDao dao;
	
	
	@Autowired
	public void setDao(TicketDao dao) {
		this.dao = dao;
	}

	
	@RequestMapping(value = "/buy_ticket")
	public String byu_ticket() {
		return "buy_ticket";
	}
	
	@RequestMapping(value = "/buy_ticket_card")
	public String buy_ticket_card(TicketDto ticketDto, Model model) {		// dto로 한꺼번에 받는다.
//		TicketDao dao = new TicketDao();
		dao.buyTicket(ticketDto);		// dao에 컨트롤러로 온 정보를dto에담아 보냇다.
		model.addAttribute("ticketInfo", ticketDto);	//  info에 dto를 실어서 보낸다.
		
		return	"buy_ticket_end";
	}
	
	

}
