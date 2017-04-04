-- Table: public."M_USER"

-- DROP TABLE public."M_USER";

CREATE TABLE public."M_USER"
(
  "ID" text -- 社員ID
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."M_USER"
  OWNER TO postgres;
COMMENT ON TABLE public."M_USER"
  IS '社員テーブル';
COMMENT ON COLUMN public."M_USER"."ID" IS '社員ID';

