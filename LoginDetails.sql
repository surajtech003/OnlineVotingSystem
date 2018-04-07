DROP TABLE IF EXISTS onlinevotingsystem.LoginDetails;
CREATE TABLE onlinevotingsystem.LoginDetails
(
  userName        VARCHAR(45) PRIMARY KEY AUTO_INCREMENT,
  fname           VARCHAR(45) NOT NULL,
  lname			  VARCHAR(45) NOT NULL,
  password        TINYTEXT NOT NULL,
  role         	  VARCHAR(10)  NOT NULL,
  email			  VARCHAR(45) NOT NULL
) ENGINE=InnoDB;

INSERT INTO onlinevotingsystem.LoginDetails (`userName`, `fname`, `lname`,`password`, `role`, `email`) VALUES ('surajcse33', 'Suraj', 'Singh', '0W2SJQAYO5gGlu9uY8S1Rg==', 'admin', 'surajcse33@gmail.com');
COMMIT;