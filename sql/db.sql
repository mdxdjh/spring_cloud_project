CREATE TABLE `goods_info` (
  `id` int(11) NOT NULL COMMENT '自增id',
  `name` varchar(32) DEFAULT NULL COMMENT '商品名称',
  `type` int(11) DEFAULT NULL COMMENT '商品类型',
  `price` bigint(20) DEFAULT NULL COMMENT '商品价格',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '商品状态，1-在售，2-下架',
  `remark` varchar(200) DEFAULT NULL COMMENT '商品备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

CREATE TABLE `mer_acct_info` (
  `mer_id` varchar(20) NOT NULL COMMENT '支付客户id',
  `acct_id` varchar(50) NOT NULL COMMENT '支付账',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `pay_channel` tinyint(4) NOT NULL COMMENT '支付渠道\n1-android支付宝，2-ios支付宝，3-微博支付宝，4-微博微信',
  `sign_key` varchar(1500) DEFAULT NULL COMMENT '签名钥匙',
  `private_key_pwd` varchar(3000) DEFAULT NULL COMMENT '公钥密码',
  `public_key_pwd` varchar(3000) DEFAULT NULL COMMENT '公钥密码',
  `used` char(1) DEFAULT 'y' COMMENT '是否使用 y=使用 n=未使用',
  PRIMARY KEY (`mer_id`,`acct_id`,`pay_channel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户支付账户表';

CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `order_no` varchar(22) DEFAULT NULL COMMENT '订单号',
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '订单类型，1-充值订单、2-x',
  `currency_type` tinyint(4) DEFAULT NULL COMMENT '货币类型，1-金币\n、2-RMB',
  `amount` bigint(20) DEFAULT NULL COMMENT '订单金额',
  `status` tinyint(4) DEFAULT NULL COMMENT '订单状态,1-待处理、2-支付成功、3-支付失败、4－已发货、11-取消关闭、12-过期关闭、13-退款关闭',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `goods_type` int(11) DEFAULT NULL COMMENT '商品类型，1-充值类',
  `channel` int(11) DEFAULT NULL COMMENT '订单渠道，1-微信公众号',
  `source` tinyint(4) DEFAULT NULL COMMENT '订单来源，1-ios、2-android、3-pc、4-h5',
  `deleted` tinyint(1) DEFAULT '1' COMMENT '是否删除，1-删除，0-没删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_no` (`order_no`),
  KEY `idx_uid_create_time` (`uid`,`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='账户订单表';

CREATE TABLE `pay_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `order_no` varchar(26) DEFAULT NULL COMMENT '支付订单号',
  `pay_acct` varchar(50) DEFAULT NULL COMMENT '实际支付账号',
  `trade_no` varchar(64) DEFAULT NULL COMMENT '第三方交易号',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间= gmt_payment',
  `pay_amount` bigint(20) DEFAULT NULL COMMENT '交易金额(分)',
  `pay_channel` tinyint(4) DEFAULT NULL COMMENT '支付渠道\n1-android支付宝、2-ios支付宝、3-ios内购',
  `pay_status` tinyint(4) DEFAULT NULL COMMENT '支付状态,1-待处理、2-支付成功、3－支付失败、11-取消关闭、12-超时关闭、13-退款关闭',
  `last_notify_time` datetime DEFAULT NULL COMMENT '最后一次通知时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_trade_no` (`trade_no`),
  KEY `idx_uid_pay_time` (`uid`,`pay_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='第三方支付流水表';

CREATE TABLE `user_info` (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户信息表',
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `iphone_pay_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `order_no` varchar(26) DEFAULT NULL COMMENT '订单号',
  `pay_acct` varchar(50) DEFAULT NULL COMMENT '实际支付账号',
  `receipt` varchar(8000) DEFAULT NULL COMMENT '收据',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `pay_amount` bigint(20) DEFAULT NULL COMMENT '交易金额(total_fee)',
  `pay_status` varchar(30) DEFAULT NULL COMMENT '第三方校验的支付状态',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_pay_time` (`pay_time`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='苹果支付流水表';
