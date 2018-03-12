package com.chenshun.test.dao.impl;

import com.chenshun.test.bean.User;
import com.chenshun.test.dao.UserDao;
import com.chenshun.test.util.base.JdbcDaoImpl;
import com.chenshun.test.util.base.Page;
import com.chenshun.test.util.base.Sql;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class UserDaoImpl extends JdbcDaoImpl implements UserDao {

    //@Autowired
    //private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User User) {
        String sql = "insert into _user (name, create_time) values (?, ?)";
        return jdbcTemplate.update(sql, User.getName(), User.getCreateTime());
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from _user where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateById(User User) {
        String sql = "update _user set name=?, create_time=? where id=?";
        return jdbcTemplate.update(sql, User.getName(), User.getCreateTime(), User.getId());
    }

    @Override
    public User selectById(int id) {
        String sql = "select * from _user where id=?";
		/*return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User User = new User();
				User.setId(rs.getInt("id"));
				User.setName(rs.getString("name"));
				User.setCreateTime(rs.getDate("create_time"));
				return User;
			}
		}, id);*/

        return queryForObject(sql, User.class, id);
    }

    @Override
    public Page<User> queryForPage(int pageCurrent, int pageSize, String name) {
        // 确定参数
		/*String sql = "select * from _user where name=?";
		return queryForPage(sql.toString(), pageCurrent, pageSize, User.class, name);*/

        // 若name可能为空，则要进行判定，如下
		/*StringBuffer sql = new StringBuffer("select * from _user where 1");
		if(!StringUtils.isNullOrEmpty(name)){
			// Sql.checkSql 的作用是防止sql注入
			sql.append(" and name = '").append(Sql.checkSql(name)).append("' ");
		}
		return queryForPage(sql.toString(), pageCurrent, pageSize, User.class);*/

        // 若要like查询，如下
        StringBuffer sql = new StringBuffer("select * from _user where 1");
        if (!StringUtils.isEmpty(name)) {
            // Sql.checkSql 的作用是防止sql注入
            sql.append(" and name like '%").append(Sql.checkSql(name)).append("%' ");
        }
        return queryForPage(sql.toString(), pageCurrent, pageSize, User.class);
    }

}
