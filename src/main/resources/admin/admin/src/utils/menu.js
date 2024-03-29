const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "会员列表",
                    "tableName": "huiyuan"
                }],
                "menu": "会员管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "产品类型列表",
                    "tableName": "chanpinleixing"
                }],
                "menu": "产品类型管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "配置管理",
                    "tableName": "peizhiguanli"
                }, {
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "新闻资讯列表",
                    "tableName": "news"
                }, {
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "客服管理",
                    "tableName": "kefuguanli"
                }],
                "menu": "系统管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "理财产品列表",
                    "tableName": "licaichanpin"
                }],
                "menu": "理财产品管理"
            }, {
                "child": [{
                    "buttons": ["查看", "审核"],
                    "menu": "理财购买列表",
                    "tableName": "licaigoumai"
                }],
                "menu": "理财购买管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "贷款产品列表",
                    "tableName": "daikuanchanpin"
                }],
                "menu": "贷款产品管理"
            }, {
                "child": [{
                    "buttons": ["查看", "审核"],
                    "menu": "贷款办理列表",
                    "tableName": "daikuanbanli"
                }],
                "menu": "贷款办理管理"
            }],
            "frontMenu": [{
                "child": [{
                    "buttons": ["查看", "产品购买"],
                    "menu": "理财产品列表",
                    "tableName": "licaichanpin"
                }],
                "menu": "理财产品模块"
            }, {
                "child": [{
                    "buttons": ["查看", "申请贷款"],
                    "menu": "贷款产品列表",
                    "tableName": "daikuanchanpin"
                }],
                "menu": "贷款产品模块"
            }],
            "roleName": "管理员",
            "tableName": "users"
        }, {
            "backMenu": [{
                "child": [{
                    "buttons": ["查看"],
                    "menu": "理财购买列表",
                    "tableName": "licaigoumai"
                }],
                "menu": "理财购买管理"
            }, {
                "child": [{
                    "buttons": ["查看"],
                    "menu": "贷款办理列表",
                    "tableName": "daikuanbanli"
                }],
                "menu": "贷款办理管理"
            }, {
                "child": [{
                    "buttons": ["查看", "删除"],
                    "menu": "收藏列表",
                    "tableName": "storeup"
                }],
                "menu": "我的收藏管理"
            }],
            "frontMenu": [{
                "child": [{
                    "buttons": ["查看", "产品购买"],
                    "menu": "理财产品列表",
                    "tableName": "licaichanpin"
                }],
                "menu": "理财产品模块"
            }, {
                "child": [{
                    "buttons": ["查看", "申请贷款"],
                    "menu": "贷款产品列表",
                    "tableName": "daikuanchanpin"
                }],
                "menu": "贷款产品模块"
            }],
            "roleName": "会员",
            "tableName": "huiyuan"
        }]
    }
}
export default menu;