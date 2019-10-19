package com.test.academy.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.test.academy.beans.User;
import com.test.academy.services.UserService;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(path="/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelMap map = new ModelMap();
		map.put("userList", userService.listAll());
		return new ModelAndView("user/index", map);
	}

	@RequestMapping(path = "/createForm", method = RequestMethod.GET)
	public ModelAndView createForm() {
		return new ModelAndView("user/createForm", "command", new User());
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createUser(HttpSession session,@ModelAttribute("user") User user, @RequestParam("file") MultipartFile file) {
		String name = new Date().getTime() + ".";
		if (!file.isEmpty()) {
			name += file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = session.getServletContext().getRealPath("/");
				File dir = new File(rootPath + File.separator + "resources/images/users");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location=" + serverFile.getAbsolutePath());

				System.out.println("You successfully uploaded file=" + name);
			} catch (Exception e) {
				System.out.println("You failed to upload " + name + " => " + e.getMessage());
			}
		} else {
			System.out.println("You failed to upload " + name + " because the file was empty.");
		}
		user.setImage("/images/users" + File.separator + name );
		String id = userService.save(user);
		return "redirect:list";
	}
}
