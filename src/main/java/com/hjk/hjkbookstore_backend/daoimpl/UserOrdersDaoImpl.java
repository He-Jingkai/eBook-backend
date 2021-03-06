package com.hjk.hjkbookstore_backend.daoimpl;

import com.hjk.hjkbookstore_backend.dao.UserOrdersDao;
import com.hjk.hjkbookstore_backend.entity.UserOrders;
import com.hjk.hjkbookstore_backend.repository.UserOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserOrdersDaoImpl implements UserOrdersDao {
    @Autowired
    private UserOrdersRepository userOrdersRepository;

    @Override
    public List<UserOrders> getAll(){
        List<UserOrders> userOrders=userOrdersRepository.findAll();
        return userOrders;
    }

}
