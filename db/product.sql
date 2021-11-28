## PROCUCT create
create table product (
    id bigint not null auto_increment,
    created_date datetime,
    modified_date datetime,
    desc varchar(255) not null,
    name varchar(255) not null,
    picture varchar(255),
    refund_cnt integer,
    sell_cnt integer,
    seller varchar(255) not null,
    show_cnt integer,
    stock_cnt integer,
    primary key (id)
) engine=InnoDB