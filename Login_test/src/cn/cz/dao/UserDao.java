package cn.cz.dao;

import cn.cz.domain.User;
import cn.cz.util.JdbcUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中User表
 *
 * @author Kartoffel
 * @create 2020-03-24-10:16
 */
public class UserDao {

    /**
     * 声明JDBCTemplate对象公用
     */
    private JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());
    /**
     * 用户登陆方法
     *
     * @param loginUser 包含用户名和密码
     * @return 包含用户所有数据
     */
    public User login(User loginUser) {
        try {
            //编写sql
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUserName(), loginUser.getPassWord());
            return user;
        } catch (DataAccessException e) {
            return null;
        }
    }

}