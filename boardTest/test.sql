create table client(
	userid varchar(25) primary key,
	pw varchar(25) not null,
	name varchar(15) not null
);

create table message2(
	mnum int primary key,
	userid varchar(25) not null,
    title varchar(30) not null,
    content varchar(100) not null,
    wdate date
);
select * from client;

insert into client values('timo','1234','티모');
insert into message2 values(1,'timo','제목1','내용1',sysdate);

select * from all_tables;
