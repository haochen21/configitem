CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE config_type
(
  id UUID DEFAULT uuid_generate_v4(),
  name VARCHAR(255),
  description VARCHAR(512),
  display_name VARCHAR(255),
  icon VARCHAR(255),
  meta_data JSONB DEFAULT '{}',
  extra_meta_data JSONB DEFAULT '{}',
  create_at TIMESTAMP NOT NULL DEFAULT LOCALTIMESTAMP,
  update_at TIMESTAMP NOT NULL DEFAULT LOCALTIMESTAMP,
  version BIGINT
);

ALTER TABLE config_type ADD CONSTRAINT unique_config_type unique(name);

CREATE TYPE property_status AS ENUM ('DRAFT', 'PUBLISHED', 'DISABLE');
CREATE TYPE property_data_type AS ENUM ('BIGINT', 'BOOLEAN', 'BYTEA', 'INTEGER', 'JSONB', 'REAL', 'STRING', 'TIMESTAMP', 'UUID');

CREATE TABLE config_type_property
(
  id UUID DEFAULT uuid_generate_v4(),
  name VARCHAR(255),
  display_name VARCHAR(255),
  description VARCHAR(512),
  config_type_id UUID,
  config_type_name VARCHAR(255),
  status property_status default 'DRAFT',
  data_type property_data_type default 'STRING',
  data_length smallint,
  default_value VARCHAR(255),
  meta_data JSONB DEFAULT '{}',
  create_at TIMESTAMP NOT NULL DEFAULT LOCALTIMESTAMP,
  update_at TIMESTAMP NOT NULL DEFAULT LOCALTIMESTAMP,
  version BIGINT
);

ALTER TABLE config_type_property ADD CONSTRAINT unique_config_type_property unique(name, config_type_id);