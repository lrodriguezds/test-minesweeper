/**
 * Game DB Schema
*/

create table game (
    id INT NOT NULL AUTO_INCREMENT,    
    status VARCHAR(15) NOT NULL,
    current_board varchar(100) NOT NULL,
    solution_board varchar(100) NOT NULL,
    started_on datetime,
    finished_on datetime,
    CONSTRAINT `pk_game` PRIMARY KEY (id)
);
