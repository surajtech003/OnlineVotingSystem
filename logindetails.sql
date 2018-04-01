Field,Type,Null,Key,Default,Extra
userId,int(11),NO,PRI,NULL,auto_increment
userName,varchar(45),NO,,NULL,
password,tinytext,NO,,NULL,
role,varchar(10),NO,,NULL,
email,varchar(45),NO,,NULL,

/*
-- Query: SELECT * FROM onlinevotingsystem.logindetails
LIMIT 0, 1000

-- Date: 2018-04-01 10:49
*/
INSERT INTO `logindetails` (`userId`,`userName`,`password`,`role`,`email`) VALUES (1,'surajcse33','0W2SJQAYO5gGlu9uY8S1Rg==','admin','surajtech003@gmail.com');
INSERT INTO `logindetails` (`userId`,`userName`,`password`,`role`,`email`) VALUES (2,'suraj','surajkumar','admin','surajcse33@gmail.com');
INSERT INTO `logindetails` (`userId`,`userName`,`password`,`role`,`email`) VALUES (3,'suraj123','b00FrriYBu501boiYExGiQ==','admin','surajcse33@gmail.com');
INSERT INTO `logindetails` (`userId`,`userName`,`password`,`role`,`email`) VALUES (4,'abhi','S/KF5hoI8/OmfkczSv3rlw==','admin','surajcse33@gmail.com');
