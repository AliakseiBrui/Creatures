package com.epam.creatures.dao.impl;

import com.epam.creatures.constant.AdminColumn;
import com.epam.creatures.constant.CreatureColumn;
import com.epam.creatures.dao.AbstractDao;
import com.epam.creatures.dao.CreatureTableDao;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.entity.Creature;
import com.epam.creatures.factory.CreatureFactory;
import com.epam.creatures.pool.ConnectionPool;
import com.epam.creatures.pool.SafeConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Creatures dao.
 */
public class CreaturesDao extends AbstractDao<Integer, Creature> implements CreatureTableDao {
    private static final Logger LOGGER = LogManager.getLogger(CreaturesDao.class);
    private static final String SELECT_ALL_CREATURES = "SELECT creatures_db.creatures.id, creatures_db.creatures.name, creatures_db.creatures.limb_quantity, " +
            "creatures_db.creatures.head_quantity, creatures_db.creatures.eye_quantity, creatures_db.creatures.gender, creatures_db.creatures.description, " +
            "creatures_db.creatures.rating, creatures_db.creatures.creator_id, a.login, creatures_db.creatures.image " +
            "FROM creatures_db.creatures " +
            "INNER JOIN creatures_db.admins a ON creatures.creator_id = a.id";

    private static final String SELECT_CREATURE_BY_ID = "SELECT creatures_db.creatures.id, creatures_db.creatures.name, creatures_db.creatures.limb_quantity, " +
            "creatures_db.creatures.head_quantity, creatures_db.creatures.eye_quantity, creatures_db.creatures.gender, creatures_db.creatures.description, " +
            "creatures_db.creatures.rating, creatures_db.creatures.creator_id, a.login, creatures_db.creatures.image " +
            "FROM creatures_db.creatures " +
            "INNER JOIN creatures_db.admins a ON creatures.creator_id = a.id " +
            "WHERE creatures_db.creatures.id = ?";

    private static final String DELETE_CREATURE = "DELETE FROM creatures_db.creatures " +
            "WHERE creatures_db.creatures.id = ?";

    private static final String INSERT_CREATURE = "INSERT INTO creatures_db.creatures(name, limb_quantity, head_quantity, eye_quantity, gender, description, creator_id) " +
            "VALUES (?,?,?,?,?,?,?)";

    private static final String UPDATE_CREATURE = "UPDATE creatures_db.creatures " +
            "SET name = ?, limb_quantity = ?, head_quantity = ?, eye_quantity = ?, gender = ?, description = ?" +
            "WHERE creatures_db.creatures.id = ?";

    private static final String SELECT_CREATURE_BY_NAME = "SELECT creatures_db.creatures.id, creatures_db.creatures.name, creatures_db.creatures.limb_quantity, " +
            "creatures_db.creatures.head_quantity, creatures_db.creatures.eye_quantity, creatures_db.creatures.gender, creatures_db.creatures.description, " +
            "creatures_db.creatures.rating, creatures_db.creatures.creator_id,a.login,creatures_db.creatures.image " +
            "FROM creatures_db.creatures " +
            "INNER JOIN creatures_db.admins a ON creatures.creator_id = a.id " +
            "WHERE creatures_db.creatures.name = ?";

    private static final String SELECT_CREATURES_BY_CREATOR_ID = "SELECT creatures_db.creatures.id, creatures_db.creatures.name, creatures_db.creatures.limb_quantity, " +
            "creatures_db.creatures.head_quantity, creatures_db.creatures.eye_quantity, creatures_db.creatures.gender, creatures_db.creatures.description, " +
            "creatures_db.creatures.rating, creatures_db.creatures.creator_id, a.login,creatures_db.creatures.image " +
            "FROM creatures_db.creatures " +
            "INNER JOIN creatures_db.admins a ON creatures.creator_id = a.id " +
            "WHERE creatures_db.creatures.creator_id = ?";

    private static final String UPDATE_CREATURE_IMAGE = "UPDATE creatures_db.creatures " +
            "SET creatures_db.creatures.image = ? " +
            "WHERE creatures_db.creatures.id = ?";

    private CreatureFactory creatureFactory = new CreatureFactory();

    @Override
    public List<Creature> findAll() throws DaoException {
        List<Creature> creatureList = new ArrayList<>();
        LOGGER.debug("Selecting all creatures.");

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            Statement statement = Objects.requireNonNull(connection).createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CREATURES)){

            while (resultSet.next()){
                creatureList.add(creatureFactory.createCreature(resultSet.getInt(CreatureColumn.ID),resultSet.getString(CreatureColumn.NAME),
                        resultSet.getInt(CreatureColumn.LIMB_QUANTITY), resultSet.getInt(CreatureColumn.HEAD_QUANTITY),
                        resultSet.getInt(CreatureColumn.EYE_QUANTITY),Creature.Gender.valueOf(resultSet.getString(CreatureColumn.GENDER)),
                        resultSet.getString(CreatureColumn.DESCRIPTION),resultSet.getDouble(CreatureColumn.RATING),
                        resultSet.getInt(CreatureColumn.CREATOR_ID),resultSet.getString(AdminColumn.LOGIN),resultSet.getBytes(CreatureColumn.IMAGE)));
            }

        } catch (SQLException e) {
            throw new DaoException("Exception while selecting all creatures.",e);
        }
        return creatureList;
    }

    @Override
    public Creature findEntityById(Integer id) throws DaoException {
        LOGGER.debug("Selecting creature by id. Id: "+id);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(SELECT_CREATURE_BY_ID)){

            if(preparedStatement!=null){
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    return creatureFactory.createCreature(resultSet.getInt(CreatureColumn.ID),resultSet.getString(CreatureColumn.NAME),
                            resultSet.getInt(CreatureColumn.LIMB_QUANTITY), resultSet.getInt(CreatureColumn.HEAD_QUANTITY),
                            resultSet.getInt(CreatureColumn.EYE_QUANTITY),Creature.Gender.valueOf(resultSet.getString(CreatureColumn.GENDER)),
                            resultSet.getString(CreatureColumn.DESCRIPTION),resultSet.getDouble(CreatureColumn.RATING),
                            resultSet.getInt(CreatureColumn.CREATOR_ID),resultSet.getString(AdminColumn.LOGIN),resultSet.getBytes(CreatureColumn.IMAGE));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while selecting creature by id.",e);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        LOGGER.debug("Deleting creature by id. Id: "+id);
        
        try (SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(DELETE_CREATURE)){

            if(preparedStatement!=null){
                preparedStatement.setInt(1,id);
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while deleting creature by id.",e);
        }
        return false;
    }

    @Override
    public boolean create(Creature entity) throws DaoException {
        LOGGER.debug("Inserting creature.");

        try (SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(INSERT_CREATURE)){

            if(preparedStatement!=null){
                preparedStatement.setString(1,entity.getCreatureName());
                preparedStatement.setInt(2,entity.getLimbQuantity());
                preparedStatement.setInt(3,entity.getHeadQuantity());
                preparedStatement.setInt(4,entity.getEyeQuantity());
                preparedStatement.setString(5,entity.getCreatureGender().toString());
                preparedStatement.setString(6,entity.getDescription());
                preparedStatement.setInt(7,entity.getCreatorId());
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while inserting creature.",e);
        }
        return false;
    }

    @Override
    public boolean update(Creature entity) throws DaoException {
        LOGGER.debug("Updating creature.");

        try (SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
             PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(UPDATE_CREATURE)){

            if(preparedStatement!=null){
                preparedStatement.setInt(7,entity.getCreatureId());
                preparedStatement.setString(1,entity.getCreatureName());
                preparedStatement.setInt(2,entity.getLimbQuantity());
                preparedStatement.setInt(3,entity.getHeadQuantity());
                preparedStatement.setInt(4,entity.getEyeQuantity());
                preparedStatement.setString(5,entity.getCreatureGender().toString());
                preparedStatement.setString(6,entity.getDescription());
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while updating creature.",e);
        }
        return false;
    }

    @Override
    public Creature findCreatureByName(String name) throws DaoException {
        LOGGER.debug("Selecting creature by name. Name: "+name);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(SELECT_CREATURE_BY_NAME)){

            if(preparedStatement!=null){
                preparedStatement.setString(1,name);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    return creatureFactory.createCreature(resultSet.getInt(CreatureColumn.ID),resultSet.getString(CreatureColumn.NAME),
                            resultSet.getInt(CreatureColumn.LIMB_QUANTITY), resultSet.getInt(CreatureColumn.HEAD_QUANTITY),
                            resultSet.getInt(CreatureColumn.EYE_QUANTITY),Creature.Gender.valueOf(resultSet.getString(CreatureColumn.GENDER)),
                            resultSet.getString(CreatureColumn.DESCRIPTION),resultSet.getDouble(CreatureColumn.RATING),
                            resultSet.getInt(CreatureColumn.CREATOR_ID),resultSet.getString(AdminColumn.LOGIN),resultSet.getBytes(CreatureColumn.IMAGE));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while selecting creature by name.",e);
        }
        return null;
    }

    @Override
    public List<Creature> findCreaturesByCreatorId(Integer creatorId) throws DaoException {
        List<Creature> creatureList = new ArrayList<>();
        LOGGER.debug("Selecting creatures by creatorId. CreatorId: "+creatorId);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(SELECT_CREATURES_BY_CREATOR_ID)){

            if(preparedStatement!=null){
                preparedStatement.setInt(1,creatorId);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    creatureList.add(creatureFactory.createCreature(resultSet.getInt(CreatureColumn.ID),resultSet.getString(CreatureColumn.NAME),
                            resultSet.getInt(CreatureColumn.LIMB_QUANTITY), resultSet.getInt(CreatureColumn.HEAD_QUANTITY),
                            resultSet.getInt(CreatureColumn.EYE_QUANTITY),Creature.Gender.valueOf(resultSet.getString(CreatureColumn.GENDER)),
                            resultSet.getString(CreatureColumn.DESCRIPTION),resultSet.getDouble(CreatureColumn.RATING),
                            resultSet.getInt(CreatureColumn.CREATOR_ID),resultSet.getString(AdminColumn.LOGIN),resultSet.getBytes(CreatureColumn.IMAGE)));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while selecting creatures by creatorId.",e);
        }
        return creatureList;
    }

    @Override
    public boolean updateCreatureImage(Integer id, InputStream image) throws DaoException {
        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(UPDATE_CREATURE_IMAGE)){

            if(preparedStatement!=null){
                preparedStatement.setInt(2,id);
                preparedStatement.setBlob(1,image);
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while updating creature's image.",e);
        }
        return false;
    }
}
