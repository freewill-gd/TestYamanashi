-- Function: public.prc_create_month_roster(character varying, integer, integer)

-- DROP FUNCTION public.prc_create_month_roster(character varying, integer, integer);

CREATE OR REPLACE FUNCTION public.prc_create_month_roster(
    in_user_id character varying,
    in_year integer,
    in_month integer)
  RETURNS void AS
$BODY$DECLARE
	month_str character varying;
	start_date timestamp with time zone;
	end_date timestamp with time zone;
	end_date_num integer;
	work_date timestamp with time zone;
BEGIN
	month_str := TO_CHAR(in_year, '0000') || TO_CHAR(in_month, '00');
	start_date := TO_DATE(month_str, 'YYYYMM');
	end_date := start_date + '1 mon'::interval + '-1 days'::interval;
	end_date_num := TO_NUMBER(TO_CHAR(end_date, 'DD'),'99');
	
	FOR day IN 1..end_date_num LOOP
		work_date := TO_DATE(month_str || TO_CHAR(day, '00'), 'YYYYMMDD');
		PERFORM prc_create_t_roster_data(in_user_id, work_date);
		--PERFORM  prc_debug(day || 'test');
	END LOOP;

END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.prc_create_month_roster(character varying, integer, integer)
  OWNER TO postgres;
COMMENT ON FUNCTION public.prc_create_month_roster(character varying, integer, integer) IS '月間勤務表データ作成';
