-- 选择数据库
USE sxit_databases_learning;

-- 创建 login 表
CREATE TABLE login (
    Muser VARCHAR(255) NOT NULL,
    Mpassword VARCHAR(255) NOT NULL
);

INSERT INTO login (Muser, Mpassword) VALUES
('user1', 'password1'),
('user2', 'password2'),
('user3', 'password3'),
('user4', 'password4'),
('user5', 'password5');   