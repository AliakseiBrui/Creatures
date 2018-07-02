package com.epam.creatures.dao;

import com.epam.creatures.constant.UserColumn;
import com.epam.creatures.entity.User;
import com.epam.creatures.factory.UserFactory;
import com.epam.creatures.pool.ConnectionPool;
import com.epam.creatures.pool.SafeConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDAO extends AbstractDAO<Integer,User> implements UserTableDAO {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private static final String SELECT_USER_BY_ID = "SELECT creatures_db.users.id,creatures_db.users.login,creatures_db.users.password,creatures_db.users.status,creatures_db.users.is_banned " +
            "FROM creatures_db.users " +
            "WHERE creatures_db.users.id = ?";

    private static final String SELECT_ALL_USERS = "SELECT creatures_db.users.id,creatures_db.users.login,creatures_db.users.password,creatures_db.users.status,creatures_db.users.is_banned " +
            "FROM creatures_db.users";

    private static final String DELETE_USER_BY_ID = "DELETE FROM creatures_db.users " +
            "WHERE creatures_db.users.id = ?";

    private static final String INSERT_USER = "INSERT INTO creatures_db.users(creatures_db.users.login, creatures_db.users.password) " +
            "VALUES (?,?)";

    private static final String UPDATE_USER = "UPDATE creatures_db.users " +
            "SET creatures_db.users.login = ?, creatures_db.users.password = ?,creatures_db.users.status = ?,creatures_db.users.is_banned = ? " +
            "WHERE creatures_db.users.id = ?";

    private static final String SELECT_USER_BY_LOGIN = "SELECT creatures_db.users.id,creatures_db.users.login,creatures_db.users.password,creatures_db.users.status,creatures_db.users.is_banned " +
            "FROM creatures_db.users " +
            "WHERE creatures_db.users.login = ?";

    private UserFactory userFactory = new UserFactory();

    @Override
    public List<User> findAll() throws DAOException {
        LOGGER.debug("Selecting all users.");
        List<User> userList = new ArrayList<>();


        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            Statement statement = Objects.requireNonNull(connection).createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS)){

            if(resultSet!=null){

                while (resultSet.next()){
                    userList.add(userFactory
                            .createUser(resultSet.getInt(UserColumn.ID),resultSet.getString(UserColumn.LOGIN),resultSet.getString(UserColumn.PASSWORD),
                                    resultSet.getDouble(UserColumn.STATUS),resultSet.getBoolean(UserColumn.IS_BANNED)));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while selecting all users.",e);
        }
        return userList;
    }

    @Override
    public User findEntityById(Integer id) throws DAOException{
        LOGGER.debug("Selecting user by id. Id: "+id);
        ResultSet resultSet = null;

        try (SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
             PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(SELECT_USER_BY_ID)){

            if (preparedStatement != null) {
                preparedStatement.setInt(1,id);
                resultSet = preparedStatement.executeQuery();
            }

            if(resultSet!=null && resultSet.next()){
                return userFactory
                        .createUser(resultSet.getInt(UserColumn.ID),resultSet.getString(UserColumn.LOGIN),resultSet.getString(UserColumn.PASSWORD),
                            resultSet.getDouble(UserColumn.STATUS),resultSet.getBoolean(UserColumn.IS_BANNED));
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while selecting user by id",e);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DAOException{
        LOGGER.debug("Deleting user by id. Id: "+id);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(DELETE_USER_BY_ID);){

            if (preparedStatement != null) {
                preparedStatement.setInt(1,id);

                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while deleting user by id.",e);
        }
        return false;
    }

    @Override
    public boolean create(User entity) throws DAOException{
        LOGGER.debug("Inserting new user. " + entity);

        try (SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
             PreparedStatement preparedStatement=Objects.requireNonNull(connection).prepareStatement(INSERT_USER)){

            if(preparedStatement!=null){
                preparedStatement.setString(1,entity.getLogin());
                preparedStatement.setString(2,entity.getPassword());

                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while inserting user.",e);
        }
        return false;
    }

    @Override
    public boolean update(User entity) throws DAOException{
        LOGGER.debug("Updating user." + entity);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement=Objects.requireNonNull(connection).prepareStatement(UPDATE_USER);){

            if(preparedStatement != null){
                preparedStatement.setInt(5,entity.getId());
                preparedStatement.setString(1,entity.getLogin());
                preparedStatement.setString(2,entity.getPassword());
                preparedStatement.setDouble(3,entity.getStatus());
                preparedStatement.setBoolean(4,entity.getBanned());

                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while updating user",e);
        }
        return false;
    }

    @Override
    public User findUserByLogin(String login) throws DAOException{
        LOGGER.debug("Selecting user by login. Login: "+login);
        ResultSet resultSet = null;

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(SELECT_USER_BY_LOGIN);){

            if(preparedStatement!=null){
                preparedStatement.setString(1,login);
                resultSet = preparedStatement.executeQuery();
            }

            if(resultSet!=null && resultSet.next()){
                return userFactory
                        .createUser(resultSet.getInt(UserColumn.ID),resultSet.getString(UserColumn.LOGIN),resultSet.getString(UserColumn.PASSWORD),
                                resultSet.getDouble(UserColumn.STATUS),resultSet.getBoolean(UserColumn.IS_BANNED));
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while selecting user by login",e);
        }
        return null;
    }
}
