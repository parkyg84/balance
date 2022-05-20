
select *
from monkey.batch_job_execution
order by job_execution_id desc
;

 
select *
from monkey.batch_job_execution_context
;

 
select *
from monkey.batch_job_execution_params
;

select *
from monkey.batch_job_execution_seq
;

select *
from monkey.batch_job_instance;

select *
from monkey.batch_job_seq
;

select *
from monkey.batch_step_execution
;


select *
from monkey.batch_step_execution_context
;


select *
from monkey.batch_step_execution_seq;


CREATE TABLE table_copy (
    id int NOT NULL AUTO_INCREMENT,
    address varchar(255) NOT NULL,
    address_type tinyint UNSIGNED NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);
 
INSERT table_copy (address) VALUES ('test');
 

select *
from monkey.people
;

insert monkey.people (first_name, last_name)
values(
'abc','def'
)
;

commit
;
drop table  monkey.people2
;

truncate table monkey.people2
;

select *
from monkey.people2
order by id desc
;



CREATE TABLE monkey.people2 (
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
	reg_dt datetime default now(),
    PRIMARY KEY (id)
);
 
 
 select now()
 ;
 select *
 from  monkey.people2 
 order by id desc
 ;
 
 


