package uz.epam.webproject.controller.command;

import uz.epam.webproject.controller.command.impl.DefaultCommand;
import uz.epam.webproject.controller.command.impl.LoginCommand;
import uz.epam.webproject.controller.command.impl.LogoutCommand;
import uz.epam.webproject.controller.command.impl.RegistrationCommand;

public enum CommandType {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    REGISTRATION(new RegistrationCommand()),
    DEFAULT(new DefaultCommand());


    private final Command command; //why final

    CommandType(Command command) {
        this.command = command;
    }

    public static Command define(String strCommand){
        CommandType current;
        current = CommandType.valueOf(strCommand.toUpperCase());
        return current.command;
    }

    public Command getCommand() {
        return command;
    }
}
