package com.techelevator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import com.techelevator.controller.AuthenticationController;
import com.techelevator.model.UserDAO;

public class AuthControllerTest {
		
		private AuthenticationController controller;
		private UserDAO userDAO;
		private HttpServletResponse response;
		private HttpServletRequest request;
		private ModelMap model;
		private HttpSession session;
		
		@Before
		public void setup() {
			userDAO = mock(UserDAO.class);
			controller = new AuthenticationController(userDAO);
			response = mock(HttpServletResponse.class);
			request = mock(HttpServletRequest.class);
			session = mock(HttpSession.class);
			model = mock(ModelMap.class);
			when(request.getCookies()).thenReturn(new Cookie[]{});
		}
		
		@Test
		public void displays_login_view() {
			String viewName = controller.displayLoginForm();
			assertThat(viewName, equalTo("login"));
		}
		
		@Test
		public void redirects_to_user_dashboard_if_username_and_password_are_valid() {
			when(userDAO.searchForUsernameAndPassword(anyString(), anyString())).thenReturn(true);
			String viewName = controller.login("myUser", "password", "destination", model, session, request);
			assertThat(viewName, equalTo("redirect:/users/myUser"));
		}
		
		@Test
		public void redirects_to_login_if_username_and_password_are_not_valid() {
			when(userDAO.searchForUsernameAndPassword(anyString(), anyString())).thenReturn(false);
			String viewName = controller.login("myUser", "password", "destination", model, session, request);
			assertThat(viewName, equalTo("redirect:/login"));
		}
		
		@Test
		public void redirects_to_home_page_after_logout() {
			String viewName = controller.logout(model, session);
			assertThat(viewName, equalTo("redirect:/"));
		}
		
//		@Test
//		public void stores_username_in_cookie_after_successful_authentication() {
//			when(userDAO.searchForUsernameAndPassword(anyString(), anyString())).thenReturn(true);
//			controller.login("myUser", "password", "destination", model, session, request);
//			Cookie cookie = new Cookie("userName", "myUser");
////			response.addCookie(cookie);
//			verify(response).addCookie(argThat(isEqualTo(cookie)));
//		}
//		
//		
//		
//		private Matcher<Cookie> isEqualTo(final Cookie expectedCookie) {
//			return new TypeSafeMatcher<Cookie>() {
//
//				@Override
//				public void describeTo(Description description) {
//					description.appendText("Cookie[name:"+expectedCookie.getName()+", value:"+expectedCookie.getValue()+"]");
//				}
//
//				@Override
//				protected boolean matchesSafely(Cookie cookieToTest) {
//					return expectedCookie.getName().equals(cookieToTest.getName()) &&
//							expectedCookie.getValue().equals(cookieToTest.getValue());
//				}
//			};
//		}
		
	}

