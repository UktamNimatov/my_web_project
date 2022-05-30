package uz.epam.webproject.controller.command.impl;

import uz.epam.webproject.controller.command.Command;
import uz.epam.webproject.controller.command.Router;
import uz.epam.webproject.controller.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        return null;
    }
}
