-- Function: public.fn_minute_to_string(bigint)

-- DROP FUNCTION public.fn_minute_to_string(bigint);

CREATE OR REPLACE FUNCTION public.fn_minute_to_string(minute bigint)
  RETURNS text AS
$BODY$DECLARE
BEGIN
	RETURN TO_CHAR(minute / 60, 'FM00:') || TO_CHAR(minute % 60, 'FM00');
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.fn_minute_to_string(bigint)
  OWNER TO postgres;
COMMENT ON FUNCTION public.fn_minute_to_string(bigint) IS '分か60進文字に変換します
';

