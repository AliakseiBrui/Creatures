package com.epam.creatures.command;


import com.epam.creatures.command.admincommand.AdminAuthorizationCommand;
import com.epam.creatures.command.admincommand.CreateCreatureCommand;
import com.epam.creatures.service.ShowCreaturesService;

public enum CommandType {
    ADMIN_AUTHORIZATION_COMMAND(new AdminAuthorizationCommand()),
    CREATE_CREATURE_COMMAND(new CreateCreatureCommand()),
    SHOW_CREATURES_COMMAND(new ShowCreaturesCommand(new ShowCreaturesService()))

    ;

    private AbstractCommand command;

    CommandType(AbstractCommand command){
        this.command = command;
    }

    public AbstractCommand getCommand(){
        return command;
    }
}
