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

 Date: 09/12/2020 16:50:21
*/


-- ----------------------------
-- Table structure for Product
-- ----------------------------
DROP TABLE "SYSTEM"."Product";
CREATE TABLE "SYSTEM"."Product" (
  "id" NUMBER VISIBLE NOT NULL,
  "name" VARCHAR2(255 BYTE) VISIBLE,
  "price" FLOAT(126) VISIBLE,
  "stockNum" NUMBER VISIBLE,
  "salarmNum" NUMBER VISIBLE,
  "supId" NUMBER VISIBLE
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
-- Primary Key structure for table Product
-- ----------------------------
ALTER TABLE "SYSTEM"."Product" ADD CONSTRAINT "SYS_C0010157" PRIMARY KEY ("id");

-- ----------------------------
-- Checks structure for table Product
-- ----------------------------
ALTER TABLE "SYSTEM"."Product" ADD CONSTRAINT "SYS_C0010156" CHECK ("id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Triggers structure for table Product
-- ----------------------------
CREATE TRIGGER "SYSTEM"."INSERT_PRODUCT_AUTOINC" BEFORE INSERT ON "SYSTEM"."Product" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
begin
SELECT product_autoinc.nextval INTO :new."id" FROM dual;
end insert_product_autoinc;
/
