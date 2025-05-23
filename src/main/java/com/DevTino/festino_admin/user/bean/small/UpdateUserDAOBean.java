package com.DevTino.festino_admin.user.bean.small;

import com.DevTino.festino_admin.user.domain.DTO.RequestUserUpdateDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserDAOBean {
    // 유저 수정
    public void exec(UserDAO userDAO, RequestUserUpdateDTO requestUserUpdateDTO) {
        userDAO.setAdminId(requestUserUpdateDTO.getAdminId());
        userDAO.setAdminName(requestUserUpdateDTO.getAdminName());
        userDAO.setPassWord(requestUserUpdateDTO.getPassWord());
        userDAO.setRole(requestUserUpdateDTO.getRole());
        userDAO.setAdminCategory(requestUserUpdateDTO.getCategory());
    }
}
