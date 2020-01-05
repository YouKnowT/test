package com.example.demo.service.implement;//package com.competition.system.service.implement;

//import com.competition.system.entity.Admin;
import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminDao;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImp implements AdminService {
    @Autowired
    AdminDao adminDao;

//    @Override
//    public Admin findById(long id){
//        return adminDao.findById(id);
//    }
//
    @Override
    public Admin findByName(String name) {
        return adminDao.findByName(name);
    }
//
//    @Override
//    public Admin registerAdmin(Admin admin) {
//        return adminDao.save(admin);
//    }

}
