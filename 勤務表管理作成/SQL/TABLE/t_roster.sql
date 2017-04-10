-- Table: public.t_roster

DROP TABLE public.t_roster;

CREATE TABLE public.t_roster
(
  user_id  character varying(6) NOT NULL, -- ユーザID
  work_date timestamp with time zone NOT NULL, -- 日付
  work_kind character varying(6), -- 勤務種別
  start_time timestamp with time zone, -- 開始時間
  end_time timestamp with time zone, -- 終了時間
  
  insert_date timestamp with time zone, -- 追加日時
  insert_user_id character varying(6), -- 追加ユーザID
  update_date timestamp with time zone, -- 更新日時
  update_user_id character varying(6), -- 更新ユーザID
  enable_flg smallint -- 有効フラグ｜0:無効,1:有効
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.t_roster
  OWNER TO postgres;
COMMENT ON TABLE public.t_roster
  IS '勤務表';
COMMENT ON COLUMN public.t_roster.user_id IS 'ユーザID';
COMMENT ON COLUMN public.t_roster.work_date IS '日付';
COMMENT ON COLUMN public.t_roster.work_kind IS '勤務種別';
COMMENT ON COLUMN public.t_roster.start_time IS '開始時間';
COMMENT ON COLUMN public.t_roster.end_time IS '終了時間';
COMMENT ON COLUMN public.t_roster.insert_date IS '追加日時';
COMMENT ON COLUMN public.t_roster.insert_user_id IS '追加ユーザID';
COMMENT ON COLUMN public.t_roster.update_date IS '更新日時';
COMMENT ON COLUMN public.t_roster.update_user_id IS '更新ユーザID';
COMMENT ON COLUMN public.t_roster.enable_flg IS '有効フラグ｜0:無効,1:有効';

