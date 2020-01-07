
-- ----------------------------
-- 增加租户表字段
-- ----------------------------
ALTER TABLE "public"."blade_tenant"
    ADD COLUMN "domain" varchar(255) COLLATE "pg_catalog"."default",
    ADD COLUMN "background_url" varchar(1000) COLLATE "pg_catalog"."default",
    ADD COLUMN "account_number" int2 DEFAULT -1,
    ADD COLUMN "expire_time" timestamp(6);
COMMENT ON COLUMN "public"."blade_tenant"."domain" IS '域名地址';
COMMENT ON COLUMN "public"."blade_tenant"."background_url" IS '系统背景';
COMMENT ON COLUMN "public"."blade_tenant"."account_number" IS '账号额度';
COMMENT ON COLUMN "public"."blade_tenant"."expire_time" IS '过期时间';

-- ----------------------------
-- 插入菜单数据
-- ----------------------------
INSERT INTO "blade_menu"("id", "parent_id", "code", "name", "alias", "path", "source", "sort", "category", "action", "is_open", "remark", "is_deleted")
VALUES ('1164733389658963251', '1123598815738675298', 'xxljob', '任务调度', 'menu', 'http://localhost:7009/xxl-job-admin', 'iconfont iconicon_cspace', 2, 1, 0, 2, '', 0);

-- ----------------------------
-- 插入角色权限数据
-- ----------------------------
INSERT INTO "blade_role_menu"("id","menu_id","role_id")
VALUES ('1161272893873322991', '1164733389658963251', '1123598816738675201');