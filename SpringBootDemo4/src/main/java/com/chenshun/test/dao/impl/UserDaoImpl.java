package com.chenshun.test.dao.impl;

import com.chenshun.test.bean.User;
import com.chenshun.test.dao.UserDao;
import com.chenshun.test.util.base.AbstractJdbcDaoImpl;
import com.chenshun.test.util.base.Page;
import com.chenshun.test.util.base.Sql;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * User: mew <p />
 * Time: 18/3/10 13:42  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@Repository
public class UserDaoImpl extends AbstractJdbcDaoImpl implements UserDao {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) {
        String sql = "insert into roncoo_user (name, create_time) values (?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getCreateTime());
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from roncoo_user where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateById(User user) {
        String sql = "update roncoo_user set name=?, create_time=? where id=?";
        return jdbcTemplate.update(sql, user.getName(), user.getCreateTime(), user.getId());
    }

    @Override
    public User selectById(int id) {
        String sql = "select * from roncoo_user where id=?";
		/*return jdbcTemplate.queryForObject(db.sql, new RowMapper<RoncooUser>() {
			@Override
			public RoncooUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				RoncooUser user = new RoncooUser();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setCreateTime(rs.getDate("create_time"));
				return user;
			}
		}, id);*/

        return queryForObject(sql, User.class, id);
    }

    @Override
    public Page<User> queryForPage(int pageCurrent, int pageSize, String name) {
        // 确定参数
		/*String db.sql = "select * from roncoo_user where name=?";
		return queryForPage(db.sql.toString(), pageCurrent, pageSize, RoncooUser.class, name);*/

        // 若name可能为空，则要进行判定，如下
		/*StringBuffer db.sql = new StringBuffer("select * from roncoo_user where 1");
		if(!StringUtils.isNullOrEmpty(name)){
			// Sql.checkSql 的作用是防止sql注入
			db.sql.append(" and name = '").append(Sql.checkSql(name)).append("' ");
		}
		return queryForPage(db.sql.toString(), pageCurrent, pageSize, RoncooUser.class);*/

        // 若要like查询，如下
        StringBuffer sql = new StringBuffer("select * from roncoo_user where 1");
        if (!StringUtils.isEmpty(name)) {
            // Sql.checkSql 的作用是防止sql注入
            sql.append(" and name like '%").append(Sql.checkSql(name)).append("%' ");
        }
        return queryForPage(sql.toString(), pageCurrent, pageSize, User.class);
    }

}
