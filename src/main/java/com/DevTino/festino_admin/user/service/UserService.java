package com.DevTino.festino_admin.user.service;

import com.DevTino.festino_admin.user.bean.*;
import com.DevTino.festino_admin.user.domain.DTO.*;
import com.DevTino.festino_admin.user.domain.UserDAO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    SaveUserBean saveUserBean;
    UpdateUserBean updateUserBean;
    DeleteUserBean deleteUserBean;
    GetUserBean getUserBean;
    GetUsersBean getUsersBean;
    CheckUserBean checkUserBean;
    CheckRoleBean checkRoleBean;
    GetCookieBean getCookieBean;
    GetBoothIdByAdminName getBoothIdByAdminName;
    AddCookieBean addCookieBean;

    @Value("${JWT_SECRET_KEY}")
    private String secretKey;

    @Autowired
    public UserService(SaveUserBean saveUserBean, UpdateUserBean updateUserBean, DeleteUserBean deleteUserBean, GetUserBean getUserBean, GetUsersBean getUsersBean, CheckUserBean checkUserBean, CheckRoleBean checkRoleBean, GetCookieBean getCookieBean, GetBoothIdByAdminName getBoothIdByAdminName, AddCookieBean addCookieBean) {
        this.saveUserBean = saveUserBean;
        this.updateUserBean = updateUserBean;
        this.deleteUserBean = deleteUserBean;
        this.getUserBean = getUserBean;
        this.getUsersBean = getUsersBean;
        this.checkUserBean = checkUserBean;
        this.checkRoleBean = checkRoleBean;
        this.getCookieBean = getCookieBean;
        this.getBoothIdByAdminName = getBoothIdByAdminName;
        this.addCookieBean = addCookieBean;
    }

    // 유저 저장
    public void saveUser(RequestUserSaveDTO requestUserSaveDTO) {
        saveUserBean.exec(requestUserSaveDTO);
    }

    // 유저 로그인
    public Cookie[] login(RequestUserLoginDTO requestUserLoginDTO) {
        UserDAO userDAO = checkUserBean.exec(requestUserLoginDTO);

        return addCookieBean.exec(userDAO, secretKey);
    }

    // 유저 수정
    public UUID updateUser(RequestUserUpdateDTO requestUserUpdateDTO) {
        return updateUserBean.exec(requestUserUpdateDTO);
    }

    // 유저 삭제
    public void deleteUser(RequestUserDeleteDTO requestUserDeleteDTO) {
        deleteUserBean.exec(requestUserDeleteDTO);
    }

    // 특정 유저 조회
    public UserDAO getUser(UUID userId) {
        return getUserBean.exec(userId);
    }

    // 유저 전체 조회
    public List<ResponseUsersGetDTO> getUserAll() {
        return getUsersBean.exec();
    }

    // role 확인
    public UserDAO checkRole() {
        return checkRoleBean.exec();
    }

    // 토큰이 들어있는 쿠키 조회
    public Cookie getCookie(HttpServletRequest request) {
        return getCookieBean.exec(request);
    }

    // adminName 과 매핑되는 boothId 조회
    public UUID getBooth(HttpServletRequest request) {
        return getBoothIdByAdminName.exec(request, secretKey);
    }
}
