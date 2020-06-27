package net.duster.ishop.service;

import java.util.List;

import net.duster.ishop.entity.Order;
import net.duster.ishop.form.ProductForm;
import net.duster.ishop.model.CurrentAccount;
import net.duster.ishop.model.ShoppingCart;
import net.duster.ishop.model.SocialAccount;

public interface OrderService {

	void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart);

	void removeProductFromShoppingCart(ProductForm form, ShoppingCart shoppingCart);

	String serializeShoppingCart(ShoppingCart shoppingCart);

	ShoppingCart deserializeShoppingCart(String string);

	CurrentAccount authentificate(SocialAccount socialAccount);

	long makeOrder(ShoppingCart shoppingCart, CurrentAccount currentAccount);

	Order findOrderById(long id, CurrentAccount currentAccount);

	List<Order> listMyOrders(CurrentAccount currentAccount, int page, int limit);

	int countMyOrders(CurrentAccount currentAccount);
}
