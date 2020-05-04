package mate.academy.shop.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.shop.lib.Injector;
import mate.academy.shop.model.Role;
import mate.academy.shop.model.User;
import mate.academy.shop.service.UserService;

@WebServlet("/")
public class IndexController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.shop");
    private UserService userService = (UserService)
            INJECTOR.getInstance(UserService.class);

    @Override
    public void init() throws ServletException {
        User bob = new User();
        bob.setName("Bob");
        bob.setPassword("123");
        bob.addRole(new Role(Role.RoleName.ADMIN));
        userService.create(bob);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB_INF/views/index.jsp").forward(req, resp);
    }
}
