package com.epam.creatures.dao.impl;

import com.epam.creatures.constant.CommentColumn;
import com.epam.creatures.constant.UserColumn;
import com.epam.creatures.dao.AbstractDao;
import com.epam.creatures.dao.CommentTableDao;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.entity.Comment;
import com.epam.creatures.entity.User;
import com.epam.creatures.factory.CommentFactory;
import com.epam.creatures.factory.UserFactory;
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

public class CommentDao extends AbstractDao<Integer, Comment> implements CommentTableDao {
    private static final Logger LOGGER = LogManager.getLogger(CommentDao.class);
    private static final String SELECT_COMMENT_BY_ID = "SELECT creatures_db.comments.id,creatures_db.comments.comment_content,creatures_db.comments.creature_id,creatures_db.comments.user_id, u.login, u.avatar " +
            "FROM creatures_db.comments " +
            "INNER JOIN creatures_db.users u ON comments.user_id = u.id " +
            "WHERE creatures_db.comments.id = ?";

    private static final String SELECT_ALL_COMMENTS = "SELECT creatures_db.comments.id,creatures_db.comments.comment_content,creatures_db.comments.creature_id, creatures_db.comments.user_id,u.login, u.avatar " +
            "FROM creatures_db.comments " +
            "INNER JOIN creatures_db.users u ON comments.user_id = u.id";

    private static final String DELETE_COMMENT_BY_ID = "DELETE FROM creatures_db.comments " +
            "WHERE creatures_db.comments.id = ?";

    private static final String INSERT_COMMENT = "INSERT INTO creatures_db.comments(creatures_db.comments.comment_content, creatures_db.comments.creature_id,creatures_db.comments.user_id) " +
            "VALUES (?,?,?)";

    private static final String UPDATE_COMMENT = "UPDATE creatures_db.comments " +
            "SET creatures_db.comments.comment_content = ?, creatures_db.comments.creature_id = ?,creatures_db.comments.user_id = ? " +
            "WHERE creatures_db.comments.id = ?";

    private static final String SELECT_COMMENT_BY_CREATURE_ID = "SELECT creatures_db.comments.id,creatures_db.comments.comment_content,creatures_db.comments.creature_id,creatures_db.comments.user_id,u.login, u.avatar " +
            "FROM creatures_db.comments " +
            "INNER JOIN creatures_db.users u ON comments.user_id = u.id " +
            "WHERE creatures_db.comments.creature_id = ?";

    private CommentFactory commentFactory = new CommentFactory();
    private UserFactory userFactory = new UserFactory();
    @Override
    public List<Comment> findAll() throws DaoException {
        List<Comment> commentList = new ArrayList<>();
        LOGGER.debug("Selecting all comments.");

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            Statement statement = Objects.requireNonNull(connection).createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_COMMENTS)){

            while (resultSet.next()){
                User user = userFactory.createUser(resultSet.getInt(CommentColumn.USER_ID),resultSet.getString(UserColumn.LOGIN),resultSet.getBytes(UserColumn.AVATAR));
                commentList.add(commentFactory
                        .createComment(resultSet.getInt(CommentColumn.ID),resultSet.getString(CommentColumn.COMMENT_CONTENT),resultSet.getInt(CommentColumn.CREATURE_ID),user));
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while selecting all comments.",e);
        }
        return commentList;
    }

    @Override
    public Comment findEntityById(Integer id) throws DaoException {
        LOGGER.debug("Selecting comment by id. Id: "+id);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(SELECT_COMMENT_BY_ID)){

            if(preparedStatement!=null){
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    User user = userFactory.createUser(resultSet.getInt(CommentColumn.USER_ID),resultSet.getString(UserColumn.LOGIN),resultSet.getBytes(UserColumn.AVATAR));
                    return commentFactory
                            .createComment(resultSet.getInt(CommentColumn.ID),resultSet.getString(CommentColumn.COMMENT_CONTENT),resultSet.getInt(CommentColumn.CREATURE_ID),user);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while selecting comment by id.",e);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        LOGGER.debug("Deleting comment by id. Id:"+id);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(DELETE_COMMENT_BY_ID)){

            if(preparedStatement!=null){
                preparedStatement.setInt(1,id);
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while deleting comment by id.",e);
        }

        return false;
    }

    @Override
    public boolean create(Comment entity) throws DaoException {
        LOGGER.debug("Inserting comment. "+entity);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(INSERT_COMMENT)){

            if(preparedStatement!=null){
                preparedStatement.setString(1,entity.getContent());
                preparedStatement.setInt(2,entity.getCreatureId());
                preparedStatement.setInt(3,entity.getUser().getId());
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while inserting comment.",e);
        }
        return false;
    }

    @Override
    public boolean update(Comment entity) throws DaoException {
        LOGGER.debug("Updating comment. "+entity);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(UPDATE_COMMENT)){

            if(preparedStatement!=null){
                preparedStatement.setInt(4,entity.getId());
                preparedStatement.setString(1,entity.getContent());
                preparedStatement.setInt(2,entity.getCreatureId());
                preparedStatement.setInt(3,entity.getUser().getId());
                return preparedStatement.executeUpdate()>0;
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while updating comment.",e);
        }
        return false;
    }

    @Override
    public List<Comment> findCommentsByCreatureId(Integer creatureId) throws DaoException {
        List<Comment> commentList = new ArrayList<>();
        LOGGER.debug("Selecting comment by creatureId. CreatureId: "+creatureId);

        try(SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
            PreparedStatement preparedStatement = Objects.requireNonNull(connection).prepareStatement(SELECT_COMMENT_BY_CREATURE_ID)){

            if(preparedStatement!=null){
                preparedStatement.setInt(1,creatureId);
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    User user = userFactory.createUser(resultSet.getInt(CommentColumn.USER_ID),resultSet.getString(UserColumn.LOGIN),resultSet.getBytes(UserColumn.AVATAR));
                    commentList.add(commentFactory
                            .createComment(resultSet.getInt(CommentColumn.ID),resultSet.getString(CommentColumn.COMMENT_CONTENT),resultSet.getInt(CommentColumn.CREATURE_ID),user));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Exception while selecting comment by creatureId.",e);
        }
        return commentList;
    }
}
