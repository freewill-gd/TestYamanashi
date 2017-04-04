-- Table: public."M_USER"

-- DROP TABLE public."M_USER";

CREATE TABLE public."M_USER"
(
  "ID" character varying(6), -- 社員ID
  "INSERT_DATE" time with time zone, -- 追加日時
  "INSERT_USER_ID" character varying(6), -- 追加ユーザID
  "UPDATE_DATE" time with time zone, -- 更新日時
  "UPDATE_USER_ID" character varying(6), -- 更新ユーザID
  "ENABLE_FLG" smallint -- 有効フラグ｜0:無効,1:有効
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
COMMENT ON COLUMN public."M_USER"."INSERT_USER_ID" IS '追加ユーザID';
COMMENT ON COLUMN public."M_USER"."UPDATE_DATE" IS '更新日時';
COMMENT ON COLUMN public."M_USER"."UPDATE_USER_ID" IS '更新ユーザID';
COMMENT ON COLUMN public."M_USER"."ENABLE_FLG" IS '有効フラグ｜0:無効,1:有効';

