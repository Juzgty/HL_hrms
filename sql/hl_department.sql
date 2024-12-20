CREATE TABLE hl_department
(
    dept_id   INT AUTO_INCREMENT PRIMARY KEY COMMENT '部门ID',
    dept_name VARCHAR(100) NOT NULL UNIQUE COMMENT '部门名称'
) COMMENT ='部门表';

INSERT INTO hl_department (dept_name)
VALUES ('人事部'),
       ('技术部'),
       ('财务部'),
       ('市场部');
