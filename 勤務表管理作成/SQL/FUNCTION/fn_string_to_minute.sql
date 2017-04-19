-- Function: public.fn_string_to_minute(character varying)

-- DROP FUNCTION public.fn_string_to_minute(character varying);

CREATE OR REPLACE FUNCTION public.fn_string_to_minute("time" character varying)
  RETURNS numeric AS
$BODY$BEGIN
	RETURN  TO_NUMBER(SUBSTR(time, 1,2), '99') * 60 + TO_NUMBER(SUBSTR(time, 4,2), '99');
END;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.fn_string_to_minute(character varying)
  OWNER TO postgres;
COMMENT ON FUNCTION public.fn_string_to_minute(character varying) IS '時間文字列からlongへ変換';
