package pend.aurrius.study22;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class TicketDao {

	
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	

	
	public TicketDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void buyTicket(final TicketDto dto) {	// 변경되지않도록 파이널로 선언해야한다. 그러면 값을 더이상 바꿀수없다.
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String sql = "insert into card (consumerid,amount) values (?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getConsumerid());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into ticket (consumerid,countnum) values (?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getConsumerid());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
	}
	

	
}
