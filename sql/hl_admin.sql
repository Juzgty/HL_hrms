CREATE TABLE hl_admin
(
    admin_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '管理员ID',
    username VARCHAR(50)  NOT NULL UNIQUE COMMENT '用户名',
    password VARCHAR(100) NOT NULL COMMENT '密码'
) COMMENT ='管理员表';

INSERT INTO hl_admin (username, password)
VALUES ('admin', '123456');
