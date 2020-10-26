create table account (
number bigint not null, 
balance double not null, 
balance_date timestamp, 
currency varchar(255), 
name varchar(255), 
type varchar(255), 
primary key (number))


create table transaction (
transaction_id bigint not null, 
account_name varchar(255), 
account_num bigint not null, 
credit_amt double not null, 
currency varchar(255), 
debit_amt double not null, 
debit_credit varchar(255), 
narrative varchar(255), 
value_date timestamp, 
primary key (transaction_id))
