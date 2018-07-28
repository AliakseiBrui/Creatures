package com.epam.creatures.command;


import com.epam.creatures.command.admin.*;
import com.epam.creatures.command.user.*;
import com.epam.creatures.service.*;
import com.epam.creatures.service.admin.*;
import com.epam.creatures.service.user.*;

/**
 * The enum Command type.
 */
public enum CommandType {
    /**
     * The Admin authorization command.
     */
    ADMIN_AUTHORIZATION_COMMAND(new AdminAuthorizationCommand(new AdminAuthorizationService())),

    /**
     * The Create creature command.
     */
    CREATE_CREATURE_COMMAND(new CreateCreatureCommand(new CreateCreatureService())),

    /**
     * The Create admin command.
     */
    CREATE_ADMIN_COMMAND(new CreateAdminCommand(new CreateAdminService())),

    /**
     * The Show creatures command.
     */
    SHOW_CREATURES_COMMAND(new ShowCreaturesCommand(new ShowCreaturesService())),

    /**
     * The Show users command.
     */
    SHOW_USERS_COMMAND(new ShowUsersCommand(new ShowUsersService())),

    /**
     * The User authorization command.
     */
    USER_AUTHORIZATION_COMMAND(new UserAuthorizationCommand(new UserAuthorizationService())),

    /**
     * The User registration command.
     */
    USER_REGISTRATION_COMMAND(new UserRegistrationCommand(new UserRegistrationService())),

    /**
     * The To admin authorization page command.
     */
    TO_ADMIN_AUTHORIZATION_PAGE_COMMAND(new ToAnyPageCommand(new ToAdminAuthorizationPageService())),

    /**
     * The To user authorization page command.
     */
    TO_USER_AUTHORIZATION_PAGE_COMMAND(new ToAnyPageCommand(new ToUserAuthorizationPageService())),

    /**
     * The To user registration page command.
     */
    TO_USER_REGISTRATION_PAGE_COMMAND(new ToAnyPageCommand(new ToUserRegistrationPageService())),

    /**
     * The To start page command.
     */
    TO_START_PAGE_COMMAND(new ToAnyPageCommand(new ToStartPageService())),

    /**
     * The Log out command.
     */
    LOG_OUT_COMMAND(new LogOutCommand(new RedirectToStartPageService())),

    /**
     * The To create creature page command.
     */
    TO_CREATE_CREATURE_PAGE_COMMAND(new ToAnyPageCommand(new ToCreateCreaturePageService())),

    /**
     * The To create admin page command.
     */
    TO_CREATE_ADMIN_PAGE_COMMAND(new ToAnyPageCommand(new ToCreateAdminPageService())),

    /**
     * The To admin main page command.
     */
    TO_ADMIN_MAIN_PAGE_COMMAND(new ToAnyPageCommand(new ToAdminMainPageService())),

    /**
     * The To user main page command.
     */
    TO_USER_MAIN_PAGE_COMMAND(new ToAnyPageCommand(new ToUserMainPageService())),

    /**
     * The To update creature page command.
     */
    TO_UPDATE_CREATURE_PAGE_COMMAND(new ToUpdateCreaturePageCommand(new ToUpdateCreaturePageService())),

    /**
     * The Delete creature command.
     */
    DELETE_CREATURE_COMMAND(new DeleteCreatureCommand(new DeleteCreatureService())),

    /**
     * The Update creature command.
     */
    UPDATE_CREATURE_COMMAND(new UpdateCreatureCommand(new UpdateCreatureService())),

    /**
     * The Change user banned command.
     */
    CHANGE_USER_BANNED_COMMAND(new ChangeUserBannedCommand(new ChangeUserBannedService())),

    /**
     * The Like creature command.
     */
    LIKE_CREATURE_COMMAND(new LikeCreatureCommand(new LikeCreatureService())),

    /**
     * The Comment creature command.
     */
    COMMENT_CREATURE_COMMAND(new CommentCreatureCommand(new CommentCreatureService())),

    /**
     * The Show creature comments command.
     */
    SHOW_CREATURE_COMMENTS_COMMAND(new ShowCreatureCommentsCommand(new ShowCreatureCommentsService())),

    /**
     * The To creature details page command.
     */
    TO_CREATURE_DETAILS_PAGE_COMMAND(new ToCreatureDetailsPageCommand(new ToCreatureDetailsPageService())),

    /**
     * The To comment creature page command.
     */
    TO_COMMENT_CREATURE_PAGE_COMMAND(new ToCommentCreaturePageCommand(new ToCommentCreaturePageService())),

    /**
     * The To user profile page command.
     */
    TO_USER_PROFILE_PAGE_COMMAND(new ToAnyPageCommand(new ToUserProfilePageService())),

    /**
     * The To admin profile page command.
     */
    TO_ADMIN_PROFILE_PAGE_COMMAND(new ToAnyPageCommand(new ToAdminProfilePageService())),

    /**
     * The To change creature image page command.
     */
    TO_CHANGE_CREATURE_IMAGE_PAGE_COMMAND(new ToChangeCreatureImagePageCommand(new ToChangeCreatureImagePageService())),

    /**
     * The To users management page command.
     */
    TO_USERS_MANAGEMENT_PAGE_COMMAND(new ToAnyPageCommand(new ToUsersManagementPageService())),

    /**
     * The Self delete command.
     */
    SELF_DELETE_COMMAND(new SelfDeleteCommand(new SelfDeleteService())),

    /**
     * Change language command command type.
     */
    CHANGE_LANGUAGE_COMMAND(new ChangeLanguageCommand(new RedirectToStartPageService())),

    /**
     * The Change creature sort type command.
     */
    CHANGE_CREATURE_SORT_TYPE_COMMAND(new ChangeCreatureSortTypeCommand(new RedirectToStartPageService())),

    /**
     * The Change user sort type command.
     */
    CHANGE_USER_SORT_TYPE_COMMAND(new ChangeUserSortTypeCommand(new RedirectToUsersManagementPageService())),

    /**
     * The Delete comment command.
     */
    DELETE_COMMENT_COMMAND(new DeleteCommentCommand(new DeleteCommentService()))
    ;

    private AbstractCommand command;

    CommandType(AbstractCommand command){
        this.command = command;
    }

    /**
     * Get command abstract command.
     *
     * @return the abstract command
     */
    public AbstractCommand getCommand(){
        return command;
    }
}
