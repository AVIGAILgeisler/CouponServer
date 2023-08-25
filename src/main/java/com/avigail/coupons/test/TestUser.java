package com.avigail.coupons.test;

//import com.avigail.coupons.dto.User;
//import com.avigail.coupons.enums.UserType;
//import com.avigail.coupons.logic.PurchaseLogic;
//import com.avigail.coupons.logic.UserLogic;
//
//import java.sql.Date;
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class TestUser {
//    public static void main(String[] args) throws ApplicationException {
//
//        UserLogic userLogic = new UserLogic();
//
//
//        User user1 = new User("avi", "vigail2", UserType.COMPANY, 2);
//        User user2 = new User("Moshe", "Moshe!10", UserType.ADMIN, 1);
//        User user3 = new User("Avigail", "sdyuy34565!", UserType.CUSTOMER, 1);
//        User user4 = new User("Chana", "Naomi!1034*", UserType.ADMIN, 1);
//
//        try {
//            userLogic.addUser(user1);
//            userLogic.addUser(user2);
//            userLogic.addUser(user3);
//            userLogic.addUser(user4);
//
//            User user = userLogic.getUser(2);
//            user.setPassword("!@987GGg");
//            userLogic.updateUser(user);
////            userLogic.deleteUser(3);
//
//            List<User> users = userLogic.getAllUsers();
//            for (int i = 0; i < users.size(); i++) {
//                System.out.println(users.get(i));
//            }
//            System.out.println(userLogic.getUsersByCompanyId(2));
//
//        } catch (ApplicationException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
