DELETE FROM t_roster;
SELECT prc_create_month_roster('fw001', 2017, 1);
SELECT prc_create_month_roster('fw001', 2017, 2);
SELECT prc_create_month_roster('fw001', 2017, 3);
SELECT prc_create_month_roster('fw001', 2017, 4);
SELECT prc_create_month_roster('fw001', 2017, 5);
SELECT prc_create_month_roster('fw001', 2017, 6);
SELECT prc_create_month_roster('fw001', 2017, 7);
SELECT prc_create_month_roster('fw001', 2017, 8);
SELECT prc_create_month_roster('fw001', 2017, 9);
SELECT prc_create_month_roster('fw001', 2017, 10);
SELECT prc_create_month_roster('fw001', 2017, 11);
SELECT prc_create_month_roster('fw001', 2017, 12);

SELECT prc_create_month_roster('fw001', 2018, 1);
SELECT prc_create_month_roster('fw001', 2018, 2);
SELECT prc_create_month_roster('fw001', 2018, 3);
SELECT prc_create_month_roster('fw001', 2018, 4);
SELECT prc_create_month_roster('fw001', 2018, 5);
SELECT prc_create_month_roster('fw001', 2018, 6);
SELECT prc_create_month_roster('fw001', 2018, 7);
SELECT prc_create_month_roster('fw001', 2018, 8);
SELECT prc_create_month_roster('fw001', 2018, 9);
SELECT prc_create_month_roster('fw001', 2018, 10);
SELECT prc_create_month_roster('fw001', 2018, 11);
SELECT prc_create_month_roster('fw001', 2018, 12);

UPDATE t_roster
SET start_time = work_date + '9 hour'::interval
   , end_time = work_date + '23 hour'::interval
   , break_time = 60
   , over_time = 4 * 60
   , late_night_over_time = 60
   , remarks = 'îıçlÇæÇ±ÇÃñÏòY!'
WHERE fn_weekday(work_date) NOT IN('ìy', 'ì˙')
;

UPDATE t_roster
SET start_time = work_date + '9 hour'::interval
   , end_time = work_date + '23 hour'::interval
   , break_time = 60
   , holiday_over_time = 60
   , holiday_late_night_over_time = 4 * 60
   , remarks = 'ãxÇ›ÇæÅIï∂ãÂÇ†ÇÈÇ©ÅAé–í{ÇæÇ±ÇÃñÏòY!'
WHERE fn_weekday(work_date) IN ('ìy', 'ì˙')
;

