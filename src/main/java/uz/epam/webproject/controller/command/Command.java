package uz.epam.webproject.controller.command;

import uz.epam.webproject.controller.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@FunctionalInterface
public interface Command {

    Router execute(HttpServletRequest request) throws CommandException;

    default void refresh(){}
}
