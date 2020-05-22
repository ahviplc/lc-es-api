/*
 Navicat Premium Data Transfer

 Source Server         : oracle-lmtplat-SCOTT-Lmt123456
 Source Server Type    : Oracle
 Source Server Version : 110200
 Source Host           : 192.168.0.7:1521
 Source Schema         : SCOTT

 Target Server Type    : Oracle
 Target Server Version : 110200
 File Encoding         : 65001

 Date: 22/05/2020 17:03:30
*/


-- ----------------------------
-- Table structure for M_B_P_USER 对应 com.lc.pojo.MBPUser
-- ----------------------------
DROP TABLE "SCOTT"."M_B_P_USER";
CREATE TABLE "SCOTT"."M_B_P_USER" (
  "ID" NUMBER(30) NOT NULL ,
  "NAME" VARCHAR2(255 BYTE) ,
  "AGE" NUMBER ,
  "EMAIL" VARCHAR2(255 BYTE) ,
  "VERSION" NUMBER DEFAULT 1  ,
  "DELETED" NUMBER DEFAULT 0  ,
  "CREATE_TIME" TIMESTAMP(6) ,
  "UPDATE_TIME" TIMESTAMP(6) 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of "M_B_P_USER"
-- ----------------------------
INSERT INTO "SCOTT"."M_B_P_USER" VALUES ('1263756984219017217', 'LC说Java', '3', '110@qq.com', '1', '0', TO_TIMESTAMP('2020-05-22 17:01:59.166000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP('2020-05-22 17:01:59.166000', 'SYYYY-MM-DD HH24:MI:SS:FF6'));
INSERT INTO "SCOTT"."M_B_P_USER" VALUES ('1263756926488576002', 'LC说Java', '3', '110@qq.com', '1', '0', TO_TIMESTAMP('2020-05-22 17:01:45.401000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP('2020-05-22 17:01:45.401000', 'SYYYY-MM-DD HH24:MI:SS:FF6'));

-- ----------------------------
-- Primary Key structure for table M_B_P_USER
-- ----------------------------
ALTER TABLE "SCOTT"."M_B_P_USER" ADD CONSTRAINT "SYS_C0072684" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table M_B_P_USER
-- ----------------------------
ALTER TABLE "SCOTT"."M_B_P_USER" ADD CONSTRAINT "SYS_C0072683" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
