insert into role (name, role) values (N'Quản Lí',N'ADMIN');
insert into role (name, role) values (N'Người dùng',N'USER');


insert into Account (Email, PassWord, Name, Status ) values (N'abcduy@gmail.com','$2a$10$FkIfJ5/sCqC/VKUYk8xVruLE5wRCbP.HsoT/c.4v9fTeynBg1QWLy',N'Trần Khánh Duy',1) ;
insert into Account (Email, PassWord, Name, Status) values (N'user@gmail.com','$2a$10$FkIfJ5/sCqC/VKUYk8xVruLE5wRCbP.HsoT/c.4v9fTeynBg1QWLy',N'Mai Xuân Cường',1) ;


INSERT INTO user_role(userid,roleid) VALUES (1,1);
INSERT INTO user_role(userid,roleid) VALUES (2,2);