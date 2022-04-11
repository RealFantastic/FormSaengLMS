DROP TABLE "NOTICE";

CREATE TABLE "NOTICE" (
	"board_notice_no"	number		NOT NULL,
	"board_notice_title"	varchar2(150)		NOT NULL,
	"board_notice_writer"	varchar2(30)		NOT NULL,
	"board_notice_date"	timestamp	DEFAULT systimestamp	NOT NULL,
	"board_notice_content"	varchar2		NOT NULL,
	"id"	varchar2(12)		NOT NULL
);

COMMENT ON COLUMN "NOTICE"."id" IS '학생:S 교수: P 관리자 :M';

DROP TABLE "COMMENT";

CREATE TABLE "COMMENT" (
	"comment_no"	number		NOT NULL,
	"board_assignment_no"	number		NOT NULL,
	"comment_writer"	varchar2(30)		NOT NULL,
	"comment_date"	timestamp	DEFAULT systimestamp	NOT NULL,
	"comment_content"	varchar2		NULL,
	"id"	varchar2(12)		NOT NULL,
	"Field"	VARCHAR(255)		NULL
);

COMMENT ON COLUMN "COMMENT"."id" IS '학생:S 교수: P 관리자 :M';

DROP TABLE "ASSIGNMENT_LIST";

CREATE TABLE "ASSIGNMENT_LIST" (
	"board_assignment_no"	number		NOT NULL,
	"board_assignment_title"	varchar2(150)		NOT NULL,
	"board_assignment_writer"	varchar2(30)		NOT NULL,
	"board_assignment_date"	timestamp	DEFAULT systimestamp	NOT NULL,
	"board_assignment_content"	varchar2		NOT NULL,
	"id"	varchar2(12)		NOT NULL
);

COMMENT ON COLUMN "ASSIGNMENT_LIST"."id" IS '학생:S 교수: P 관리자 :M';

DROP TABLE "ASSIGNMENT_FILE";

CREATE TABLE "ASSIGNMENT_FILE" (
	"board_file_no"	number		NOT NULL,
	"comment_no"	number		NOT NULL,
	"board_assignment_no"	number		NOT NULL,
	"board_file_name"	varchar2		NOT NULL,
	"board_file_add"	varchar2		NOT NULL
);

DROP TABLE "ACADEMIC_CALENDAR";

CREATE TABLE "ACADEMIC_CALENDAR" (
	"academic_no"	number		NOT NULL,
	"academic_name"	varchar2		NOT NULL,
	"start_date"	date	DEFAULT sysdate	NOT NULL,
	"end_date"	date	DEFAULT sysdate	NOT NULL
);

COMMENT ON COLUMN "ACADEMIC_CALENDAR"."academic_no" IS '시퀀스';

DROP TABLE "SUBJECT";

CREATE TABLE "SUBJECT" (
	"subject_code"	varchar2(30)		NOT NULL,
	"subject_name"	varchar2(30)		NOT NULL,
	"course_grade"	number(1)		NOT NULL,
	"course_semester"	number(1)		NOT NULL,
	"course_credit"	number(1)		NOT NULL,
	"course_class"	varchar2		NOT NULL,
	"course_capacity"	number		NOT NULL,
	"open_yn"	varchar2(3)		NOT NULL,
	"department_code"	varchar2(4)		NOT NULL,
	"class_type"	varchar2(12)		NULL,
	"course_day"	varchar2(3)		NULL,
	"course_period"	varchar2		NULL
);

COMMENT ON COLUMN "SUBJECT"."subject_code" IS 'ex) C001,C002,M001,M002';

COMMENT ON COLUMN "SUBJECT"."course_semester" IS '연도구분 다시생각';

COMMENT ON COLUMN "SUBJECT"."open_yn" IS '말해~ yes~or~no~';

COMMENT ON COLUMN "SUBJECT"."department_code" IS '컴공:C, 실음:M, 관리자:ADMIN';

COMMENT ON COLUMN "SUBJECT"."class_type" IS '전공선택/전공필수';

DROP TABLE "DEPARTMENT";

CREATE TABLE "DEPARTMENT" (
	"department_code"	varchar2(4)		NOT NULL,
	"department_name"	varchar2(20)		NOT NULL,
	"department_capacity"	number(99)		NOT NULL
);

COMMENT ON COLUMN "DEPARTMENT"."department_code" IS '컴공:C 실음:M 관리자 : ADMIN';

DROP TABLE "REFERENCE";

CREATE TABLE "REFERENCE" (
	"ref_no"	number		NOT NULL,
	"ref_title"	varchar2(30)		NOT NULL,
	"ref_content"	varchar2		NULL,
	"ref_writer"	vachar2		NOT NULL,
	"ref_write_date"	timestamp	DEFAULT systimestamp	NOT NULL,
	"subject_code"	varchar2(30)		NOT NULL
);

COMMENT ON COLUMN "REFERENCE"."subject_code" IS 'ex) C001,C002,M001,M002';

DROP TABLE "ENROLLMENT_STUDENT";

CREATE TABLE "ENROLLMENT_STUDENT" (
	"id"	varchar2(12)		NOT NULL,
	"subject_code"	varchar2(30)		NOT NULL
);

COMMENT ON COLUMN "ENROLLMENT_STUDENT"."id" IS '학생:S , 교수:P, 관리자:M';

COMMENT ON COLUMN "ENROLLMENT_STUDENT"."subject_code" IS 'ex) C001,C002,M001,M002';

DROP TABLE "WEEK_IMFOMATION";

CREATE TABLE "WEEK_IMFOMATION" (
	"lecture_no"	VARCHAR(255)		NOT NULL,
	"week"	VARCHAR(255)		NOT NULL,
	"subject_code"	varchar2(30)		NOT NULL,
	"period"	timestamp	DEFAULT systimestamp	NOT NULL,
	"video_link"	varchar2		NOT NULL,
	"file_no"	number		NULL,
	"video_length"	number		NOT NULL,
	"video_title"	varchar2(40)		NOT NULL
);

COMMENT ON COLUMN "WEEK_IMFOMATION"."subject_code" IS 'ex) C001,C002,M001,M002';

COMMENT ON COLUMN "WEEK_IMFOMATION"."period" IS 'systimestamp+7days';

COMMENT ON COLUMN "WEEK_IMFOMATION"."file_no" IS 'todo) delete';

COMMENT ON COLUMN "WEEK_IMFOMATION"."video_title" IS 'ex) 스마트 콘텐츠-6주차-12강';

DROP TABLE "REFERENCE_FILE";

CREATE TABLE "REFERENCE_FILE" (
	"ref_file_no"	number		NOT NULL,
	"ref_no"	number		NOT NULL,
	"ref_file_name"	varchar2		NOT NULL,
	"ref_file_type"	varchar2		NOT NULL,
	"ref_file_count"	number		NOT NULL
);

DROP TABLE "RECORD";

CREATE TABLE "RECORD" (
	"lecture_no"	VARCHAR(255)		NOT NULL,
	"week"	VARCHAR(255)		NOT NULL,
	"subject_code"	varchar2(30)		NOT NULL,
	"playtime"	number	DEFAULT 0	NOT NULL,
	"id"	varchar2(12)		NOT NULL,
	"Field"	VARCHAR(255)		NULL
);

COMMENT ON COLUMN "RECORD"."subject_code" IS 'ex) C001,C002,M001,M002';

COMMENT ON COLUMN "RECORD"."id" IS '학생:S 교수: P 관리자 :M';

DROP TABLE "QUIZ";

CREATE TABLE "QUIZ" (
	"week"	VARCHAR(255)		NOT NULL,
	"subject_code"	varchar2(30)		NOT NULL,
	"quiz_score"	number		NOT NULL,
	"quiz_cnt"	number		NOT NULL
);

COMMENT ON COLUMN "QUIZ"."subject_code" IS 'ex) C001,C002,M001,M002';

DROP TABLE "MESSAGE";

CREATE TABLE "MESSAGE" (
	"msg_no"	number		NOT NULL,
	"msg_title"	varchar2(150)		NOT NULL,
	"msg_content"	varchar2(600)		NOT NULL,
	"msg_date"	timestamp	DEFAULT systimestamp	NOT NULL,
	"receiver"	varchar2(30)		NOT NULL,
	"sender"	varchar2(30)		NOT NULL,
	"id"	varchar2(12)		NOT NULL
);

COMMENT ON COLUMN "MESSAGE"."id" IS '학생:S 교수: P 관리자 :M';

DROP TABLE "MEMBER";

CREATE TABLE "MEMBER" (
	"id"	varchar2(12)		NOT NULL,
	"name"	varchar2(30)		NOT NULL,
	"pwd"	varchar2(30)		NOT NULL,
	"rnum"	varchar2(20)		NOT NULL,
	"email"	varchar2(165)		NOT NULL,
	"address"	varchar2(600)		NOT NULL,
	"department_code"	varchar2(4)		NOT NULL
);

COMMENT ON COLUMN "MEMBER"."id" IS '학생:S 교수: P 관리자 :M';

COMMENT ON COLUMN "MEMBER"."department_code" IS '컴공:C 실음:M 관리자 : ADMIN';

ALTER TABLE "NOTICE" ADD CONSTRAINT "PK_NOTICE" PRIMARY KEY (
	"board_notice_no"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "PK_COMMENT" PRIMARY KEY (
	"comment_no",
	"board_assignment_no"
);

ALTER TABLE "ASSIGNMENT_LIST" ADD CONSTRAINT "PK_ASSIGNMENT_LIST" PRIMARY KEY (
	"board_assignment_no"
);

ALTER TABLE "ASSIGNMENT_FILE" ADD CONSTRAINT "PK_ASSIGNMENT_FILE" PRIMARY KEY (
	"board_file_no",
	"comment_no",
	"board_assignment_no"
);

ALTER TABLE "ACADEMIC_CALENDAR" ADD CONSTRAINT "PK_ACADEMIC_CALENDAR" PRIMARY KEY (
	"academic_no"
);

ALTER TABLE "SUBJECT" ADD CONSTRAINT "PK_SUBJECT" PRIMARY KEY (
	"subject_code"
);

ALTER TABLE "DEPARTMENT" ADD CONSTRAINT "PK_DEPARTMENT" PRIMARY KEY (
	"department_code"
);

ALTER TABLE "REFERENCE" ADD CONSTRAINT "PK_REFERENCE" PRIMARY KEY (
	"ref_no"
);

ALTER TABLE "ENROLLMENT_STUDENT" ADD CONSTRAINT "PK_ENROLLMENT_STUDENT" PRIMARY KEY (
	"id",
	"subject_code"
);

ALTER TABLE "WEEK_IMFOMATION" ADD CONSTRAINT "PK_WEEK_IMFOMATION" PRIMARY KEY (
	"lecture_no",
	"week",
	"subject_code"
);

ALTER TABLE "REFERENCE_FILE" ADD CONSTRAINT "PK_REFERENCE_FILE" PRIMARY KEY (
	"ref_file_no",
	"ref_no"
);

ALTER TABLE "RECORD" ADD CONSTRAINT "PK_RECORD" PRIMARY KEY (
	"lecture_no",
	"week",
	"subject_code"
);

ALTER TABLE "QUIZ" ADD CONSTRAINT "PK_QUIZ" PRIMARY KEY (
	"week",
	"subject_code"
);

ALTER TABLE "MESSAGE" ADD CONSTRAINT "PK_MESSAGE" PRIMARY KEY (
	"msg_no"
);

ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"id"
);

ALTER TABLE "NOTICE" ADD CONSTRAINT "FK_MEMBER_TO_NOTICE_1" FOREIGN KEY (
	"id"
)
REFERENCES "MEMBER" (
	"id"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_ASSIGNMENT_LIST_TO_COMMENT_1" FOREIGN KEY (
	"board_assignment_no"
)
REFERENCES "ASSIGNMENT_LIST" (
	"board_assignment_no"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_MEMBER_TO_COMMENT_1" FOREIGN KEY (
	"id"
)
REFERENCES "MEMBER" (
	"id"
);

ALTER TABLE "ASSIGNMENT_LIST" ADD CONSTRAINT "FK_MEMBER_TO_ASSIGNMENT_LIST_1" FOREIGN KEY (
	"id"
)
REFERENCES "MEMBER" (
	"id"
);

ALTER TABLE "ASSIGNMENT_FILE" ADD CONSTRAINT "FK_COMMENT_TO_ASSIGNMENT_FILE_1" FOREIGN KEY (
	"comment_no"
)
REFERENCES "COMMENT" (
	"comment_no"
);

ALTER TABLE "ASSIGNMENT_FILE" ADD CONSTRAINT "FK_COMMENT_TO_ASSIGNMENT_FILE_2" FOREIGN KEY (
	"board_assignment_no"
)
REFERENCES "COMMENT" (
	"board_assignment_no"
);

ALTER TABLE "SUBJECT" ADD CONSTRAINT "FK_DEPARTMENT_TO_SUBJECT_1" FOREIGN KEY (
	"department_code"
)
REFERENCES "DEPARTMENT" (
	"department_code"
);

ALTER TABLE "REFERENCE" ADD CONSTRAINT "FK_SUBJECT_TO_REFERENCE_1" FOREIGN KEY (
	"subject_code"
)
REFERENCES "SUBJECT" (
	"subject_code"
);

ALTER TABLE "ENROLLMENT_STUDENT" ADD CONSTRAINT "FK_MEMBER_TO_ENROLLMENT_STUDENT_1" FOREIGN KEY (
	"id"
)
REFERENCES "MEMBER" (
	"id"
);

ALTER TABLE "ENROLLMENT_STUDENT" ADD CONSTRAINT "FK_SUBJECT_TO_ENROLLMENT_STUDENT_1" FOREIGN KEY (
	"subject_code"
)
REFERENCES "SUBJECT" (
	"subject_code"
);

ALTER TABLE "WEEK_IMFOMATION" ADD CONSTRAINT "FK_SUBJECT_TO_WEEK_IMFOMATION_1" FOREIGN KEY (
	"subject_code"
)
REFERENCES "SUBJECT" (
	"subject_code"
);

ALTER TABLE "REFERENCE_FILE" ADD CONSTRAINT "FK_REFERENCE_TO_REFERENCE_FILE_1" FOREIGN KEY (
	"ref_no"
)
REFERENCES "REFERENCE" (
	"ref_no"
);

ALTER TABLE "RECORD" ADD CONSTRAINT "FK_WEEK_IMFOMATION_TO_RECORD_1" FOREIGN KEY (
	"lecture_no"
)
REFERENCES "WEEK_IMFOMATION" (
	"lecture_no"
);

ALTER TABLE "RECORD" ADD CONSTRAINT "FK_WEEK_IMFOMATION_TO_RECORD_2" FOREIGN KEY (
	"week"
)
REFERENCES "WEEK_IMFOMATION" (
	"week"
);

ALTER TABLE "RECORD" ADD CONSTRAINT "FK_WEEK_IMFOMATION_TO_RECORD_3" FOREIGN KEY (
	"subject_code"
)
REFERENCES "WEEK_IMFOMATION" (
	"subject_code"
);

ALTER TABLE "RECORD" ADD CONSTRAINT "FK_MEMBER_TO_RECORD_1" FOREIGN KEY (
	"id"
)
REFERENCES "MEMBER" (
	"id"
);

ALTER TABLE "QUIZ" ADD CONSTRAINT "FK_WEEK_IMFOMATION_TO_QUIZ_1" FOREIGN KEY (
	"week"
)
REFERENCES "WEEK_IMFOMATION" (
	"week"
);

ALTER TABLE "QUIZ" ADD CONSTRAINT "FK_WEEK_IMFOMATION_TO_QUIZ_2" FOREIGN KEY (
	"subject_code"
)
REFERENCES "WEEK_IMFOMATION" (
	"subject_code"
);

ALTER TABLE "MESSAGE" ADD CONSTRAINT "FK_MEMBER_TO_MESSAGE_1" FOREIGN KEY (
	"id"
)
REFERENCES "MEMBER" (
	"id"
);

ALTER TABLE "MEMBER" ADD CONSTRAINT "FK_DEPARTMENT_TO_MEMBER_1" FOREIGN KEY (
	"department_code"
)
REFERENCES "DEPARTMENT" (
	"department_code"
);

