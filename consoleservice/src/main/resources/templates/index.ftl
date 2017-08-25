<!DOCTYPE HTML>
<html>
<head>
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/console/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/console/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="/console/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
    <div class="dl-title">
        <h1>聚乐云后台管理系统</h1>
    </div>
    <div class="dl-log">欢迎您，<span class="dl-log-user"></span>
        <a onclick="logout()" title="退出系统" class="dl-log-quit">[注销]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform">
            <div class="dl-inform-title">
                <s class="dl-inform-icon dl-up"></s>
            </div>
        </div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected">
                <div class="nav-item-inner nav-home">系统管理</div>
            </li>
            <li class="nav-item dl-selected">
                <div class="nav-item-inner nav-order">业务管理</div>
            </li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="/console/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/console/assets/js/bui-min.js"></script>
<script type="text/javascript" src="/console/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="/console/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{id:'1',menu:[{text:'系统管理',items:[
            {id:'1',text:'全局用户',href:'/console/uauth/uauthlist'},
            {id:'2',text:'用户令牌',href:'/console/token/tokenlist'},
            {id:'3',text:'后台用户',href:'/console/list/ucenterlist'},
            {id:'4',text:'活动',href:'/console/activities/activitieslist'},
            {id:'5',text:'注册',href:'/console/account/accountlist'},
            {id:'6',text:'历史订单',href:'/console/orders/orderlist'}
            ]}
        ]},
            {id:'2',menu:[{text:'业务管理',items:[
                {id:'1',text:'查询业务',href:'/console/Node/index.html'}]
            }]
        }];
        new PageUtil.MainPage({
            modulesConfig:config
        });
    });
</script>
<script>
    function logout(){
        location.href="/console/logout";
    }
</script>
</body>
</html>