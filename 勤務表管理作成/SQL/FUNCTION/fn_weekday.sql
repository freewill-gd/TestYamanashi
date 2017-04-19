-- Function: public.fn_weekday(timestamp with time zone)

-- DROP FUNCTION public.fn_weekday(timestamp with time zone);

CREATE OR REPLACE FUNCTION public.fn_weekday(in_date timestamp with time zone)
  RETURNS text AS
$BODY$DECLARE
	ret_str TEXT[];
	dow INT;
BEGIN
	ret_str = ARRAY['日', '月', '火', '水', '木', '金', '土'];
	dow = date_part('dow'::text, in_date) + 1;
	RETURN ret_str[dow];
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.fn_weekday(timestamp with time zone)
  OWNER TO postgres;
COMMENT ON FUNCTION public.fn_weekday(timestamp with time zone) IS '日付型から曜日（漢字）を出力します
';
