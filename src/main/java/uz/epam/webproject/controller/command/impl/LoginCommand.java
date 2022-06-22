package uz.epam.webproject.controller.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uz.epam.webproject.controller.command.Command;
import uz.epam.webproject.controller.command.Router;
import uz.epam.webproject.controller.command.exception.CommandException;
import uz.epam.webproject.service.UserService;
import uz.epam.webproject.service.exception.ServiceException;
import uz.epam.webproject.service.impl.UserServiceImpl;
import uz.epam.webproject.controller.command.ParameterName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(ParameterName.PAGES_PATH);
    private static final String ERROR_MESSAGE = "Incorrect login or password";

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String userName = request.getParameter(ParameterName.USERNAME);
        String password = request.getParameter(ParameterName.PASSWORD);
        HttpSession session = request.getSession();

//        String attrLocale = (String) session.getAttribute(ParameterName.LOCALE);
//        if (attrLocale == null){
//            logger.info("attrLocale is null");
//            System.out.println("attrLocale is null");
//        }
//        logger.info("attrLocale is not null");
//        System.out.println("attrLocale is not null");

        Router router;
        String page;

        UserService userService = UserServiceImpl.getInstance();
        try {
            if(userService.authenticate(userName, password)){
                request.setAttribute(ParameterName.USERNAME, userName);
                session.setAttribute(ParameterName.USERNAME, userName);
                session.setAttribute(ParameterName.EMAIL, password);
                router = new Router(resourceBundle.getString(ParameterName.HOME_PAGE), Router.Type.FORWARD);
            }else {
                request.setAttribute(ParameterName.ERROR_MESSAGE_SIGN_IN, ERROR_MESSAGE);
                router = new Router(resourceBundle.getString(ParameterName.INDEX_PAGE), Router.Type.REDIRECT);
            }
        } catch (ServiceException e) {
            logger.error("error in login", e);
            throw new CommandException(e);
        }
        return router;
    }
}
