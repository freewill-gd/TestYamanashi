-- Function: public.fn_minute_to_string(integer)

-- DROP FUNCTION public.fn_minute_to_string(integer);

CREATE OR REPLACE FUNCTION public.fn_minute_to_string(minute integer)
  RETURNS text AS
$BODY$DECLARE
BEGIN
	RETURN TO_CHAR(minute / 60, 'FM00:') || TO_CHAR(minute % 60, 'FM00');
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.fn_minute_to_string(integer)
  OWNER TO postgres;
COMMENT ON FUNCTION public.fn_minute_to_string(integer) IS '分か60進文字に変換します
';
