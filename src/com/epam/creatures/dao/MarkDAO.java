package com.epam.creatures.dao;

import com.epam.creatures.constant.MarkColumn;
import com.epam.creatures.entity.Mark;
import com.epam.creatures.factory.MarkFactory;
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

public class MarkDAO extends AbstractDAO<Integer,Mark> implements MarkTableDAO {
    private static final Logger LOGGER = LogManager.getLogger(MarkDAO.class);
    private static final String SELECT_ALL_MARKS = "SELECT creatures_db.marks.mark_value, creatures_db.marks.creature_id, creatures_db.marks.user_id " +
            "FROM creatures_db.marks";

    private static final String INSERT_MARK = "INSERT INTO creatures_db.marks(creatures_db.marks.mark_value, creatures_db.marks.creature_id, creatures_db.marks.user_id) " +
            "VALUES (?,?,?)";

    private static final String UPDATE_MARK = "UPDATE creatures_db.marks " +
            "SET creatures_db.marks.mark_value = ? " +
            "WHERE creatures_db.marks.creature_id = ? " +
            "AND creatures_db.marks.user_id = ?";

    private static final String SELECT_MARK_BY_CREATURE_ID_AND_USER_ID = "SELECT creatures_db.marks.mark_value " +
            "FROM creatures_db.marks "+
            "WHERE creatures_db.marks.creature_id = ? " +
            "AND creatures_db.marks.user_id = ?";

    private MarkFactory markFactory = new MarkFactory();

    @Override
    public List<Mark> findAll() throws DAOException {
        LOGGER.debug("Selecting all marks.");
        List<Mark> markList = new ArrayList<>();

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            Statement statement = Objects.requireNonNull(connection).createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_MARKS)){

            if(resultSet != null){

                while (resultSet.next()){
                    markList.add(markFactory
                            .createMark(resultSet.getDouble(MarkColumn.MARK_VALUE),resultSet.getInt(MarkColumn.CREATURE_ID),resultSet.getInt(MarkColumn.USER_ID)));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while selecting all marks.",e);
        }
        return markList;
    }

    @Override
    public Mark findEntityById(Integer id) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Mark entity) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Mark entity) throws DAOException {
        LOGGER.debug("Creating new mark. "+entity);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(INSERT_MARK)){

            if(preparedStatement!=null){
                preparedStatement.setDouble(1,entity.getMarkValue());
                preparedStatement.setInt(2,entity.getCreatureId());
                preparedStatement.setInt(3,entity.getUserId());
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while creating mark.",e);
        }
        return false;
    }

    @Override
    public boolean update(Mark entity) throws DAOException {
        LOGGER.debug("Updating mark. "+entity);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(UPDATE_MARK)) {

            if(preparedStatement!=null){
                preparedStatement.setInt(2,entity.getCreatureId());
                preparedStatement.setInt(3,entity.getUserId());
                preparedStatement.setDouble(1,entity.getMarkValue());
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while updating mark.",e);
        }
        return false;
    }

    @Override
    public Mark findMark(Integer creatureId, Integer userId) throws DAOException {
        LOGGER.debug("Selecting mark by creatureId and userId.");

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(SELECT_MARK_BY_CREATURE_ID_AND_USER_ID)){

            if(preparedStatement!=null){
                preparedStatement.setInt(1,creatureId);
                preparedStatement.setInt(2,userId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    return markFactory.createMark(resultSet.getDouble(MarkColumn.MARK_VALUE),creatureId,userId);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while selecting mark.",e);
        }
        return null;
    }
}
