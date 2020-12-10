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

 Date: 09/12/2020 16:50:52
*/


-- ----------------------------
-- Table structure for Sale
-- ----------------------------
DROP TABLE "SYSTEM"."Sale";
CREATE TABLE "SYSTEM"."Sale" (
  "sid" NUMBER VISIBLE NOT NULL,
  "pid" NUMBER VISIBLE,
  "pName" VARCHAR2(255 BYTE) VISIBLE,
  "saleCount" VARCHAR2(255 BYTE) VISIBLE,
  "prices" FLOAT(126) VISIBLE,
  "uid" NUMBER VISIBLE,
  "uName" VARCHAR2(255 BYTE) VISIBLE,
  "date" DATE VISIBLE
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
-- Primary Key structure for table Sale
-- ----------------------------
ALTER TABLE "SYSTEM"."Sale" ADD CONSTRAINT "SYS_C0010172" PRIMARY KEY ("sid");

-- ----------------------------
-- Triggers structure for table Sale
-- ----------------------------
CREATE TRIGGER "SYSTEM"."INSERT_SALE_AUTOINC" BEFORE INSERT ON "SYSTEM"."Sale" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
begin
SELECT sale_autoinc.nextval INTO :new."sid" FROM dual;
end insert_sale_autoinc;
/
CREATE TRIGGER "SYSTEM"."SALE_ADD_PRODUCT" AFTER DELETE OR INSERT OR UPDATE ON "SYSTEM"."Sale" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
begin
if inserting then
update "Product" set "stockNum"="stockNum"-:new."saleCount" where "id"=:new."pid";
end if;
if deleting then
update "Product" set "stockNum"="stockNum"+:old."saleCount" where "id"=:old."pid";
end if;
if updating then
update "Product" set "stockNum"="stockNum"+:old."saleCount" where "id"=:old."pid";
update "Product" set "stockNum"="stockNum"-:new."saleCount" where "id"=:new."pid";
end if;
end sale_add_product;
/
