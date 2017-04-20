-- Table: public.m_user

-- DROP TABLE public.m_user;

CREATE TABLE public.m_user
(
  user_id character varying(6) NOT NULL, -- ユーザID
  user_name character varying(6), -- ユーザ名
  insert_date time with time zone, -- 追加日時
  insert_user_id character varying(6), -- 追加ユーザID
  update_date time with time zone, -- 更新日時
  update_user_id character varying(6), -- 更新ユーザID
  enable_flg smallint, -- 有効フラグ｜0:無効,1:有効
  CONSTRAINT m_user_pkey PRIMARY KEY (user_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.m_user
  OWNER TO postgres;
COMMENT ON TABLE public.m_user
  IS 'ユーザテーブル';
COMMENT ON COLUMN public.m_user.user_id IS 'ユーザID';
COMMENT ON COLUMN public.m_user.user_name IS 'ユーザ名';
COMMENT ON COLUMN public.m_user.insert_date IS '追加日時';
COMMENT ON COLUMN public.m_user.insert_user_id IS '追加ユーザID';
COMMENT ON COLUMN public.m_user.update_date IS '更新日時';
COMMENT ON COLUMN public.m_user.update_user_id IS '更新ユーザID';
COMMENT ON COLUMN public.m_user.enable_flg IS '有効フラグ｜0:無効,1:有効';

