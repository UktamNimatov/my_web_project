package uz.epam.webproject.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uz.epam.webproject.controller.command.Command;
import uz.epam.webproject.controller.command.CommandType;
import uz.epam.webproject.controller.command.Router;
import uz.epam.webproject.controller.command.exception.CommandException;
import uz.epam.webproject.pool.ConnectionPool;
import uz.epam.webproject.controller.command.ParameterName;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        String strCommand = request.getParameter(ParameterName.COMMAND);
//        Command command = CommandType.define(strCommand);
        Command command = CommandType.define(strCommand);
        Router router;
        try {
            router = command.execute(request);
        } catch (CommandException e) {
            logger.error("error in executing command" + strCommand, e);
            throw new ServletException(e);
        }
        String currentPage = router.getPage();
        HttpSession session = request.getSession();
        session.setAttribute(ParameterName.CURRENT_PAGE, currentPage);
        if (router.getActionType() == Router.Type.FORWARD){
//            request.getRequestDispatcher(router.getPage()).forward(request, response);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(currentPage);
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(currentPage);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        ConnectionPool.INSTANCE.destroyPool();
    }
}
