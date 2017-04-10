-- Function: public.prc_create_t_roster_data(character varying, timestamp with time zone)

-- DROP FUNCTION public.prc_create_t_roster_data(character varying, timestamp with time zone);

CREATE OR REPLACE FUNCTION public.prc_create_t_roster_data(
    in_user_id character varying,
    in_work_date timestamp with time zone)
  RETURNS void AS
$BODY$DECLARE
	row_t_roster t_roster%ROWTYPE;
	sysdate timestamp with time zone;
BEGIN

	sysdate := now();
	row_t_roster.user_id := in_user_id; -- ���[�UID
	row_t_roster.work_date := date_trunc('day', in_work_date); -- ���t
	row_t_roster.insert_date := sysdate; -- �ǉ�����
	row_t_roster.insert_user_id := in_user_id; -- �ǉ����[�UID
	row_t_roster.update_date := sysdate; -- �X�V����
	row_t_roster.update_user_id := in_user_id; -- �X�V���[�UID
	row_t_roster.enable_flg := 1; -- �L���t���O�b0:����,1:�L��

	INSERT INTO
		t_roster
	(
		  user_id -- ���[�UID
		, work_date -- ���t
		, work_kind -- �Ζ����
		, start_time -- �J�n����
		, end_time -- �I������
		, break_time -- �x�e(��)
		, over_time -- �c��(��)
		, late_night_over_time -- �[��c��(��)
		, holiday_over_time -- �x���c��(��)
		, holiday_late_night_over_time -- �x���[��c��(��)
		, insert_date -- �ǉ�����
		, insert_user_id -- �ǉ����[�UID
		, update_date -- �X�V����
		, update_user_id -- �X�V���[�UID
		, enable_flg -- �L���t���O�b0:����,1:�L��
	)
	VALUES
	(
		  row_t_roster.user_id -- ���[�UID
		, row_t_roster.work_date -- ���t
		, row_t_roster.work_kind -- �Ζ����
		, row_t_roster.start_time -- �J�n����
		, row_t_roster.end_time -- �I������
		, row_t_roster.break_time -- �x�e(��)
		, row_t_roster.over_time -- �c��(��)
		, row_t_roster.late_night_over_time -- �[��c��(��)
		, row_t_roster.holiday_over_time -- �x���c��(��)
		, row_t_roster.holiday_late_night_over_time -- �x���[��c��(��)
		, row_t_roster.insert_date -- �ǉ�����
		, row_t_roster.insert_user_id -- �ǉ����[�UID
		, row_t_roster.update_date -- �X�V����
		, row_t_roster.update_user_id -- �X�V���[�UID
		, row_t_roster.enable_flg -- �L���t���O�b0:����,1:�L��
	);

END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.prc_create_t_roster_data(character varying, timestamp with time zone)
  OWNER TO postgres;
COMMENT ON FUNCTION public.prc_create_t_roster_data(character varying, timestamp with time zone) IS '�Ζ��\�f�[�^�쐬';
