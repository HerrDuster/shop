package net.duster.ishop.servlet.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.duster.ishop.Constants;
import net.duster.ishop.servlet.AbstractController;
import net.duster.ishop.util.RoutingUtils;
import net.duster.ishop.util.SessionUtils;

@WebServlet("/sign-in")
public class SignInController extends AbstractController {
	private static final long serialVersionUID = -8146770694377066438L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (SessionUtils.isCurrentAccountCreated(req)) {
			RoutingUtils.redirect("/my-orders", req, resp);
		} else {
			RoutingUtils.forwardToPage("sign-in.jsp", req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (SessionUtils.isCurrentAccountCreated(req)) {
			RoutingUtils.redirect("/my-orders", req, resp);
		} else {
			String targetUrl = req.getParameter("target");
			if (targetUrl != null) {
				req.getSession().setAttribute(Constants.SUCCESS_REDIRECT_URL_AFTER_SIGNIN, targetUrl);
			}
			RoutingUtils.redirect(getSocialService().getAuthorizeUrl(), req, resp);
		}
	}
}
