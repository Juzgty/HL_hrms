CREATE TABLE hl_position
(
    pos_id   INT AUTO_INCREMENT PRIMARY KEY COMMENT '职位ID',
    pos_name VARCHAR(100) NOT NULL UNIQUE COMMENT '职位名称'
) COMMENT ='职位表';

INSERT INTO hl_position (pos_name,)
VALUES ('部门经理'),
       ('开发工程师'),
       ('财务专员'),
       ('市场专员');
