DROP DATABASE IF EXISTS `auth_server_db`;
CREATE DATABASE `auth_server_db` CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `auth_server_db`;

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;

CREATE TABLE `user_account`  (
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `phonenumber` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `user_account` VALUES('janwee','$2a$10$zAtKQOqE.J9w3WjuMLNexuqUQWeTbd1sWHp25F/pQp40BRcQ3pCzO',
'19999999999');
