-- insert tag data
insert into tag(id, name) values (1, 'Sports');
insert into tag(id, name) values (2, 'Politics');
insert into tag(id, name) values (3, 'Science');
insert into tag(id, name) values (4, 'Entertainment');

-- insert categories
insert into category(id, name) values (1, 'Sports');
insert into category(id, name) values (2, 'Politics');
insert into category(id, name) values (3, 'Entertainment');
insert into category(id, name) values (4, 'Science');

-- insert user
insert into user(id, firstName, lastName, username, password, role) values (1, 'Dheeraj', 'Karki', 'dheerajkarki', '$2a$10$fTI1ygMp8xwE7MC/UdORqeh3on5VSKtkZjV2jq09jvbxv2lzSzfFe', 'ROLE_ADMIN');
insert into user(id, firstName, lastName, username, password, role) values (2, 'Saurav', 'Shrestha', 'sauravshrestha', '$2a$10$JO.yNSzUEIL.ZGfXUtJwF.9OWIA9ou6fIU584aSKXD9aLaIvMaPEa', 'ROLE_AUTHOR');
insert into user(id, firstName, lastName, username, password, role) values (3, 'Roshan', 'Dhakal', 'roshandhakal', '$2a$10$p38JPpUCBECJ8zdSDeX1DOn22P3BJgshogBsCioSFvz9evYECs9wu', 'ROLE_ADMIN');
insert into user(id, firstName, lastName, username, password, role) values (4, 'Nabin', 'Karki', 'nabinkarki', '$2a$10$Webjf/LmtkdzUX5y07GRgOVWmySKE4hdlE28vUb.XoyFY5N2mpzAO', 'ROLE_AUTHOR');

-- insert user with category
insert into author_category(author_id,category_id) values (1,1);
insert into author_category(author_id,category_id) values (1,3);
insert into author_category(author_id,category_id) values (2,3);
insert into author_category(author_id,category_id) values (3,1);
insert into author_category(author_id,category_id) values (3,2);
insert into author_category(author_id,category_id) values (4,2);

-- insert into articles
insert into article(id,title,content,publishDate,noOfViews, author_id, category_id) values (1, 'Legendary NBA coach Jerry Sloan ''dying'' while battling dementia, Parkinson''s disease: report', 'Salt Lake Tribune columnist Gordon Monson gave an update on Sloan’s health Wednesday, writing that he asked someone outside the family who would know the details about the coach’s health and received an eerie response.','2019-07-28T13:56:17.538',0, 1 ,1);
insert into article(id,title,content,publishDate,noOfViews, author_id, category_id) values (2, 'Trump''s comments on black lawmaker hyperbole, not racism: top aide', 'President Donald Trump was speaking hyperbolically when he lashed out at a prominent African-American lawmaker by calling his district "disgusting, rat and rodent infested," his acting chief of staff said on Sunday, denying the comments were racist.','2019-06-28T13:56:17.538',0, 3 ,2);
insert into article(id,title,content,publishDate,noOfViews, author_id, category_id) values (3, 'Selena Gomez Says She Is ''Truly Grateful'' and Ready to Get ''Back to Work''', 'The 27-year-old "The Heart Wants What It Wants" singer is expressing how "truly grateful" she is, following a restful and enjoyable vacation in Italy. On Thursday, the pop star took to Instagram to share a slew of snapshots from her overseas getaway. In the first photo, Gomez is casually dressed and sitting on a boat. There''s also a group pic with her gal pals, a solo smiling shot and a candid pasta-making cooking class snap.','2019-07-01T13:56:17.538',0, 4 ,3);
insert into article(id,title,content,publishDate,noOfViews, author_id, category_id) values (4, 'Judge agrees to hear bid to move Trump state tax return case to New York', 'President Donald Trump was speaking hyperbolically when he lashed out at a prominent African-American lawmaker by calling his district "disgusting, rat and rodent infested," his acting chief of staff said on Sunday, denying the comments were racist.','2019-06-28T13:56:17.538',0, 3 ,2);
insert into article(id,title,content,publishDate,noOfViews, author_id, category_id) values (5, 'A 3-D map of stars reveals the Milky Way’s warped shape', 'Making 3-D measurements of the galaxy requires estimating how far away stars are from Earth, typically a matter of guesswork. But unlike other stars, Cepheids vary in brightness over time in a particular way that can be used to determine a precise distance to each star.','2019-06-28T13:56:17.538',0, 3 ,4);

-- insert article_tag
insert into article_tag(article_id,tag_id) values (1,1);
insert into article_tag(article_id,tag_id) values (2,2);
insert into article_tag(article_id,tag_id) values (3,3);
insert into article_tag(article_id,tag_id) values (4,2);
insert into article_tag(article_id,tag_id) values (5,3);