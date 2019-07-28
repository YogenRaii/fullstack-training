-- insert tag data
insert into tag(id, name) values (1, 'Sports');
insert into tag(id, name) values (2, 'Politics');
insert into tag(id, name) values (3, 'Science');
insert into tag(id, name) values (4, 'Entertainment');

-- insert categories
insert into category(id, name) values (1, 'Sports');
insert into category(id, name) values (2, 'Politics');
insert into category(id, name) values (3, 'Entertainment');

-- insert author
insert into author(id, firstName, lastName) values (1, 'Dheeraj', 'Karki');
insert into author(id, firstName, lastName) values (2, 'Saurav', 'Shrestha');
insert into author(id, firstName, lastName) values (3, 'Roshan', 'Dhakal');
insert into author(id, firstName, lastName) values (4, 'Nabin', 'Karki');

-- insert author with category
insert into author_category(author_id,category_id) values (1,1);
insert into author_category(author_id,category_id) values (1,3);
insert into author_category(author_id,category_id) values (2,3);
insert into author_category(author_id,category_id) values (3,1);
insert into author_category(author_id,category_id) values (3,2);
insert into author_category(author_id,category_id) values (4,2);

-- insert into articles
insert into article(id,title,content,publishDate,noOfViews, author_id, category_id) values (1, 'Legendary NBA coach Jerry Sloan ''dying'' while battling dementia, Parkinson''s disease: report', 'Salt Lake Tribune columnist Gordon Monson gave an update on Sloan’s health Wednesday, writing that he asked someone outside the family who would know the details about the coach’s health and received an eerie response.','2019-07-28T13:56:17.538',0, 1 ,1);
insert into article(id,title,content,publishDate,noOfViews, author_id, category_id) values (2, 'Trump''s comments on black lawmaker hyperbole, not racism: top aide', 'President Donald Trump was speaking hyperbolically when he lashed out at a prominent African-American lawmaker by calling his district "disgusting, rat and rodent infested," his acting chief of staff said on Sunday, denying the comments were racist.','2019-06-28T13:56:17.538',0, 3 ,2);

-- insert article_tag
insert into article_tag(article_id,tag_id) values (1,1);
insert into article_tag(article_id,tag_id) values (2,2);