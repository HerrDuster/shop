package net.duster.ishop.servlet.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.duster.ishop.servlet.AbstractController;
import net.duster.ishop.util.RoutingUtils;
import net.duster.ishop.util.SessionUtils;

@WebServlet("/shopping-cart")
public class ShowShoppingCartController extends AbstractController {
	private static final long serialVersionUID = -1916373553298888514L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (SessionUtils.isCurrentShoppingCartCreated(req)) {
			RoutingUtils.forwardToPage("shopping-cart.jsp", req, resp);
		} else {
			RoutingUtils.redirect("/products", req, resp);
		}
	}
}
