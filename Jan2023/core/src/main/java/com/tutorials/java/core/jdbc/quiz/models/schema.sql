-- questions table
create table questions(
    id serial primary key not null,
    content varchar(500) not null,
    option1 varchar(100) not null,
    option2 varchar(100) not null,
    option3 varchar(100) not null,
    option4 varchar(100) not null,
    correctAnswer varchar(100) not null
);

insert into questions(content, option1, option2, option3, option4, correctAnswer)
values('What is capitol of India?', 'KTM', 'Agra', 'Bengal', 'Delhi', 'Delhi');