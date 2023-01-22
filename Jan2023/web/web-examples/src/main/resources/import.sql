-- questions table
create table if not exists questions (id serial primary key not null,content varchar(500) not null,option1 varchar(100) not null,option2 varchar(100) not null,option3 varchar(100) not null,option4 varchar(100) not null,correctAnswer varchar(100) not null);

insert into questions(id,content, option1, option2, option3, option4, correct_answer) values(1, 'What is capitol of India?', 'KTM', 'Agra', 'Bengal', 'Delhi', 'Delhi');