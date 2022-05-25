package uz.epam.webproject.controller.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uz.epam.webproject.controller.command.Command;
import uz.epam.webproject.controller.command.Router;
import uz.epam.webproject.controller.command.exception.CommandException;
import uz.epam.webproject.service.UserService;
import uz.epam.webproject.service.exception.ServiceException;
import uz.epam.webproject.service.impl.UserServiceImpl;
import uz.epam.webproject.util.ParameterName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle(ParameterName.PAGES_PATH);

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        UserService userService = UserServiceImpl.getInstance();
        String userName = request.getParameter(ParameterName.USERNAME);
        String email = request.getParameter(ParameterName.EMAIL);
        Router router;
        HttpSession session = request.getSession();

        try {
            if(userService.authenticate(userName, email)){
                session.setAttribute(ParameterName.USERNAME, userName);
                session.setAttribute(ParameterName.EMAIL, email);
                router = new Router(resourceBundle.getString("home.page"));
            }else {
                router = new Router(resourceBundle.getString("index.page"));
            }
        } catch (ServiceException e) {
            logger.error("error in login", e);
            throw new CommandException(e);
        }
        return router;
    }
}
