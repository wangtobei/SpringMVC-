/*
 Navicat Premium Data Transfer

 Source Server         : localhostOracle
 Source Server Type    : Oracle
 Source Server Version : 120100
 Source Host           : localhost:1521
 Source Schema         : SYSTEM

 Target Server Type    : Oracle
 Target Server Version : 120100
 File Encoding         : 65001

 Date: 09/12/2020 16:51:31
*/


-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE "SYSTEM"."User";
CREATE TABLE "SYSTEM"."User" (
  "empID" NUMBER VISIBLE NOT NULL,
  "userName" VARCHAR2(255 BYTE) VISIBLE,
  "passWord" VARCHAR2(255 BYTE) VISIBLE,
  "empPost" VARCHAR2(255 BYTE) VISIBLE,
  "phone" VARCHAR2(255 BYTE) VISIBLE,
  "privilege" NUMBER VISIBLE
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Primary Key structure for table User
-- ----------------------------
ALTER TABLE "SYSTEM"."User" ADD CONSTRAINT "SYS_C0010166" PRIMARY KEY ("empID");

-- ----------------------------
-- Triggers structure for table User
-- ----------------------------
CREATE TRIGGER "SYSTEM"."INSERT_USER_AUTOINC" BEFORE INSERT ON "SYSTEM"."User" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
begin
SELECT user_autoinc.nextval INTO :new."empID" FROM dual;
end insert_user_autoinc;
/
