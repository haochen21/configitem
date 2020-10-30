CREATE TABLE config_item
(
  id serial NOT NULL PRIMARY KEY,
  name varchar(255),
  description varchar(512),
  display_name varchar(255),
  icon varchar(255),
  create_time timestamp,
  update_time timestamp
);

ALTER TABLE config_item ADD CONSTRAINT unique_ci_name unique(name);