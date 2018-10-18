package com.yangshijie.dzxiaoyuan;

import com.yangshijie.dzxiaoyuan.bean.User;
import com.yangshijie.dzxiaoyuan.dao.UserMapping;
import com.yangshijie.dzxiaoyuan.dao.db.DbUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * @author yangshijie
 */
@RestController
@RequestMapping("/test")
public class Test {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(ServletRequest request) throws Exception {

        SqlSession sqlSession = DbUtils.getSqlSession();
        UserMapping mapper = sqlSession.getMapper(UserMapping.class);
        User phone = mapper.getUserById(request.getParameter("phone"));
        if (phone==null){
            mapper.addUser(new User(request.getParameter("name"), request.getParameter("phone"), request.getParameter("sfid")));
            sqlSession.commit();
            sqlSession.close();
            System.out.println("已添加新用户"+request.getParameter("phone"));
            return "ok";
        }else {
            System.out.println("已有用户，记录失败！");
            sqlSession.close();
            return "已经存在手机号！";
        }
    }
}
