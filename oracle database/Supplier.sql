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

 Date: 09/12/2020 16:51:17
*/


-- ----------------------------
-- Table structure for Supplier
-- ----------------------------
DROP TABLE "SYSTEM"."Supplier";
CREATE TABLE "SYSTEM"."Supplier" (
  "supID" NUMBER VISIBLE NOT NULL,
  "supName" VARCHAR2(255 BYTE) VISIBLE,
  "supContact" VARCHAR2(255 BYTE) VISIBLE,
  "supPhone" VARCHAR2(255 BYTE) VISIBLE,
  "address" VARCHAR2(255 BYTE) VISIBLE
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
-- Primary Key structure for table Supplier
-- ----------------------------
ALTER TABLE "SYSTEM"."Supplier" ADD CONSTRAINT "SYS_C0010163" PRIMARY KEY ("supID");

-- ----------------------------
-- Checks structure for table Supplier
-- ----------------------------
ALTER TABLE "SYSTEM"."Supplier" ADD CONSTRAINT "SYS_C0010162" CHECK ("supID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Triggers structure for table Supplier
-- ----------------------------
CREATE TRIGGER "SYSTEM"."DELETE_SUPPLIER_PRODUCT" AFTER DELETE ON "SYSTEM"."Supplier" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
begin 
delete from "Product" where "supId" =:old."supID";
end delete_supplier_product;
/
CREATE TRIGGER "SYSTEM"."INSERT_SUPPLIER_AUTOINC" BEFORE INSERT ON "SYSTEM"."Supplier" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
begin
SELECT supplier_autoinc.nextval INTO :new."supID" FROM dual;
end insert_supplier_autoinc;
/
