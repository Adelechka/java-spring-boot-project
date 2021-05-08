<!DOCTYPE html>
<html lang="en">
<head>
    <#include "head.ftlh">
    <!-- Custom styles for this template -->
    <title>Пост</title>
    <link href="headers.css" rel="stylesheet">
    <link href="styles/profile.css" rel="stylesheet">
</head>

<body class="profile-page">

<#include "header.ftlh">

<div class="page-header header-filter" data-parallax="true"></div>
<div class="main main-raised">
    <div class="profile-content">
        <div class="container">

            <div class="tab-content tab-space">
                <div class="tab-pane active text-center gallery" id="studio">
                    <div class="row">

                        <#list posts as post>
                            <#include "post.ftlh">
                        </#list>
                    </div>
                    <#if auth == true>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6 offset-md-3">
                                    <div class="card">
                                        <div class="card-body">

                                            <form action="/post/comment_post${postId}" method="post"
                                                  class="sign-in-form">
                                                <input type="hidden" name="${_csrf.parameterName}"
                                                       value="${_csrf.token}">
                                                <input class="form-control" name="text"
                                                       placeholder="Оставьте комментарий">
                                                <input type="submit" value="Опубликовать"
                                                       class="btn btn-outline-secondary solid"/>
                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </#if>


                    <#if comment_for_post?size gt 0>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6 offset-md-3">
                                    <#list comment_for_post as comment>
                                        <div class="card">
                                            <div class="card-header">
                                                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                                    <#if auth == true>
                                                        <#if auth_user_id == comment.author.id>
                                                            <form style="margin-bottom: 0" method="post" action="/delete_comment${comment.id}">
                                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                                                <input class="btn btn-danger" type="submit" value="Удалить">
                                                            </form>
                                                        </#if>
                                                    </#if>
                                                </div>
                                            <div class="card-body">
                                                <p class="h5">${comment.author.firstName} ${comment.author.lastName}</p>
                                                <p class="card-text">${comment.text}</p>
                                                <a href="/id${comment.author.login}"
                                                   class="card-link">${comment.author.login}</a>
                                            </div>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </#if>
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

