package net.duster.ishop.servlet.page;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.duster.ishop.Constants;
import net.duster.ishop.entity.Order;
import net.duster.ishop.model.CurrentAccount;
import net.duster.ishop.servlet.AbstractController;
import net.duster.ishop.util.RoutingUtils;
import net.duster.ishop.util.SessionUtils;

@WebServlet("/my-orders")
public class MyOrdersController extends AbstractController {
	private static final long serialVersionUID = -1782066337808445826L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CurrentAccount currentAccount = SessionUtils.getCurrentAccount(req);
		List<Order> orders = getOrderService().listMyOrders(currentAccount, 1, Constants.ORDERS_PER_PAGE);
		req.setAttribute("orders", orders);
		int orderCount = getOrderService().countMyOrders(currentAccount);
		req.setAttribute("pageCount", getPageCount(orderCount, Constants.ORDERS_PER_PAGE));
		RoutingUtils.forwardToPage("my-orders.jsp", req, resp);
	}
}
