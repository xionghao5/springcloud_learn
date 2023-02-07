CREATE TABLE `pms_product_category` (
                                        `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                                        `parent_id` BIGINT(19) NULL DEFAULT NULL COMMENT '上级分类的编号：0表示一级分类',
                                        `name` VARCHAR(64) NULL DEFAULT NULL COMMENT '名称' COLLATE 'utf8mb4_general_ci',
                                        `level` TINYINT(1) NULL DEFAULT NULL COMMENT '分类级别：0表示1级；1表示2级',
                                        `product_count` INT(10) NULL DEFAULT NULL COMMENT '商品数量',
                                        `product_unit` VARCHAR(64) NULL DEFAULT NULL COMMENT '商品单位' COLLATE 'utf8mb4_general_ci',
                                        `nav_status` TINYINT(1) NULL DEFAULT NULL COMMENT '是否显示在导航栏：0不显示，1显示',
                                        `show_status` TINYINT(1) NULL DEFAULT NULL COMMENT '是否显示状态:0不显示，1显示',
                                        `sort` INT(10) NULL DEFAULT NULL COMMENT '排序',
                                        `icon` VARCHAR(255) NULL DEFAULT NULL COMMENT '图标' COLLATE 'utf8mb4_general_ci',
                                        `keywords` VARCHAR(255) NULL DEFAULT NULL COMMENT '关键字' COLLATE 'utf8mb4_general_ci',
                                        `description` VARCHAR(255) NULL DEFAULT NULL COMMENT '描述' COLLATE 'utf8mb4_general_ci',
                                        PRIMARY KEY (`id`) USING BTREE
)
    COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
