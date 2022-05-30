package uz.epam.webproject.controller.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uz.epam.webproject.controller.command.Command;
import uz.epam.webproject.controller.command.ParameterName;
import uz.epam.webproject.controller.command.Router;
import uz.epam.webproject.controller.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ResourceBundle;

public class LogoutCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(ParameterName.PAGES_PATH);

    @Override
    public Router /*String*/ execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        if (session != null){
            session.invalidate();
        }
        return new Router(resourceBundle.getString(ParameterName.INDEX_PAGE));
    }
}
