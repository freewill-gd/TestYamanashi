-- Function: public.prc_create_t_roster_data(character varying, timestamp with time zone)

-- DROP FUNCTION public.prc_create_t_roster_data(character varying, timestamp with time zone);

CREATE OR REPLACE FUNCTION public.prc_create_t_roster_data(
    in_user_id character varying,
    in_work_date timestamp with time zone)
  RETURNS void AS
$BODY$DECLARE
	row_t_roster t_roster%ROWTYPE;
	sysdate timestamp with time zone;
BEGIN

	sysdate := now();
	row_t_roster.user_id := in_user_id; -- ユーザID
	row_t_roster.work_date := date_trunc('day', in_work_date); -- 日付
	row_t_roster.insert_date := sysdate; -- 追加日時
	row_t_roster.insert_user_id := in_user_id; -- 追加ユーザID
	row_t_roster.update_date := sysdate; -- 更新日時
	row_t_roster.update_user_id := in_user_id; -- 更新ユーザID
	row_t_roster.enable_flg := 1; -- 有効フラグ｜0:無効,1:有効

	INSERT INTO
		t_roster
	(
		  user_id -- ユーザID
		, work_date -- 日付
		, work_kind -- 勤務種別
		, start_time -- 開始時間
		, end_time -- 終了時間
		, break_time -- 休憩(分)
		, over_time -- 残業(分)
		, late_night_over_time -- 深夜残業(分)
		, holiday_over_time -- 休日残業(分)
		, holiday_late_night_over_time -- 休日深夜残業(分)
		, insert_date -- 追加日時
		, insert_user_id -- 追加ユーザID
		, update_date -- 更新日時
		, update_user_id -- 更新ユーザID
		, enable_flg -- 有効フラグ｜0:無効,1:有効
	)
	VALUES
	(
		  row_t_roster.user_id -- ユーザID
		, row_t_roster.work_date -- 日付
		, row_t_roster.work_kind -- 勤務種別
		, row_t_roster.start_time -- 開始時間
		, row_t_roster.end_time -- 終了時間
		, row_t_roster.break_time -- 休憩(分)
		, row_t_roster.over_time -- 残業(分)
		, row_t_roster.late_night_over_time -- 深夜残業(分)
		, row_t_roster.holiday_over_time -- 休日残業(分)
		, row_t_roster.holiday_late_night_over_time -- 休日深夜残業(分)
		, row_t_roster.insert_date -- 追加日時
		, row_t_roster.insert_user_id -- 追加ユーザID
		, row_t_roster.update_date -- 更新日時
		, row_t_roster.update_user_id -- 更新ユーザID
		, row_t_roster.enable_flg -- 有効フラグ｜0:無効,1:有効
	);

END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.prc_create_t_roster_data(character varying, timestamp with time zone)
  OWNER TO postgres;
COMMENT ON FUNCTION public.prc_create_t_roster_data(character varying, timestamp with time zone) IS '勤務表データ作成';
