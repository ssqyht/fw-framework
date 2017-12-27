package com.fw.api.web.controllers.ui.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fw.api.core.http.AjaxResult;
import com.fw.api.security.auth.JwtAuthenticationToken;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@RequestMapping(value = "/me", method = { RequestMethod.GET, RequestMethod.POST })
	@PreAuthorize("hasRole('AUTH')")
	public @ResponseBody AjaxResult get(JwtAuthenticationToken token) {
		return new AjaxResult().success().data(token.getPrincipal());
	}

}
