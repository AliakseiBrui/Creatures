package com.epam.creatures.command;


import com.epam.creatures.command.admincommand.AdminAuthorizationCommand;
import com.epam.creatures.command.admincommand.CreateAdminCommand;
import com.epam.creatures.command.admincommand.CreateCreatureCommand;
import com.epam.creatures.command.usercommand.UserAuthorizationCommand;
import com.epam.creatures.command.usercommand.UserRegistrationCommand;
import com.epam.creatures.service.ShowCreaturesService;
import com.epam.creatures.service.ToAdminAuthorizationPageService;
import com.epam.creatures.service.ToStartPageService;
import com.epam.creatures.service.ToUserAuthorizationPageService;
import com.epam.creatures.service.adminservice.AdminAuthorizationService;
import com.epam.creatures.service.adminservice.CreateAdminService;
import com.epam.creatures.service.adminservice.CreateCreatureService;
import com.epam.creatures.service.userservice.UserAuthorizationService;
import com.epam.creatures.service.userservice.UserRegistrationService;

public enum CommandType {
    ADMIN_AUTHORIZATION_COMMAND(new AdminAuthorizationCommand(new AdminAuthorizationService())),

    CREATE_CREATURE_COMMAND(new CreateCreatureCommand(new CreateCreatureService())),

    CREATE_ADMIN_COMMAND(new CreateAdminCommand(new CreateAdminService())),

    SHOW_CREATURES_COMMAND(new ShowCreaturesCommand(new ShowCreaturesService())),

    USER_AUTHORIZATION_COMMAND(new UserAuthorizationCommand(new UserAuthorizationService())),

    USER_REGISTRATION_COMMAN(new UserRegistrationCommand(new UserRegistrationService())),

    TO_ADMIN_AUTHORIZATION_PAGE_COMMAND(new ToAnyPageCommand(new ToAdminAuthorizationPageService())),

    TO_USER_AUTHORIZATION_PAGE_COMMAND(new ToAnyPageCommand(new ToUserAuthorizationPageService())),

    TO_START_PAGE_COMMAND(new ToAnyPageCommand(new ToStartPageService())),
    ;

    private AbstractCommand command;

    CommandType(AbstractCommand command){
        this.command = command;
    }

    public AbstractCommand getCommand(){
        return command;
    }
}
