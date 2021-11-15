# Database Configuration
## below are SQL Script
CREATE DATABASE datagriptools;  
use datagriptools;  
create table trace  
(  
    location   varchar(40)               not null,  
    enter_time datetime                  not null,  
    Name       varchar(40) default '未留名' null,  
    phone      varchar(20)               null,  
    id         varchar(20)               not null,  
    primary key (enter_time, id)  
);  
