SELECT user_id
 , work_date
 , holiday_flg
 , work_kind
 , start_time
 , end_time
 , break_time
 , over_time
 , late_night_over_time
 , holiday_over_time
 , holiday_late_night_over_time
 , remarks
 , insert_date
 , insert_user_id
 , update_date
 , update_user_id
 , enable_flg
FROM 
  t_roster
WHERE
 work_date >= TO_DATE('2017/04', 'YYYY/MM')
 AND work_date < TO_DATE('2017/05', 'YYYY/MM')
