<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<title>团队规模编辑</title>
</head>
<body>
	<div class="mainbar">
		<div class="page-head">
			<h2 class="pull-left">团队规模管理</h2>
			<div class="bread-crumb pull-right">
				<a class="btn btn-default btn-sm" href="/team/add">新建团队规模</a>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="matter">
			<div class="container">
				<!--row start-->
				<div class="row">
					<div class="col-md-12">
						<div class="widget wgreen">
							<div class="widget-head">
								<div class="pull-left">编辑团队规模</div>
								<div class="clearfix"></div>
							</div>
							<div class="widget-content">
								<div class="padd">
									<form id="edit_team_form" class="form-horizontal" role="form" action="/team/update/${teamSize.id}" method="post">
										<div class="form-group">
											<label class="col-lg-2 control-label" for="name">团队规模名称<span class="cofrequired">*</span>:</label>
											<div class="col-lg-10">
												<input name="name" id="name" value="${teamSize.name}" type="text" class="form-control" placeholder="团队规模名称"></input>
											</div>
										</div>
										<div class="form-group">
											<label class="col-lg-2 control-label" for="type">显示<span class="cofrequired">*</span>:</label>
											<div class="col-lg-10">
												<jsp:include page="control/commons-listed.jsp">
													<jsp:param value="${teamSize.isListed}" name="listed"/>
													<jsp:param value="false" name="has_all"/>
												</jsp:include>
											</div>
										</div>
										<hr />
										<div class="form-group">
											<div class="col-lg-offset-1 col-lg-12">
												<button type="submit" class="btn btn-default">提交</button>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div class="widget-foot"></div>
						</div>
					</div>
				</div>
				<!--row end-->
			</div>
		</div>
	</div>
	
	<script>
		$(document).ready(function() {
			$('#name').focus();
	        $('#edit_team_form').validate({
	        	onsubmit:true,
        	  	onfocusout:false,
        	  	onkeyup:false,
        	  	onkeyup:false,
        	  	onclick:false,
	            rules: {
	            	name: {
	                    required: true,
	                    minlength: 2,
	                    maxlength: 64
	                }
	            },
	            messages: {
	            	name: {
	                    required: '名称不能为空',
	                    minlength: "名称长度不能小于2个字符",
	                    maxlength: "名称长度不能大于64个字符"
	                }
	            },
	            submitHandler: function(form) {
	                form.submit();
	            }
	        });
		});
	</script>
	
</body>
