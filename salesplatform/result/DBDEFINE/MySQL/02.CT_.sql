-- auto create by SMD

use DB_SALESPLATFORM;

-- 用户表

drop table if exists T_USER;

create table DB_SALESPLATFORM.T_USER
(
    C_BH                 char(32)                             NOT NULL     comment '编号',
    C_USERNAME           varchar(300)                         NULL         comment '用户名',
    C_PASSWPRD           varchar(300)                         NULL         comment '密码',
    N_AGE                int                                  NULL         comment '年龄',
    C_SEX                varchar(300)                         NULL         comment '性别',
    C_TEL                varchar(300)                         NULL         comment '电话',
    C_ADRESS             varchar(300)                         NULL         comment '地址',
    C_EMAIL              varchar(300)                         NULL         comment '邮箱',
    C_ORDER              char(32)                             NULL         comment '订单编号',
    C_CAR                char(32)                             NULL         comment '购物车编号',
    C_COLLECTRION        char(32)                             NULL         comment '收藏编号'
) comment = '用户表' ;


use DB_SALESPLATFORM;

-- 角色表

drop table if exists T_ROLE;

create table DB_SALESPLATFORM.T_ROLE
(
    C_BH                 char(32)                             NOT NULL     comment '编号',
    C_NAME               varchar(300)                         NULL         comment '角色名',
    C_ZXTMC              varchar(300)                         NULL         comment '子系统名称'
) comment = '角色表' ;


use DB_SALESPLATFORM;

-- 权限表

drop table if exists T_RIGHT;

create table DB_SALESPLATFORM.T_RIGHT
(
    C_BH                 char(32)                             NOT NULL     comment '编号',
    C_NAME               varchar(300)                         NULL         comment '权限名'
) comment = '权限表' ;


use DB_SALESPLATFORM;

-- 用户角色表

drop table if exists T_USER_ROLE;

create table DB_SALESPLATFORM.T_USER_ROLE
(
    C_BH                 char(32)                             NOT NULL     comment '编号',
    C_USER               char(32)                             NULL         comment '用户编号',
    C_ROLE               char(32)                             NULL         comment '角色编号'
) comment = '用户角色表' ;


use DB_SALESPLATFORM;

-- 角色权限表

drop table if exists T_ROLE_RIGHT;

create table DB_SALESPLATFORM.T_ROLE_RIGHT
(
    C_BH                 char(32)                             NOT NULL     comment '编号',
    C_ROLE               char(32)                             NULL         comment '角色编号',
    C_RIGHT              char(32)                             NULL         comment '权限编号'
) comment = '角色权限表' ;


use DB_SALESPLATFORM;

-- 商品表

drop table if exists T_GOODS;

create table DB_SALESPLATFORM.T_GOODS
(
    C_BH                 char(32)                             NOT NULL     comment '编号',
    C_NAME               varchar(300)                         NULL         comment '商品名',
    C_PRICE              varchar(300)                         NULL         comment '价格',
    C_IMAGE              varchar(300)                         NULL         comment '商品图片',
    C_DESCRIBE           varchar(300)                         NULL         comment '商品描述'
) comment = '商品表' ;


use DB_SALESPLATFORM;

-- 订单表

drop table if exists T_ORDER;

create table DB_SALESPLATFORM.T_ORDER
(
    C_BH                 char(32)                             NOT NULL     comment '编号',
    N_NUM                int                                  NULL         comment '数量',
    C_GOODS              char(32)                             NULL         comment '商品编号',
    C_PAY                char(300)                            NULL         comment '是否付款'
) comment = '订单表' ;


use DB_SALESPLATFORM;

-- 购物车表

drop table if exists T_CAR;

create table DB_SALESPLATFORM.T_CAR
(
    C_BH                 char(32)                             NOT NULL     comment '编号',
    N_NUM                int                                  NULL         comment '数量',
    C_GOODS              char(32)                             NULL         comment '商品编号'
) comment = '购物车表' ;


use DB_SALESPLATFORM;

-- 收藏表

drop table if exists T_COLLECTRION;

create table DB_SALESPLATFORM.T_COLLECTRION
(
    C_BH                 char(32)                             NOT NULL     comment '编号'
) comment = '收藏表' ;


use DB_SALESPLATFORM;

-- 留言表

drop table if exists T_MESSAGE;

create table DB_SALESPLATFORM.T_MESSAGE
(
    C_BH                 char(32)                             NOT NULL     comment '编号',
    C_MESSAGE            varchar(900)                         NULL         comment '留言内容',
    D_ADDDATE            date                                 NULL         comment '留言时间',
    C_NAME               varchar(300)                         NULL         comment '留言人名称'
) comment = '留言表' ;


use DB_SALESPLATFORM;

-- 新闻表

drop table if exists T_NEWS;

create table DB_SALESPLATFORM.T_NEWS
(
    C_BH                 char(32)                             NOT NULL     comment '编号',
    C_NEW                varchar(900)                         NULL         comment '新闻内容',
    D_ADDDATE            date                                 NULL         comment '发布时间'
) comment = '新闻表' ;


use DB_SALESPLATFORM;

-- 运动小贴士表

drop table if exists T_TIPS;

create table DB_SALESPLATFORM.T_TIPS
(
    C_BH                 char(32)                             NOT NULL     comment '编号',
    C_TIP                varchar(900)                         NULL         comment '内容',
    C_TYPE               varchar(300)                         NULL         comment '类别'
) comment = '运动小贴士表' ;


use DB_SALESPLATFORM;

-- 活动表

drop table if exists T_ACTTIP;

create table DB_SALESPLATFORM.T_ACTTIP
(
    C_BH                 char(32)                             NOT NULL     comment '编号',
    C_GOODS              char(32)                             NULL         comment '商品编号',
    D_STARTDATE          date                                 NULL         comment '开始时间',
    D_ENDDATE            date                                 NULL         comment '结束时间',
    C_DISCOUNT           varchar(300)                         NULL         comment '折扣率',
    C_DETAILS            varchar(900)                         NULL         comment '详情'
) comment = '活动表' ;


