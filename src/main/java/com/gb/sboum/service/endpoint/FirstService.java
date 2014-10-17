package com.gb.sboum.service.endpoint;

import java.time.LocalDate;
import java.time.Month;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gb.sboom.model.User;
import com.gb.sboum.service.dto.UserDto;
import com.gb.sboum.service.mapper.UserMapper;

@Path("/first")
public class FirstService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FirstService.class);

	@Autowired
	private UserMapper userMapper;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHi() {
		User user = new User();
		user.setDateOfBirth(LocalDate.of(1982, Month.APRIL, 11));
		user.setFirstName("guillaume");
		user.setId("1");
		user.setLastName("sboum");
		user.setNickName("BoomBoom");

		UserDto userDto = userMapper.toUserDto(user);
		LOGGER.info(userDto.toString());
		return "Hi folks !!!";
	}

}
