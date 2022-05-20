CREATE TABLE monkey.ORDER (
                      order_id   INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                      product_id VARCHAR(64) NOT NULL,
                      order_qty  INTEGER NOT NULL,
                      create_at  DATETIME NOT NULL DEFAULT NOW()
);

CREATE TABLE monkey.TOTAL_ORDER_QTY (
                         summary_id       INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                         product_id       VARCHAR(64) NOT NULL,
                         total_order_qty  INTEGER NOT NULL,
                         create_at        DATETIME NOT NULL DEFAULT NOW()
);

commit
;

create table monkey.people
(
	first_name nvarchar(25)
    , last_name nvarchar(25)
)
;

create table monkey.people2
(
	first_name nvarchar(25)
    , last_name nvarchar(25)
)
;

insert into monkey.people(first_name, last_name)
values('dragon','flight')
;

SELECT first_name,last_name
FROM monkey.people
;

SELECT first_name,last_name
FROM monkey.people2
;