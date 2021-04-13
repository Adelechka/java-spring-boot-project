<!DOCTYPE html>
<html lang="en">
<head>
    <#include "head.ftlh">
    <!-- Custom styles for this template -->
    <title>Профиль</title>
    <link href="headers.css" rel="stylesheet">
    <link href="styles/profile.css" rel="stylesheet">
</head>
<!--
<#--        <#if user.admin>-->
<#--            <table>-->
<#--                <thead>-->
<#--                <tr>-->
<#--                    <td>Имя Фамилия</td>-->
<#--                    <td>Логин</td>-->
<#--                    <td>Статус</td>-->
<#--                    <td>Роль</td>-->
<#--                    <td>Забанить</td>-->
<#--                    <td>Разбанить</td>-->
<#--                </tr>-->
<#--                </thead>-->
<#--                <tbody>-->
<#--                <#list users as admins_user>-->
<#--                    <tr>-->
<#--                        <td>${admins_user.firstName} ${admins_user.lastName}</td>-->
<#--                        <td>${admins_user.login}</td>-->
<#--                        <td>${admins_user.state}</td>-->
<#--                        <td>${admins_user.role}</td>-->
<#--                        <td></td>-->
<#--                        <td>Разбанить</td>-->
<#--                    </tr>-->
<#--                </#list>-->
<#--                </tbody>-->
<#--            </table>-->
<#--        </#if>-->
-->

<body class="profile-page">

<#include "header.ftlh">

<div class="page-header header-filter" data-parallax="true"></div>
<div class="main main-raised">
    <div class="profile-content">
        <div class="container">
            <div class="row">
                <div class="col-md-6 ml-auto mr-auto">
                    <div class="profile">
                        <div class="avatar">
                            <img src="img/profile.svg" alt="Circle Image" class="img-raised rounded-circle img-fluid">
                        </div>
                        <div class="name">
                            <h3 class="title">${user.firstName} ${user.lastName}</h3>
                            <h6>${user.login}</h6>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 ml-auto mr-auto">
                    <div class="profile-tabs">
                        <ul class="nav nav-pills nav-pills-icons justify-content-center" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" href="#studio" role="tab" data-toggle="tab">
                                    <i class="fas fa-user-edit"></i>Мои посты</i>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#works" role="tab" data-toggle="tab">
                                    <i class="fas fa-heart"></i>Понравившиеся</i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="tab-content tab-space">
                <div class="tab-pane active text-center gallery" id="studio">
                    <div class="row">
                        <div class="col-md-3 ml-auto">
                            <img src="https://images.unsplash.com/photo-1524498250077-390f9e378fc0?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=83079913579babb9d2c94a5941b2e69d&auto=format&fit=crop&w=751&q=80"
                                 class="rounded">
                            <img src="https://images.unsplash.com/photo-1528249227670-9ba48616014f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=66b8e7db17b83084f16fdeadfc93b95b&auto=format&fit=crop&w=357&q=80"
                                 class="rounded">
                        </div>
                        <div class="col-md-3 mr-auto">
                            <img src="https://images.unsplash.com/photo-1521341057461-6eb5f40b07ab?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=72da2f550f8cbd0ec252ad6fb89c96b2&auto=format&fit=crop&w=334&q=80"
                                 class="rounded">
                            <img src="https://images.unsplash.com/photo-1506667527953-22eca67dd919?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=6326214b7ce18d74dde5e88db4a12dd5&auto=format&fit=crop&w=750&q=80"
                                 class="rounded">
                        </div>
                    </div>
                </div>
                <div class="tab-pane text-center gallery" id="works">
                    <div class="row">
                        <div class="col-md-3 ml-auto">
                            <img src="https://images.unsplash.com/photo-1524498250077-390f9e378fc0?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=83079913579babb9d2c94a5941b2e69d&auto=format&fit=crop&w=751&q=80"
                                 class="rounded">
                            <img src="https://images.unsplash.com/photo-1506667527953-22eca67dd919?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=6326214b7ce18d74dde5e88db4a12dd5&auto=format&fit=crop&w=750&q=80"
                                 class="rounded">
                            <img src="https://images.unsplash.com/photo-1505784045224-1247b2b29cf3?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=ec2bdc92a9687b6af5089b335691830e&auto=format&fit=crop&w=750&q=80"
                                 class="rounded"></div>
                        <div class="col-md-3 mr-auto">
                            <img src="https://images.unsplash.com/photo-1504346466600-714572c4b726?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=6754ded479383b7e3144de310fa88277&auto=format&fit=crop&w=750&q=80"
                                 class="rounded">
                            <img src="https://images.unsplash.com/photo-1494028698538-2cd52a400b17?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=83bf0e71786922a80c420c17b664a1f5&auto=format&fit=crop&w=334&q=80"
                                 class="rounded">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "footer.ftlh">

</body>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js"
        integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js"
        integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9"
        crossorigin="anonymous"></script>
</html>

