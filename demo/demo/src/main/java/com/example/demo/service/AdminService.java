package com.example.demo.service;//package com.competition.system.service;

import com.example.demo.entity.Admin;


public interface AdminService {

    Admin findById(long id);
    Admin findByName(String name);
   // Admin registerAdmin(Admin admin);
}
