DROP TABLE IF EXISTS onlinevotingsystem.VotingMenu;
CREATE TABLE onlinevotingsystem.VotingMenu
(
  serialNumber          int(11) PRIMARY KEY AUTO_INCREMENT,
  partyName 			varchar(20) NOT NULL,
  symbol 				int(11) NOT NULL
) ENGINE=InnoDB;

INSERT INTO onlinevotingsystem.VotingMenu (`serialNumber`, `partyName`, `symbol`) VALUES (1,'BJP',1);
COMMIT;