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

 Date: 09/12/2020 16:50:36
*/


-- ----------------------------
-- Table structure for Purchase
-- ----------------------------
DROP TABLE "SYSTEM"."Purchase";
CREATE TABLE "SYSTEM"."Purchase" (
  "pcID" NUMBER VISIBLE NOT NULL,
  "pid" NUMBER VISIBLE,
  "sid" NUMBER VISIBLE,
  "count" NUMBER VISIBLE,
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
-- Primary Key structure for table Purchase
-- ----------------------------
ALTER TABLE "SYSTEM"."Purchase" ADD CONSTRAINT "SYS_C0010164" PRIMARY KEY ("pcID");

-- ----------------------------
-- Triggers structure for table Purchase
-- ----------------------------
CREATE TRIGGER "SYSTEM"."ADDPURCHASE_ADD_PRODUCT" AFTER DELETE OR INSERT OR UPDATE ON "SYSTEM"."Purchase" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
begin
if inserting then
update "Product" set "stockNum"="stockNum"+:new."count" where "id"=:new."pid";
end if;
if deleting then
update "Product" set "stockNum"="stockNum"-:old."count" where "id"=:old."pid";
end if;
if updating then
update "Product" set "stockNum"="stockNum"-:old."count" where "id"=:old."pid";
update "Product" set "stockNum"="stockNum"+:new."count" where "id"=:new."pid";
end if;
end addpurchase_add_product;
/
CREATE TRIGGER "SYSTEM"."INSERT_PURCHASE_AUTOINC" BEFORE INSERT ON "SYSTEM"."Purchase" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
begin
SELECT purchase_autoinc.nextval INTO :new."pcID" FROM dual;
end insert_purchase_autoinc;
/
