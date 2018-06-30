package com.epam.creatures.command;


import com.epam.creatures.command.admincommand.AuthorizationCommand;
import com.epam.creatures.command.admincommand.CreateCreatureCommand;

public enum CommandType {
    ADMIN_AUTHORIZATION_COMMAND(new AuthorizationCommand()),
    CREATE_CREATURE_COMMAND(new CreateCreatureCommand()),

    ;

    private AbstractCommand command;

    CommandType(AbstractCommand command){
        this.command = command;
    }

    public AbstractCommand getCommand(){
        return command;
    }
}
