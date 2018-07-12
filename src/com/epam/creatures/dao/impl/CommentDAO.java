package com.epam.creatures.dao.impl;

import com.epam.creatures.constant.CommentColumn;
import com.epam.creatures.dao.AbstractDAO;
import com.epam.creatures.dao.CommentTableDAO;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.entity.Comment;
import com.epam.creatures.factory.CommentFactory;
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

public class CommentDAO extends AbstractDAO<Integer, Comment> implements CommentTableDAO {
    private static final Logger LOGGER = LogManager.getLogger(CommentDAO.class);
    private static final String SELECT_COMMENT_BY_ID = "SELECT creatures_db.comments.id,creatures_db.comments.comment_content,creatures_db.comments.creature_id,creatures_db.comments.user_id " +
            "FROM creatures_db.comments " +
            "WHERE creatures_db.comments.id = ?";

    private static final String SELECT_ALL_COMMENTS = "SELECT creatures_db.comments.id,creatures_db.comments.comment_content,creatures_db.comments.creature_id,creatures_db.comments.user_id " +
            "FROM creatures_db.comments";

    private static final String DELETE_COMMENT_BY_ID = "DELETE FROM creatures_db.comments " +
            "WHERE creatures_db.comments.id = ?";

    private static final String INSERT_COMMENT = "INSERT INTO creatures_db.comments(creatures_db.comments.comment_content, creatures_db.comments.creature_id,creatures_db.comments.user_id) " +
            "VALUES (?,?,?)";

    private static final String UPDATE_COMMENT = "UPDATE creatures_db.comments " +
            "SET creatures_db.comments.comment_content = ?, creatures_db.comments.creature_id = ?,creatures_db.comments.user_id = ? " +
            "WHERE creatures_db.comments.id = ?";

    private static final String SELECT_COMMENT_BY_CREATURE_ID = "SELECT creatures_db.comments.id,creatures_db.comments.comment_content,creatures_db.comments.creature_id,creatures_db.comments.user_id " +
            "FROM creatures_db.comments " +
            "WHERE creatures_db.comments.creature_id = ?";

    private CommentFactory commentFactory = new CommentFactory();

    @Override
    public List<Comment> findAll() throws DAOException {
        List<Comment> commentList = new ArrayList<>();
        LOGGER.debug("Selecting all comments.");

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            Statement statement = Objects.requireNonNull(connection).createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_COMMENTS)){

            while (resultSet.next()){
                commentList.add(commentFactory
                        .createComment(resultSet.getInt(CommentColumn.ID),resultSet.getString(CommentColumn.COMMENT_CONTENT),resultSet.getInt(CommentColumn.CREATURE_ID),resultSet.getInt(CommentColumn.USER_ID)));
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while selecting all comments.",e);
        }
        return commentList;
    }

    @Override
    public Comment findEntityById(Integer id) throws DAOException {
        LOGGER.debug("Selecting comment by id. Id: "+id);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(SELECT_COMMENT_BY_ID)){

            if(preparedStatement!=null){
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    return commentFactory
                            .createComment(resultSet.getInt(CommentColumn.ID),resultSet.getString(CommentColumn.COMMENT_CONTENT),resultSet.getInt(CommentColumn.CREATURE_ID),resultSet.getInt(CommentColumn.USER_ID));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while selecting comment by id.",e);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        LOGGER.debug("Deleting comment by id. Id:"+id);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(DELETE_COMMENT_BY_ID)){

            if(preparedStatement!=null){
                preparedStatement.setInt(1,id);
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while deleting comment by id.",e);
        }

        return false;
    }

    @Override
    public boolean create(Comment entity) throws DAOException {
        LOGGER.debug("Inserting comment. "+entity);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(INSERT_COMMENT)){

            if(preparedStatement!=null){
                preparedStatement.setString(1,entity.getContent());
                preparedStatement.setInt(2,entity.getCreatureId());
                preparedStatement.setInt(3,entity.getUserId());
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while inserting comment.",e);
        }
        return false;
    }

    @Override
    public boolean update(Comment entity) throws DAOException {
        LOGGER.debug("Updating comment. "+entity);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(UPDATE_COMMENT)){

            if(preparedStatement!=null){
                preparedStatement.setInt(4,entity.getId());
                preparedStatement.setString(1,entity.getContent());
                preparedStatement.setInt(2,entity.getCreatureId());
                preparedStatement.setInt(3,entity.getUserId());
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while updating comment.",e);
        }
        return false;
    }

    @Override
    public List<Comment> findCommentsByCreatureId(Integer creatureId) throws DAOException {
        List<Comment> commentList = new ArrayList<>();
        LOGGER.debug("Selecting comment by creatureId. CreatureId: "+creatureId);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(SELECT_COMMENT_BY_CREATURE_ID)){

            if(preparedStatement!=null){
                preparedStatement.setInt(1,creatureId);
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    commentList.add(commentFactory
                            .createComment(resultSet.getInt(CommentColumn.ID),resultSet.getString(CommentColumn.COMMENT_CONTENT),resultSet.getInt(CommentColumn.CREATURE_ID),resultSet.getInt(CommentColumn.USER_ID)));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Exception while selecting comment by creatureId.",e);
        }
        return commentList;
    }
}
