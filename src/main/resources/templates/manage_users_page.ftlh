<!DOCTYPE html>
<html lang="en">
<head>
    <#include "head.ftlh">
    <!-- Custom styles for this template -->
    <title>Управление пользователями</title>
    <link href="headers.css" rel="stylesheet">
    <link href="styles/profile.css" rel="stylesheet">
</head>


<body class="profile-page">

<#include "header.ftlh">

<div class="page-header header-filter" data-parallax="true"></div>
<div class="main main-raised">
    <div class="profile-content">
        <div class="container">
            <div class="row">
                <table class="table" style="text-align: center">
                    <thead class="table-dark">
                    <tr>
                        <td><p class="fw-bold">Имя Фамилия</p></td>
                        <td><p class="fw-bold">Логин</p></td>
                        <td><p class="fw-bold">Статус</p></td>
                        <td><p class="fw-bold">Роль</p></td>
                        <td></td>
                    </tr>
                    </thead>
                    <tbody>
                    <#list users as admins_user>
                        <tr>
                            <td><p class="fw-bold">${admins_user.firstName} ${admins_user.lastName}</p></td>
                            <td><p class="fw-bold">${admins_user.login}</p></td>
                            <td>
                                <#if admins_user.isActive()>
                                    <p class="fw-bold">Активный</p>
                                <#else>
                                    <p class="fw-bold">Забаненный</p>
                                </#if>
                            </td>
                            <td>
                                <#if admins_user.isAdmin()>
                                    <p class="fw-bold">Администратор</p>
                                <#else>
                                    <p class="fw-bold">Пользователь</p>
                                </#if>
                            </td>
                            <td>
                                <#if admins_user.isAdmin()>
                                    <p class="fw-bold">Дейтвие недоступно</p>
                                <#else>
                                    <#if admins_user.isActive()>
                                        <form method="post" action="/ban/${admins_user.id}">
                                           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                           <input type="submit" class="btn btn-danger" value="Заблокировать">
                                        </form>
                                    <#else>
                                        <form method="post" action="/unban/${admins_user.id}">
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                            <input type="submit" class="btn btn-success" value="Разблокировать">
                                        </form>
                                    </#if>
                                </#if>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>

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

