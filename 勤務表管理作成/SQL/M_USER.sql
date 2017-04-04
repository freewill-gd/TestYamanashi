-- Table: public."M_USER"

-- DROP TABLE public."M_USER";

CREATE TABLE public."M_USER"
(
  "ID" character varying(6), -- 社員ID
  "INSERT_DATE" time with time zone -- 追加日時
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."M_USER"
  OWNER TO postgres;
COMMENT ON TABLE public."M_USER"
  IS '社員テーブル';
COMMENT ON COLUMN public."M_USER"."ID" IS '社員ID';
COMMENT ON COLUMN public."M_USER"."INSERT_DATE" IS '追加日時';

