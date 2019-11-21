<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>员工管理系统</title>
<link href="${pageContext.request.contextPath }/resource/css/dataTables.bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resource/css/sb-admin-2.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resource/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resource/css/boot-crm.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resource/css/bootstrap-3.3.7.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resource/css/bootstrapValidator.css" rel="stylesheet" type="text/css">
</head>

<body>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/quote/jquery-2.1.1.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/quote/bootstrap-3.3.7.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/quote/bootstrapValidator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/department/department.js"></script>

<div id="wrapper">
    <nav class="navbar navbar-inverse navbar-static-top" role="navigation"
         style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">员工管理系统</a>
        </div>
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li><a href="/department/list" class="active"><i class="fa fa-edit fa-fw"></i> 部门管理</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">部门管理</h1>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-body">
                <form class="form-inline" action="${pageContext.request.contextPath }/department/list" method="post">
                    <div class="form-group">
                        <label for="departmentId">部门编号</label>
                        <input type="text" class="form-control" id="departmentId" value="${queryDto.departmentId}" name="departmentId" autocomplete="off" maxlength="5">
                    </div>
                    <div class="form-group">
                        <label for="departmentName">部门名称</label>
                        <input type="text" class="form-control" id="departmentName" value="${queryDto.departmentName}" name="departmentName" autocomplete="off" maxlength="10">
                    </div>
                    <button type="submit" class="btn btn-primary">查询</button>
                    <a href="#"  class="btn btn-primary" data-toggle="modal" data-target="#departmentInsertDialog" id="insert">新增</a>
                    <input type="button" class="btn btn-danger"  value="批量删除" onclick="selectDelete()">
                </form>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">部门信息列表</div>
                    <table class="table table-striped table-bordered table-hover" id="tableId">
                        <thead>
                        <tr>
                            <td align = center><input type="checkBox" id="selectAll" name="case" onclick="selectAllCheckBox('case')"/></td>
                            <th>部门编号</th>
                            <th>部门名称</th>
                            <th>部门主管</th>
                            <th>部门描述</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.rows}" var="item">
                            <tr align = center id="${item.departmentRecId}">
                                <td><input type="checkBox" id="case" name="case" value="${item.departmentRecId}"/></td>
                                <td>${item.departmentId}</td>
                                <td>${item.departmentName}</td>
                                <td>${item.departmentManager}</td>
                                <td>${item.departmentDescription}</td>
                                <td>
                                    <a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#departmentInsertDialog" onclick="edit(${item.departmentRecId})">编辑</a>
                                    <a href="#" class="btn btn-danger btn-xs" onclick="deleteDepartment(${item.departmentRecId})">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                    <%--返回分页对象时，这里面是page显示的内容，这样就能显示分页的标签--%>
                    <div class="col-md-12 text-right">
                        <itcast:page url="${pageContext.request.contextPath }/department/list"/>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<!-- 新增编辑对话框 -->
<div class="modal fade" id="departmentInsertDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                    <span class="hide">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel2">部门信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal"  id="insertDepartmentForm"  action="#" method="get" >
                    <input type="hidden" id="insertDepartmentRecId" name="departmentRecId"/>

                    <div class="form-group">
                        <label for="insertDepartmentId" class="col-sm-2 control-label">部门编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="insertDepartmentId" placeholder="部门编号" name="departmentId"  autocomplete="off" maxlength="5" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="insertDepartmentName" class="col-sm-2 control-label">部门名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="insertDepartmentName" placeholder="部门名称" maxlength="20" autocomplete="off" name="departmentName">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="insertDepartmentManager" class="col-sm-2 control-label">部门主管</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="insertDepartmentManager" placeholder="部门主管" maxlength="20" autocomplete="off" name="departmentManager">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="insertDepartmentDescription" class="col-sm-2 control-label">部门描述</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="insertDepartmentDescription" placeholder="部门描述" maxlength="200" autocomplete="off" name="departmentDescription">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" id="close">关闭</button>
                <button type="button" class="btn btn-primary" id="save" >保存 </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
