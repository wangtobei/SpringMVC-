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

 Date: 09/12/2020 16:48:01
*/


-- ----------------------------
-- Table structure for Customer
-- ----------------------------
DROP TABLE "SYSTEM"."Customer";
CREATE TABLE "SYSTEM"."Customer" (
  "cid" NUMBER VISIBLE NOT NULL,
  "name" VARCHAR2(255 BYTE) VISIBLE,
  "phone" VARCHAR2(255 BYTE) VISIBLE,
  "notes" VARCHAR2(255 BYTE) VISIBLE
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
-- Primary Key structure for table Customer
-- ----------------------------
ALTER TABLE "SYSTEM"."Customer" ADD CONSTRAINT "SYS_C0010167" PRIMARY KEY ("cid");

-- ----------------------------
-- Triggers structure for table Customer
-- ----------------------------
CREATE TRIGGER "SYSTEM"."INSERT_CUSTOMER_AUTOINC" BEFORE INSERT ON "SYSTEM"."Customer" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
begin
SELECT customer_autoinc.nextval INTO :new."cid" FROM dual;
end insert_customer_autoinc;
/
