DROP TABLE IF EXISTS tb_user;

CREATE TABLE tb_user (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户编号',
    user_name VARCHAR(50) NOT NULL COMMENT '用户姓名',
    blog_url VARCHAR(50) NOT NULL COMMENT '博客地址',
    sex CHAR(2) DEFAULT '2' COMMENT '性别（1：男；2：女；）',
    province_name VARCHAR(20) COMMENT '省份',
    hobby VARCHAR(50) COMMENT '兴趣爱好',
    remark VARCHAR(50) COMMENT '备注'
) COMMENT='用户信息表';
