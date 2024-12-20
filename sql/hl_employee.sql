CREATE TABLE hl_employee (
    emp_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '员工ID',
    name VARCHAR(50) NOT NULL COMMENT '姓名',
    gender ENUM('男', '女') NOT NULL COMMENT '性别',
    birth_date DATE COMMENT '出生日期',
    id_card VARCHAR(18) UNIQUE COMMENT '身份证号',
    phone VARCHAR(20) DEFAULT NULL COMMENT '联系电话',
    email VARCHAR(100) DEFAULT NULL COMMENT '电子邮箱',
    address VARCHAR(255) DEFAULT NULL COMMENT '家庭住址',
    hire_date DATE NOT NULL COMMENT '入职时间',
    dept_id INT NOT NULL COMMENT '部门ID',
    pos_id INT NOT NULL COMMENT '职位ID',
    FOREIGN KEY (dept_id) REFERENCES hl_department(dept_id) ON DELETE CASCADE,
    FOREIGN KEY (pos_id) REFERENCES hl_position(pos_id) ON DELETE CASCADE
) COMMENT='员工表';

INSERT INTO hl_employee (name, gender, birth_date, id_card, phone, email, address, hire_date, dept_id, pos_id)
VALUES
('张三', '男', '1990-05-15', '110101199005152345', '13800138000', 'zhangsan@example.com', '北京市朝阳区某小区', '2020-03-01', 1, 1),
('李四', '女', '1992-08-20', '110101199208202345', '13800138001', 'lisi@example.com', '北京市海淀区某小区', '2021-07-15', 2, 2),
('王五', '男', '1985-12-10', '110101198512102345', '13800138002', 'wangwu@example.com', '北京市丰台区某小区', '2019-11-05', 3, 3),
('赵六', '女', '1995-03-08', '110101199503082345', '13800138003', 'zhaoliu@example.com', '北京市东城区某小区', '2022-05-20', 4, 4);

