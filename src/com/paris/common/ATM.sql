Create table person
(
    id           serial primary key not null,
    firstName    character varying,
    lastName     character varying,
    nationalCode character varying,
    age          integer
);

create table accountType
(
    id    serial            not null primary key,
    type  character varying not null,
    value integer           not null
);


create table Account
(
    id            serial primary key not null,
    accountNumber character varying  not null unique,
    password      character varying  not null,
    balance       double precision default 50000,
    personId      integer            not null references person (id),
    accountTypeId integer            not null references accountType (id)
);

create table transactionStatus
(
    id     serial primary key not null,
    status character varying  not null,
    value  integer            not null

);
create table transactionType
(
    id    serial primary key not null,
    type  character varying  not null,
    value integer            not null
);



create table transaction
(
    id                  serial primary key not null,
    amount              double precision,
    createdDate         timestamp          not null,
    accountId           integer            not null references Account (id),
    transactionStatusId integer            not null references transactionStatus (id),
    transactionTypeId   integer            not null references transactionType (id)

);


create table deposit
(
    id                  serial primary key not null,
    amount              double precision,
    createdDate         timestamp          not null,
    accountId           integer            not null references Account (id),
    transactionStatusId integer            not null references transactionStatus (id),
    transactionTypeId   integer            not null references transactionType (id)

);


create table withdraw
(
    id                  serial primary key not null,
    amount              double precision,
    createdDate         timestamp          not null,
    accountId           integer            not null references Account (id),
    transactionStatusId integer            not null references transactionStatus (id),
    transactionTypeId   integer            not null references transactionType (id)

);

insert into accountType(type, value)
values ('current ', 1);
insert into accountType(type, value)
values ('saving ', 2);
insert into accountType(type, value)
values ('salary ', 3);

select *
from accountType;


insert into transactionType(type, value)
values ('transfer', 0);
insert into transactionType(type, value)
values ('deposit', 1);
insert into transactionType(type, value)
values ('withdraw', 2);

select *
from transactionType;


insert into transactionStatus(status, value)
values ('Done', 0);
insert into transactionStatus(status, value)
values ('Processing', 1);
insert into transactionStatus(status, value)
values ('Failed', 2);

select *
from transactionStatus;

