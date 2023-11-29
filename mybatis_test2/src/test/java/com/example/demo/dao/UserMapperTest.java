package com.example.demo.dao;

import com.example.demo.model.Articleinfo;
import com.example.demo.model.Userinfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    ArticleMapper articleMapper;

    @Test
    void getAll() {
        List<Userinfo> list = userMapper.getAll();
        System.out.println(list);
    }


    @Test
    void getUserById() {
        Userinfo userinfo = userMapper.getUserById(1);
        System.out.println(userinfo);
    }

    @Test
    void login() {
        String username = "admin";
//        String password = "' or 1='1";
        String password = "admin";
        Userinfo userinfo = userMapper.login(username, password);
        System.out.println(userinfo);
    }

    @Test
    void getAllByOrder() {
        List<Userinfo> list = userMapper.getAllByOrder("desc");
        System.out.println(list);
    }


    @Transactional//可以保证测试不影响数据库
    @Test
    void delByID() {
        int id = 1;
        int result = userMapper.delByID(id);
        System.out.println("受影响的行数：" + result);
    }

    @Transactional
    @Test
    void update() {
        Userinfo userinfo = new Userinfo();
        userinfo.setId(1);
        userinfo.setUsername("管理员");
        int result = userMapper.update(userinfo);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    void add() {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("张三");
        userinfo.setPassword("2222");
        userinfo.setPhoto("/image/cat.jpg");
        int result = userMapper.add(userinfo);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    void add2() {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("李四");
        userinfo.setPassword("1111");
        userinfo.setPassword("/image/dog.jpg");
        int result = userMapper.add2(userinfo);
        System.out.println("受影响的行数：" + result + "  ID:" + userinfo.getId());
    }

    @Test
    void getLikeList() {
        String username = "三";
        List<Userinfo> list = userMapper.getLikeList(username);

    }
    @Test
    void getUserList() {
        int uid = 1;
        // 定义线程池
        ThreadPoolExecutor threadPool =
                new ThreadPoolExecutor(5, 10,
                        100, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(100));
        final Object[] resultArray = new Object[2];
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                // 1.根据 uid 查询 userinfo
                resultArray[0] = userMapper.getUserById2(uid);
            }
        });
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                // 2.根据 uid 查询查询文章列表
                resultArray[1] = articleMapper.getListByUid(uid);
            }
        });
        // 组装数据（等线程池执行完成之后）
        while (threadPool.getTaskCount() !=
                threadPool.getCompletedTaskCount()) {
        }
        Userinfo userinfo = (Userinfo) resultArray[0];
        userinfo.setALsit((List<Articleinfo>) resultArray[1]);
        System.out.println(userinfo);
    }
}