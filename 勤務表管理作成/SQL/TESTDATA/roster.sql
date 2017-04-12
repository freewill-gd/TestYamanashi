UPDATE t_roster
SET start_time = work_date + '9 hour'::interval
   , end_time = work_date + '23 hour'::interval
   , break_time = 60
   , over_time = 4 * 60
   , late_night_over_time = 60
   , holiday_over_time = 0
   , holiday_late_night_over_time = 0
   , remarks = '”õl‚Ì‚±‚Ì–ì˜Y!'
;
commit;
