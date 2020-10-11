create table t_emp
(
    id       int auto_increment
        primary key,
    ename    varchar(30) null,
    age      int(3)      null,
    sex      char        null,
    sal      double      null,
    birthday varchar(15) null,
    edate    varchar(15) null
);

create table t_user
(
    id       int auto_increment
        primary key,
    username varchar(30) null,
    password varchar(50) null,
    nickname varchar(30) null
);


