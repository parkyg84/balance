create table monkey.BATCH_STEP_EXECUTION_CONTEXT
(
step_execution_id bigint(20)
, short_context varchar(2500)
, serialized_context text
)
;

create table monkey.BATCH_STEP_EXECUTION
(
step_execution_id bigint(20)
, version bigint(20)
, job_execution_id bigint(20)
, start_time datetime
, end_time datetime
, status varchar(10)
, commit_count bigint(20)
, read_count bigint(20)
, filter_count bigint(20)
, write_count bigint(20)
, read_skip_count bigint(20)
, write_skip_count bigint(20)
, process_skip_count bigint(20)
, rollback_count bigint(20)
, exit_code varchar(100)
, exit_message varchar(2500)
, last_updated datetime
);


create table monkey.BATCH_JOB_INSTANCE
(
job_instance_id bigint(20)
, version bigint(20)
, job_name varchar(100)
, job_key varchar(32)
)
;
create table monkey.BATCH_JOB_EXECUTION
(
job_execution_id bigint(20)
, version bigint(20)
, job_instance_id bigint(20)
, create_time datetime
, start_time datetime
, end_time datetime
, status varchar(10)
, exit_code varchar(100)
, exit_message varchar(2500)
, last_updated datetime
)
;



create table monkey.BATCH_JOB_EXECUTION_CONTEXT
(
job_execution_id bigint(20)
, shot_context varchar(2500)
, serialized_context text
)
;

create table monkey.BATCH_JOB_EXECUTION_PARAMS
(
job_execution_id bigint(20)
, type_cd varchar(6)
, key_name varchar(100)
, string_val varchar(250)
, date_val datetime
, long_val bigint(20)
, double_val double
, identifying char(1)
)
;


commit;

select * from monkey.BATCH_STEP_EXECUTION_CONTEXT;
select * from monkey.BATCH_STEP_EXECUTION;
select * from monkey.BATCH_JOB_INSTANCE;
select * from monkey.BATCH_JOB_EXECUTION;
select * from monkey.BATCH_JOB_EXECUTION_CONTEXT;
select * from monkey.BATCH_JOB_EXECUTION_PARAMS;

CREATE SEQUENCE monkey.BATCH_STEP_EXECUTION_SEQ;
CREATE SEQUENCE monkey.BATCH_JOB_EXECUTION_SEQ;
CREATE SEQUENCE monkey.BATCH_JOB_SEQ;


drop table  monkey.BATCH_STEP_EXECUTION_CONTEXT;
drop table  monkey.BATCH_STEP_EXECUTION;
drop table  monkey.BATCH_JOB_INSTANCE;
drop table  monkey.BATCH_JOB_EXECUTION;
drop table  monkey.BATCH_JOB_EXECUTION_CONTEXT;
drop table  monkey.BATCH_JOB_EXECUTION_PARAMS;


drop table monkey.BATCH_JOB_SEQ;
drop table monkey.BATCH_JOB_EXECUTION_SEQ;

CREATE TABLE monkey.BATCH_JOB_SEQ (ID BIGINT NOT NULL) ;
CREATE TABLE monkey.BATCH_JOB_EXECUTION_SEQ (ID BIGINT NOT NULL);

INSERT INTO monkey.BATCH_JOB_EXECUTION_SEQ values(0);









CREATE TABLE BATCH_JOB_EXECUTION  (

JOB_EXECUTION_ID BIGINT  NOT NULL PRIMARY KEY ,

VERSION BIGINT  ,

JOB_INSTANCE_ID BIGINT NOT NULL,

CREATE_TIME DATETIME NOT NULL,

START_TIME DATETIME DEFAULT NULL ,

END_TIME DATETIME DEFAULT NULL ,

STATUS VARCHAR(10) ,

EXIT_CODE VARCHAR(100) ,

EXIT_MESSAGE VARCHAR(2500) ,

LAST_UPDATED DATETIME,

JOB_CONFIGURATION_LOCATION varchar(2500) DEFAULT NULL,

constraint JOB_INST_EXEC_FK foreign key (JOB_INSTANCE_ID)

references BATCH_JOB_INSTANCE(JOB_INSTANCE_ID)

) ENGINE=InnoDB;
