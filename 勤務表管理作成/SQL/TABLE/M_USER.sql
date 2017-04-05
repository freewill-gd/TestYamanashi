-- Table: public."M_USER"

-- DROP TABLE public."M_USER";

CREATE TABLE public."M_USER"
(
  "USER_ID" character varying(6) NOT NULL, -- ユーザID
  "USER_NAME" character varying(6), -- ユーザ名
  "INSERT_DATE" time with time zone, -- 追加日時
  "INSERT_USER_ID" character varying(6), -- 追加ユーザID
  "UPDATE_DATE" time with time zone, -- 更新日時
  "UPDATE_USER_ID" character varying(6), -- 更新ユーザID
  "ENABLE_FLG" smallint, -- 有効フラグ｜0:無効,1:有効
  CONSTRAINT "M_USER_pkey" PRIMARY KEY ("USER_ID")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."M_USER"
  OWNER TO postgres;
COMMENT ON TABLE public."M_USER"
  IS 'ユーザテーブル';
COMMENT ON COLUMN public."M_USER"."USER_ID" IS 'ユーザID';
COMMENT ON COLUMN public."M_USER"."USER_NAME" IS 'ユーザ名';
COMMENT ON COLUMN public."M_USER"."INSERT_DATE" IS '追加日時';
COMMENT ON COLUMN public."M_USER"."INSERT_USER_ID" IS '追加ユーザID';
COMMENT ON COLUMN public."M_USER"."UPDATE_DATE" IS '更新日時';
COMMENT ON COLUMN public."M_USER"."UPDATE_USER_ID" IS '更新ユーザID';
COMMENT ON COLUMN public."M_USER"."ENABLE_FLG" IS '有効フラグ｜0:無効,1:有効';

