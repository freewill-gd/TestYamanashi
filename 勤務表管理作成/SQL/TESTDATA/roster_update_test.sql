UPDATE
	t_roster
SET
	work_kind = 1 -- 勤務種別
	, start_time = TO_TIMESTAMP('2010/10/10 08:10', 'YYYY/MM/DD HH24:MI') -- 開始時間
	, end_time = TO_TIMESTAMP('2010/10/10 24:10', 'YYYY/MM/DD HH24:MI') -- 終了時間
	, break_time = fn_string_to_minute('02:30') -- 休憩(分)
	, over_time = fn_string_to_minute('02:30') -- 残業(分)
	, late_night_over_time = fn_string_to_minute('02:30') -- 深夜残業(分)
	, holiday_over_time = fn_string_to_minute('02:30') -- 休日残業(分)
	, holiday_late_night_over_time = fn_string_to_minute('02:30') -- 休日深夜残業(分)
	, remarks = 'ほげほげ'
	, update_date = NOW()-- 更新日時
	, update_user_id = 'fw001'-- 更新ユーザID
	, enable_flg = 1-- 有効フラグ｜0:無効,1:有効
WHERE
	 user_id = 'fw001' -- ユーザID
	AND work_date = TO_DATE('2017/01', 'YYYY/MM/DD')-- 日付
