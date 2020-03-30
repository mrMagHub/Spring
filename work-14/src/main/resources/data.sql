insert into AUTHORS (ID, NAME, BIRTH_YAR, DESCRIPTION) values (1, 'Harry harrison', '1925-03-12','Harry Harrison is the pseudonym of Henry Maxwell Dempsey, a famous American science fiction writer and editor. Born March 12, 1925 in Stamford');
insert into GENRES (ID, NAME) values(1, 'Fantasy');
insert into BOOKS (ID, NAME, DESCRIPTION, AUTHOR_ID, GENRE_ID) values (1, 'The Birth of Steel Rat','The magnificent Jim Dee Gris - a famous interstellar criminal - received for his ingenuity and determination a well-known nickname Stainless Steel Rat', 1, 1);
insert into COMMENTS (ID, BOOK_ID, TEXT) values(1, 1, 'Text');

insert into USERS (ID, USERNAME, PASSWORD, NONEXPIRED, NONLOCKED, CREDENTIALSNONEXPIRED, ENABLED) values(1, 'admin', '123', 1, 1, 1, 1);
insert into USERS (ID, USERNAME, PASSWORD, NONEXPIRED, NONLOCKED, CREDENTIALSNONEXPIRED, ENABLED) values(2, 'user', '111', 1, 1, 1, 1);

insert into USER_AUTHORITIES (ID, USERNAME, AUTHORITY) values(1, 'admin', 'ROLE_ADMIN');
insert into USER_AUTHORITIES (ID, USERNAME, AUTHORITY) values(2, 'user', 'ROLE_USER');