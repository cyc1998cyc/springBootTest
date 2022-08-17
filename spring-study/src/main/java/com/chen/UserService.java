package com.chen;

/**
 * 陈宇超
 * 10:58
 */
public class UserService {
    private UserDao userDao;

    private AddressDao addressDao;

    public UserService() {
    }

    public UserService(UserDao userDao, AddressDao addressDao) {
        this.userDao = userDao;
        this.addressDao = addressDao;
    }

    private static final UserService userService = new UserService();

    public static UserService create(){
        for (int i = 0; i < 100; i++) {
            System.out.println("用create方法创建bean");
        }
        return userService;
    }

    public UserDao create2(){
        for (int i = 0; i < 100; i++) {
            System.out.println("创建userDao");
        }
        return new UserDao();
    }

    public void hello(){
        userDao.hello();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
}
