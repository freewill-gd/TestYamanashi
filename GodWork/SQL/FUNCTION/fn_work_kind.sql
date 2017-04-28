-- Function: public.fn_work_kind(text)

-- DROP FUNCTION public.fn_work_kind(text);

CREATE OR REPLACE FUNCTION public.fn_work_kind(in_kind text)
  RETURNS text AS
$BODY$DECLARE
	ret_str TEXT[];
	kind INT;
BEGIN
	ret_str = ARRAY['通常勤務', '休日出勤', '有給休暇', '特別休暇', '欠勤'];
	kind := TO_NUMBER(in_kind, '99');
	IF kind > 5 THEN 
		RETURN '';
	END IF;
	RETURN ret_str[kind];
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.fn_work_kind(text)
  OWNER TO postgres;
COMMENT ON FUNCTION public.fn_work_kind(text) IS '勤務種別を出力します
';

