package com.epam.creatures.dao.impl;

import com.epam.creatures.constant.AdminColumn;
import com.epam.creatures.dao.AbstractDAO;
import com.epam.creatures.dao.AdminTableDAO;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.entity.Admin;
import com.epam.creatures.factory.AdminFactory;
import com.epam.creatures.pool.ConnectionPool;
import com.epam.creatures.pool.SafeConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminDAO extends AbstractDAO<Integer, Admin> implements AdminTableDAO {
    private static final Logger LOGGER = LogManager.getLogger(AdminDAO.class);
    private static final String SELECT_ADMIN_BY_ID = "SELECT creatures_db.admins.id,creatures_db.admins.login,creatures_db.admins.password " +
            "FROM creatures_db.admins " +
            "WHERE creatures_db.admins.id = ?";

    private static final String SELECT_ALL_ADMINS = "SELECT creatures_db.admins.id,creatures_db.admins.login,creatures_db.admins.password " +
            "FROM creatures_db.admins";

    private static final String DELETE_ADMIN_BY_ID = "DELETE FROM creatures_db.admins " +
            "WHERE creatures_db.admins.id = ?";

    private static final String INSERT_ADMIN = "INSERT INTO creatures_db.admins(creatures_db.admins.login, creatures_db.admins.password) " +
            "VALUES (?,?)";

    private static final String UPDATE_ADMIN = "UPDATE creatures_db.admins " +
            "SET creatures_db.admins.login = ?, creatures_db.admins.password = ? " +
            "WHERE creatures_db.admins.id = ?";

    private static final String SELECT_ADMIN_BY_LOGIN = "SELECT creatures_db.admins.id,creatures_db.admins.login,creatures_db.admins.password " +
            "FROM creatures_db.admins " +
            "WHERE creatures_db.admins.login = ?";

    private AdminFactory adminFactory = new AdminFactory();

    @Override
    public List<Admin> findAll() throws DAOException {
        List<Admin> adminList = new ArrayList<>();
        LOGGER.debug("Selecting all admins.");

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            Statement statement = Objects.requireNonNull(connection).createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ADMINS)){

            if(resultSet!=null){

                while (resultSet.next()){
                    adminList.add(adminFactory
                            .createAdmin(resultSet.getInt(AdminColumn.ID),resultSet.getString(AdminColumn.LOGIN), resultSet.getString(AdminColumn.PASSWORD)));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while selecting all admins.",e);
        }
        return adminList;
    }

    @Override
    public Admin findEntityById(Integer id) throws DAOException {
        LOGGER.debug("Selecting admin by id. Id: "+id);

        try (SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
             PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(SELECT_ADMIN_BY_ID)){

            if(preparedStatement!=null){
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    return adminFactory
                            .createAdmin(resultSet.getInt(AdminColumn.ID),resultSet.getString(AdminColumn.LOGIN),resultSet.getString(AdminColumn.PASSWORD));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while selecting admin by id.",e);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        LOGGER.debug("Deleting admin by id. Id: "+id);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(DELETE_ADMIN_BY_ID)){

            if(preparedStatement!=null){
                preparedStatement.setInt(1,id);
                return preparedStatement.executeUpdate()>0;
            }
        }catch (SQLException e){
            throw new DAOException("Exception while deleting admin by id.",e);
        }
        return false;
    }

    @Override
    public boolean create(Admin entity) throws DAOException {
        LOGGER.debug("Inserting admin." +entity);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(INSERT_ADMIN)){

            if(preparedStatement!=null){
                preparedStatement.setString(1,entity.getLogin());
                preparedStatement.setString(2,entity.getPassword());
                return preparedStatement.executeUpdate()>0;
            }
        }catch (SQLException e){
            throw new DAOException("Exception while inserting admin.",e);
        }
        return false;
    }

    @Override
    public boolean update(Admin entity) throws DAOException {
        LOGGER.debug("Updating admin. "+entity);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(UPDATE_ADMIN)){

            if(preparedStatement!=null){
                preparedStatement.setInt(3,entity.getId());
                preparedStatement.setString(1,entity.getLogin());
                preparedStatement.setString(2,entity.getPassword());
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while updating admin.",e);
        }
        return false;
    }

    @Override
    public Admin findAdminByLogin(String login) throws DAOException {
        LOGGER.debug("Selecting admin by login. Login: "+login);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(SELECT_ADMIN_BY_LOGIN)){

            if(preparedStatement!=null){
                preparedStatement.setString(1,login);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    return adminFactory
                            .createAdmin(resultSet.getInt(AdminColumn.ID),resultSet.getString(AdminColumn.LOGIN),resultSet.getString(AdminColumn.PASSWORD));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while selecting admin by login.",e);
        }
        return null;
    }
}
